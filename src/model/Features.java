package model;

import java.util.*;
import java.util.regex.*;

/**
 * Clase Features: En esta clase estan definidos los métodos que permiten dar
 * la funcionalidad del programa.
 * 
 * @TallerColavorativo1er50
 */
public class Features {
	/**
	 * ms: Permite almacenar la cadena por defecto, la cual es la referencia
	 * para la mayoria de los metodos.
	 */
	private String ms;

	/**
	 * Metodo constructor: Define las variables de tipo String ms y key.
	 */
	public Features(String ms) {
		this.ms = ms;
	}

	public String getMs() {
		return ms;
	}

	public void setMs(String ms) {
		this.ms = ms;
	}

	/**
	 * convertProperame: Convierte las palabras de la cadena ms en nombres
	 * priopios.
	 * 
	 * @return Cadena con nombres propios.
	 */
	public String convertProperName() {
		Character c = ' ';
		char[] chars = new char[ms.length()];

		for (int i = 0; i < ms.length(); i++) {
			c = ms.charAt(i);
			if ((i == 0) || (ms.charAt(i - 1) == ' ')) {
				c = Character.toUpperCase(c);
			}

			chars[i] = c;
		}

		return new String(chars);
	}

	/**
	 * findString: Permite buscar una cadena en la cadena ms, y cuenta el numero
	 * de veces que se encuentra.
	 * 
	 * @param input
	 *            Recibe la cadena que se va a buscar dentro de la cadema ms.
	 * @return int Devuelve el numero de veces que esta input dentro de ms.
	 */
	public int findString(String input) {
		int cont = 0;
		String[] c = ms.toLowerCase().split(" ");
		for (int i = 0; i < c.length; i++) {
			if (c[i].equals(input.toLowerCase())) {
				cont++;
			}
		}

		return cont;
	}

	/**
	 * countVowels: Permite mostrar la cantidad de veces que se encuentra la
	 * vocal ingresada en la cadena ms.
	 * 
	 * @param message
	 *            Recibe la vocal que se va a comparar con la cadena ms.
	 * @return Devuelve el nunmero de veces que se encuentra la vocal en la
	 *         cadena ms.
	 */
	public int countVowels(String message) {
		int repeated = 0;
		char[] messageChars = message.toCharArray();
		char[] msChars = ms.toCharArray();
		for (int i = 0; i < message.length(); i++) {
			for (int j = 0; j < ms.length(); j++) {
				String aux;
				aux = "" + messageChars[i];
				if (Character.toLowerCase(messageChars[i]) == Character.toLowerCase(msChars[j])) {

					repeated++;
				}
			}
		}
		return repeated;
	}

	public String newYear() {
		String hour, minute, second, ampm, space = ":", space1 = " ", time1[] = null, time2[] = { "12:00:00 am" };
		int minutes = 0;
		Calendar calendar = new GregorianCalendar();
		Date actualTime = new Date();
		calendar.setTime(actualTime);
		ampm = calendar.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";

		if (ampm.equals("PM")) {
			int h = calendar.get(Calendar.HOUR_OF_DAY) - 12;
			if (h == 0) {
				h = 12;
			}
			hour = h > 9 ? "" + h : "0" + h;
		} else {
			hour = calendar.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendar.get(Calendar.HOUR_OF_DAY)
			: "0" + calendar.get(Calendar.HOUR_OF_DAY);
		}
		minute = calendar.get(Calendar.MINUTE) > 9 ? "" + calendar.get(Calendar.MINUTE)
		: "0" + calendar.get(Calendar.MINUTE);
		second = calendar.get(Calendar.SECOND) > 9 ? "" + calendar.get(Calendar.SECOND)
		: "0" + calendar.get(Calendar.SECOND);
		time1[0] = (hour);
		time1[1] = (space);
		time1[2] = (minute);
		time1[3] = (space);
		time1[4] = (second);
		time1[5] = (space1);
		time1[6] = (ampm);

		// hasta aqui ya da la hora del sistema, el paso a seguir es hallar los
		// minutos de diferencia entre esta horas time1[] y time 2[] la cual se
		// encuentra inicializada a las 12 de la media noche

		for (int i = 0; i < time1.length; i++) {
			for (int j = 0; j < time2.length; j++) {
				if (time1[i].equals(space) && time2[j].equals(space)
						|| time1[i].equals(space1) && time2[j].equals(space1)) {

				} else {
					minutes = Integer.parseInt(time1[i]) - Integer.parseInt(time2[i]);
					minutes = +minutes * 60;
				}
			}
		}
		return String.valueOf(minutes);

	}

