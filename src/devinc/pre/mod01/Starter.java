package devinc.pre.mod01;

import java.util.Scanner;

public class Starter {

	public static void main(String[] args) {
		// консольное приложение, в которое вводиться с консоли строка и проверяется
		// правильность расставления скобок(“[”,”]”,”{”,”}”,”<”,”>”,”(”,”)”)

		String input = callScanner();
		System.out.println("Строка: " + input);
		
		
		
		

	}

	private static String callScanner() {
		System.out.println("Введите сстроку для проверки и нажмите <Enter> ");
		Scanner scan = new Scanner(System.in);
		String name = scan.next();
		scan.close();
		return name;

	}

}
