package o10.reflexion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CsvToolsGen {

	public static <T> void toCsv(String filePath, List<T> liste, String separator, Class<T> clazz)
			throws IOException, IllegalArgumentException, IllegalAccessException {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {

			Field[] fields = clazz.getDeclaredFields();
			int i = 1;
			for (Field f : fields) {
				bw.write(f.getName());
				if (i != fields.length)
					bw.write(separator);
				i++;
			}
			bw.newLine();

			for (T el : liste) {
				i = 1;
				for (Field f : fields) {
					f.setAccessible(true);
					bw.write(f.get(el).toString()); // potentiellement un NPE
					// null pointeur exception. Rajouter un test f.get(el) == null
					if (i != fields.length)
						bw.write(separator);
					i++;
				}

				bw.newLine();
			}
		}
	}

	public static <T> List<T> fromCsv(String filePath, String separator, Class<T> clazz)
			throws FileNotFoundException, IOException, InstantiationException, IllegalAccessException {
		List<T> res = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] champs = line.split(separator);
				T obj = clazz.newInstance(); // utilise le constructeur sans paramètres qui doit exister

				Field[] fields = clazz.getDeclaredFields();
				int i = 0;
				for (Field f : fields) {
					f.setAccessible(true);

					// les objets de type classes ne sont pas adaptés pour les
					// types primitifs c'est à dire
					// byte, short, int, long, char, float, double, boolean

					String typeName = f.getType().getName();

					switch (typeName) {
					case "byte":
						f.set(obj, Byte.parseByte(champs[i]));
						break;
					case "short":
						f.set(obj, Short.parseShort(champs[i]));
						break;
					case "int":
						f.set(obj, Integer.parseInt(champs[i]));
						break;
					case "long":
						f.set(obj, Long.parseLong(champs[i]));
						break;
					case "char":
						f.set(obj, champs[i].toCharArray()[0]);
						break;
					case "float":
						f.set(obj, Float.parseFloat(champs[i]));
						break;
					case "double":
						f.set(obj, Double.parseDouble(champs[i]));
						break;
					case "boolean":
						f.set(obj, Boolean.parseBoolean(champs[i]));
						break;
					default:
						f.set(obj, f.getType().cast(champs[i]));
						break;
					}
					i++;
				}
				res.add(obj);

			}
		}
		return res;
	}
}
