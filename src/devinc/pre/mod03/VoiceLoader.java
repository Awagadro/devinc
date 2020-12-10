package devinc.pre.mod03;

import devinc.pre.mod03.animals.Animal;

public class VoiceLoader {
	// Java Generic Method
	public static <T extends Animal> void loadVoice(T a) {
		a.callByName();
	}
}
