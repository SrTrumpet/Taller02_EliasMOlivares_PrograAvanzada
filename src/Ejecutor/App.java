package Ejecutor;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import Clases.Gestor;
import Clases.Menu;
import Clases.Persona;

public class App {

	public static void main(String[] args) throws IOException {
		App admin = new App();
		admin.exe(admin);
	}

	/***
	 * Administra el flujo de la ejecucion del programa completo
	 * 
	 * @param admin
	 * @throws IOException
	 */
	public void exe(App admin) throws IOException {
		Menu menu = new Menu();
		admin.leerArchivo(menu);
		Gestor g = new Gestor();
		menu.generarGrupos();

		if (verificarInicioSesion(menu)) {
			System.out.println("Iniciando Sesion...");
			System.out.println("");

			admin.menuOpciones(menu);
		} else {
			System.out.println("Error, usuario no encontrado o error en los datos ingresados!!");
		}

	}

	public void leerArchivo(Menu menu) throws IOException {

		// Se leeran todos los archivos antes del archivo robots.txt ya que este ultimo
		// nos dirá que conecta con que
		// ya que si se hace al revez no tendriamos las instancias creadas

		Scanner leerPersonas = new Scanner(new File("src\\Txt\\Personas.txt"));
		// Lectura arch Personas.txt
		while (leerPersonas.hasNextLine()) {
			String linea = leerPersonas.nextLine();
			menu.guardarArchPersonas(linea);
		}

		Scanner leerMaterial = new Scanner(new File("src\\Txt\\Materiales.txt"));

		while (leerMaterial.hasNextLine()) {
			String linea = leerMaterial.nextLine();
			menu.guardarMaterial(linea);

		}

		Scanner leerArmas = new Scanner(new File("src\\Txt\\Armas.txt"));

		while (leerArmas.hasNextLine()) {
			String linea = leerArmas.nextLine();
			menu.guardarArmas(linea);
		}

		Scanner leerPieza = new Scanner(new File("src\\Txt\\Piezas.txt"));

		while (leerPieza.hasNextLine()) {
			String linea = leerPieza.nextLine();
			menu.guardarPiezas(linea);
		}

		Scanner leerPaises = new Scanner(new File("src\\Txt\\Paises.txt"));

		while (leerPaises.hasNextLine()) {
			String linea = leerPaises.nextLine();
			menu.guardarPaises(linea);
		}

		Scanner leerRobot = new Scanner(new File("src\\Txt\\robots.txt"));

		while (leerRobot.hasNextLine()) {
			String linea = leerRobot.nextLine();
			menu.guardarRobot(linea);

		}
	}

