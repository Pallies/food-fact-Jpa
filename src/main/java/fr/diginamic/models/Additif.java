package models;

import utils.FormatTo;

/**
 * The Class Additif.
 */
public class Additif extends Descriptif {

	/**
	 * Instantiates a new additif.
	 *
	 * @param nom the nom
	 */
	public Additif(String nom) {
		super(FormatTo.nom(nom));
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Additif " + getNom();
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
		if (!(obj instanceof Additif))
			return false;
		Additif objAdditif = (Additif) obj;
		return objAdditif.getNom().equals(this.getNom());

	}

}
