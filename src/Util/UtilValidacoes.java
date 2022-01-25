package Util;


import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;



public class UtilValidacoes {
	
	public int validarCamposForamPreenchidos(JTextField nome, JTextField nota1) {
		if(nome.getText().equals("") ||nota1.getText().equals("") ) {
			
			JOptionPane.showMessageDialog(null, "Existem campos não preenchidos!", "Erro!", JOptionPane.ERROR_MESSAGE);
			return 1;
		}else {
			return 0;
		}
		
	}
	
		
	public boolean validarLinhaSelecionada(JTable table) {
		if(table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Selecione uma matéria para poder prosseguir!", "Erro!", JOptionPane.ERROR_MESSAGE);
			return true;
		}else {
			return false;
		}

	}
	
	
}
