
package menu;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * The Class MenuService.
 * prend en charge la saisie clavier de l'utilisateur
 * extention de class
 * MainMenu
 * SelectionMenu
 */
public abstract class MenuService {

	/**
	 * Traiter.
	 * sélectionne le menu choisi
	 * @param scanner the scanner
	 */
	public void traiter(Scanner scanner) {
		int key = Integer.MAX_VALUE;
		do {
			affichageMenu();
			try {
				key = scanner.nextInt();
				choixUser(scanner, key);
			} catch (InputMismatchException e) {
				affichageErreur();
			}
			scanner.nextLine();
//			Retour au menu pricipal
			if (this instanceof SelectionMenu)
				break;
		} while (key != 0);

	}

	/**
	 * Traitement.
	 * sélectionne le produit choisi
	 * @param scanner the scanner
	 * @param map the map
	 * @return the string
	 */
	public String traitement(Scanner scanner, Map<Integer, String> map) {
		int limit = map.size();
		int key = limit + 1;
		do {
			try {
				key = scanner.nextInt();
			} catch (InputMismatchException e) {
				affichageErreur(limit);
			}
			scanner.nextLine();
		} while (key < 0 || key > limit);

		return map.get(key);
	}

	/**
	 * Choix user.
	 *
	 * @param scanner the scanner
	 * @param key     the key
	 */

	public abstract void choixUser(Scanner scanner, int key);

	public abstract void affichageMenu();

	public abstract void affichageErreur();

	public abstract void affichageErreur(int max);

}
