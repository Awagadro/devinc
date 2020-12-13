package devinc.pre.mod08;

import java.util.stream.Collectors;

public class BracketChecker {
	static String open = "([<{";
	static String close = ")]>}";

	public BracketChecker() {

	}

	public boolean getResult(String unfiltered) throws BracketException {
		String input = getFilteredBrackets(unfiltered);
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
		return input.isEmpty() ? open.isEmpty()
				: isOpen(input.charAt(0)) ? isBalanced(input.substring(1), input.charAt(0) + open)
						: isClose(input.charAt(0))
								? !open.isEmpty() && isMatching(open.charAt(0), input.charAt(0))
										&& isBalanced(input.substring(1), open.substring(1))
								: isBalanced(input.substring(1), open);

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
