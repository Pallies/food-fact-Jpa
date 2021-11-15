package services.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import models.Allergene;
import models.Descriptif;
import utils.FilterNotNull;

/**
 * Class servant à la fabrication d'un produit.
 *
 * Création de liste Allergene
 */
public class AllergeneFactory implements Services<Stream<String>,List<Descriptif>> {

	/**
	 * Builder.
	 *
	 * @param data the data
	 * @return the list
	 */
	@Override
	public List<Descriptif> builder(Stream<String> data) {
		String lineAllergene = data.collect(Collectors.joining());

		if (!lineAllergene.contains("en:"))
			return new ArrayList<Descriptif>();
		
		List<String> linesAllergenes = Arrays.asList(lineAllergene.replace(",", " ").split("en:"));
		return linesAllergenes.stream()
				.filter(new FilterNotNull())
				.map(new AllergeneBuilder())
				.collect(Collectors.toList());
	}

}
class AllergeneBuilder implements Function<String, Allergene> {

	@Override
	public Allergene apply(String value) {
		return new Allergene(value);
	}

}
