package devinc.pre.mod08;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.file.Files;
import java.nio.file.Paths;

import devinc.pre.mod08.original.IText;
import devinc.pre.mod08.original.TextImpl;

public class Starter1 {
	public static void main(String[] args) throws Exception {
// вызов функции проверки скобок при отработке метода, помеченного аннотацией
		final String fileName = "src\\devinc\\pre\\data\\text.txt";
		String input = readFile(fileName);
		IText text = new TextImpl();
		Handler handler = new Handler(text);
		// Class<?> cl = IText.class;
		// Object o = cl.getDeclaredConstructor().newInstance();
		// Method[] mm = cl.getDeclaredMethods();

		IText textProxy = (IText) Proxy.newProxyInstance(text.getClass().getClassLoader(),
				TextImpl.class.getInterfaces(), handler);
		textProxy.setAuthor("name");
		textProxy.setTitle("(document>");
		textProxy.setContents(input);
		textProxy.getContents(); // если скобки расставлены неправильно выскочит Exception
//		textProxy.getTitle();
	}

	static class Handler implements InvocationHandler {
		private final IText original;

		public Handler(IText original) {
			this.original = original;
		}

		BracketChecker checker = new BracketChecker();

		public Object invoke(Object proxy, Method method, Object[] args)
				throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, BracketException {
			if (method.isAnnotationPresent(MethodAnnotation.class)) {
				System.out.println("Результат проверки расстоновки скобок: "
						+ checker.getResult(((String) method.invoke(original, args))));
				return method.invoke(original, args);
			}
			return method.invoke(original, args);
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
