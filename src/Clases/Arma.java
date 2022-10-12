package Clases;

public class Arma {
	
	private String nombre; 
	private int codArma;
	private int municion; 
	private String paisOrigen;
	private int cantMaterial;
	
	public Arma(String nombre, int codArma, int municion, String paisOrigen, int cantMaterial) {
		this.nombre = nombre;
		this.codArma = codArma;
		this.municion = municion;
		this.paisOrigen = paisOrigen;
		this.cantMaterial = cantMaterial;
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodArma() {
		return codArma;
	}

	public void setCodArma(int codArma) {
		this.codArma = codArma;
	}

	public int getMunicion() {
		return municion;
	}

	public void setMunicion(int municion) {
		this.municion = municion;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	public int getCantMaterial() {
		return cantMaterial;
	}

	public void setCantMaterial(int cantMaterial) {
		this.cantMaterial = cantMaterial;
	}
}
