package models;

/**
 * The Class Descriptif.
 *
 * Nom d'une Marque / d'une Categorie Nom d'un Ingrédient /
 *         d'un Allergene / d'un Additif
 */
public abstract class Descriptif {

	/** The nom. */
	private String nom;

	/**
	 * Instantiates a new descriptif.
	 *
	 * @param nom the nom
	 */
	public Descriptif(String nom) {
		this.nom = nom;
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
	 * Setter.
	 *
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}
}
