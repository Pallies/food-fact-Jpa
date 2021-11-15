package services.factory;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import models.Attributs;
import models.Element;

/**
 * Class servant à la fabrication d'un produit.
 *
 * Création de liste éléments
 * Element => HashMap<String, Double>
 */
public class ElementFactory implements Services<Stream<String>, List<Element>> {
	
	/**
	 * Convertir la chaine de caratère en liste élément (Enum Attributs)
	 * {@link AffectationBuider}.
	 *
	 * @param data the data
	 * @return the list
	 */
	@Override
	public List<Element> builder(Stream<String> data) {
		return data.map(new AttributeBuilder()).collect(Collectors.toList());
	}

}
class AttributeBuilder implements Function<String, Element> {
	 private int index = 0;
		
		public AttributeBuilder(){
		}

		@Override
		public Element apply(String value) {
			Attributs attribut=Attributs.values()[index++];
			try {				
				Double parse = value.isEmpty() ? 0: Double.parseDouble(value);
				attribut.setQuantite(parse);
			} catch (Exception e) {
				return null;
			}
			return new Element(attribut);
		}



	}