	public void menuOpciones(Menu menu) {

		Scanner leer = new Scanner(System.in);
		int opcion = 0;

		while (opcion != 18) {
			System.out.println(
					"""
							1) Ingresar pieza o arma: Se pregunta si se añadirá una pieza o arma con todas las características de esta.
							2) Ensamblar robot: Se ingresan las piezas del robot existentes (en caso de añadir pieza extra es opcional)
							para luego asociarlo a un equipo y a un piloto ya existente
							3) Crear equipo: Se creará un nuevo equipo, en caso de que no exista alguna persona en la base de datos
							se le pedirá añadir uno nuevo.
							4) Buscar por tipos de piezas: Se ingresa un tipo de pieza y se muestran los países con las piezas
								disponibles.
							5) Buscar por material: se ingresa un material y se muestra el país de donde se produce y su stock restante
							6) Crear modelo: Los modelos de cada robot viene dado por la suma de los códigos de sus piezas más un
							código que es el nombre del equipo y la inicial de cada integrante, para ser guardados como un objeto
							llamado modelos, que tiene el código modelo y el nombre del robot
							7) Revisar piezas: Es posible que algunos robots tengan mal asociados sus piezas, así que se pide un
								nombre de robot para ver las piezas que tiene y cambiarles por alguna pieza válida correspondiente.
							8) Mostrar todas las personas, estas deberán ser mostradas por separado Ensamblador/Piloto
							9) Mostrar todos los grupos
							10) Mostrar todos los robots
							11) Revisar munición: Se muestran todos los robots, para luego aumentar la munición de alguno,
								independiente de que tenga o no munición.
							12) Mostrar todos los Países
							13) Añadir stock piezas: Se elige un país para agregar el stock de las piezas que crea
							14) Añadir stock Materiales: Se elige un material para agregar el stock
							15) Mostrar todas las Piezas y armas
							16) Cambiar piezas: Se ingresa el nombre de un robot para mostrar sus piezas y arma, luego se pedirá
								cambiar una de estas por alguna otra del mismo tipo.
							17) Menú secreto
							18) Cerrar Sistema
							""");
			opcion = Integer.parseInt(leer.nextLine());

			if (opcion == 1) {
				System.out.println("Que añadira? Pieza = 1, Arma = 2");
				int opcionAdd = Integer.parseInt(leer.nextLine());

				if (opcionAdd == 1) {
					System.out.println("Igrese le nombre de la pieza: ");
					String nombrePieza = leer.nextLine();
					System.out.println("Ingrese el codigo de la pieza: ");
					String codigoPieza = leer.nextLine();
					System.out.println("Ingrese el tipo de pieza: ");
					String tipoPieza = leer.nextLine();
					System.out.println("Ingrese el pais de Origen: ");
					String paisOrigen = leer.nextLine();
					System.out.println("Ingrese la cantidad de material: ");
					String cantMaterial = leer.nextLine();

					System.out.println("Ingrese la cantidad de " + nombrePieza + " que tendra " + paisOrigen);
					String cantidad = leer.nextLine();
					System.out.println("Ingrese el material de que esta hecho el " + nombrePieza);
					String material = leer.nextLine();

					String objetoPieza = nombrePieza + "," + codigoPieza + "," + tipoPieza + "," + paisOrigen + ","
							+ cantMaterial;
					menu.guardarPiezas(objetoPieza);

					String paisGuardar = paisOrigen + ",pieza," + codigoPieza + "," + cantidad + "," + material;
					menu.guardarPaises(paisGuardar);
				} else if (opcionAdd == 2) {
					System.out.println("Ingrese el nombre del arma: ");
					String nombre = leer.nextLine();
					System.out.println("Ingrese el codigo del arma: ");
					String codigo = leer.nextLine();
					System.out.println("Ingrese la municion: ");
					String municion = leer.nextLine();
					System.out.println("Ingrese el pais de origen: ");
					String paisOrigen = leer.nextLine();
					System.out.println("Ingrese el tipo de material que esta hecha el arma: ");
					String tipoMaterial = leer.nextLine();
					System.out.println("Ingrese cantidad de material: ");
					String cantMaterial = leer.nextLine();

					String objetoArma = nombre + "," + codigo + "," + municion + "," + paisOrigen + "," + cantMaterial;
					menu.guardarArmas(objetoArma);

					System.out.println("Cuantas armas agregara?: ");
					String cantidadArmas = leer.nextLine();

					String objetoPais = paisOrigen + ",arma," + codigo + "," + cantidadArmas + "," + tipoMaterial;
					menu.guardarPaises(objetoPais);

				} else {
					System.out.println("Opcion no valida");
				}
			} else if (opcion == 2) {
			} else if (opcion == 3) {
			} else if (opcion == 4) {
				System.out.println("Ingrese el tipo de pieza: ");
				String tipo = leer.nextLine();
				menu.mostrarTipoPieza(tipo);
			} else if (opcion == 5) {
				System.out.println("Ingrese le material a buscar: ");
				String material = leer.nextLine().toLowerCase();

				menu.mostrarMaterialPais(material);
				System.out.println(" ");
			} else if (opcion == 6) {
			} else if (opcion == 7) {

				System.out.println("Ingrese el nombre del robot: ");
				String nombre = leer.nextLine();
				Clases.Robot robot = menu.robotMunicion(nombre);
				if (robot == null) {
					System.out.println("Robot no encontrado!");
				} else {
					System.out.println(robot.mostrarPiezasArmas());
					System.out.println("");
					System.out.println("Ve algun error? SI/NO");
					String confirmacion = leer.nextLine().toLowerCase();

					if (confirmacion.equals("si")) {
						System.out.println("Ingrese la pieza a cambiar: (brazo, cabeza, piernas o torax)");
						String tipoPieza = leer.nextLine();
						System.out.println("Ingrese el nombre de la pieza: ");
						String nombrePieza = leer.nextLine();
						if (menu.buscarPieza(nombrePieza, tipoPieza)) {
							if (tipoPieza.equals("brazo")) {
								robot.setNombreBrazo(nombrePieza);
							} else if (tipoPieza.equals("cabeza")) {
								robot.setNombreCabeza(nombrePieza);
							} else if (tipoPieza.equals("piernas")) {
								robot.setNombrePiernas(nombrePieza);
							} else if (tipoPieza.equals("torax")) {
								robot.setNombreTorax(nombrePieza);
							}
							System.out.println("Cambiado con exito");
						} else {
							System.out.println("Error!");
						}
					} else {
						System.out.println("Saliendo...");
					}
				}
			} else if (opcion == 8) {
				System.out.println(" ");
				menu.mostrarPersonas();
				System.out.println(" ");
			} else if (opcion == 9) {
				menu.mostrarGrupos();
			} else if (opcion == 10) {
				menu.mostrarRobots();
			} else if (opcion == 11) {
				menu.mostrarMunicionRobot();
				System.out.println("Ingrese el nombre del robot a añadir municion: ");
				String nombre = leer.nextLine();
				Clases.Robot addMunicion = menu.robotMunicion(nombre);
				System.out.println("Cuanta municion añadira?: ");
				int municionAdd = Integer.parseInt(leer.nextLine());
				if (addMunicion == null) {
					System.out.println("Robot ingresado no encontrado");
				} else {
					addMunicion.addMunicion(municionAdd);
					System.out.println("Robot: " + addMunicion.getNombreRobot() + " ,municion actual: "
							+ addMunicion.getMunicion());
				}

			} else if (opcion == 12) {
				System.out.println("##############");
				System.out.println("Lista Paises");
				System.out.println("##############");
				menu.mostrarPaises();
				System.out.println(" ");
			} else if (opcion == 13) {
				System.out.println("Ingrese el nombre del pais que añadira piezas: ");
				String pais = leer.nextLine();
				String frase = menu.mostrarPiezaSegunPais(pais);

				if (frase.equals("a")) {
					System.out.println("El pais no tiene piezas vinculadas");
				} else {
					System.out.println(frase);
					System.out.println("Ingrese el codigo de la pieza para añadirle stock: ");
					String codigo = leer.nextLine();
					System.out.println("Ingrese cuanto stock le añadira: ");
					int cantidad = Integer.parseInt(leer.nextLine());

					if (menu.addStockPieza(codigo, cantidad)) {
						System.out.println("Añadido correctamente");
					} else {
						System.out.println("No se pudo añadir");
					}
				}
			} else if (opcion == 14) {
				System.out.println(" ");
				System.out.println("Ingrese el nombre del material que se le agregará stock: ");
				String material = leer.nextLine().toLowerCase();
				System.out.println("Ingrese la cantidad a agregar: ");
				int cantidad = Integer.parseInt(leer.nextLine());

				menu.addMaterial(material, cantidad);
				System.out.println(" ");
			} else if (opcion == 15) {
				System.out.println(" ");
				menu.mostrarArmasPiezas();
				System.out.println(" ");
			} else if (opcion == 16) {

				System.out.println("Ingrese el nombre del robot: ");
				String nombre = leer.nextLine();
				Clases.Robot robot = menu.robotMunicion(nombre);
				if (robot == null) {
					System.out.println("Robot no encontrado!");
				} else {
					System.out.println(robot.mostrarPiezasArmas());
					System.out.println("");

				}
			} else if (opcion == 17) {

				System.out.println("Ingrese credencial: ");
				String credencial = leer.nextLine();
				if (credencial.equals("empanada")) {
					System.out.println("Ingrese identificacion: ");
					String pass = leer.nextLine();
					if (pass.equals("porotosconriendas")) {
						String material = "area51,100000,uranio";
						menu.guardarMaterial(material);

					} else {
						System.out.println("ERROR!");
					}
				} else {
					System.out.println("ERROR!");
				}
			} else if (opcion == 18) {
				opcion = 0;
			}

		}

	}

	public boolean verificarInicioSesion(Menu menu) {
		Scanner leer = new Scanner(System.in);

		System.out.println("Ingrese nombre de usuario: ");
		String nombre = leer.nextLine();
		System.out.println("Ingrese su identificacion: ");
		String identificacion = leer.nextLine();

		Persona userInicioSesion = menu.getPersona(identificacion);

		if (userInicioSesion == null) {
			return false;
		}

		return userInicioSesion.getIdentificacion().equals(identificacion)
				&& userInicioSesion.getNombre().equals(nombre) && userInicioSesion.getEspecialidad().equals("admin");
	}

	public static void burbuja(int[] A) {
		int i, j, aux;
		for (i = 0; i < A.length - 1; i++) {
			for (j = 0; j < A.length - i - 1; j++) {
				if (A[j + 1] < A[j]) {
					aux = A[j + 1];
					A[j + 1] = A[j];
					A[j] = aux;
				}
			}
		}
	}
}
