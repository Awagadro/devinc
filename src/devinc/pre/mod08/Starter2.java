package devinc.pre.mod08;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Starter2 {

	public static void main(String[] args) {
		// Добавить метод, в который передается объект класса и если в классе есть
		// String поля, то делать для них проверку на правильность раставления скобок

		final String fileName = "src\\devinc\\pre\\data\\text.txt";
		String input = readFile(fileName);

		try { // выберем какой-нибудь класс и создадим его объект
			Class<?> cl = Class.forName("devinc.pre.mod08.AnyClass");
			Object o = cl.getDeclaredConstructor().newInstance();

			Field field1 = cl.getDeclaredField("name");
			field1.setAccessible(true);
			field1.set(o, "<Название текста>");

			Field field2 = cl.getDeclaredField("contents");
			field2.setAccessible(true);
			field2.set(o, input);

			Field field3 = cl.getDeclaredField("id");
			field3.setAccessible(true);
			field3.set(o, 7L);

			Field field4 = cl.getDeclaredField("clasDescription");
			field4.setAccessible(true);
			field4.set(o, "{какой-то документ}");

			checkFields(o); // запуск проверки String полей

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void checkFields(Object ob) {

		Class<?> cl = ob.getClass();

		BracketChecker ac = new BracketChecker();

		try { // проверка полей объекта
			Field[] fields = cl.getDeclaredFields();
			for (Field field : fields) {
				if (field.getType().isAssignableFrom(String.class)) {
					field.setAccessible(true);
					boolean res = ac.getResult((String) field.get(ob));// передаем в BracketChecker содержание поля
					System.out.println("Проверили поле " + field.getName() + ", результат: " + res);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
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
