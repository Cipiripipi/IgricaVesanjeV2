package demo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IzuzetakProvera {

	/** Metoda radi proveru unosa, ukoliko je broj vraca broj, ukoliko nije trazi da se ponovo unese broj!
	 * 
	 * @param text - Ulazni parametar je string koji zelimo da nam ispise pri pozivu metode!
	 * @return Vraca broj
	 */
		public static Integer proveraUnosaBroja (String text) {
			Scanner unos = new Scanner(System.in);
			boolean krug = true;
			Integer broj = 0;
			do {
				try {
					System.out.print(text);
					broj = unos.nextInt();
					krug = true;
			} catch (InputMismatchException e) {
					System.err.println("Pogresno ste uneli podatak!");
					unos.next();
					krug = false;
				}
			} while (krug == false);
			return broj;
		}
}
