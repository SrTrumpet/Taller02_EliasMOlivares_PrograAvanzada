package Clases;

import java.util.ArrayList;
import java.util.List;

public class Menu {

	private List<String> listaPaises = new ArrayList<String>();

	public void guardarArchPersonas(String linea) {

	}

	public void guardarMaterial(String linea) {

	}

	public void guardarPaises(String linea) {

		String[] datos = linea.split(",");

		String nombre = datos[0];
		// Esta condicion sirve para agregar los paises que trabajaron en construir los
		// robots el cual nos servira para la opcion "12" de la clase App
		if (verificarPais(nombre)) {
			listaPaises.add(nombre);
		}
		
		
		
		

	}

	public void guardarArmas(String linea) {

	}

	public void guardarPiezas(String linea) {

	}

	public void guardarRobot(String linea) {

	}

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

}
