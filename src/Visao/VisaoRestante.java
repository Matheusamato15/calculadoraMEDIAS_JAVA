package Visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controle.ControleAcoes;
import Controle.ControleJanelas;
import Controle.ControleMateria;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisaoRestante extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	VisaoResumo resumo = new VisaoResumo();
	ControleJanelas controleJanelas = new ControleJanelas();
	ControleAcoes controleAcoes = new ControleAcoes();
	ControleMateria controleMateria = new ControleMateria();
	
	protected JTextField textFieldNota2;
	protected JTextField textFieldMediaFinal;
	protected JTextField textFieldMateria;
	protected JTextField textFieldNota;
	protected JTextField textFieldRestante;
	
	protected JPanel painelPrincipal;
	protected JPanel painelBotoes;
	protected JPanel painelTitulo;
	protected JPanel painelDados;
		
	private JLabel labelNota2;
	private JLabel labelMediaFinal;
	private JLabel labelTitulo;
	private JLabel labelMateria;
	private JLabel labelNota; 
	private JLabel labelRestante; 
	private JPanel painelCalculadora;
	
	protected JButton botao1;
	protected JButton botao2;
	protected JButton botao3;
	protected JButton botao4;
	protected JButton botao5;
	protected JButton botao6;
	protected JButton botao7;
	protected JButton botao8;
	protected JButton botao9;
	protected JButton botao0;
	protected JButton botaoCorrigir;
	private JButton botaoSair;
	private JButton botaoSalvar;
	private JButton botaoLimparDados;
	private JButton botaoResumo;

	
	
	public VisaoRestante() {

		montarPainelPrincipal();
		
		estiloFrame();
		
		configurarPainelDados();
		
		montarPainelTitulo();

		montarPainelBotoes();
		
		montarTextField();
		
		montarPainelCalculadora();
		
		montarCalculadora();
		
		configurarBotoesComAcoes();
		
		montarLabel();
		
		bloquarComponentes();
		
	}

	private void montarTextField() {
						
		textFieldMediaFinal = new JTextField();
		textFieldMediaFinal.setEnabled(false);
		textFieldMediaFinal.setEditable(false);
		textFieldMediaFinal.setFont(new Font("Tahoma", Font.BOLD, 14));
		painelDados.add(textFieldMediaFinal, "cell 2 6,alignx left");
		textFieldMediaFinal.setColumns(5);
		
		textFieldNota2 = new JTextField();
		textFieldNota2.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldNota2.setEnabled(false);
		textFieldNota2.setEditable(false);
		painelDados.add(textFieldNota2, "cell 2 4,alignx left");
		textFieldNota2.setColumns(5);
		
		textFieldRestante = new JTextField();
		textFieldRestante.setEditable(false);
		textFieldRestante.setFont(new Font("Tahoma", Font.BOLD, 14));
		painelDados.add(textFieldRestante, "cell 2 3,alignx left");
		textFieldRestante.setColumns(5);

		textFieldMateria = new JTextField();
		textFieldMateria.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldMateria.setFont(new Font("Tahoma", Font.BOLD, 14));
		painelDados.add(textFieldMateria, "cell 2 0,growx");
		textFieldMateria.setColumns(7);

		textFieldNota = new JTextField();
		textFieldNota.setEditable(false);
		textFieldNota.setFont(new Font("Tahoma", Font.BOLD, 14));
		painelDados.add(textFieldNota, "cell 2 1,alignx left");
		textFieldNota.setColumns(5);
		

	}

	protected void montarLabel() {
		
		labelTitulo = new JLabel();
		formarTitulo("Bem vindo ao restante de nota!");
		labelTitulo.setForeground(Color.WHITE);
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		painelTitulo.add(labelTitulo);
		
		labelMateria = new JLabel("Matéria: ");
		painelDados.add(labelMateria, "cell 0 0,alignx center,aligny top");
		designerLabel(labelMateria);

		labelNota = new JLabel("Nota 1: ");
		painelDados.add(labelNota, "cell 0 1,alignx center");
		designerLabel(labelNota);
		
		labelNota2 = new JLabel("Nota 2:");
		painelDados.add(labelNota2, "cell 0 4,alignx center");
		designerLabel(labelNota2);
		
		labelRestante = new JLabel("Restante: ");
		painelDados.add(labelRestante, "cell 0 3,alignx center");
		designerLabel(labelRestante);

		
		labelMediaFinal = new JLabel("Média Final:");
		painelDados.add(labelMediaFinal, "cell 0 6,alignx center");
		designerLabel(labelMediaFinal);
		


	}
	
	protected void bloquarComponentes() {
		labelMediaFinal.setVisible(false);
		labelNota2.setVisible(false);
		
		textFieldMediaFinal.setVisible(false);
		textFieldNota2.setVisible(false);
		
	}
	
	protected void liberarComponentes() {
		labelMediaFinal.setVisible(true); 
		labelNota2.setVisible(true);
		
		textFieldMediaFinal.setVisible(true);
		textFieldNota2.setVisible(true);
		
	}
	
	protected void formarTitulo(String texto) {
		labelTitulo.setText(texto);
	}

	protected void designerLabel(JLabel label) {
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setForeground(Color.BLACK);
	}

	private void montarCalculadora() {
		
		botao1 = new JButton("1"); botao2 = new JButton("2"); botao3 = new JButton("3"); botao4 = new JButton("4");
		botao5 = new JButton("5"); botao6 = new JButton("6"); botao7 = new JButton("7"); botao8 = new JButton("8");
		botao9 = new JButton("9"); botao0 = new JButton("0"); botaoCorrigir = new JButton("C");
		
		configurarBotoes(botao0, textFieldNota); configurarBotoes(botao1, textFieldNota); configurarBotoes(botao2, textFieldNota);
		configurarBotoes(botao3, textFieldNota); configurarBotoes(botao4, textFieldNota); configurarBotoes(botao5, textFieldNota);
		configurarBotoes(botao6, textFieldNota); configurarBotoes(botao7, textFieldNota); configurarBotoes(botao8, textFieldNota);
		configurarBotoes(botao9, textFieldNota); configurarBotoes(botaoCorrigir, textFieldNota);
		
		painelCalculadora.setLayout(new MigLayout("", "[91.00px][91.00px][91px]", "[76px][76px][76px][76px]"));
		painelCalculadora.add(botao1, "cell 0 0,grow");
		painelCalculadora.add(botao2, "cell 1 0,grow");
		painelCalculadora.add(botao3, "cell 2 0,grow");
		painelCalculadora.add(botao4, "cell 0 1,grow");
		painelCalculadora.add(botao5, "cell 1 1,grow");
		painelCalculadora.add(botao6, "cell 2 1,grow");
		painelCalculadora.add(botao7, "cell 0 2,grow");
		painelCalculadora.add(botao8, "cell 1 2,grow");
		painelCalculadora.add(botao9, "cell 2 2,grow");
		painelCalculadora.add(botao0, "cell 1 3,grow");
		painelCalculadora.add(botaoCorrigir, "cell 2 3,grow");


	}

	private void configurarBotoesComAcoes() {
		
		////////////////////////////////////////////////////////SALVAR DADOS
		botaoSalvar = new JButton("Salvar Dados");
		controleAcoes.realizarCalculoRestante(botaoSalvar, textFieldMateria, textFieldNota, textFieldRestante);
		botaoSalvar.setForeground(Color.WHITE);
		botaoSalvar.setBackground(new Color(0, 0, 51));
		painelBotoes.add(botaoSalvar);
		
		////////////////////////////////////////////////////////LIMPAR CAMPOS PREENCHIDOS
		botaoLimparDados = new JButton("Limpar Dados");
		controleAcoes.limparCampos(botaoLimparDados, textFieldMateria, textFieldNota, textFieldRestante);
		botaoLimparDados.setForeground(Color.WHITE);
		botaoLimparDados.setBackground(new Color(0, 0, 51));
		painelBotoes.add(botaoLimparDados);
		
		////////////////////////////////////////////////////////ABRIR RESUMO DAS MATÉRIAS
		botaoResumo = new JButton("Resumo");
		botaoResumo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resumo.visualizarTable();
				resumo.setVisible(true);
			}
		});
		controleJanelas.fecharFrame(this, botaoResumo);
		botaoResumo.setForeground(Color.WHITE);
		botaoResumo.setBackground(new Color(0, 0, 51));
		painelBotoes.add(botaoResumo);
		
		////////////////////////////////////////////////////////FECHAR PROGRAMAS
		botaoSair = new JButton("Sair");
		botaoSair.setBackground(new Color(0, 0, 51));
		botaoSair.setForeground(Color.WHITE);
		controleJanelas.fecharPrograma(botaoSair, this);
		painelBotoes.add(botaoSair);
	}

	private void configurarBotoes(JButton botao,JTextField texto) {
		botao.setFont(new Font("Nirmala UI", Font.BOLD, 16));
		botao.setForeground(Color.WHITE);
		botao.setBackground(new Color(0, 0, 51));
		escreverNaCalculadora(botao, texto);
	}

	protected void escreverNaCalculadora(JButton botao, JTextField texto) {
		controleAcoes.escrever(botao, texto);
	}
	
	private void montarPainelCalculadora() {
		painelCalculadora = new JPanel();
		painelCalculadora.setBackground(new Color(0, 0, 51));
		painelPrincipal.add(painelCalculadora, BorderLayout.CENTER);

	}

	private void montarPainelBotoes() {
		painelBotoes = new JPanel();
		painelBotoes.setBackground(Color.BLACK);
		painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);
	}

	private void montarPainelPrincipal() {
		painelPrincipal = new JPanel();
		painelPrincipal.setBackground(new Color(0, 0, 51));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(new BorderLayout(0, 0));

	}

	private void montarPainelTitulo() {
		painelTitulo = new JPanel();
		painelTitulo.setBackground(Color.BLACK);
		painelPrincipal.add(painelTitulo, BorderLayout.NORTH);
	}

	private void configurarPainelDados() {
		painelDados = new JPanel();
		painelDados.setBackground(Color.ORANGE);
		painelPrincipal.add(painelDados, BorderLayout.WEST);
		painelDados.setLayout(new MigLayout("", "[47px][][grow][-21.00,grow]", "[][][][][][][][20px][][][]"));
		
	}

	private void estiloFrame() {
		setResizable(false);
		setUndecorated(true);
		setSize(514,389);
		setLocationRelativeTo(null);
	}

}
