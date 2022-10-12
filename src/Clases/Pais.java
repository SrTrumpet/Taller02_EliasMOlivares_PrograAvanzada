package Clases;

import java.util.ArrayList;
import java.util.List;

public class Pais {
	
	private String nombre;
	private String piezaArma;
	private int codPiezaArma;
	private int cantidad;
	private String materialPiezaArma;
	
	private List<Pieza> listaPiezas = new ArrayList<Pieza>();
	private List<Arma> listaArmas = new ArrayList<Arma>();
	
	
	public Pais(String nombre, String piezaArma, int codPiezaArma, int cantidad, String materialPiezaArma) {
		this.nombre = nombre;
		this.piezaArma = piezaArma;
		this.codPiezaArma = codPiezaArma;
		this.cantidad = cantidad;
		this.materialPiezaArma = materialPiezaArma;
	}

	public void agregarArma(Arma arma) {
		if(listaArmas.size() < cantidad) {
			listaArmas.add(arma);
		}
	}
	public void agregarPieza(Pieza pieza) {
		if(listaPiezas.size() < cantidad) {
			listaPiezas.add(pieza);
		}
	}
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getPiezaArma() {
		return piezaArma;
	}


	public void setPiezaArma(String piezaArma) {
		this.piezaArma = piezaArma;
	}


	public int getCodPiezaArma() {
		return codPiezaArma;
	}


	public void setCodPiezaArma(int codPiezaArma) {
		this.codPiezaArma = codPiezaArma;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public String getMaterialPiezaArma() {
		return materialPiezaArma;
	}


	public void setMaterialPiezaArma(String materialPiezaArma) {
		this.materialPiezaArma = materialPiezaArma;
	}
}
