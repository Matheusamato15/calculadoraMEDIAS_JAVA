package Visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controle.ControleAcoes;
import Controle.ControleJanelas;
import Controle.ControleMateria;
import Modelo.ModeloJTable;
import Modelo.ModeloMateria;
import Util.UtilValidacoes;

import java.awt.FlowLayout;

public class VisaoResumo extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ControleMateria controleMateria = new ControleMateria();
	ModeloJTable modeloTable = new ModeloJTable();
	ControleJanelas controleTelas = new ControleJanelas();
	ControleAcoes controleAcoes = new ControleAcoes();
	UtilValidacoes validacoes = new UtilValidacoes();
	
	private JPanel painelPrincipal;
	private JPanel painelBotoes;

	protected JTable table;
	protected JScrollPane barraDeRolagem;
	protected JButton botaoSair;
	protected JButton botaoRetornar;
	private JButton botaoMedia;

	public VisaoResumo() {
		configurarFrame();
		
		configurarPainelPrincipal();
		
		configurarPainelBotoes();
		
		configurarJTable();
		
		configurarScrollPane();
		
		visualizarTable();
		
		configurarBotoes();
		
	}
	
	private void configurarScrollPane() {
		barraDeRolagem = new JScrollPane();
		painelPrincipal.add(barraDeRolagem, BorderLayout.CENTER);
		barraDeRolagem.setViewportView(table);
		barraDeRolagem.getViewport().setBackground(Color.ORANGE);
		
	}
	
	private void configurarJTable() {
		table = new JTable(); 
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		table.setBackground(Color.BLACK);
		table.setForeground(Color.WHITE);
		table.setSelectionMode(0);
		table.setModel(modeloTable);
	}

	private void configurarPainelPrincipal() {
		painelPrincipal = new JPanel();
		painelPrincipal.setBackground(new Color(0, 0, 51));
		painelPrincipal.setLayout(new BorderLayout(0, 0));
		setContentPane(painelPrincipal);

	}

	private void configurarPainelBotoes() {
		painelBotoes = new JPanel();
		painelBotoes.setBackground(new Color(0, 0, 51));
		painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

	}
	
	
	private void configurarBotoes() {
		painelBotoes.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		botaoSair = new JButton("Sair do Programa");
		controleTelas.fecharPrograma(botaoSair, this);
		configurarLayoutBotoes(botaoSair );
		painelBotoes.add(botaoSair);
	
		botaoMedia = new JButton("Média Final");
		montarEdicao();
		
		configurarLayoutBotoes(botaoMedia);
		painelBotoes.add(botaoMedia);

		
	}

	
	private void configurarLayoutBotoes(JButton botao) {
		botao.setFont(new Font("Dialog", Font.BOLD, 13));
		botao.setForeground(Color.WHITE);
		botao.setBackground(new Color(0, 0, 51));
	}
	
	protected void visualizarTable() {
		modeloTable = new ModeloJTable();
		
		for (int i=0; i<controleMateria.executarVisualizarDAO().size(); i++) {
			modeloTable.adicionarLinha(controleMateria.executarVisualizarDAO().get(i));
		}

		
		table.setModel(modeloTable);
	}
	
	protected ModeloMateria getMateriaSelecionado() {
		int linha = table.getSelectedRow();
		
		ModeloJTable modelo = (ModeloJTable) table.getModel();
		
		return modelo.obterLinha(linha);
	}
	
	protected int getLinhaSelecionado() {
		int linha = table.getSelectedRow();

		return linha;
	}


	private void montarEdicao() {
		botaoMedia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(validacoes.validarLinhaSelecionada(table)) {
						atualizarFrame();
					}else {
						new ControleJanelas().abrir(new VisaoMedia(getMateriaSelecionado()));
						dispose();
					}

				}
				
		});
	}
	
	private void atualizarFrame() {
		this.setVisible(true);
		visualizarTable();
	}
	
	private void configurarFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 700);
		setLocationRelativeTo(null);
		setUndecorated(true);
	}

}
