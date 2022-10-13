package Clases;



public class Pais {

	private String nombre;
	private String piezaArma;
	private String codPiezaArma;
	private int cantidad;
	private String materialPiezaArma;

	private Pieza pieza;
	private Arma arma;

	public Pais(String nombre, String piezaArma, String codPiezaArma, int cantidad, String materialPiezaArma) {
		this.nombre = nombre;
		this.piezaArma = piezaArma;
		this.codPiezaArma = codPiezaArma;
		this.cantidad = cantidad;
		this.materialPiezaArma = materialPiezaArma;
	}

	public void agregarArma(Arma arma) {
		this.arma = arma;
	}

	public void agregarPieza(Pieza pieza) {
		this.pieza = pieza;
	}

	public String piezaTipo(String tipo) {
		if (pieza == null) {
			return null;
		} else if (pieza.getTipoPieza().equals(tipo)) {
			return this.nombre + ": " + pieza.getNombre() + " - codigo: " + pieza.getCodigoPieza() + " - disponibles: "
					+ cantidad;
		}return null;
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

	public String getCodPiezaArma() {
		return codPiezaArma;
	}

	public void setCodPiezaArma(String codPiezaArma) {
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
