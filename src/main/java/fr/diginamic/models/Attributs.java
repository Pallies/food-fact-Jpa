package models;

/**
 * référence aux minéraux et vitamines
 * qui se trouve dans les produits
 * comparaison pour un poids de produit de .
 *
 */
public enum Attributs {
	
	/** The energie. */
	ENERGIE("energie", 0d), 
	
	/** The graisse. */
	GRAISSE("graisse", 0d), 
	
	/** The sucres. */
	SUCRES("sucres", 0d), 
	
	/** The fibres. */
	FIBRES("fibres", 0d),
	
	/** The proteines. */
	PROTEINES("proteines", 0d), 
	
	/** The sel. */
	SEL("sel", 0d), 
	
	/** The vit a. */
	VIT_A("vit A", 0d), 
	
	/** The vit d. */
	VIT_D("vit D", 0d),
	
	/** The vit e. */
	VIT_E("vit E", 0d), 
	
	/** The vit k. */
	VIT_K("vit K", 0d), 
	
	/** The vit c. */
	VIT_C("vit C", 0d), 
	
	/** The vit b1. */
	VIT_B1("vit B1", 0d),
	
	/** The vit b2. */
	VIT_B2("vit B2", 0d), 
	
	/** The vit pp. */
	VIT_PP("vit PP", 0d), 
	
	/** The vit b6. */
	VIT_B6("vit B6", 0d), 
	
	/** The vit b9. */
	VIT_B9("vit B9", 0d),
	
	/** The vit b12. */
	VIT_B12("vit B12", 0d), 
	
	/** The calcium. */
	CALCIUM("calcium", 0d), 
	
	/** The magnesium. */
	MAGNESIUM("magnesium", 0d), 
	
	/** The iron. */
	IRON("iron", 0d),
	
	/** The fer. */
	FER("fer", 0d), 
	
	/** The beta carotene. */
	BETA_CAROTENE("betaCarotene", 0d), 
	
	/** The is huile de palme. */
	IS_HUILE_DE_PALME("presenceHuilePalme", 0d);

	/** The nom. */
	private String nom;
	
	/** The quantite. */
	private Double quantite;

	/**
	 * Instantiates a new attributs.
	 *
	 * @param nom the nom
	 * @param quota the quota
	 */
	private Attributs(String nom, Double quota) {
		this.nom = nom;
		quantite = quota;
	}

	/**
	 * Retour d'un Attribut par son index.
	 *
	 * @param index the index
	 * @return Attribut
	 */
	public Attributs getIndex(int index) {
		return Attributs.values()[index - 1];
	}

	/**
	 * retour d'Attribut par don nom.
	 *
	 * @param name the name
	 * @return Attribut
	 */
	public Attributs getAttribut(String name) {
		String format= name.replace("100g", "");
		return Attributs.valueOf(format.replace("vit", "vit "));
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
	 * @return the quantite
	 */
	public Double getQuantite() {
		return quantite;
	}

	/**
	 * Setter.
	 *
	 * @param quantite the quantite to set
	 */
	public void setQuantite(Double quantite) {
		this.quantite = quantite;
	}

}
