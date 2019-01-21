package demo;

import java.io.IOException;
import java.util.Scanner;

import bazaPojmova.Oblasti;
import bazaPojmova.PogadjanjePojma;
import controlPanel.backupRestore;

public class Menu {
	
	Oblasti o = new Oblasti();
	
	public void opcija1 () 
	{
		boolean pomocniMeni1 = true;
		do 
		{
			System.out.println("");
			o.prikaziOblasti();
			System.out.println("0) Povratak na predhodni meni\n");
			int odluka1 = IzuzetakProvera.proveraUnosaBroja("Izaberite oblast za koju zelite da vidite listu pojmova: ");
			odluka1--; //smanjujemo zato sto u prikazu prva oblast je oznacena sa 1 a u listi sa 0
			
				if (odluka1 >= 0 && odluka1 < Aplikacija.oblasti.size()) 
					o.prikaziReciIzNekeOblasti(Aplikacija.oblasti.get(odluka1).getLista());
				else if (odluka1 == -1) 
					pomocniMeni1 = false;
				else 
					System.out.println("Uneli ste pogresnu opciju! Unesite ponovo!");
		}
		while (pomocniMeni1 == true);
	}
	
	public void opcija2 () throws IOException
	{
		boolean pomocniMeni2 = true;
		do 
		{
			System.out.println("");
			o.prikaziOblasti();
			System.out.println("0) Povratak na predhodni meni\n");
			int odluka2 = IzuzetakProvera.proveraUnosaBroja("Izaberite oblast za koju zelite da vidite listu pojmova: ");
			odluka2--; //smanjujemo zato sto u prikazu prva oblast je oznacena sa 1 a u listi sa 0
			
			if (odluka2 >= 0 && odluka2 < Aplikacija.oblasti.size()) 
				o.ubaciNovuRec(Aplikacija.oblasti.get(odluka2).getLista(), Aplikacija.oblasti.get(odluka2).getPutanjaFajla());
			else if (odluka2 == -1) 
				pomocniMeni2 = false;
			else 
				System.out.println("Uneli ste pogresnu opciju! Unesite ponovo!");
		}
		while (pomocniMeni2 == true);
	}
	
	public void opcija3 () 
	{
		boolean pomocniMeni3 = true;
		do 
		{
			System.out.println("");
			o.prikaziOblasti();
			System.out.println("0) Povratak na predhodni meni\n");
			int odluka3 = IzuzetakProvera.proveraUnosaBroja("Izaberite oblast za koju zelite da vidite listu pojmova: ");
			odluka3--; //smanjujemo zato sto u prikazu prva oblast je oznacena sa 1 a u listi sa 0
			
			PogadjanjePojma pp = new PogadjanjePojma();
			RandomPojam rp = new RandomPojam();
			if (odluka3 >= 0 && odluka3 < Aplikacija.oblasti.size()) 
				pp.pogodiPojam(rp.izvuciRandomPojam(Aplikacija.oblasti.get(odluka3).getLista()));
			else if (odluka3 == -1)
				pomocniMeni3 = false;
			else
				System.out.println("Uneli ste pogresnu opciju! Unesite ponovo!");
		}
		while (pomocniMeni3 == true);
	}
	
	public void opcija4 () throws IOException 
	{
		boolean pomocniMeni4 = true;
		do 
		{
			System.out.println("");
			System.out.println("1) Uradi backup baze!");
			System.out.println("2) Uradi restore baze!");
			System.out.println("0) Povratak na predhodni meni\n");
			System.out.print("Izaberite opciju: ");
			
			String odluka4 = new Scanner(System.in).next();
			backupRestore br = new backupRestore();
			
			if (odluka4.equals("1"))
				br.backupAndRestore("C:\\Users\\LapTop LenovoT510\\Desktop\\JAVA zadaci\\Eclipse\\IgricaVesanjeV2\\src\\fajlovi\\", "C:\\Users\\LapTop LenovoT510\\Desktop\\JAVA zadaci\\Eclipse\\IgricaVesanjeV2\\src\\backup\\");
			else if (odluka4.equals("2"))
				br.backupAndRestore("C:\\Users\\LapTop LenovoT510\\Desktop\\JAVA zadaci\\Eclipse\\IgricaVesanjeV2\\src\\backup\\", "C:\\Users\\LapTop LenovoT510\\Desktop\\JAVA zadaci\\Eclipse\\IgricaVesanjeV2\\src\\fajlovi\\");
			else if (odluka4.equals("0"))
				pomocniMeni4 = false;
			else
				System.out.println("Uneli ste pogresnu opciju! Unesite ponovo!");
		}
		while(pomocniMeni4 == true);
	}
	
}
