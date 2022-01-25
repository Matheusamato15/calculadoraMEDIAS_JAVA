package Modelo;

public class ModeloMediaFinal extends ModeloCalculoNotas {

	@Override
	public Integer getNumeroNotas() {
		return 2;
	}

	@Override
	public float executarCalculoPeso() {
		return (float) ((notas.get(0)*0.1) * 3.0);
	}

	@Override
	public float executaCalculo() {
		return (float) ((notas.get(0)*2 + notas.get(1)*3)/5);
	}

	@Override
	public String getSimbolo() {
		return "M";
	}

}
