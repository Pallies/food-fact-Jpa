package view;

/**
 * The Class AffichageMenu.
 *
 * Gestion de l' affichage principale
 */
public class AffichageSelection extends AffichageService {

	/** The Constant CHOIX_1. */
	public static final String CHOIX_1 = "| - 1. Rechercher les meilleurs produits ( nutriScore A )            |\n";

	/** The Constant CHOIX_2. */
	public static final String CHOIX_2 = "| - 2. Rechercher les produits à éviter  ( nutriScore F )            |\n";

	/** The Constant CHOIX_3. */
	public static final String CHOIX_3 = "| - 3. Rechercher les plus Allergissants                             |\n";

	/** The Constant CHOIX_4. */
	public static final String CHOIX_4 = "| - 4. Rechercher les produits avec le plus additifs                   |\n";

	/** The Constant CHOIX_5. */
	public static final String CHOIX_5 = "| - 5. Afficher les produits avec le plus d'ingredients              |\n";
	/** The selection. */
	private StringBuilder menuString = new StringBuilder();

	/**
	 * Instantiates a new affichage menu.
	 */
	public AffichageSelection() {
		builder();
		menu();
	}

	/**
	 * Affichage du menu.
	 */
	public void menu() {
		System.out.println(menuString.toString());
	}

	/**
	 * Construction de l'affichage.
	 */
	public void builder() {
		menuString.append(HEADER_1)
		.append(HEADER_2)
		.append(BORDER)
		.append(SPACE)
		.append(CHOIX_1)
		.append(CHOIX_2)
		.append(CHOIX_3)
		.append(CHOIX_4)
		.append(CHOIX_5)
		.append(SPACE)
		.append(QUITER)
		.append(BORDER);
	}

}
