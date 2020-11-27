package devinc.pre.mod03;

import devinc.pre.mod03.animals.Animal;

public class VoiceLoader<T extends Animal> {
	public void loadVoice(T a) {
		a.callByName();
	}
}
