package devinc.pre.mod01;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		Map<Integer, String> words = new HashMap<Integer, String>();
		words.put(1, "First");
		words.put(3, "Two");
		words.put(3, "Three");
		System.out.println("Map :" + words);
		System.out.println("Word is " + words.get(3));

	}

}
