package Clases;

import java.util.ArrayList;
import java.util.List;

public class Gestor {

	private List<Persona> listaUsuarios = new ArrayList<Persona>();
	private List<Pieza> listaPiezas = new ArrayList<Pieza>();
	private List<Arma> listaArmas = new ArrayList<Arma>();
	private List<Pais> listaPaises = new ArrayList<Pais>();
	private List<Material> listaMateriales = new ArrayList<Material>();
	private List<Robot> listaRobots = new ArrayList<Robot>();
	private List<Grupo> listaGrupos = new ArrayList<Grupo>();

	protected void guardarPersona(Persona agregar) {
		listaUsuarios.add(agregar);
	}

	protected void guardarPieza(Pieza pieza) {
		listaPiezas.add(pieza);
	}

	protected void guardarArma(Arma arma) {
		listaArmas.add(arma);
	}
	
	protected void guardarMaterial(Material material) {
		listaMateriales.add(material);
	}
	
	protected void guardarRobot(Robot robot) {
		listaRobots.add(robot);
	}

	protected void vincularPaisArmaPieza(Pais pais) {

		if (pais.getPiezaArma().equals("arma")) {
			Arma vincular = buscarArma(pais.getCodPiezaArma());
			if (vincular == null) {
				System.out.println("Arma con el codigo: " + pais.getCodPiezaArma() + " No esta en los registros");
			} else {
				pais.agregarArma(vincular);
			}
		} else {
			Pieza vincular = buscarPieza(pais.getCodPiezaArma());
			if (vincular == null) {
				System.out.println("Pieza codigo: " + pais.getCodPiezaArma() + " no encotrado");
			} else {
				pais.agregarPieza(vincular);
			}
		}
		listaPaises.add(pais);
	}

	/***
	 * Genera una lista con todos los tipos de piezas que coincidan con el dato
	 * ingresado
	 * 
	 * @param tipoPieza
	 * @return
	 */
	protected String mostrarTipoDePieza(String tipoPieza) {
		String todasLasPiezas = "";

		for (Pais p : listaPaises) {
			String add = p.piezaTipo(tipoPieza);
			if (add == null) {
				continue;
			} else {
				todasLasPiezas += (add + "\n");
			}
		}
		return todasLasPiezas;
	}

	/***
	 * Devuelve la instancia de la clase Pieza, se debe ingresar el codigo para
	 * encontrarla
	 * 
	 * @param codigo
	 * @return
	 */
	private Pieza buscarPieza(String codigo) {
		for (Pieza p : listaPiezas) {
			if (p.getCodigoPieza().equals(codigo)) {
				return p;
			}
		}
		return null;
	}

	/***
	 * Devuelve la referencia a la instancia de la clase Arma, se debe ingresar el
	 * codigo para encontrarla
	 * 
	 * @param codigo
	 * @return
	 */
	private Arma buscarArma(String codigo) {
		for (Arma a : listaArmas) {
			if (a.getCodArma().equals(codigo)) {
				return a;
			}
		}
		return null;
	}

	/***
	 * Genera una lista con todas las armas y piezas existentes actualmente agregadas
	 * @return
	 */
	protected String mostrarTodasLasPiezasArmas() {
		
		String todo = "Piezas: \n";
		for(Pieza p: listaPiezas) {
			todo += (p.getNombre()+"\n"); 
		}
		todo += "\nArmas: \n";
		for(Arma a: listaArmas) {
			todo+= (a.getNombre()+"\n");
		}
		return todo;
		
	}
	protected Material buscarMaterial(String material) {
		for(Material m: listaMateriales) {
			if(m.getNombreMaterial().toLowerCase().equals(material)) {
				return m;
			}
		}
		return null;
	}
	
	protected String mostrarRobot() {
		String todosLosRobots = "Lista Robots: \n\n";
		for(Robot r: listaRobots) {
			todosLosRobots += r.toString()+"\n";
		}
		return todosLosRobots;
	}
	
	protected String mostrarGrupos() {
		String grupos = "";
		for(Grupo g: listaGrupos) {
			grupos+= g.toString();
			grupos+= "##################\n";
		}
		return grupos;
	}
	protected void generarGrupos() {
		
		for(Robot r: listaRobots) {
			String equipo = r.getNombreEquipo();
			Grupo grupo = verificarGrupo(equipo);
			if(grupo == null) {
				grupo = new Grupo(equipo);
				listaGrupos.add(grupo);
				addPersonasEquipo(grupo);
			}
		}
		
	}
	
	private void addPersonasEquipo(Grupo g) {
		for(Persona p: listaUsuarios) {
			System.out.println("Nombre: "+p.getNombre()+" Usao: "+p.getEquipo());
			if(p.getEquipo().equals(g.getNombreGrupo())) {
				g.addArmador(p);
			}
		}
		
	}
	
	private Grupo verificarGrupo(String equipo) {
		for(Grupo g: listaGrupos) {
			if(g.getNombreGrupo().equals(equipo)) {
				return g;
			}
		}
		return null;
	}
	
	protected String mostrarPiezaSegunPais(String pais) {
		boolean existePieza = true;
		String piezasPais = pais.toUpperCase()+"\n";
		
		for(Pais p: listaPaises) {
			if(p.getNombre().equals(pais) && p.getPiezaArma().equals("pieza")) {
				existePieza = false;
				Pieza objetoPieza = buscarPieza(p.getCodPiezaArma());
				piezasPais+= (objetoPieza.getNombre()+" ==> Cantidad Disponible: "+ p.getCantidad()+" Codigo ==>"+p.getCodPiezaArma()+"\n");
				
			}
		}
		if(existePieza) {
			return "a";
		}
		return piezasPais;
	}
	
	protected Pais menuBuscarPais(String codigo) {
		for(Pais p: listaPaises) {
			if(p.getCodPiezaArma().equals(codigo)) {
				return p;
			}
		}
		return null;
	}
	

}
