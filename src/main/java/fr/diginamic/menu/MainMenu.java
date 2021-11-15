package menu;

import java.util.Scanner;

import models.Categorie;
import models.Marque;
import services.CategorieProduit;
import services.MarqueCategorieProduit;
import services.MarqueProduit;
import services.ProduitService;
import services.Stock;
import view.AffichageMain;
import view.AffichageService;

/**
 * The Class MainMenu.
 * choix de sélection suite à l'affichage du menu principal
 * {@link AffichageMain}
 */
public class MainMenu extends MenuService {

	private AffichageService viewMain;

	@Override
	public void choixUser(Scanner scanner, int key) {

		switch (key) {
//			"| - 1. Rechercher une Marque
		case 1:
			viewMain.affichageListMarque();
			String nomMarque = traitement(scanner, Stock.listingMarque());
			ProduitService produitMarque = new MarqueProduit(new Marque(nomMarque), Stock.toList());
			MenuService selectMarque = new SelectionMenu(produitMarque);
			selectMarque.traiter(scanner);
			break;
//			"| - 2. Rechercher une Catégorie
		case 2:
			viewMain.affichageListCategorie();
			String nomCategorie = traitement(scanner, Stock.listingCategorie());
			ProduitService produitCategorie = new CategorieProduit(new Categorie(nomCategorie), Stock.toList());
			MenuService selectCategorie = new SelectionMenu(produitCategorie);
			selectCategorie.traiter(scanner);
			break;
//			"| - 3. Rechercher une Marque et une Catégorie
		case 3:
			viewMain.affichageListMarque();
			String nomMark = traitement(scanner, Stock.listingMarque());
			Marque marque = new Marque(nomMark);
			viewMain.affichageListMarqueCategorie(marque);
			String nomMarkCategorie = traitement(scanner, Stock.listingMarqueCategorie(marque));
			ProduitService produitMarkCategorie = new MarqueCategorieProduit(marque, new Categorie(nomMarkCategorie),
					Stock.toList());
			MenuService selectMarkCategorie = new SelectionMenu(produitMarkCategorie);
			selectMarkCategorie.traiter(scanner);
			break;
//			"| - 4. Afficher les produits avec le plus d'allergènes 
		case 4:
			ProduitService produitStockAllergene = Stock.getInstance();
			viewMain.affichageList(produitStockAllergene.selectionByAllergens(AffichageService.NB_PRODUIT_A_AFFICHER_MAX));
			break;
//			"| - 5. Afficher les produits avec le plus additifs
		case 5:
			ProduitService produitStockAdditif = Stock.getInstance();
			viewMain.affichageList(produitStockAdditif.selectionByAdditif(AffichageService.NB_PRODUIT_A_AFFICHER_MAX));
			break;
//			"| - 6. Afficher les produits avec le plus d'ingrédients
		case 6:
			ProduitService produitStockIngredient = Stock.getInstance();
			viewMain.affichageList(produitStockIngredient.selectionByIngredients(AffichageService.NB_PRODUIT_A_AFFICHER_MAX));
			break;
//			"| - 7. Afficher les allergènes les plus courants 
		case 7:
			ProduitService produitAllergens = Stock.getInstance();
			viewMain.affichageList(produitAllergens.allergensCommun());
			break;
//			"| - 8. Afficher les additifs les plus courants
		case 8:
			ProduitService produitAdditifs = Stock.getInstance();
			viewMain.affichageList(produitAdditifs.additifsCommun());
			break;
		default:
			break;
		}
	}

	/**
	 * Affichage menu.
	 */
	@Override
	public void affichageMenu() {
		viewMain = new AffichageMain();
	}

	/**
	 * Affichage erreur. pour la méthode traiter du menuService
	 */
	@Override
	public void affichageErreur() {
		viewMain.affichageErreur();
	}

	/**
	 * Affichage erreur. pour la méthode traitement du menuService
	 * 
	 * @param max the max
	 */
	@Override
	public void affichageErreur(int max) {
		viewMain.affichageErreur(max);
	}

	/**
	 * Getter
	 * 
	 * @return the viewMain
	 */
	protected AffichageService getViewMain() {
		return viewMain;
	}

}
