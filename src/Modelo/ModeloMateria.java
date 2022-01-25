package Modelo;

public class ModeloMateria {
	
	private Integer id;
	private String primeiraNota;
	private String segundaNota;
	private String restanteNota;
	private String mediaFinal;
	private String nomeMateria;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeMateria() {
		return nomeMateria;
	}
	
	public void setNomeMateria(String nomeMateria) {
		this.nomeMateria = nomeMateria;
	}
	
	public String getPrimeiraNota() {
		return primeiraNota;
	}
	
	public void setPrimeiraNota(String primeiraNota) {
		this.primeiraNota = primeiraNota;
	}
	
	public String getSegundaNota() {
		return segundaNota;
	}
	
	public void setSegundaNota(String segundaNota) {
		this.segundaNota = segundaNota;
	}
	
	public String getRestanteNota() {
		return restanteNota;
	}

	public void setRestanteNota(String restanteNotaFloat) {
		this.restanteNota = restanteNotaFloat;
	}

	public String getMediaFinal() {
		return mediaFinal;
	}

	public void setMediaFinal(String mediaFinalFloat) {
		this.mediaFinal = mediaFinalFloat;
	}

	@Override
	public String toString() {
		return "ModeloMateria [primeiraNota=" + primeiraNota + ", segundaNota=" + segundaNota + ", id=" + id
				+ ", nomeMateria=" + nomeMateria + "]";
	}

}
