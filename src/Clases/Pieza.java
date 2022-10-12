package Clases;

public class Pieza {
	
	private String nombre;
	private int codigoPieza; 
	private String tipoPieza; 
	private String paisOrigen;
	private int cantMaterialNecesario;
	
	public Pieza(String nombre, int codigoPieza, String tipoPieza, String paisOrigen, int cantMaterialNecesario) {
		this.nombre = nombre;
		this.codigoPieza = codigoPieza;
		this.tipoPieza = tipoPieza;
		this.paisOrigen = paisOrigen;
		this.cantMaterialNecesario = cantMaterialNecesario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigoPieza() {
		return codigoPieza;
	}

	public void setCodigoPieza(int codigoPieza) {
		this.codigoPieza = codigoPieza;
	}

	public String getTipoPieza() {
		return tipoPieza;
	}

	public void setTipoPieza(String tipoPieza) {
		this.tipoPieza = tipoPieza;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	public int getCantMaterialNecesario() {
		return cantMaterialNecesario;
	}

	public void setCantMaterialNecesario(int cantMaterialNecesario) {
		this.cantMaterialNecesario = cantMaterialNecesario;
	} 
	
	
	

}
