package devinc.pre.mod04;

import java.util.Scanner;
import java.util.stream.Collectors;

public class Starter {
	static String open = "([<{";
	static String close = ")]>}";

	public static void main(String[] args) {
		// консольное приложение, в которое вводиться с консоли строка и проверяется
		// правильность расставления скобок(“[”,”]”,”{”,”}”,”<”,”>”,”(”,”)”)

		String input = callScanner(); // вызов сканнера для ввода проверяемой строки

		System.out.println("Проверка строки: " + input);

		String filtered = input.chars() // извлекаем из строки скобки в отдельную строку
				.filter(i -> isOpen((char) i) || isClose((char) i)).mapToObj(i -> "" + (char) i)
				.collect(Collectors.joining());
		System.out.println(filtered);

		try {
			System.out.println("Результат проверки: " + getResult(filtered));
		} catch (BracketException e) {
			e.printStackTrace();
		}

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

	private static String callScanner() {
		System.out.println("Введите сстроку для проверки и нажмите <Enter> ");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		scan.close();
		return name;

	}

}
