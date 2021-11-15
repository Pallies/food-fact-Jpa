package utils;

import java.util.function.Predicate;

/**
 * The Class FilterNotNull.
 *
 * Class de filtrage
 * exclu les types String de valeur null ou ""
 * {@link AdditifFactory}
 * {@link AllergeneFactory}
 */
public class FilterNotNull implements Predicate<String> {

	/**
	 * Test.
	 *
	 * @param value the value
	 * @return true, if successful
	 */
	@Override
	public boolean test(String value) {
		return (!value.contentEquals("") && value!=null);
	}

}
