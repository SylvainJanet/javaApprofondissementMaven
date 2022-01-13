package o10.reflexivite;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflexionTools {

	public static <T> T createInstance(Class<T> clazz) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {

		// clazz.newInstance();

		Constructor<T> constructeur = clazz.getDeclaredConstructor();

		return constructeur.newInstance();
	}
}
