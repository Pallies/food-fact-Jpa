package models;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import utils.FormatTo;

/**
 * The Class Produit.
 */
public class Produit {

	/** Categorie du poduit. */
	private Categorie categorie;

	/** Marque du produit. */
	private Marque marque;

	/** nom du produit. */
	private String nom;

	/** nutri Score note de A<->F. */
	private String nutritionGradeFr;

	/** ingrédients dans le produit. */
	private List<Descriptif> ingredients;

	/** quantité pour chaque �lement pour 100g. */
	private List<Element> elements;

	/** list d'allergenes. */
	private List<Descriptif> allergenes;

	/** list d'additifs. */
	private List<Descriptif> additifs;

	/**
	 * #Constructor.
	 *
	 * @param categorie        the categorie
	 * @param marque           the marque
	 * @param nom              the nom
	 * @param nutritionGradeFr the nutrition grade fr
	 * @param ingredients      the ingredients
	 * @param elements         the elements
	 * @param allergenes       the allergenes
	 * @param additifs         the additifs
	 */
	public Produit(Categorie categorie, Marque marque, String nom, String nutritionGradeFr,
			List<Descriptif> ingredients, List<Element> elements, List<Descriptif> allergenes, List<Descriptif> additifs) {
		this.categorie = categorie;
		this.marque = marque;
		this.nom = FormatTo.nom(nom);
		this.nutritionGradeFr = nutritionGradeFr.toUpperCase();
		this.ingredients = ingredients;
		this.elements = elements;
		this.allergenes = allergenes;
		this.additifs = additifs;
	}

	/**
	 * Joining collection.
	 * permet l'affichage des listes qui compose un produit
	 * sur plusieurs lignes
	 * @param list the list
	 * @return the string
	 */
	public  String joiningCollection(List<Descriptif> list) {
		return list.stream().map(Descriptif::getNom).collect(Collectors.joining("\n "));
	}

	/**
	 * Gets the allergenes size.
	 *
	 * @return the allergenes size
	 */
	public int getAllergenesSize() {
		return allergenes.size();
	}

	/**
	 * Gets the additifs size.
	 *
	 * @return the additifs size
	 */
	public int getAdditifsSize() {
		return additifs.size();
	}
	/**
	 * Gets the igredients size.
	 *
	 * @return the igredients size
	 */
	public int getIgredientsSize() {
		return ingredients.size();
	}
	/**
	 * Getter.
	 *
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	/**
	 * Getter.
	 *
	 * @return the marque
	 */
	public Marque getMarque() {
		return marque;
	}

	/**
	 * Getter.
	 *
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Getter.
	 *
	 * @return the nutritionGradeFr
	 */
	public String getNutritionGradeFr() {
		return nutritionGradeFr;
	}

	/**
	 * Getter.
	 *
	 * @return the elements
	 */
	public List<Element> getElements() {
		return elements;
	}

	/**
	 * Getter.
	 *
	 * @return the ingredients
	 */
	public List<Descriptif> getIngredients() {
		return ingredients;
	}

	/**
	 * Getter.
	 *
	 * @return the allergenes
	 */
	public List<Descriptif> getAllergenes() {
		return allergenes;
	}

	/**
	 * Getter.
	 *
	 * @return the additifs
	 */
	public List<Descriptif> getAdditifs() {
		return additifs;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		StringBuilder produitString = new StringBuilder();
		produitString
		.append(getNom()).append("\n")
		.append(getMarque()).append("\n")
		.append(getCategorie()).append("\n")
		.append(getNutritionGradeFr()).append("\n")
		.append(joiningCollection(getIngredients()))
		.append("\n").append(getElements())
		.append("\n").append(joiningCollection(getAdditifs()))
		.append("\n").append(joiningCollection(getAllergenes()));

		return produitString.toString();
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(marque, nom, nutritionGradeFr);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Produit))
			return false;
		Produit objProduit = (Produit) obj;
		return marque.equals(objProduit.marque) && nom.equals(objProduit.nom)
				&& nutritionGradeFr.equals(objProduit.nutritionGradeFr);
	}

}

