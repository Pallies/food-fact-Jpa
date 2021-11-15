package fr.diginamic.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import fr.diginamic.models.Produit;
import fr.diginamic.utils.AdditifCommon;
import fr.diginamic.utils.AllergenCommon;


/**
 * The Class ProduitService.
 */
public abstract class ProduitService {

	/**
	 * Selection by nutri score.
	 *
	 * @param nb the nb
	 * @return the list
	 */
	public abstract List<Produit> selectionByNutriScoreA(int nb);

	public abstract List<Produit> selectionByNutriScoreF(int nb);

	/**
	 * Selection by allergens. s�lection des produits avec le plus d'ellergènes
	 * 
	 * @param nb the nb
	 * @return the list
	 */
	public List<Produit> selectionByAllergens(int nb) {
		List<Produit> produits = Stock.toList();
		Collections.sort(produits, Comparator.comparing(Produit::getAllergenesSize).reversed());
		return produits.stream().limit(nb).collect(Collectors.toList());
	}

	/**
	 * Selection by additif. S�lection des produits avec le plus d'additifs
	 * 
	 * @param nb the nb
	 * @return the list
	 */
	public List<Produit> selectionByAdditif(int nb) {
		List<Produit> produits = Stock.toList();
		Collections.sort(produits, Comparator.comparing(Produit::getAdditifsSize).reversed());
		return produits.stream().limit(nb).collect(Collectors.toList());
	}

	/**
	 * Selection by ingredients. S�lection des produits avec le plus d'ingr�dients
	 * 
	 * @param nb the nb
	 * @return the list
	 */
	public List<Produit> selectionByIngredients(int nb) {
		List<Produit> produits = Stock.toList();
		Collections.sort(produits, Comparator.comparing(Produit::getIgredientsSize).reversed());
		return produits.stream().limit(nb).collect(Collectors.toList());
	}

	/**
	 * Allergens commun. S�lection des allerg�nes les plus courant
	 * 
	 * @return the list
	 */
	public List<String> allergensCommun() {
		List<Produit> produits = Stock.toList();
		AllergenCommon allergenUtils = new AllergenCommon();

		produits.stream().filter(allergenUtils).forEach(allergenUtils);
		return allergenUtils.getHahsMapCount().entrySet().stream().sorted(allergenUtils).map(allergenUtils)
				.collect(Collectors.toList());
	}

	/**
	 * Additif commun. S�lection des allerg�nes les plus courant
	 * 
	 * @return the list
	 */
	public List<String> additifsCommun() {
		List<Produit> produits = Stock.toList();
		AdditifCommon additifUtils = new AdditifCommon();

		produits.stream().filter(additifUtils).forEach(additifUtils);
		return additifUtils.getHahsMapCount().entrySet().stream().sorted(additifUtils).map(additifUtils)
				.collect(Collectors.toList());
	}
}