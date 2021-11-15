package services.factory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import models.Descriptif;
import models.Ingredient;

/**
 * Class servant à la fabrication d'un produit.
 *
 * Création d'une liste d'ingrédients
 */
public class IngredientFactory implements Services<String,List<Descriptif>> {
	
	/**
	 * Builder.
	 *
	 * @param data ligne des ingrédients
	 * @return liste formatté d'ingrédients
	 */
	@Override
	public List<Descriptif> builder(String data) {
		return Arrays.asList(data.split(",")).stream()
				.map(Ingredient::new)
				.collect(Collectors.toList());
	}

}
