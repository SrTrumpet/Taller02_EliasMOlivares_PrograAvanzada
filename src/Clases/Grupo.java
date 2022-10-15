package Clases;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
	
	private String nombreGrupo;
	private List<Persona> listaPersonas;
	private int cantUsuarios = 5;
	private Persona piloto;
	
	public Grupo(String nombre) {
		this.nombreGrupo = nombre;
		listaPersonas = new ArrayList<Persona>();
		
	}
	
	public void addArmador(Persona ensamblador) {
		if(ensamblador.getEspecialidad().equals("piloto")) {
			this.piloto = ensamblador;
		}
		else if(listaPersonas.size()<cantUsuarios) {
			listaPersonas.add(ensamblador);
		}
	}

	public String getNombreGrupo() {
		return nombreGrupo;
	}

	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}
	
	@Override
	
	public String toString() {
		if(piloto == null) {
			return "Equipo: "+nombreGrupo+ "\nPiloto: NO ASIGANDO"+"\nTotal Ensambladores en el grupo: "+listaPersonas.size()+"\n";
		}
		return "Equipo: "+nombreGrupo+ "\nPiloto: "+piloto.getNombre()+"\nTotal Ensambladores en el grupo: "+listaPersonas.size()+"\n";
	}
	

}
