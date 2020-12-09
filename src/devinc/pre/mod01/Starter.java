package devinc.pre.mod01;

import java.util.Scanner;

public class Starter {
	static String open = "([<{";
	static String close = ")]>}";

	public static void main(String[] args) {
		// консольное приложение, в которое вводиться с консоли строка и проверяется
		// правильность расставления скобок(“[”,”]”,”{”,”}”,”<”,”>”,”(”,”)”)

		String input = callScanner(); // вызов сканнера для ввода проверяемой строки

		System.out.println("Проверка строки: " + input);

		System.out.println("Результат проверки: " + isBalanced(input));

	}

	private static boolean isBalanced(String input) {
		// находим и удаляем соответствующие скобки
		char[] ch = input.toCharArray();
		char[] open = new char[1]; // стек, куда будем запихивать открытые скобки
		for (int i = 0; i < ch.length; i++) {
			if (isOpen(ch[i])) { // если нашли открытую скобку
				open = addCharToArray(open, ch[i]); // добавляем открытую скобку в стек
				continue; // возврат в начало цикла с проверкой нового символа
			} else if (isClose(ch[i]) && isMatching(open[0], ch[i])) { // если нашли закрытую и она совпадает с
																		// последней открытой
				open = removeCharFromArray(open); // убираем из стека соответствующую скобку
				continue; // возврат в начало цикла с проверкой нового символа
			} else if (isClose(ch[i]) && !isMatching(open[0], ch[i])) {
				return false;
			} else if (!isClose(ch[i]) && !isOpen(ch[i])) { // если встретили какой-то другой символ (не скобки)
				continue;// возврат в начало цикла с проверкой нового символа
			}
		}

		if (open[0] != '\u0000') { // пустой default char
			return false;
		}
		return true;
	}

	private static char[] removeCharFromArray(char[] open) {// удаляет символ из начало массива
		char[] temp = new char[open.length - 1];
		for (int i = 1; i < open.length; i++) {
			temp[i - 1] = open[i];
		}
		return temp;
	}

	private static char[] addCharToArray(char[] open, char c) { // добавляет символ в начало массива
		char[] temp = new char[open.length + 1];
		temp[0] = c;
		for (int i = 0; i < open.length; i++) {
			temp[i + 1] = open[i];
		}
		return temp;
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
