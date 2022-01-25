package Visao;

import Controle.ControleJanelas;
import Modelo.ModeloMateria;

public class VisaoMedia extends VisaoRestante {
	
	ControleJanelas controleJanelas = new ControleJanelas();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VisaoMedia(ModeloMateria materia) {
		formarTitulo("Bem-Vindo a média final!");
		
		liberarComponentes();
		
		preencherCamposComDeusParaAtualizar(materia);
		
		escreverNaSegundaNota();
		
	}


	private void escreverNaSegundaNota() {
		
		escreverNaCalculadora(botao1, textFieldNota2);
		escreverNaCalculadora(botao2, textFieldNota2);
		escreverNaCalculadora(botao3, textFieldNota2);
		escreverNaCalculadora(botao4, textFieldNota2);
		escreverNaCalculadora(botao5, textFieldNota2);
		escreverNaCalculadora(botao6, textFieldNota2);
		escreverNaCalculadora(botao7, textFieldNota2);
		escreverNaCalculadora(botao8, textFieldNota2);
		escreverNaCalculadora(botao9, textFieldNota2);
		escreverNaCalculadora(botao0, textFieldNota2);
	}
	
	
	
	private void preencherCamposComDeusParaAtualizar(ModeloMateria deusParaAtualizar) {
		textFieldMateria.setText(deusParaAtualizar.getNomeMateria());
		textFieldNota.setText(deusParaAtualizar.getPrimeiraNota());
		textFieldNota2.setText(deusParaAtualizar.getSegundaNota());
		textFieldRestante.setText(deusParaAtualizar.getRestanteNota());
		textFieldMediaFinal.setText(deusParaAtualizar.getMediaFinal());
	}

}
