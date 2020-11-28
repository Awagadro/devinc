package devinc.pre.mod07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class MyThread implements Runnable {
	static String open = "([<{";
	static String close = ")]>}";
	final String fileName = "src\\devinc\\pre\\mod07\\data\\text.txt";

	private Thread t;

	MyThread(String name) {
		t = new Thread(this, name);
		t.start();
	}

	@Override
	public void run() {
//		try {
		System.out.println("MyThread запущен: " + t.getName());
		String input = readFile(fileName);
		String filtered = input.chars() // извлекаем из строки скобки в отдельную строку
				.filter(i -> isOpen((char) i) || isClose((char) i)).mapToObj(i -> "" + (char) i)
				.collect(Collectors.joining());

		try {
			System.out.println("Результат проверки: " + getResult(filtered));
		} catch (BracketException e) {
			e.printStackTrace();
		}
//		} catch (InterruptedException e) {
//			System.out.println("MyThread прерван: "+t.getName());
//		}
	}

	private static boolean getResult(String input) throws BracketException {
		boolean result = isBalanced(input, "");
		if (result == false) {
			throw new BracketException("неправильная последовательность скобок");
		}

		return result;

	}

	private static boolean isBalanced(String input, String open) {
		// находим и удаляем соответствующие скобки методом рекурсии
		if (input.isEmpty()) {
			return open.isEmpty();
		} else if (isOpen(input.charAt(0))) { // ищем открывающие скобки
			return isBalanced(input.substring(1), input.charAt(0) + open); // и, если находим, добавляем в open
		} else if (isClose(input.charAt(0))) {// ищем закрывающие скобки
			return !open.isEmpty() && isMatching(open.charAt(0), input.charAt(0))// и, если находим, сравниваем с
																					// последней открывающей из open
					&& isBalanced(input.substring(1), open.substring(1)); // если нашли соответствие, удаляем пару
																			// скобок и повторяем цикл
		} else {
			return isBalanced(input.substring(1), open); // не обязательно, отработает если предварительно не извлекать
															// скобки из текста
		}

	}

	private static boolean isMatching(char chO, char chC) {
		return open.indexOf(chO) == close.indexOf(chC);
	}

	private static boolean isOpen(char ch) {
		return open.indexOf(ch) != -1;
	}

	private static boolean isClose(char ch) {
		return close.indexOf(ch) != -1;
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
