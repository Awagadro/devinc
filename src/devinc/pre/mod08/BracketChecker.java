package devinc.pre.mod08;

import java.util.stream.Collectors;

public class BracketChecker {
	static String open = "([<{";
	static String close = ")]>}";
	private String st; // вот что мы будем проверять

	public BracketChecker(String st) {
		this.st = st;
	}

	public BracketChecker() {

	}

	public String getSt() {
		return st;
	}

	public void setSt(String st) {
		this.st = st;
	}

	@MethodAnnotation()
	public boolean getResult() throws BracketException {
		String input = this.getSt();
		String filtered = getFilteredBrackets(input);
		boolean result = isBalanced(filtered, "");
		if (result == false) {
			throw new BracketException("неправильная последовательность скобок");
		}

		return result;
		
	}

	private static String getFilteredBrackets(String input) {
		return input.chars() // извлекаем из строки скобки в отдельную строку
				.filter(i -> isOpen((char) i) || isClose((char) i)).mapToObj(i -> "" + (char) i)
				.collect(Collectors.joining());
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

}
