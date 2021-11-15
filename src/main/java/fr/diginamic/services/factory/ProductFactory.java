package services.factory;

import java.util.ArrayList;
import java.util.List;

import models.Attributs;
import models.Categorie;
import models.Descriptif;
import models.Element;
import models.Marque;
import models.Produit;

/**
 * Class servant à la fabrication d'un produit.
 *
 * Création d'un produit
 */
public class ProductFactory implements Services<List<String>, Produit> {

	/** The ingredient factory. */
	private  IngredientFactory ingredientFactory = new IngredientFactory();
	
	/** The element factory. */
	private  ElementFactory elementFactory = new ElementFactory();
	
	/** The allergene factory. */
	private  AllergeneFactory allergeneFactory = new AllergeneFactory();
	
	/** The additif factory. */
	private  AdditifFactory additifFactory = new AdditifFactory();

	/**
	 * Contruction d'un produit ! index et indexEnd sont des variables qui aident à
	 * compartimenter la liste avec l'utilisation de skip() et limit().
	 *
	 * @param dataFormat liste d'information pour un produit
	 * @return Produit
	 */
	public Produit builder(List<String> dataFormat) {

		
		List<Descriptif> ingredients = new ArrayList<>();
		List<Descriptif> allergenes = new ArrayList<>();
		List<Descriptif> additifs = new ArrayList<>();
		
		int index = 0;// index pour le débutde ligne
		int indexEnd = Attributs.values().length; // index du rang limit d'attribut
		
		Categorie categorie = new Categorie(dataFormat.get(index++));//index 0
		Marque marque = new Marque(dataFormat.get(index++));//index 1
		String nom = dataFormat.get(index++);//index 2
		String nutritionGradeFr = dataFormat.get(index++);// index 3
		ingredients = ingredientFactory.builder(dataFormat.get(index++));// index 4
		
		boolean isNAN=true;
//		gestion des ingrédients supplémentaires séparés par un "|" au lieu d'une virgule
//		si ingrédient
		while(isNAN) {			
			try {
				Double.valueOf(dataFormat.get(index));// 5
				index++;
				isNAN=false;
			} catch (Exception e) {
				ingredients.addAll(ingredientFactory.builder(dataFormat.get(index++)));// 5 / 6 / 7
			}
		}
		
		List<Element> elements = elementFactory.builder(dataFormat.stream().skip(index).limit(indexEnd)); //rang d'index 6 à 8 + limit + 23
		
		indexEnd += index-1;// réafectation du début de ligne index => en court + index Attributs.length

		allergenes = allergeneFactory.builder(dataFormat.stream().skip(indexEnd++).limit(1));//rang d'index 29 à 31
		additifs = additifFactory.builder(dataFormat.stream().skip(indexEnd).limit(1));//rang d'index 30 - 32

		return new Produit(categorie, marque, nom, nutritionGradeFr, ingredients, elements, allergenes, additifs);
	}

	
	

}
