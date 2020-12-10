package devinc.pre.mod06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class Starter {
	static String open = "([<{";
	static String close = ")]>}";

	public static void main(String[] args) {
		// mod 1 with collections + stream Api

		String input = callScanner(); // вызов сканнера для ввода проверяемой строки

		String filtered = input.chars() // извлекаем из строки скобки в отдельную строку
				.filter(i -> isOpen((char) i) || isClose((char) i)).mapToObj(i -> "" + (char) i)
				.collect(Collectors.joining());

		System.out.println("Результат проверки: " + isBalanced(filtered));

	}

	private static boolean isBalanced(String input) {
		// находим и удаляем соответствующие скобки
		List<Character> ch = (ArrayList<Character>) input.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		Stack<Character> open = new Stack<Character>(); // стек, куда будем запихивать открытые скобки
		for (int i = 0; i < ch.size(); i++) {
			if (isOpen(ch.get(i))) { // если нашли открытую скобку
				open.add(ch.get(i)); // добавляем открытую скобку в стек
				continue; // возврат в начало цикла с проверкой нового символа
			} else if (isClose(ch.get(i)) && !open.isEmpty() && isMatching(open.peek(), ch.get(i))) {
				// если нашли закрытую и совпадает с последней открытой
				open.pop(); // убираем из стека соответствующую скобку
				continue; // возврат в начало цикла с проверкой нового символа
			} else if (isClose(ch.get(i)) && open.isEmpty()) {
				return false;
			} else if (isClose(ch.get(i)) && !isMatching(open.peek(), ch.get(i))) {
				return false;
			} else if (!isClose(ch.get(i)) && !isOpen(ch.get(i))) { // если встретили какой-то другой символ (не скобки)
				continue;// возврат в начало цикла с проверкой нового символа
			}
		}

		if (!open.isEmpty()) {
			return false;
		}
		return true;
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
