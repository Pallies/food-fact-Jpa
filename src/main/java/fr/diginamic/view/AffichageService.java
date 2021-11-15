package view;

import java.util.List;

import models.Marque;
import services.Stock;

/**
 * The Class AffichageMain.
 *
 * Aide à l'affichage des menus stockage des constantes
 *         d'affichage
 */
public abstract class AffichageService {

	/** The Constant NB_PRODUIT_AFFICHE. */
	public static final int NB_PRODUIT_A_AFFICHER_MAX = 10;
	/** The Constant HEADER_1. */
	public static final String HEADER_1 = "                       __--  MENU  --__                             \n";

	/** The Constant HEADER_2. */
	public static final String HEADER_2 = "                       __------------__                             \n";

	/** The Constant SPACE. */
	public static final String SPACE = "|                                                                    |\n";

	/** The Constant BORDER. */
	public static final String BORDER = "+--------------------------------------------------------------------+\n";

//	les produit les plus allergenes
	/** The Constant QUITER. */
	public static final String QUITER = "| - 0. Pour sortir de l'application                                  |\n";

	/** The Constant ERROR. */
	public static final String ERROR_START = "| - Erreur de saisie entrez un chiffre";

	/** The Constant ERROR_MIDDLE. */
	public static final String ERROR_MIDDLE = " entre 1 et ";

	/** The Constant ERROR_END. */
	public static final String ERROR_END = "|\n";

	/**
	 * Menu.
	 */
	public abstract void menu();

	/**
	 * Builder.
	 */
	public abstract void builder();

	/**
	 * Affichage list.
	 *
	 * @param list the list
	 */
	public <T> void affichageList(List<T> list) {
		list.forEach(System.out::println);
	}

	/**
	 * Affichage erreur. composition d'un message d'erreur spécifique indiquant
	 * l'intervalle du choix d'entrée
	 * 
	 * @param max the max
	 */
	public void affichageErreur(int max) {
		int nbLength = String.valueOf(max).length();
		String errorMiddle = new String(new char[19 - nbLength]).replace("\0", " ");
		StringBuilder serviceString = new StringBuilder();
		serviceString.append(BORDER).append(SPACE).append(ERROR_START).append(ERROR_MIDDLE).append(max)
				.append(errorMiddle).append(ERROR_END).append(SPACE).append(BORDER);
		System.out.println(serviceString.toString());
	}

	/**
	 * Affichage erreur.
	 *
	 */
	public void affichageErreur() {
		String errorMiddle = new String(new char[31]).replace("\0", " ");
		StringBuilder serviceString = new StringBuilder();
		serviceString.append(BORDER).append(SPACE).append(ERROR_START).append(errorMiddle).append(ERROR_END)
				.append(SPACE).append(BORDER);
		System.out.println(serviceString.toString());
	}

	/**
	 * Affichage list marque.
	 */
	public void affichageListMarque() {
		Stock.listingMarque().entrySet().forEach(System.out::println);
	}

	/**
	 * Affichage list categorie.
	 */
	public void affichageListCategorie() {
		Stock.listingCategorie().entrySet().forEach(System.out::println);
	}

	/**
	 * Affichage list marque categorie.
	 *
	 * @param marque the marque
	 */
	public void affichageListMarqueCategorie(Marque marque) {
		Stock.listingMarqueCategorie(marque).entrySet().forEach(System.out::println);
	}
}
