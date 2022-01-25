package Controle;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Modelo.ModeloCalculoNotas;
import Modelo.ModeloMateria;
import Modelo.ModeloRestante;
import Persistencia.PersistenciaDAOMateria;
import Util.UtilRetorno;
import Util.UtilRetornoDado;

public class ControleMateria {
	
	ModeloMateria modeloMateria = new ModeloMateria();
	public ArrayList<ModeloCalculoNotas> listModelos = new ArrayList<ModeloCalculoNotas>();
	private PersistenciaDAOMateria daoDeus = PersistenciaDAOMateria.getInstance();
	
	public ControleMateria() {
		adicionar();
	}
	
	public void gerarMateriaRestante(String nome, String nota, String restante) {
		modeloMateria.setNomeMateria(nome);
		modeloMateria.setPrimeiraNota(nota);
		modeloMateria.setSegundaNota("0");
		modeloMateria.setRestanteNota(restante);
		modeloMateria.setMediaFinal("0");

	}
	
	public void adicionar() {
		
		listModelos.add(new ModeloRestante());
	}
	
	public void incluirDAO() {

		UtilRetorno retorno = daoDeus.incluir(modeloMateria);
		
		if (retorno.isSucesso()) {
			JOptionPane.showMessageDialog(null, " Calculado com sucesso");
		} else {
			System.out.println("Erro ao executar:" + retorno.getMensagens());
			JOptionPane.showMessageDialog(null, " Erro ao calcular!", "Erro!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public List<ModeloMateria> executarVisualizarDAO() {
		UtilRetornoDado<List<ModeloMateria>> listarDeus = daoDeus.listarmateria();
			
		return listarDeus.getDado();
	}

	
}
