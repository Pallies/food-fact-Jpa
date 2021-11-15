package services.factory;



/**
 * Interface englobant les class Factory.
 *
 * @author Yvan Palliès
 * @param <T> the generic type
 * @param <R> the generic type
 */
public interface Services<T,R> {

	
	/**
	 * Builder.
	 *
	 * @param data the data
	 * @return the r
	 */
	public abstract R builder(T data);
}
