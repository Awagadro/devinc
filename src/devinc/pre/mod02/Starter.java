package devinc.pre.mod02;

import java.util.Scanner;

import devinc.pre.mod02.animals.Animal;
import devinc.pre.mod02.animals.Cow;
import devinc.pre.mod02.animals.Dog;
import devinc.pre.mod02.animals.Sheep;

public class Starter {

	public static void main(String[] args) {
		// консольное приложение, в которое вводиться с консоли имя животного и
		// возвращается его голос (Собака – Гав-гав, корова – му-му и т.п.)

		String input = callScanner(); // вызов сканнера для ввода проверяемой строки
		Animal a = null;
		if (input.equals(Cow.NAME)) {
			a = new Cow();
			a.callByName();
		} else if (input.equals(Dog.NAME)) {
			a = new Dog();
			a.callByName();
		} else if (input.equals(Sheep.NAME)) {
			a = new Sheep();
			a.callByName();
		} else {
			System.out.println("нет такого зверя");
		}

	}

	private static String callScanner() {
		System.out.println("Введите название животного и нажмите <Enter> ");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		scan.close();
		return name;

	}
}
