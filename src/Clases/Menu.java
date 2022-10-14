package Clases;

import java.util.ArrayList;
import java.util.List;

public class Menu {

	private Gestor administrador = new Gestor();
	private List<String> listaPaises = new ArrayList<String>();
	private List<Persona> listaUsuarios = new ArrayList<Persona>();

	public void guardarArchPersonas(String linea) {

		String[] datos = linea.split(",");
		String identificacion = datos[1];
		Persona buscar = verificarUsuario(identificacion);

		if (buscar == null) {
			String nombre = datos[0];
			// indentificacion
			String especialidad = datos[2];
			String equipo = datos[3];
			Persona agregar = new Persona(nombre, identificacion, especialidad, equipo);

			administrador.guardarPersona(agregar);
			listaUsuarios.add(agregar);
		}

	}

	public void guardarMaterial(String linea) {
		
		String[] datos = linea.split(",");
		String nombreMaterial = datos[0];
		int stock = Integer.parseInt(datos[1]);
		String nombrePais = datos[2];
		
		Material material = new Material(nombreMaterial, stock, nombrePais);
		administrador.guardarMaterial(material);

	}

	public void guardarPaises(String linea) {

		String[] datos = linea.split(",");

		String nombre = datos[0];
		// Esta condicion sirve para agregar los paises que trabajaron en construir los
		// robots el cual nos servira para la opcion "12" de la clase App
		if (verificarPais(nombre)) {
			listaPaises.add(nombre);
		}

		String piezaArma = datos[1];
		String codArmaPieza = datos[2];
		int cantidad = Integer.parseInt(datos[3]);
		String materialPieza = datos[4];

		Pais nuevo = new Pais(nombre, piezaArma, codArmaPieza, cantidad, materialPieza);
		administrador.vincularPaisArmaPieza(nuevo);
	}

	public void guardarArmas(String linea) {

		String[] datos = linea.split(",");

		String nombreArma = datos[0];
		String codArma = datos[1];
		int municion = Integer.parseInt(datos[2]);
		String paisOrigen = datos[3];
		int cantMaterial = Integer.parseInt(datos[4]);

		Arma agregar = new Arma(nombreArma, codArma, municion, paisOrigen, cantMaterial);

		administrador.guardarArma(agregar);

	}

	public void guardarPiezas(String linea) {

		String[] datos = linea.split(",");

		String nombrePieza = datos[0];
		String codigoPieza = datos[1];
		String tipoPieza = datos[2];
		String paisOrigen = datos[3];
		int cantMaterial = Integer.parseInt(datos[4]);

		Pieza agregar = new Pieza(nombrePieza, codigoPieza, tipoPieza, paisOrigen, cantMaterial);
		administrador.guardarPieza(agregar);
	}

	public void guardarRobot(String linea) {
		
		String[] datos = linea.split(",");
		
		String nombreRobot = datos[0];
		String nombreBrazo = datos[1];
		String nombrePiernas = datos[2];
		String nombreTorax = datos[3];
		String nombreCabeza = datos[4];
		String nombreCualidad = datos[5];
		String nombreArma = datos[6];
		String nombreEquipo = datos[7];
		String codigoPiloto = datos[8];
		
		Robot robot = new Robot(nombreRobot, nombreBrazo, nombrePiernas, nombreTorax, nombreCabeza, nombreCualidad, nombreArma, nombreEquipo, codigoPiloto);
		
		administrador.guardarRobot(robot);
		

	}
	
	public void addMaterial(String material, int add) {
		
		Material addStock = administrador.buscarMaterial(material);
		if(addStock == null) {
			System.out.println("Material no encontrado");
		}else {
			System.out.println("Material ingresado: "+material.toUpperCase()+" Pais: "+addStock.getNombrePais());
			System.out.println(" ");
			System.out.println("Cantidad actual: "+addStock.getStock());
			int actual = addStock.getStock();
			addStock.setStock(add+actual);
			System.out.println("Cantidad añadida: +"+add);
			System.out.println("Total ==> "+addStock.getStock());
			
		}
	}
	
	public void mostrarMaterialPais(String material) {
		Material buscar = administrador.buscarMaterial(material);
		if(buscar == null) {
			System.out.println("Material no econtrado");
		}else {
			System.out.println("Material ingresado: "+material.toUpperCase());
			System.out.println("Pais que lo tiene: "+buscar.getNombrePais());
			System.out.println("Stock restante: "+buscar.getStock());
		}
	}
	

	/***
	 * Muestra por consola los paises que participan de este programa
	 */
	public void mostrarPaises() {
		for (String s : listaPaises) {
			System.out.println(s);
		}
	}

	/***
	 * Devuelve falso si el pais ingresado ya existe en la listaPaises, de lo
	 * contrario devuelve true
	 * 
	 * @param nombre
	 * @return boolean
	 */
	private boolean verificarPais(String nombre) {
		boolean encontrado = true;
		for (String s : listaPaises) {
			if (s.equals(nombre)) {
				encontrado = false;
			}
		}
		return encontrado;
	}

	/***
	 * Busca por la listaUsuarios para verificar si la persona estaba registrada con
	 * anterioridad, en el caso de que no esté registrada se devuelve null
	 * 
	 * @param identificacion
	 * @return
	 */
	private Persona verificarUsuario(String identificacion) {
		for (Persona p : listaUsuarios) {
			if (p.getIdentificacion().equals(identificacion)) {
				return p;
			}
		}
		return null;
	}

	/***
	 * Esta funcion sera de uso exclusivo de la clase App
	 * 
	 * @param identificacion
	 * @return Persona (si se encuentra) sino se devuelve null
	 */
	public Persona getPersona(String identificacion) {
		for (Persona p : listaUsuarios) {
			if (p.getIdentificacion().equals(identificacion)) {
				return p;
			}
		}
		return null;
	}

	/***
	 * Se ingresa el tipo de pieza a buscar y devuelve el pais, nombre de la pieza y
	 * su disponibilidad
	 * 
	 * @param tipo
	 */
	public void mostrarTipoPieza(String tipo) {
		System.out.println(administrador.mostrarTipoDePieza(tipo));
	}

	/***
	 * Genera una lista separada, la primera parte es de ensambladores, y la segunda
	 * lista es de pilotos
	 */
	public void mostrarPersonas() {
		System.out.println("Ensambladores: ");
		for (Persona p : listaUsuarios) {
			if (p.getEspecialidad().equals("ensamblador")) {
				System.out.println("Nombre: " + p.getNombre() + " - unidad: " + p.getEquipo());
			}
		}
		System.out.println("Pilotos: ");
		for (Persona p : listaUsuarios) {
			if (p.getEspecialidad().equals("piloto")) {
				System.out.println("Nombre: " + p.getNombre() + " - unidad: " + p.getEquipo());
			}
		}
	}
	
	/***
	 * Muestra todas las armas y piezas
	 */
	public void mostrarArmasPiezas() {
		System.out.println(administrador.mostrarTodasLasPiezasArmas());
	}

	public void mostrarRobots() {
		System.out.println(administrador.mostrarRobot());
	}
}
