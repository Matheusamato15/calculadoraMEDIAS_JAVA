package Modelo;


import java.util.ArrayList;
import java.util.List;

public abstract class ModeloCalculoNotas {
	
	protected List<Integer> notas;

	public List<Integer> getNotas() {
		return notas;
	}

	public void setNotas(List<Integer> notas) {
		this.notas = notas;
	}
	
	public ModeloCalculoNotas() {
		notas = new ArrayList<Integer>();
	}
	
	public abstract Integer getNumeroNotas();
	public abstract float executarCalculoPeso();
	public abstract float executaCalculo();
	public abstract String getSimbolo();
	
	public boolean addoperando(Integer valor) {
		if(notas.size()<this.getNumeroNotas()) {
			notas.add(valor);
		} 
		return true;
		
	}
	
	
	public float calculoPeso() {
		return executarCalculoPeso();
	}
	
	public float calculoRestante() {
		return executaCalculo();
	}
	
	public void esvaziarLista() {
		notas.clear();
	}
	
}
