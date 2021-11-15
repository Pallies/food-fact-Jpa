package run;

import java.util.Scanner;

import menu.MainMenu;

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
		
		MainMenu menu = new MainMenu();
		Scanner scanner = new Scanner(System.in);
		
		menu.traiter(scanner);
	}

}
