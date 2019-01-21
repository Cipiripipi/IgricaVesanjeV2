package bazaPojmova;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import demo.Aplikacija;

public class Oblasti {
	
	private String nazivOblasti;
	private ArrayList<String> lista = new ArrayList<>();
	private String putanjaFajla;
	
	public Oblasti() {}
	
	public Oblasti (String nazivOblasti, ArrayList<String> lista, String putanjaFajla) {
		this.nazivOblasti = nazivOblasti;
		this.lista = lista;
		this.putanjaFajla = putanjaFajla;
	}
	
	public void prikaziOblasti() {
		int brojOblasti = Aplikacija.oblasti.size();
		System.out.println("==============================");
		for (int i = 0; i < brojOblasti; i++)
			System.out.println((i+1) + ") " + Aplikacija.oblasti.get(i).getNazivOblasti());
	}
	
	public void ucitavanjeBaze() {
		File original = new File("C:\\Users\\LapTop LenovoT510\\Desktop\\JAVA zadaci\\Eclipse\\IgricaVesanjeV2\\src\\fajlovi\\");
		File fajlovi [] = original.listFiles();
		
		for (int i = 0; i < fajlovi.length; i++) 
		{
			String trenutnaPutanjaFajla = (String) fajlovi[i].getAbsoluteFile().toString();
			String trenutnoImeFajla = fajlovi[i].getName().substring(0, (int) fajlovi[i].getName().length()-4);
			Oblasti oblast = new Oblasti(trenutnoImeFajla, new UcitajIUpisiPojmove().ucitajFajl(trenutnaPutanjaFajla), trenutnaPutanjaFajla);
			Aplikacija.oblasti.add(oblast);
		}
	}
	
	public void prikaziReciIzNekeOblasti (ArrayList<String> oblast) 
	{
		Collections.sort(oblast);
		for (String ob : oblast) 
			System.out.println(ob);
	}
	
	public void brisiPojmoveIzOblasti (ArrayList<String> ...oblast) {
		for (int i = 0; i < oblast.length; i++) {
			oblast[i].clear();
			System.out.println("Lista pojmova " + oblast[i].getClass().getName() + " je obrisana!");//kako dobiti ime deklarisane promenjive
		}
	}
	/** Metoda vraca true ukoliko postoji pojam u listi oblast. Ako ne postoji vraca false.
	 * 
	 * @param oblast - U koju listu (oblasti) da se pretrazuje pojam
	 * @param pojam - Pojam koji se pretrazuje
	 * @return vraca true ukoliko je pojam pronadjen
	 */
	private boolean pretraziPojmove(ArrayList<String> oblast, String pojam) {
		for (String x : oblast) {
			if (x.equals(pojam))
				return true;
		}
		return false;
	}
	/**Metoda trazi od korisnika da unese odredjeni pojam i oblast. Nakon unosa proverava se da li uneti pojam vec postoji u listi pojmova.
	 * Ukoliko postoji ubacuje pojam u listu i upisuje u odgovarajuci fajl(fajl za tu oblast)
	 * @param oblast - U koju listu (oblasti) da se ubacuje pojam
	 * @param putanjaFajla - Fajl u koji se dodaje pojam
	 * @throws IOException
	 */
	public void ubaciNovuRec (ArrayList<String> oblast, String putanjaFajla) throws IOException {
		System.out.print("Unesite novi pojam: ");
		String pojam = new Scanner(System.in).nextLine();
		if (pretraziPojmove(oblast, pojam) == false) 
		{
			oblast.add(pojam);
			System.out.println("Nov pojam je ubacen!");
			UcitajIUpisiPojmove uup = new UcitajIUpisiPojmove();
			uup.upisiPojam(pojam, putanjaFajla);
			
		}
		else System.out.println("Uneti pojam vec postoji u listi pojmova. Pojam nije ubacen!");
	}

	public String getNazivOblasti() {
		return nazivOblasti;
	}
	public void setNazivOblasti(String nazivOblasti) {
		this.nazivOblasti = nazivOblasti;
	}

	public ArrayList<String> getLista() {
		return lista;
	}
	public void setLista(ArrayList<String> lista) {
		this.lista = lista;
	}

	public String getPutanjaFajla() {
		return putanjaFajla;
	}
	public void setPutanjaFajla(String putanjaFajla) {
		this.putanjaFajla = putanjaFajla;
	}
	
}
