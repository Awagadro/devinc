package devinc.pre.mod02.animals;

public class Sheep extends Animal {
	public static final String NAME = "овца";
	private static final String VOICE = "БЕ-МЕ";

	public Sheep() {
		super();
	}

	@Override
	public void callByName() {
		System.out.printf("Привет, я %s. Я говорю %s!", NAME, VOICE);

	}

}
//