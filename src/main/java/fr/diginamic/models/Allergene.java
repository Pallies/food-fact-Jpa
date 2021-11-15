package models;

import utils.FormatTo;

/**
 * The Class Allergene.
 */
public class Allergene extends Descriptif{

	/**
	 * Instantiates a new allergene.
	 *
	 * @param nom the nom
	 */
	public Allergene(String nom) {
		super(FormatTo.nom(nom));
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Allergene " + getNom();
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
		if (!(obj instanceof Allergene))
			return false;
		Allergene objAllergene = (Allergene) obj;
		return objAllergene.getNom().equals(this.getNom());
	}
}
