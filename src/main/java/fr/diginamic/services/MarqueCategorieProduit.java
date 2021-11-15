package fr.diginamic.services;

import fr.diginamic.models.Categorie;
import fr.diginamic.models.Marque;
import fr.diginamic.models.Produit;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * The Class ProduitCategorieMarque. cr�ation d'une liste à partir d'une
 * Cat�gorie et d'une marque
 * 
 */
public class MarqueCategorieProduit extends ProduitService implements Predicate<Produit> {

	/** The list. */
	private List<Produit> produits;

	/** The categorie. */
	private Categorie categorie;

	/** The marque. */
	private Marque marque;

	/**
	 * Instantiates a new produit categorie marque.
	 *
	 * @param categorie the categorie
	 * @param marque    the marque
	 */
	public MarqueCategorieProduit(Marque marque, Categorie categorie, List<Produit> produits) {
		super();
		this.marque = marque;
		this.categorie = categorie;
		this.produits = produits.stream().filter(this::test).collect(Collectors.toList());
	}

	/**
	 * Selection by nutri score A.
	 *
	 * @param nb the nb
	 * @return the list
	 */
	@Override
	public List<Produit> selectionByNutriScoreA(int nb) {
		Collections.sort(produits, Comparator.comparing(Produit::getNutritionGradeFr));
		return produits.stream().limit(nb).collect(Collectors.toList());
	}

	/**
	 * Selection by nutri score F. reversed list
	 * 
	 * @param nb the nb
	 * @return the list
	 */
	@Override
	public List<Produit> selectionByNutriScoreF(int nb) {
		List<Produit> orderList = selectionByNutriScoreA(nb);
		Collections.reverse(orderList);
		return orderList;
	}
	/**
	 * Selection by allergens.
	 * s�lection des produits avec le plus d'ellergènes de la Cat�gorie
	 * @param nb the nb
	 * @return the list produits
	 */
	@Override
	public List<Produit> selectionByAllergens(int nb) {
		Collections.sort(produits, Comparator.comparing(Produit::getAllergenesSize).reversed());
		return produits.stream().limit(nb).collect(Collectors.toList());
	}


	/**
	 * Selection by additif.
	 * S�lection des produits avec le plus d'additifs de la Cat�gorie
	 * @param nb the nb
	 * @return the list produits
	 */
	@Override
	public List<Produit> selectionByAdditif(int nb) {
		Collections.sort(produits, Comparator.comparing(Produit::getAdditifsSize).reversed());
		return produits.stream().limit(nb).collect(Collectors.toList());
	}
	/**
	 * Predicate Test.
	 * 
	 * @param produit the produit
	 * @return true, if successful
	 */
	@Override
	public boolean test(Produit produit) {
		String categorieName = produit.getCategorie().getNom();
		String marqueName = produit.getMarque().getNom();
		return categorie.getNom().equals(categorieName) && marque.getNom().equals(marqueName);
	}

}
