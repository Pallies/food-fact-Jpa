package fr.diginamic.services.factory;

import fr.diginamic.models.Additif;
import fr.diginamic.models.Descriptif;
import fr.diginamic.utils.FilterNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;




/**
 * Class servant à la fabrication d'un produit.
 *
 * Création de liste Additif
 */
public class AdditifFactory implements Services<Stream<String>, List<Descriptif>> {

	/**
	 * Builder.
	 * 
	 * @param data the data
	 * @return the list
	 */
	@Override
	public List<Descriptif> builder(Stream<String> data) {
		String lineAdditif = data.collect(Collectors.joining());
		
//		un additif est toujours composé du préfix E
		if (!lineAdditif.startsWith("E"))
			return  new ArrayList<>();
		
		List<String> linesAdditifs = Arrays.asList(lineAdditif.replace(",", " ").split("E"));
		
		return linesAdditifs.stream()
				.filter(new FilterNotNull())
				.map(new AdditifBuilder())
				.collect(Collectors.toList());
	}

}
class AdditifBuilder implements Function<String, Additif> {

	@Override
	public Additif apply(String value) {
//		rajoute le E supprimé par la function split("E")
		return new Additif("E"+value);
	}

}