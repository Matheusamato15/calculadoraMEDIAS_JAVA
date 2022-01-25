package Modelo;


public class ModeloRestante extends ModeloCalculoNotas {
	

	@Override
	public Integer getNumeroNotas() {
		return 1;
	}

	@Override
	public float executaCalculo() {
		return (float) (((30.0-(notas.get(0)*0.1)*2.0))/3.0);
	}

	@Override
	public float executarCalculoPeso() {
		return (float) ((notas.get(0)*0.1) * 2.0);
	}

	@Override
	public String getSimbolo() {
		return "R";
	}



}
