package Clases;

import java.util.ArrayList;
import java.util.List;

public class Gestor {
	
	private List<Persona> listaUsuarios = new ArrayList<Persona>();
	private List<Pieza> listaPiezas = new ArrayList<Pieza>();
	private List<Arma> listaArmas = new ArrayList<Arma>();
	private List<Pais> listaPaises = new ArrayList<Pais>();
	
	protected void guardarPersona(Persona agregar) {
		listaUsuarios.add(agregar);
	}

	protected void guardarPieza(Pieza pieza) {
		listaPiezas.add(pieza);
	}
	
	protected void guardarArma(Arma arma) {
		listaArmas.add(arma);
	}
	
	
	
	protected void guardarPais(Pais pais) {
		
		
		
		
		listaPaises.add(pais);
	}
	
	
	
	private Pieza buscarPieza(String codigo) {
		return null;
	}
	
	private Arma buscarArma(String codigo) {
		return null;
	}
	
}
