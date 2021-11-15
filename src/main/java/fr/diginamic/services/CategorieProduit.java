package fr.diginamic.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import fr.diginamic.models.Categorie;
import fr.diginamic.models.Produit;

/**
 * The Class ProduitCategorie. cr�ation d'une liste à partir d'une Cat�gorie
 *
 */
public class CategorieProduit extends ProduitService implements Predicate<Produit> {

	/** The list. */
	private List<Produit> produits;

	/** The categorie. */
	private Categorie categorie;

	/**
	 * Instantiates a new produit categorie.
	 *
	 * @param categorie the categorie
	 */
	public CategorieProduit(Categorie categorie, List<Produit> produits) {
		super();
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
	 * s�lection des produits avec le plus d'ellerg�nes de la Cat�gorie
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
	 * Test.
	 *
	 * @param produit the produit
	 * @return true, if successful
	 */
	@Override
	public boolean test(Produit produit) {
		return categorie.getNom().equals(produit.getCategorie().getNom());
	}

}
