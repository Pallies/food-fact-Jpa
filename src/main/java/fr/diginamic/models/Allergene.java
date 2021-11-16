package fr.diginamic.models;


import fr.diginamic.utils.FormatTo;

import javax.persistence.*;

/**
 * The Class Allergene.
 */
@Entity
@Table(name = "ALLERGENE")
public class Allergene implements Descriptif{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nom;

	public Allergene() {
	}

	/**
	 * Instantiates a new allergene.
	 *
	 * @param nom the nom
	 */
	public Allergene(String nom) {
		this.nom = FormatTo.nom(nom);
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