	/**
	 * fillChars: Permite concatenar la cadena ms con la direccion selecionada y
	 * el numero de veces del caracter ingresado, entrados por parametro.
	 * 
	 * @param character
	 *            Recibe por parametro el caracter que se desea concatenar.
	 * @param number
	 *            Recibe el numero de veces que se quiere repetir el caracter
	 *            que se recibe por parametro.
	 * @param direction
	 *            Recibe la direccion (Derecha o Izquierda) a la que se va a
	 *            concatenar.
	 * @return Devuelve la cadena concatenada según los parametros de entrada.
	 */
	public String fillChars(char character, int number, String direction) {
		String chars = "", aux = "";
		for (int i = 0; i < number; i++) {
			chars += character;
		}
		if (direction.equals("Derecha")) {
			aux = ms + chars;
		} else {
			aux = chars + ms;
		}

		return aux;
	}

	/**
	 * cleanChar: Elimina el caracter de entrada por parametro en la cadena ms.
	 * 
	 * @param character
	 *            Recibe por parametro de el caracter que se desea eliminar de
	 *            la cadena ms.
	 * @return Devuelve la cadena borrando el caracter ingresado por parametro,
	 *         si existe.
	 */
	public String cleanChar(char character) {
		String aux = "";
		String c = "" + character;
		aux = ms.toLowerCase().replaceAll(c, "").replaceAll(c.toLowerCase(), "");
		return aux;
	}

	/**
	 * intersection: Permite buscar los caracteres en comun entre la cadena de
	 * entrada por parametro y la cadena ms.
	 * 
	 * @param data
	 *            Recibe por parametro la cadena que se va a comparar con la
	 *            cadena ms.
	 * @return Devuelve la cadena con la intersección de caracteres entre la
	 *         cadena ingresada por parametro y la cadena ms.
	 */
	public String intersection(String data) {
		String repeated = "";
		char[] dataChars = data.toCharArray();
		char[] msChars = ms.toCharArray();
		for (int i = 0; i < data.length(); i++) {
			for (int j = 0; j < ms.length(); j++) {
				String aux;
				aux = "" + dataChars[i];
				if (Character.toLowerCase(dataChars[i]) == Character.toLowerCase(msChars[j])) {
					if (repeated.contains(aux)) {

					} else {
						repeated = repeated + dataChars[i];
					}
				}
			}
		}
		return repeated;
	}

	/**
	 * diference: permite encontrar los caracteres diferentes entre la cadena ms
	 * y la cadena de entrada por parametro, y los elimina.
	 * 
	 * @param data
	 *            Recibe por parametro la cadena que se va a comparar con la
	 *            cadena ms.
	 * @return Devuelve la cadena con la diferencia de caracteres entre la
	 *         cadena ingresada por parametro y la cadena ms.
	 */
	public String difference(String data) {
		ArrayList<Character> arr = new ArrayList<>();
		String aux = "";
		for (int i = 0; i < ms.length(); i++) {
			arr.add(i, ms.charAt(i));
		}
		for (int i = 0; i < data.length(); i++) {
			for (int j = 0; j < arr.size(); j++) {
				if (String.valueOf(data.charAt(i)).equalsIgnoreCase(String.valueOf(arr.get(j)))) {
					arr.remove(j);
				}
			}
		}
		for (int i = 0; i < arr.size(); i++) {
			aux += arr.get(i);
		}
		return aux;
	}

	/**
	 * wordCount: Permite contar las palabras que contiene la cadena.
	 * 
	 * @param count
	 *            Recibe por parametro la cadena para realizar el conteo.
	 * @return Devuelve el numero total de palabras que contiene la cadena.
	 */
	public int wordCount(String count) {
		String[] words = count.split("\\s+");
		return words.length;
	}

	/**
	 * checkEmail: permite validar una direccion de correo por medio de la
	 * cadena de entrada por parametro.
	 * 
	 * @param email
	 *            Recibe por parametro la direccion de correo.
	 * @return Devuelve un mesaje de tipo String indiando.
	 */
	public boolean checkEmail(String email) {
		Pattern pat = Pattern
				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mat = pat.matcher(email);
		return mat.matches();
	}
}
