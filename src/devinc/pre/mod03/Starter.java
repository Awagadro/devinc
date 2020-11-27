package devinc.pre.mod03;

import java.util.Scanner;

import devinc.pre.mod03.animals.Animal;
import devinc.pre.mod03.animals.Cow;
import devinc.pre.mod03.animals.Dog;
import devinc.pre.mod03.animals.Sheep;

public class Starter {

	public static void main(String[] args) {
		// консольное приложение, в которое вводиться с консоли имя животного и
		// возвращается его голос (Собака – Гав-гав, корова – му-му и т.п.)

		String input = callScanner(); // вызов сканнера для ввода проверяемой строки
		Animal a = null;
		if (input.equals(Cow.NAME)) {
			a = new Cow();
			VoiceLoader<Animal> vl = new VoiceLoader<Animal>();
			vl.loadVoice(a);
		} else if (input.equals(Dog.NAME)) {
			a = new Dog();
			VoiceLoader<Animal> vl = new VoiceLoader<Animal>();
			vl.loadVoice(a);
		} else if (input.equals(Sheep.NAME)) {
			a = new Sheep();
			VoiceLoader<Animal> vl = new VoiceLoader<Animal>();
			vl.loadVoice(a);
			;
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
