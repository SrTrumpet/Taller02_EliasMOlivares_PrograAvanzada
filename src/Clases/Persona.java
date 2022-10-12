package Clases;

public class Persona {
	
	private String nombre;
	private String identificacion;
	private String especialidad;
	private String equipo;
	
	
	public Persona(String nombre, String identificacion, String especialidad, String equipo) {
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.especialidad = especialidad;
		this.equipo = equipo;
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	
	
	

}
