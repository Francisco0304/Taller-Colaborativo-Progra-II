package Logic;

import javax.swing.JOptionPane;

public class Run {

	public static void main(String[] args) {
		Logic logic = new Logic(JOptionPane.showInputDialog(null, "Ingrese una cadena por defecto"));
		String menu[] = { "Convertir a nombre propio", "Buscar cadena de caracteres", "Contar vocales", "Año nuevo",
				"Llenar caracteres", "Borrar caracteres", "Intersectar cadenas", "Eliminar caracteres repetidos",
				"Contar palabras", "Validar direccion de correo electronico", "Salir" };

		boolean continuee = true;

		while (continuee && logic.getDEFAULT_MESSAGE() != null) {
			String menuString = (String) JOptionPane.showInputDialog(null,
					"                      Bienvenido \n" + "Elija una opcion: ", "Taller Colaborativo Programacion II",
					1, null, menu, null);

			switch (menuString) {

			case "Convertir a nombre propio":
				JOptionPane.showMessageDialog(null, "Cadena original= " + logic.getDEFAULT_MESSAGE()
				+ "\nNombre propio: " + logic.convertProperName());
				break;

			case "Buscar cadena de cararcteres":
				JOptionPane.showMessageDialog(null,
						"Cantidad de veces que aparece la palabra: " + logic.searchCharacterString(
								JOptionPane.showInputDialog(null, "Ingrese una palabra a buscar dentro del texo")));
				break;

			case "Contar vocales":

				break;

			case "Año nuevo":

				break;

			case "Llenar caracteres":
				String string = JOptionPane.showInputDialog(null, "Ingrese un caracter a añadir");
				int amount = Integer
						.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de veces que se repite"));
				String orientation = (String) JOptionPane.showInputDialog(null, "Elija donde añadir caracteres: ", "",
						1, null, new Object[] { "Izquierda", "Derecha" }, null);
				JOptionPane.showMessageDialog(null, "Cadena original: " + logic.getDEFAULT_MESSAGE()
				+ "\nCadena obtenida: " + logic.fillCharacters(string.charAt(0), amount, orientation));
				break;

			case "Borrar caracteres":
				String entry = JOptionPane.showInputDialog(null, "Ingrese el caracter a eliminar");
				JOptionPane.showMessageDialog(null, "Cadena original: " + logic.getDEFAULT_MESSAGE()
				+ "\nCadena obtenida: " + logic.deleteCharacter(entry.charAt(0)));
				break;

			case "Intersectar cadenas":
				JOptionPane.showMessageDialog(null, "Cadena original: " + logic.getDEFAULT_MESSAGE()
				+ "\nCadena obtenida: "
				+ logic.intersectCharacters(JOptionPane.showInputDialog(null, "Ingrese una palabra: ")));
				break;

			case "Eliminar caracteres repetidos":

				break;

			case "Validar direcciones de correo electronico":

				break;
			case "Salir":
				continuee = false;
				break;
			default:
				JOptionPane.showMessageDialog(null, "ERROR! Ingrese una opcoón valida");
				break;
			}

		}

	}

}
