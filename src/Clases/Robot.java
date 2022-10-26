package Clases;
public class Robot {

	private String nombreRobot;
	private String nombreBrazo;
	private String nombrePiernas;
	private String nombreTorax;
	private String nombreCabeza;
	private String nombreCualidad;
	private String nombreArma;
	private String nombreEquipo;
	private String codigoPiloto;
	private int municion;

	public Robot(String nombreRobot, String nombreBrazo, String nombrePiernas, String nombreTorax, String nombreCabeza,
			String nombreCualidad, String nombreArma, String nombreEquipo, String codigoPiloto) {
		this.nombreRobot = nombreRobot;
		this.nombreBrazo = nombreBrazo;
		this.nombrePiernas = nombrePiernas;
		this.nombreTorax = nombreTorax;
		this.nombreCabeza = nombreCabeza;
		this.nombreCualidad = nombreCualidad;
		this.nombreArma = nombreArma;
		this.nombreEquipo = nombreEquipo;
		this.codigoPiloto = codigoPiloto;
	}

	public void addMunicion(int municion) {
		this.municion += municion;
	}

	public int getMunicion() {
		return municion;
	}

	public void setMunicion(int municion) {
		this.municion = municion;
	}

	public String getNombreRobot() {
		return nombreRobot;
	}

	public void setNombreRobot(String nombreRobot) {
		this.nombreRobot = nombreRobot;
	}

	public String getNombreBrazo() {
		return nombreBrazo;
	}

	public void setNombreBrazo(String nombreBrazo) {
		this.nombreBrazo = nombreBrazo;
	}

	public String getNombrePiernas() {
		return nombrePiernas;
	}

	public void setNombrePiernas(String nombrePiernas) {
		this.nombrePiernas = nombrePiernas;
	}

	public String getNombreTorax() {
		return nombreTorax;
	}

	public void setNombreTorax(String nombreTorax) {
		this.nombreTorax = nombreTorax;
	}

	public String getNombreCabeza() {
		return nombreCabeza;
	}

	public void setNombreCabeza(String nombreCabeza) {
		this.nombreCabeza = nombreCabeza;
	}

	public String getNombreCualidad() {
		return nombreCualidad;
	}

	public void setNombreCualidad(String nombreCualidad) {
		this.nombreCualidad = nombreCualidad;
	}

	public String getNombreArma() {
		return nombreArma;
	}

	public void setNombreArma(String nombreArma) {
		this.nombreArma = nombreArma;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public String getCodigoPiloto() {
		return codigoPiloto;
	}

	public void setCodigoPiloto(String codigoPiloto) {
		this.codigoPiloto = codigoPiloto;
	}

	@Override
	public String toString() {
		return this.nombreRobot + " pilotado por: " + this.codigoPiloto;
	}

	public String mostrarMunicion() {
		return this.nombreRobot + " - totalMunicion: " + this.municion;
	}

	public String mostrarPiezasArmas() {
		return "Arma: "+this.nombreArma+"\n"+"Piezas: \n\nBrazo: "+this.nombreBrazo+"\nCabeza: "+this.nombreCabeza+"\nPiernas: "+this.nombrePiernas+"\nTorax: "+this.nombreTorax;
	}
}













