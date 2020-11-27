package devinc.pre.mod03.animals;

public class Dog extends Animal {
	public static final String NAME = "собака";
	private static final String VOICE = "ГАВ-ГАВ";

	public Dog() {
		super();
	}

	@Override
	public void callByName() {
		System.out.printf("Привет, я %s. Я говорю %s!", NAME, VOICE);

	}

}
//