package services.factory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import models.Produit;

/**
 * Class servant à la fabrication d'un produit.
 *
 */
public class FormatFile implements Services<List<String>, List<Produit>> {

	/** The product factory. */
	private ProductFactory productFactory = new ProductFactory();

	/**
	 * Création de la liste Formater sous la forme d'objet format le fichier et
	 * sépare les informations dans un tableau pour être retraité en
	 * {@link ProductFactory#builder}.
	 *
	 * @param data lignes de fichier
	 * @return liste formattée de produits
	 */
	public List<Produit> builder(List<String> data) {
		List<Produit> produitsList = new ArrayList<Produit>();
		for (String d : data) {
			List<String> dataProduit = Arrays.asList(d.split("[|]"));
			produitsList.add(productFactory.builder(dataProduit));
		}
		return produitsList;
	}
}