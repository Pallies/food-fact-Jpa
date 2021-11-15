package run;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import error.FilesError;

/**
 * The Class ReadFoodFact.
 *
 * Lecture du fichier
 */
public class ReadFoodFact {

	/** emplacement du fichier source. */
	private static final String FILE_OPENFOODFACT = "C:/Users/Peac178/Documents/dev/Diginamic/Exercices/traitement-fichier/src/main/resources/open-food-facts.csv";
	
	private Path path = Paths.get(FILE_OPENFOODFACT);
	/**
	 * gestion de l'erreur gestion de la liste vide.
	 *
	 * @return List<String> lignes du fichier
	 * @throws FilesError
	 */
	public List<String> open() {
		List<String> fileList = Collections.emptyList();

		try {
			test();
			fileList = extractLines();
			} catch (FilesError | IOException e) {
				System.out.println(e.getMessage()+"\n Fermeture de l'pplication dû à la lecture de fichier");
				System.exit(0);
			} 
		return fileList;
	}

	/**
	 * Test.
	 * teste si le fichier est accessible et peut-être lu
	 * @return true, if successful
	 * @throws FilesError 
	 */
	private void test() throws FilesError {
		boolean isNotExist = !Files.isRegularFile(path);
		boolean isNotRead = !Files.isReadable(path);
		if(isNotExist || isNotRead)
			throw new FilesError(isNotExist,path);
	}
	/**
	 * Ouverture du fichier.
	 *
	 * @return the list
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private List<String> extractLines() throws IOException {
		List<String> file = Files.readAllLines(path, StandardCharsets.UTF_8);
		return file.stream().skip(1).collect(Collectors.toList());
	}

}
