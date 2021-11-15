package models;

import utils.FormatTo;

/**
 * The Class Categorie.
 */
public class Categorie extends Descriptif{

	/**
	 * Instantiates a new categorie.
	 *
	 * @param nom the nom
	 */
	public Categorie(String nom) {
		super(FormatTo.nom(nom));
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Catégorie " + getNom() ;
	}
	
	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Categorie))
			return false;
		Categorie objCategorie = (Categorie) obj;
		return objCategorie.getNom().equals(this.getNom());
	}

	
}
