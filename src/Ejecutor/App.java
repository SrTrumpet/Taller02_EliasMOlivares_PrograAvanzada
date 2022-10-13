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
		admin.ejecutor(admin);
	}

	/***
	 * Administra el flujo de la ejecucion del programa completo
	 * @param admin
	 * @throws IOException
	 */
	public void ejecutor(App admin) throws IOException {
		Menu menu = new Menu();
		admin.leerArchivo(menu);
		Gestor g = new Gestor();
		
		if(verificarInicioSesion(menu)) {
			System.out.println("Iniciando Sesion...");
			System.out.println("");
			admin.menuOpciones(menu);
		}else {
			System.out.println("Error, usuario no encontrado o error en los datos ingresados!!");
		}
		
		
	}

	
	public void leerArchivo(Menu menu) throws IOException {

		// Se leeran todos los archivos antes del archivo robots.txt ya que este ultimo
		// nos dirá que conecta con que
		// ya que si se hace al revez no tendriamos las instancias creadas
		
		Scanner leerPersonas = new Scanner(new File("src\\Txt\\Personas.txt"));
		//Lectura arch Personas.txt
		while(leerPersonas.hasNextLine()) {
			String linea = leerPersonas.nextLine();
			menu.guardarArchPersonas(linea);
		}
		
		Scanner leerMaterial = new Scanner(new File("src\\Txt\\Materiales.txt"));
		
		while(leerMaterial.hasNextLine()) {
			String linea = leerMaterial.nextLine();
			menu.guardarArchPersonas(linea);
		}
		
		Scanner leerArmas = new Scanner(new File("src\\Txt\\Armas.txt"));
		
		while(leerArmas.hasNextLine()) {
			String linea = leerArmas.nextLine();
			menu.guardarArmas(linea);
		}
		
		Scanner leerPieza = new Scanner(new File("src\\Txt\\Piezas.txt"));
		
		while(leerPieza.hasNextLine()) {
			String linea = leerPieza.nextLine();
			menu.guardarPiezas(linea);
		}
		
		Scanner leerPaises = new Scanner(new File("src\\Txt\\Paises.txt")); 
		
		while(leerPaises.hasNextLine()) {
			String linea = leerPaises.nextLine();
			menu.guardarPaises(linea);
		}
		
		Scanner leerRobot = new Scanner("src\\Txt\\robots.txt");
		
		while(leerRobot.hasNextLine()) {
			String linea = leerRobot.nextLine();
			
		}
	}
	
	public void menuOpciones(Menu menu) {
		
		Scanner leer = new Scanner(System.in);
		int opcion = 0;
		
		while(opcion!= 18) {
			System.out.println("""
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
			
			if(opcion == 1) {}
			else if(opcion == 2) {}
			else if(opcion == 3) {}
			else if(opcion == 4) {
				System.out.println("Ingrese el tipo de pieza: ");
				String tipo = leer.nextLine();
				menu.mostrarTipoPieza(tipo);
			}
			else if(opcion == 5) {}
			else if(opcion == 6) {}
			else if(opcion == 7) {}
			else if(opcion == 8) {
				System.out.println(" ");
				menu.mostrarPersonas();
				System.out.println(" ");
			}
			else if(opcion == 9) {}
			else if(opcion == 10) {}
			else if(opcion == 11) {}
			else if(opcion == 12) {
				System.out.println("##############");
				System.out.println("Lista Paises");
				System.out.println("##############");
				menu.mostrarPaises();
				System.out.println(" ");
			}
			else if(opcion == 13) {}
			else if(opcion == 14) {}
			else if(opcion == 15) {
				System.out.println(" ");
				menu.mostrarArmasPiezas();
				System.out.println(" ");
			}
			else if(opcion == 16) {}
			else if(opcion == 17) {}
			else if(opcion == 18) {}
			
		}
		
		
	}
	
	public boolean verificarInicioSesion(Menu menu) {
		Scanner leer = new Scanner(System.in);
		
		System.out.println("Ingrese nombre de usuario: ");
		String nombre = leer.nextLine();
		System.out.println("Ingrese su identificacion: ");
		String identificacion = leer.nextLine();
		
		Persona userInicioSesion = menu.getPersona(identificacion);
		
		if(userInicioSesion == null) {
			return false;
		}
		
		return userInicioSesion.getIdentificacion().equals(identificacion) && userInicioSesion.getNombre().equals(nombre) && userInicioSesion.getEspecialidad().equals("admin");
	}
}
