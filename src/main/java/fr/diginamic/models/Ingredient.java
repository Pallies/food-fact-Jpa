package models;

/**
 * The Class Ingredient.
 *
 * Les Ingrédients du produit
 */
public class Ingredient extends Descriptif {

	/**
	 *  #Constructor.
	 *
	 * @param nom the nom
	 */
	public Ingredient(String nom) {
		super(formatNom(nom));
	}

	/**
	 * Enlèver les caractères parasites.
	 *
	 * @param nom the nom
	 * @return nom de l'ingrédient
	 */
	private static String formatNom(String nom) {
		return nom.trim().replace("_", "");
	}
	
	/**
	 * Formattage d'affichage
	 * Ex: Ingredient  sucre.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		StringBuilder builderString = new StringBuilder();
		return builderString.append("Ingrédient ").append(getNom()).toString();
	}

}
