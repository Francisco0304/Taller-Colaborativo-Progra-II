package view;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase View: En esta clase estaran definidos los metodos que estaran a la
 * vista el usuario.
 * 
 * @TallerColavorativo1er50
 */
public class View {
	private Scanner sc = new Scanner(System.in);

	/**
	 * Imprime las opciones del menu y lee la opcion seleccionada.
	 * 
	 * @return Devuelve un entero segun la opcion selecionada.
	 */
	public int readOptionMenu() {
		showMessage("Bienvenido! \n" + "¿Qué desea hacer con la cadena? Selecione una opcion. \n"
				+ "[1] Convertirla a nombre propio.\n" + "[2] Buscar cadena.\n" + "[3] Contar Vocales.\n"
				+ "[4] Anio nuevo.\n" + "[5] Llenar caracteres.\n" + "[6] Borrar caracteres.\n" + "[7] Interseccion.\n"
				+ "[8] Eliminar repetidos.\n" + "[9] Contar palabras\r\n" + "[10] Validar direccion de correo.\n"
				+ "[11] Salir.");
		int option = Integer.parseInt(sc.nextLine());
		if (option < 1 || option > 11) {
			showMessageErr("Digito invalido");
		}
		return option;
	}

	/**
	 * Metodo que permite mostrar un mensaje.
	 * 
	 * @param message
	 *            Recibe por parametro una cadena como mensaje.
	 */
	public void showMessage(String message) {
		System.out.println(message);
	}

	/**
	 * Metodo que permite mostar mensaje de error.
	 * 
	 * @param message
	 *            Recibe por parametro una cadena como mensaje.
	 */
	public void showMessageErr(String message) {
		System.err.println(message);
	}
	
	
	/**
	 * Metodo que permite capturar entradas
	 * @return devuelve una entrada por consola de tipo Scanner.
	 */
	public String readString() {
		return sc.nextLine();
	}

	/**
	 * Metodo que permite leer un entero.
	 * 
	 * @param message
	 *            Recibe por parametro una cadena como mensaje.
	 * @return Devuelve un entero ingresado por Scanner.
	 */
	public int readInt(String message) {
		System.out.println(message);
		return Integer.parseInt((sc.nextLine()));
	}

	/**
	 * Metodo que permite leer una cadena.
	 * 
	 * @param message
	 *            Recibe por parametro una cadena como mensaje.
	 * @return Devuelve una cadena ingresada por Scanner.
	 */
	public String readString(String message) {
		System.out.println(message);
		return sc.nextLine();
	}

	/**
	 * Metodo que permite leer un caracter.
	 * 
	 * @param message
	 *            Recibe por parametro una cadena como mensaje.
	 * @return Devuelve Character ingresado por Scanner.
	 */
	public Character readChar(String message) {
		System.out.println(message);
		return sc.nextLine().charAt(0);
	}

	/**
	 * Metodo que permite selccionar una direccion (Derecha o Izquierda).
	 * 
	 * @param message
	 *            Recibe por parametro una cadena como mensaje.
	 * @return Devuelve una cadena indecando la direccion selecionada (Derecha o
	 *         Izquierda).
	 */
	public String selecDirection(String message) {
		int option = 0;
		System.out.println(message);
		System.out.println("[1] Derecha");
		System.out.println("[2] Izquierda");
		option = Integer.parseInt(sc.nextLine());
		if (option < 1 || option > 2) {
			showMessageErr("Opcion invalida");
		}
		return option == 1 ? "Derecha" : "Izquierda";
	}

	/**
	 * Metodo que permite leer los elementos de un ArrayList de tipo String.
	 * 
	 * @param sentence
	 *            Recibe por parametro un ArrayList<String>.
	 */
	public void readArr(ArrayList<String> sentence) {
		sentence.forEach(phrase -> System.out.print(phrase));
		System.out.println();
	}

	/**
	 * Metodo que permite mostar el mensaje de validacion de la direccion de
	 * correo.
	 * 
	 * @param isTrue
	 *            Recibe por parametro un boolean.
	 */
	public void showCheckEmail(boolean isTrue) {
		System.out.println(isTrue ? "Direccion de correo VALIDA" : "Direccion de correo INVALIDA");
	}
}
