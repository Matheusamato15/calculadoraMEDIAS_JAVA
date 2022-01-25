package Modelo;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ModeloJTable extends AbstractTableModel{

	
	private String [] colunas = {"Materia", "Primeira Nota", "Segunda Nota", "Restante Nota", "Média Final"};
	private ArrayList<ModeloMateria> listaDeMaterias = new ArrayList<ModeloMateria>();
	
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return listaDeMaterias.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
			case 0: 
				return listaDeMaterias.get(linha).getNomeMateria();
			case 1:
				return listaDeMaterias.get(linha).getPrimeiraNota();
			case 2:
				return listaDeMaterias.get(linha).getSegundaNota();
			case 3:
				return listaDeMaterias.get(linha).getRestanteNota();
			case 4:
				return listaDeMaterias.get(linha).getMediaFinal();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int coluna) {
		return colunas[coluna];
	}
	
	public void adicionarLinha (ModeloMateria materia) {
		this.listaDeMaterias.add(materia);
	
	}
	
	public ModeloMateria obterLinha(int linha) {
		return this.listaDeMaterias.get(linha);
	}
}
