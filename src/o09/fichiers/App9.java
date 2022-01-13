package o09.fichiers;

import java.io.IOException;
import java.util.List;

import classes.Product;
import o01.console.tools.InitialData;
import o08.genericite.GenericFunctions;

public class App9 {

	public static void main(String[] args) {
		List<Product> list = InitialData.productList;

		try {
			CsvTools.toCsv("products.csv", list, ";");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			List<Product> list2 = CsvTools.fromCsv("products2.csv", ";");
			GenericFunctions.displayList(list2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
