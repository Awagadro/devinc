package devinc.pre.mod08;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Starter1 {
	public static void main(String[] args) throws Exception {
// вызов основного функционала с помощью аннотаций, при добавлении аннотации к методу 
		final String fileName = "src\\devinc\\pre\\data\\text.txt";
		String input = readFile(fileName);

		Class<?> cl = BracketChecker.class;
		Object o = cl.getDeclaredConstructor().newInstance();
		// AnnotationChecker o = (AnnotationChecker) cl.newInstance(); // можно и так

		Field field = cl.getDeclaredField("st");
		field.setAccessible(true);
		field.set(o, input);

		Method[] mm = cl.getMethods();
		for (Method method : mm) {
			if (method.isAnnotationPresent(MethodAnnotation.class)) {

				boolean result = (boolean) method.invoke(o);
				System.out.println("Проверка расстановки скобок: " + result);

			}
		}

	}

	private static String readFile(String fileName) {
		try {
			return Files.readAllLines(Paths.get(fileName)).toString();

		} catch (IOException e) {
			e.printStackTrace(System.out);
		}
		return null;

	}

}
