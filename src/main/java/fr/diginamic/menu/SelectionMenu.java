package menu;

import java.util.Scanner;

import services.ProduitService;
import view.AffichageSelection;
import view.AffichageService;

/**
 * The Class SelectionMenu.
 * choix de sélection suite à l'affichage du menu de sélection
 * {@link AffichageSelection}
 */
public class SelectionMenu extends MenuService {

	private AffichageService viewSelection;
	private ProduitService list;

	protected SelectionMenu(ProduitService list) {
		super();
		this.setList(list);
	}

	@Override
	public void choixUser(Scanner scanner, int key) {
		switch (key) {
		case 1:
//			"| - 1. Rechercher les meilleurs produits ( nutriScore A )
			viewSelection.affichageList(list.selectionByNutriScoreA(AffichageService.NB_PRODUIT_A_AFFICHER_MAX));
			break;
		case 2:
//			"| - 2. Rechercher les produits à éviter  ( nutriScore F )
			viewSelection.affichageList(list.selectionByNutriScoreF(AffichageService.NB_PRODUIT_A_AFFICHER_MAX));
			break;
		case 3:
//			"| - 3. Rechercher les plus Allergissants
			viewSelection.affichageList(list.selectionByAllergens(AffichageService.NB_PRODUIT_A_AFFICHER_MAX));
			break;
		case 4:
//			"| - 3. Rechercher avec le plus d'additif
			viewSelection.affichageList(list.selectionByAdditif(AffichageService.NB_PRODUIT_A_AFFICHER_MAX));
			break;
		default:
			break;
		}
	}

	public ProduitService getList() {
		return list;
	}

	public void setList(ProduitService list) {
		this.list = list;
	}

	/**
	 * Affichage menu.
	 */
	@Override
	public void affichageMenu() {
		viewSelection = new AffichageSelection();
	}

	/**
	 * Affichage erreur.
	 */
	@Override
	public void affichageErreur() {
		viewSelection.affichageErreur();
	}

	/**
	 * Affichage erreur.
	 *
	 * @param max the max
	 */
	@Override
	public void affichageErreur(int max) {
		viewSelection.affichageErreur(max);
	}

}
