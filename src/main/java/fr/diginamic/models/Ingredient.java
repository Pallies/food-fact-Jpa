package fr.diginamic.models;

import javax.persistence.*;

/**
 * The Class Ingredient.
 *
 * Les Ingrédients du produit
 */
@Entity
@Table(name = "INGREDIENT")
public class Ingredient implements Descriptif {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nom;

	public Ingredient() {
	}

	/**
	 *  #Constructor.
	 *
	 * @param nom the nom
	 */
	public Ingredient(String nom) {
		this.nom  =formatNom(nom);
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
