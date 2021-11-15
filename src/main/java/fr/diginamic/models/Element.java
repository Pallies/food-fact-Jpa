package models;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * The Class Element.
 *
 * référence pour 100Gr
 * de quantité d'élément 
 * pour un attribut Naturel donné
 */
public class Element{
	
	/** The elements. */
	private HashMap<String, Double> elements = new HashMap<String, Double>();

	/**
	 *  #Constructor.
	 *
	 * @param attribut Enregistre les attributs dans un HashMap
	 * sous forme Entry<String,Double>
	 */
	public Element(Attributs attribut) {
		elements.put(attribut.getNom(), attribut.getQuantite());
	}

	/**
	 * Formattage d'affichage
	 * Ex: Elements vit A : 0.0
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		StringBuilder elementString = new StringBuilder();
		for(Entry<String, Double> el:elements.entrySet()) {
			elementString.append("Elements ")
			.append(el.getKey()).append(" : ").append(el.getValue()).append("\n");
		}
		
		return elementString.toString();
	}

}
