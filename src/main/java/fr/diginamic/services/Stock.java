package fr.diginamic.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import fr.diginamic.models.Categorie;
import fr.diginamic.models.Marque;
import fr.diginamic.models.Produit;
import fr.diginamic.run.ReadFoodFact;
import fr.diginamic.services.factory.FormatFile;
import fr.diginamic.utils.SetInHashMap;


/**
 * The Class Stock.
 *
 * @Singleton Class instanci�e une seul fois pour la lecture du fichier
 *            OpenFoodFact
 * 
 *            la classe ne peut pas �tre instanci�
 */
public class Stock extends ProduitService {

	/** The produits. */
	private static List<Produit> produits = null;
	private static Stock instance = null;

	/**
	 * #Constructor appel du Lecteur du fichier appel du formatteur de donn�es
	 * constitution de la liste Produit.
	 */
	private Stock() {
		produits = new ArrayList<>();
		ReadFoodFact readFile = new ReadFoodFact();
		FormatFile fileFormat = new FormatFile();
		List<String> linesFile = readFile.open();
		produits.addAll(fileFormat.builder(linesFile));
	}

	public static Stock getInstance() {
		if (instance == null)
			instance = new Stock();
		return instance;
	}

	/**
	 * Restitution de la lecture du fichier.
	 *
	 * @return List (renvoie une image de produits)
	 */
	public static List<Produit> toList() {
		if (produits == null)
			instance = new Stock();
		return produits.stream().collect(Collectors.toList());
	}

	/**
	 * Listing marque.
	 *
	 * @return the map
	 */
	public static Map<Integer, String> listingMarque() {
		Set<String> marqueSet = Stock.toList().stream().map(Produit::getMarque).map(Marque::getNom)
				.collect(Collectors.toSet());
		return SetInHashMap.format(marqueSet);
	}

	/**
	 * Listing categorie.
	 *
	 * @return the map
	 */
	public static Map<Integer, String> listingCategorie() {
		Set<String> categorieSet = Stock.toList().stream().map(Produit::getCategorie).map(Categorie::getNom)
				.collect(Collectors.toSet());
		return SetInHashMap.format(categorieSet);
	}

	/**
	 * Listing marque categorie. listing g�n�r� à la suite du choix de la marque
	 * 
	 * @param marque the marque
	 * @return the map
	 */
	public static Map<Integer, String> listingMarqueCategorie(Marque marque) {
		Set<String> categorieSet = Stock.toList().stream().filter(new FilterMarque(marque)).map(Produit::getCategorie)
				.map(Categorie::getNom).collect(Collectors.toSet());
		return SetInHashMap.format(categorieSet);
	}

	/**
	 * Selection by nutri score A.
	 *
	 * @param nb the nb
	 * @return the list
	 */
	@Override
	public List<Produit> selectionByNutriScoreA(int nb) {
		List<Produit> listSort = Stock.toList();
		Collections.sort(Stock.toList(), Comparator.comparing(Produit::getNutritionGradeFr));
		return listSort.stream().limit(nb).collect(Collectors.toList());
	}

	/**
	 * Selection by nutri score F. reversed list
	 * 
	 * @param nb the nb
	 * @return the list
	 */
	@Override
	public List<Produit> selectionByNutriScoreF(int nb) {
		List<Produit> listSort = selectionByNutriScoreA(nb);
		Collections.reverse(listSort);
		return listSort;
	}

}

/**
 * The Class FilterMarque. ne concerne que la m�thode listingMarqueCategorie et
 * n'a pas vocation à être externalis�e
 */
class FilterMarque implements Predicate<Produit> {

	private Marque marque;

	public FilterMarque(Marque marque) {
		this.marque = marque;
	}

	/**
	 * Test.
	 *
	 * @param produit the produit
	 * @return true, if successful
	 */
	@Override
	public boolean test(Produit produit) {
		return marque.getNom().equals(produit.getMarque().getNom());
	}

}
