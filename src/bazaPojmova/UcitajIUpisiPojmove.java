package bazaPojmova;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UcitajIUpisiPojmove 
{

	/**Ova metoda se koristi da bi u neku listu ubacili podatke iz nekog fajla
	 * 
	 * @param putanjaFajla - fajl koji se ucitava
	 * @return vraca se ceo niz Stringova, svaki red u fajlu predstavlja jedan element u nizu
	 */
	public static ArrayList<String> ucitajFajl (String putanjaFajla) 
	{
		Scanner in;
		ArrayList<String> pojam = new ArrayList<>();
		try 
		{
			in = new Scanner(new FileReader(putanjaFajla));
			
			while(in.hasNextLine()) 
				pojam.add(in.nextLine());
			in.close();
			return pojam;
		}
		catch (FileNotFoundException e)
		{
			System.err.println("Navedeni fajl ne postoji! ");
			return null;
		}
	}
	
	/**Ova metoda se poziva pri unosu nove reci (Metoda u clasi Oblasti.ubaciNovuRec())
	 * Metoda u clasi Oblasti.ubaciNovuRec() pored dodavanja nove reci u odgovarajucu listu istu rec ubacuje
	 * i u fajl koji se kasnije koristi kao baza podataka koja se ocitava pri novom startovanju programa.
	 * @param pojam - rec koja treba da se upise
	 * @param putanjaFajla - fajl (oblast) u koji uneti pojam treba da se sacuva
	 * @throws IOException - proverava da li fajl postoji
	 */
	public static void upisiPojam (String pojam, String putanjaFajla) throws IOException 
	{
		try 
		{ //ovde nema true jer hocemo da se iz pocetka napravi nov csv fajl
			BufferedWriter upisi = new BufferedWriter(new FileWriter(putanjaFajla, true));
			upisi.newLine();
			upisi.write(pojam);
			upisi.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Greska! Fajl sa studentima nije pronadjen!");
		}
	}
}
