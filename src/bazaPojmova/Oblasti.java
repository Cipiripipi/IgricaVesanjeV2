package bazaPojmova;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Oblasti {

	public static ArrayList<Oblasti> oblasti = new ArrayList<>();
	
	public static ArrayList<String> filmovi = UcitajIUpisiPojmove.ucitajFajl("C:\\Users\\Slavko LapTop\\Desktop\\JAVA zadaci\\Eclipse\\IgricaVesanjeV2\\src\\fajlovi\\Filmovi.txt");
	public static ArrayList<String> reci = UcitajIUpisiPojmove.ucitajFajl("C:\\Users\\Slavko LapTop\\Desktop\\JAVA zadaci\\Eclipse\\IgricaVesanjeV2\\src\\fajlovi\\Reci.txt");
	
	
	public static void prikaziReciIzNekeOblasti (ArrayList<String> oblast) 
	{
		for (String film : oblast) 
			System.out.println(film);
	}
	/** Metoda vraca true ukoliko postoji pojam u listi oblast. Ako ne postoji vraca false.
	 * 
	 * @param oblast U koju listu (oblasti) da se pretrazuje pojam
	 * @param pojam Pojam koji se pretrazuje
	 * @return vraca true ukoliko je pojam pronadjen
	 */
	private static boolean pretraziPojmove(ArrayList<String> oblast, String pojam) {
		for (String x : oblast) {
			if (x.equals(pojam))
				return true;
		}
		return false;
	}
	/**Metoda trazi od korisnika da unese odredjeni pojam i oblast. Nakon unosa proverava se da li uneti pojam vec postoji u listi pojmova.
	 * Ukoliko postoji ubacuje pojam u listu i upisuje u odgovarajuci fajl(fajl za tu oblast)
	 * @param oblast U koju listu (oblasti) da se ubacuje pojam
	 * @param putanjaFajla Fajl u koji se dodaje pojam
	 * @throws IOException
	 */
	public static void ubaciNovuRec (ArrayList<String> oblast, String putanjaFajla) throws IOException {
		System.out.print("Unesite novi pojam: ");
		String pojam = new Scanner(System.in).nextLine();
		if (pretraziPojmove(oblast, pojam) == false) 
		{
			oblast.add(pojam);
			System.out.println("Nov pojam je ubacena!");
			UcitajIUpisiPojmove.upisiPojam(pojam, putanjaFajla);
		}
		else System.out.println("Uneti pojam vec postoji u listi pojmova. Pojam nije ubacena!");
	}
	
	
}
