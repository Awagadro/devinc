package devinc.pre.mod02.animals;

public class Cow extends Animal {
	public static final String NAME = "корова";
	private static final String VOICE = "МУ-МУ";

	public Cow() {
		super();
	}

	@Override
	public void callByName() {
		System.out.printf("Привет, я %s. Я говорю %s!", NAME, VOICE);

	}

}
//