package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JTextField;

import Util.UtilValidacoes;

/**
 * @author Matheus Amato
 *
 */
public class ControleAcoes {
	ControleMateria controleMateria = new ControleMateria();
	UtilValidacoes validacoes = new UtilValidacoes();

	public void escrever(JButton botao, JTextField texto) {
		botao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (botao.getText() == "C") {
					texto.setText("");
				} else {
					texto.setText(texto.getText() + botao.getText());
				}

			}
		});
	}

	public void limparCampos(JButton botao, JTextField materia, JTextField nota, JTextField restante) {

		botao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				materia.setText("");
				nota.setText("");
				restante.setText("");

			}
		});

	}

	/*
	 * A partir daqui, os métodos são para a realização dos cálculos
	 * 
	 * 
	 * 
	 */

	public String formatarNumero(float numero) {
		DecimalFormat formatador = new DecimalFormat("0.0");
		return formatador.format(numero);
	}

	private void enviarDadosParaCalculoRestante(JTextField textoMateria, JTextField textoNota) {

		for (int i = 0; i < controleMateria.listModelos.size(); i++) {
			controleMateria.listModelos.get(i).addoperando(Integer.parseInt(textoNota.getText()));
		}

	}

	public void realizarCalculoRestante(JButton botao, JTextField textoMateria, JTextField textoNota,
			JTextField textoRestante) {
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validacoes.validarCamposForamPreenchidos(textoMateria, textoNota) == 1) {
					
				} else {
					enviarDadosParaCalculoRestante(textoMateria, textoNota);
					for (int i = 0; i < controleMateria.listModelos.size(); i++) {
						if (controleMateria.listModelos.get(i).getSimbolo() == "R") {

							finalizarCalculoRestante(textoMateria, textoNota, textoRestante, i);
						}
					}
				}
				

			}

			
		});
	}
	
	private void finalizarCalculoRestante(JTextField textoMateria, JTextField textoNota,
			JTextField textoRestante, int i) {

		textoRestante.setText(formatarNumero(controleMateria.listModelos.get(i).calculoRestante()));

		controleMateria.listModelos.get(i).esvaziarLista();

		controleMateria.gerarMateriaRestante(textoMateria.getText(), textoNota.getText(),
				textoRestante.getText());

		controleMateria.incluirDAO();
	}

}
