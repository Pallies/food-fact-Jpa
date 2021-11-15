package utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The Class SetInHashMap.
 * transforme un set en hashMap afin d'avoir une liste indexée
 * {@link Stock}
 */
public class SetInHashMap {

//	 Todo à modifier en ArrayList
	public static Map<Integer, String> format(Set<String> setString) {
		int index = 1;
		
		Map<Integer, String> hashMap = new HashMap<Integer, String>();
		List<String> typeList = setString.stream().collect(Collectors.toList());

		Collections.sort(typeList);
		
		for (String type : typeList) {
			hashMap.put(index++, type);
		}

		return hashMap;
	}
}
