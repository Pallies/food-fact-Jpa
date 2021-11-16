package fr.diginamic.models;


import fr.diginamic.utils.FormatTo;

import javax.persistence.*;

/**
 * The Class Additif.
 */
@Entity
@Table(name = "ADDITIF")
public class Additif implements Descriptif {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nom;

	public Additif() {
	}

	/**
	 * Instantiates a new additif.
	 *
	 * @param nom the nom
	 */
	public Additif(String nom) {
		this.nom = FormatTo.nom(nom);
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
