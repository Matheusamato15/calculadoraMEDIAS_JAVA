package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class ControleJanelas {

	public void abrirJanelasBotao(JButton botao, JFrame tela, JFrame telaAtual) {
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaAtual.dispose();
				tela.setVisible(true);
			}
		});
	}

	
	public void fecharPrograma(JButton botao, JFrame tela) {
		botao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja sair do programa?", "Aviso!", 
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0 ) {
					tela.setVisible(false);
				} else {
					tela.setVisible(true);
				}
			}
		});
	}
	
	public void fecharFrame(JFrame tela, JButton botao) {
		botao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tela.setVisible(false);
				
			}
		});
		
	}
	
	public void abrir(JFrame tela) {
		tela.setVisible(true);
	}
	
}
