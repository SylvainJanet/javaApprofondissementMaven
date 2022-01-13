package o10.reflexivite;

import java.lang.reflect.Field;

import classes.Product;

public class App10 {

	public static void main(String[] args) {
		/*
		 * 
		 * La réflexion est un concept POO qui permet d'obtenir des informations
		 * structurelles sur un type de données Par exemple, connaître les attributs
		 * d'une classe.
		 * 
		 * Ces informations sont stockées dans un objet de type Class. Ce type "Class"
		 * est générique, il fonctionne pour n'importe quelle type d'objet. Il utilise
		 * le package java.lang. ...
		 * 
		 */

		System.out.println("__________ getDeclaredFields __________");
		Class<Product> metadata = Product.class;
		Product product = new Product(1, "Ma description", 50);

		Field[] fields = metadata.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field.getName());
			try {
				boolean wasAccessible = field.isAccessible();
				if (!wasAccessible)
					field.setAccessible(true);
				System.out.println(field.get(product));
				if (!wasAccessible)
					field.setAccessible(false);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		// Set the accessible flag for this object to the indicated boolean value.
		// A value of true indicates that the reflected object should suppress Java
		// language access checking when it is used. A value of false indicates that the
		// reflected object should enforce Java language access checks.

		System.out.println("__________ createInstance __________");

		try {
			Product p = metadata.newInstance();
			System.out.println(p);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

		System.out.println("__________ getSimpleName __________");

		System.out.println("simple name " + metadata.getSimpleName());
		System.out.println("name " + metadata.getName());

	}

}
