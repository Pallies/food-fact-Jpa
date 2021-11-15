package utils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.function.Function;

/**
 * The Class FilterCommon.
 * prend en charge le trie du hashMap -> sorted()
 * prend en charge la transformation du hasMap -> map()
 * {@link ProduitService}
 */
public abstract class FilterCommon implements Comparator<Entry<String, Integer>>,
Function<Entry<String, Integer>, String> {
	
	protected HashMap<String, Integer> hahsMapCount = new HashMap<>();
	
	/**
	 * Compare.
	 * trie le hashmap dans l'ordre descendant
	 * @param o1 the o 1
	 * @param o2 the o 2
	 * @return the int
	 */
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		return o2.getValue() - o1.getValue();
	}
	
	/**
	 * Apply.
	 * assemble le hashMap en une chaine de caractère 
	 * pour afficher son contenu
	 * @param hashMap the hash map
	 * @return the string
	 */
	public String apply(Entry<String, Integer> hashMap) {
		StringBuilder builderString = new StringBuilder();
		return builderString.append(hashMap.getKey()).append(" => ").append(hashMap.getValue()).toString();
	}
	/**Getter
	 * @return the hahsMapCount
	 */
	public HashMap<String, Integer> getHahsMapCount() {
		return hahsMapCount;
	}
}
