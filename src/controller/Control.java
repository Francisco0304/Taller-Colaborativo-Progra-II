package controller;

import model.Features;
import view.View;

/**
 * Clase Control: en esta clase se controlan las clases que intervienen en el
 * programa.
 * 
 * @TallerColavorativo1er50
 */
public class Control {
	private Features features;
	private View view;

	/**
	 * Metodo constructor: define las instancias de la clase Features y View, y
	 * se ejecuta el metodo menu().
	 */
	public Control() {
		features = new Features(null);
		view = new View();
	}

	/**
	 * Metodo que permite dar una organizacion a la ejecucion del programa segun
	 * un menu de opciones.
	 */
	public void menu() {
		boolean check = true;

		try {
			view.showMessage("------ Ingrese la cadena de caracteres: ");
			features.setMs(view.readString());
			System.out.println(features.getMs());
		} catch (Exception e) {
			view.showMessageErr("Dato no valido");
		}

		while (check) {
			int option = 0;
			option = view.readOptionMenu();
			switch (option) {
			case 1:
				view.showMessage(features.convertProperName());
				break;
			case 2:
				view.showMessage("La cadena esta " + features.findString(view.readString("Escriba la cadena a buscar"))
				+ " veces");
				break;
			case 3:
				view.showMessage("La vocal se encuentra "
						+ features.countVowels(view
								.readString("Digite la vocal que desea ver cuantas veces se encuentra en la cadena "))
						+ " veces.");
				break;
			case 4:
				view.showMessage("Faltan " + (String.valueOf(features.newYear())) + " minutos para año nuevo");
				break;
			case 5:
				char character = view.readChar("Digite el caracter que desea añadir");
				int number = view.readInt("Digite el numero de veces que se va repetir el caracter");
				String direction = view.selecDirection("Selecione la direcciÃ³n que desea");
				view.showMessage(features.fillChars(character, number, direction));
				break;
			case 6:
				view.showMessage(features.cleanChar(view.readChar("Digite el caracter que desea borrar")));
				break;
			case 7:
				view.showMessage(features.intersection(view.readString("Digite la cadena")));
				break;
			case 8:
				view.showMessage(features.difference(view.readString("Digite la cadena")));
				break;
			case 9:
				view.showMessage("La cadena tiene " + features.wordCount(view.readString("Escriba la cadena a buscar"))
				+ " palabras");
				break;
			case 10:
				view.showCheckEmail(features.checkEmail(view.readString("Digite direccion de correo")));
				break;
			case 11:
				view.showMessage("Cerrando programa...");
				check = false;
				break;
			}
		}
	}

}
