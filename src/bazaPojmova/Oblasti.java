package bazaPojmova;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FileUtils;

import demo.Aplikacija;

public class Oblasti {
	
	private String nazivOblasti;
	private ArrayList<String> lista = new ArrayList<>();
	private String putanjaFajla;
	
	public Oblasti() {}
	
	/**Pri pravljenju objekta se kreira naziv oblasti koji je isti kao ime fajla, iz tog fajla se ubacuju pojmovi u listu i pamti se
	 * putanja fajla zbog naknadnih promena (pored dodavanja novog pojma u listu treba taj pojam dodati i u fajl a za to nam treba informacija o fajlu).
	 * @param nazivOblasti - Predstavlja ime oblasti za pogadjanje (dodeljuje se po imenu fajla)
	 * @param lista - u listu se ubacuju pojmovi tako sto se pozove metoda za ucitavanje fajlova.
	 * @param putanjaFajla - putanja fajla koji se koristi za ubacivanje pojmova u listu.
	 * 							Koristi se da bi znali u kom fajlu treba da se upisu promene kada se dese (Unos nove reci)
	 */
	public Oblasti (String nazivOblasti, ArrayList<String> lista, String putanjaFajla) 
	{
		this.nazivOblasti = nazivOblasti;
		this.lista = lista;
		this.putanjaFajla = putanjaFajla;
	}
	
	/**Metoda ucitava sve fajlove iz foldera i za svaki fajl pravi novu listu i u nju ubacuje pojmove koji se nalaze u tom fajlu.
	 * Ime liste je isto kao ime fajla. Metoda radi za nedefinisan broj fajlova u folderu.
	 */
	public void ucitavanjeBaze() 
	{
		File original = new File("src/fajlovi/");
		File fajlovi [] = original.listFiles();
		
		for (int i = 0; i < fajlovi.length; i++) 
		{
			String trenutnaPutanjaFajla = (String) fajlovi[i].getAbsoluteFile().toString();
			String trenutnoImeFajla = fajlovi[i].getName().substring(0, (int) fajlovi[i].getName().length()-4);
			Oblasti oblast = new Oblasti(trenutnoImeFajla, new UcitajIUpisiPojmove().ucitajFajl(trenutnaPutanjaFajla), trenutnaPutanjaFajla);
			Aplikacija.oblasti.add(oblast);
		}
	}
	
	public void ucitajFajl () throws IOException {
		JFileChooser fc = new JFileChooser();
		//fc.addChoosableFileFilter(new FileNameExtensionFilter("txt", "txt"));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "txt");
		fc.setFileFilter(filter);
		fc.showOpenDialog(fc);
		File fl = fc.getSelectedFile();
		
		if (fl != null) 
		{
			String putanjaFajla = fl.getAbsolutePath();
			String imeFajla = fl.getName().substring(0, fl.getName().length()-4);
			File fajlSta = new File(putanjaFajla);
			File fajlGde = new File("src/fajlovi/");
			FileUtils.copyFileToDirectory(fajlSta, fajlGde);
			Oblasti oblast = new Oblasti(imeFajla, new UcitajIUpisiPojmove().ucitajFajl(putanjaFajla),putanjaFajla);
			Aplikacija.oblasti.add(oblast);
			System.out.println("Ubacili ste novu oblast!");
		}
		else System.out.println("Odustali ste od odabira fajla!");
		
	}
	
	/**Metoda prikazuje pojmove iz oblasti koju unesemo kao ulazni parametar.
	 * 
	 * @param oblast - Oblast iz koje zelimo da pogledamo spisak pojmova
	 */
	public void prikaziReciIzNekeOblasti (ArrayList<String> oblast) 
	{
		Collections.sort(oblast);
		System.out.println("Pojmovi iz izabrane oblasti: ");
		for (String ob : oblast) 
			System.out.println(ob);
		if (oblast.size() == 0)
			System.out.println("U ovoj oblasti jos uvek nema ubacenih pojmova!");
	}
	
	/**Metoda prikazuje sve oblasti koje mozete izabrati za pogadjanje.
	 * 
	 */
	public void prikaziOblasti() 
	{
		int brojOblasti = Aplikacija.oblasti.size();
		System.out.println("==============================");
		for (int i = 0; i < brojOblasti; i++)
			System.out.println((i+1) + ") " + Aplikacija.oblasti.get(i).getNazivOblasti());
		if (brojOblasti == 0)
			System.out.println("Jos uvek nema kreiranih oblasti! Prvo kreirajte oblast i ubacite reci!" );
	}
	
	//u izradi
	public void brisiPojmoveIzOblasti (ArrayList<String> ...oblast) {
		for (int i = 0; i < oblast.length; i++) {
			oblast[i].clear();
			System.out.println("Lista pojmova " + oblast[i].getClass().getName() + " je obrisana!");//kako dobiti ime deklarisane promenjive
		}
	}
	/**Metoda kreira novu oblast i pavi fajl sa imenom oblasti
	 * 
	 * @throws IOException
	 */
	public void ubaciNovuOblast () throws IOException 
	{
		System.out.print("Unesite naziv nove oblasti: ");
		String nazivNoveOblasti = new Scanner(System.in).next();
		String putanjaFajla = "src/fajlovi/" + nazivNoveOblasti + ".txt";
		new BufferedWriter(new FileWriter(putanjaFajla)); //,true
		Oblasti oblast = new Oblasti(nazivNoveOblasti, new UcitajIUpisiPojmove().ucitajFajl(putanjaFajla), putanjaFajla);
		Aplikacija.oblasti.add(oblast);
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
	 * Ukoliko ne postoji ubacuje pojam u listu i upisuje u odgovarajuci fajl(fajl za tu oblast)
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
