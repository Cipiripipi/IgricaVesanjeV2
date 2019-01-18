package demo;

import java.util.ArrayList;

public class RandomPojam {

	/**Metoda vraca random rec tipa string iz liste (oblasti) koju smo odabrali pri pozivanju metode
	 * 
	 * @param pojmovi - Ime liste iz koje zelimo da pogadjamo rec
	 * @return Metoda vraca random rec tipa String
	 */
	public String izvuciRandomPojam (ArrayList<String> pojmovi) {
		int randomBroj = (int) (Math.random() * pojmovi.size());
		String randomPojam = pojmovi.get(randomBroj);
		return randomPojam;
	}
}
