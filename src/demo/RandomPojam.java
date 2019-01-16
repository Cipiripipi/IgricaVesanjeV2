package demo;

import java.util.ArrayList;

public class RandomPojam {

	public static String izvuciRandomPojam (ArrayList<String> pojmovi) {
		int randomBroj = (int) (Math.random() * pojmovi.size());
		String randomPojam = pojmovi.get(randomBroj);
		return randomPojam;
	}
}
