package utils;


/**
 * The Class Format. formatage des nom des éléments trouver dans la liste
 * utilitaire static pour chaque élément de produit
 * {@link Produit}
 * {@link Marque}
 * {@link Categorie}
 * {@link Ingredient}
 * {@link Additif}
 * {@link Allergene}
 */
public class FormatTo {

	/** The carateres speciaux. */
	private static String[][] CARATERES_SPECIAUX = { { "é", "e" }, { "è", "e" }, { "€", "e" }, { "î", "i" },
			{ "ï", "i" }, { "ü", "u" }, { "à", "a" }, { "œ", "oe" } };

	/**
	 * Marque. Formatage du nom de la marque d'un produit
	 * 
	 * @param nom the nom
	 * @return the string
	 */
	public static String nom(String nom) {
		nom = firstLetter(nom.trim());
		if (nom.contains(","))
			return nom.trim().split(",")[0];
		return nom;
	}

	/**
	 * First letter. format la première lettre d'un nom
	 * 
	 * @param nom the nom
	 * @return the string
	 */
	private static String firstLetter(String nom) {
		StringBuilder concatString = new StringBuilder();
//		traitement de la première lettre
		String letter = nom.toLowerCase().substring(0, 1);
		for (int i = 0; i < CARATERES_SPECIAUX.length; i++) {
			letter = letter.replace(CARATERES_SPECIAUX[i][0], CARATERES_SPECIAUX[i][1]);
		}
		letter = letter.toUpperCase();
		if (letter.length() == 2)
			letter = twoForFirst(letter);
		
//		traitement du mot
		String mot;
		if (nom.contains("-europeensans"))
			mot = nom.substring(1, nom.indexOf("-"));
		mot = nom.substring(1).toLowerCase().replace("œ", "oe").replaceAll("De:", "").replaceAll("fr:", ",");
		return concatString.append(letter).append(mot).toString();
	}

	/**
	 * Two for first. fonction pour enlever les majuscules lier au formatage {ex :
	 * "œ -> OE" doit être convertit en Oe }
	 * 
	 * @param firstLetter the first letter
	 * @return the string
	 */
	private static String twoForFirst(String firstLetter) {
		StringBuilder concatString = new StringBuilder();
		String[] caractere = firstLetter.split("");
		return concatString.append(caractere[0]).append(caractere[1].toLowerCase()).toString();
	}

}