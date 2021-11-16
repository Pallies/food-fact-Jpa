package fr.diginamic.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * The Class Marque.
 *
 * Indique la Marque du produit
 */
@Embeddable
public class Marque implements Descriptif {

	@Column
	private String nom;

	/**
	 * Instantiates a new marque.
	 */
	public Marque() {

	}

	/**
	 * Instantiates a new marque.
	 *
	 * @param nom the nom
	 */
	public Marque(String nom) {
		this.nom = nom;
	}


	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Marque " + getNom();
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Marque))
			return false;
		Marque objMarque = (Marque) obj;
		return objMarque.getNom().equals(this.getNom());

	}

	@Override
	public String getNom() {
		return nom;
	}

	@Override
	public void setNom(String nom) {
		this.nom = nom;
	}
}
