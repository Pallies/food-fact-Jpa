package view;

/**
 * The Class AffichageMenu.
 *
 * Gestion de l' affichage principale
 */
public class AffichageMain extends AffichageService {
	/** The Constant CHOIX_1. */
	public static final String CHOIX_1 = "| - 1. Rechercher une Marque                                         |\n";

	/** The Constant CHOIX_2. */
	public static final String CHOIX_2 = "| - 2. Rechercher une Catégorie                                      |\n";

	/** The Constant CHOIX_3. */
	public static final String CHOIX_3 = "| - 3. Rechercher une Marque et une Catégorie                        |\n";

	/** The Constant CHOIX_4. */
	public static final String CHOIX_4 = "| - 4. Afficher les produits avec le plus d'allergènes               |\n";

	/** The Constant CHOIX_5. */
	public static final String CHOIX_5 = "| - 5. Afficher les produits avec le plus additifs                   |\n";

	/** The Constant CHOIX_6. */
	public static final String CHOIX_6 = "| - 6. Afficher les produits avec le plus d'ingrédients              |\n";
	
	/** The Constant CHOIX_7. */
	public static final String CHOIX_7 = "| - 7. Afficher les allergènes les plus courants                     |\n";

	/** The Constant CHOIX_8. */
	public static final String CHOIX_8 = "| - 8. Afficher les additifs les plus courants                       |\n";
	
	/** The mainString. */
	private StringBuilder mainString = new StringBuilder();

	/**
	 * Instantiates a new affichage menu.
	 */
	public AffichageMain() {
		builder();
		menu();
	}

	/**
	 * Affichage du menu.
	 */
	public void menu() {
		System.out.println(mainString.toString());
	}

	/**
	 * Construction de l'affichage.
	 */
	public void builder() {
		mainString.append(HEADER_1)
		.append(HEADER_2)
		.append(BORDER)
		.append(SPACE)
		.append(CHOIX_1)
		.append(CHOIX_2)
		.append(CHOIX_3)
		.append(CHOIX_4)
		.append(CHOIX_5)
		.append(CHOIX_6)
		.append(CHOIX_7)
		.append(CHOIX_8)
		.append(SPACE)
		.append(QUITER)
		.append(BORDER);
	}

}
