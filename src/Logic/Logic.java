package Logic;

public class Logic {

	private String DEFAULT_MESSAGE;

	public Logic(String defaultMessaje) {
		this.DEFAULT_MESSAGE = defaultMessaje;
	}

	public String getDEFAULT_MESSAGE() {
		return DEFAULT_MESSAGE;
	}

	public String convertProperName() {
		String convertedString = "";
		for (int i = 0; i < DEFAULT_MESSAGE.length(); i++) {
			convertedString += (i == 0
					|| (DEFAULT_MESSAGE.charAt(i - 1) == ' ' && DEFAULT_MESSAGE.charAt(i + 1) != ' '))
					? Character.toUpperCase(DEFAULT_MESSAGE.charAt(i))
							: Character.toLowerCase(DEFAULT_MESSAGE.charAt(i));
		}

		return DEFAULT_MESSAGE.length() > 0 ? convertedString : "Error:Imposible acceder";
	}

	public int searchCharacterString(String message) {
		int counter = 0;
		for (int i = 0; i < DEFAULT_MESSAGE.length(); i++) {
			counter += (DEFAULT_MESSAGE.toLowerCase().indexOf(message.toLowerCase(), i) >= 0
					&& DEFAULT_MESSAGE.toLowerCase().indexOf(message.toLowerCase(), i) == i) ? 1 : 0;
		}
		return counter;
	}

	public String fillCharacters(char letter, int amount, String orientation) {
		String add = "";
		for (int i = 0; i < amount; i++) {
			add += letter;
		}
		if (orientation == "Izquierda") {
			return add + DEFAULT_MESSAGE;
		} else if (orientation == "Derecha") {
			return DEFAULT_MESSAGE + add;
		} else {
			return "Error";
		}
	}

	public String deleteCharacter(char letter) {
		String message = "";
		for (int i = 0; i < DEFAULT_MESSAGE.length(); i++) {
			message += (DEFAULT_MESSAGE.toLowerCase().charAt(i) == Character.toLowerCase(letter)) ? ""
					: DEFAULT_MESSAGE.charAt(i);
		}
		return DEFAULT_MESSAGE.length() > 0 ? message : "Error:Imposible acceder";
	}

	public String intersectCharacters(String string) {
		String message = "";
		String word = "";
		for (int i = 0; i < word.length(); i++) {
			message += (DEFAULT_MESSAGE.toLowerCase().indexOf(string.toLowerCase().charAt(i)) >= 0)
					? string.toLowerCase().charAt(i) : "";
		}
		for (int j = 0; j < message.length(); j++) {
			word += (message.indexOf(message.charAt(j)) == j) ? message.charAt(j) : "";
		}
		return word;
	}

	public boolean validateEmail(String email) {

		return false;
	}

}
