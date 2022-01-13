package o09.fichiers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import classes.Product;

public class CsvTools {
	// fichier CSV :
	// id, description, price (, ou ; ou autre caractère spécial)
	// 1, ordinateur, 300
	// 2, clavier, 50
	// 3, souris, 20

	public static void toCsv(String filePath, List<Product> liste, String separator) throws IOException {
		// Writer : FileWriter qui est un flux d'écriture vers un fichier
		// le bufferedWriter a besoin, pour fonctionner, d'un Writer
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {

			bw.write("id" + separator + "description" + separator + "price");
			bw.newLine();
			for (Product p : liste) {
				String line = p.getId() + separator + p.getDescription() + separator + p.getPrice();
				bw.write(line);
				bw.newLine();
			}
		}
	}

	public static List<Product> fromCsv(String filePath, String separator) throws FileNotFoundException, IOException {
		List<Product> res = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				// "valeur ; valeur ; valeur" ; ou autre chose (valeur dans separator)
				String[] champs = line.split(separator);
				long id = Long.parseLong(champs[0]);
				String description = champs[1];
				double price = Double.parseDouble(champs[2]);
				res.add(new Product(id, description, price));

			}
		}
		return res;
	}

}
