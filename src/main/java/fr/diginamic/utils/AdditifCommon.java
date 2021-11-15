package utils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import models.Produit;

/**
 * The Class AdditifCommon.
 * prend en charge la création du hashMap -> forEach()
 * prend en charge la filtration des listes descriptives vides -> filter()
 * {@link ProduitService}
 */
public class AdditifCommon extends FilterCommon implements Consumer<Produit>, Predicate<Produit>, Function<Entry<String, Integer>, String>,
		Comparator<Entry<String, Integer>> {


	/**
	 * Accept.
	 * addition les valeurs déja présent dans un hashMap
	 * @param produit the produit
	 */
	@Override
	public void accept(Produit produit) {
		produit.getAdditifs().forEach(additif->{
			String[] additifsName =additif.getNom().replaceAll("Additif ", "").split(",");
			for(String name : additifsName) {
				hahsMapCount.merge(name.trim().replaceAll("[^E[0-9A-Z]]{0,4} -", " - "), 1, Integer::sum);
			}
		});
	}

	/**
	 * Test. filtre les produits sans additif
	 *
	 * @param produit the produit
	 * @return true, if successful
	 */
	@Override
	public boolean test(Produit produit) {
		return produit.getAdditifsSize() != 0;
	}

	/**Getter
	 * @return the additifsCount
	 */
	public HashMap<String, Integer> getAdditifsCount() {
		return hahsMapCount;
	}

}
