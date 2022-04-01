package fr.diginamic.run;

import javax.persistence.EntityManager;

/**
 * The Class ApplicationOpenFoodFacts.
 * Class principal : début du programme
 */
public class ApplicationOpenFoodFacts {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EntityManager em = Connection.builder();

		System.out.println("TEST "+em);
//		MainMenu menu = new MainMenu();
//		Scanner scanner = new Scanner(System.in);

//		menu.traiter(scanner);
	}

}
