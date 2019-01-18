package demo;

import java.io.IOException;
import java.util.Scanner;

import bazaPojmova.Oblasti;
import bazaPojmova.PogadjanjePojma;

public class Menu {
	
	Oblasti o = new Oblasti();
	Aplikacija app = new Aplikacija();

	public void opcija1 () 
	{
		boolean pomocniMeni1 = true;
		do 
		{
			System.out.println("");
			System.out.println("1) Filmovi");
			System.out.println("2) Reci");
			System.out.println("0) Povratak na predhodni meni\n");
			System.out.print("Izaberite oblast za koju zelite da vidite listu pojmova: ");
			String odluka1 = new Scanner(System.in).next();
			
			
			if (odluka1.equals("1")) 
			{
				System.out.println("\nLista reci iz oblasti filmovi:");
				System.out.println("==============================");
				o.prikaziReciIzNekeOblasti(app.filmovi);
				System.out.println("==============================");
			}
			else if (odluka1.equals("2")) 
			{
				System.out.println("\nLista reci iz oblasti reci:");
				System.out.println("==============================");
				o.prikaziReciIzNekeOblasti(app.reci);
				System.out.println("==============================");
			}
			else if (odluka1.equals("0")) 
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
			System.out.println("1) Filmovi");
			System.out.println("2) Reci");
			System.out.println("0) Povratak na predhodni meni\n");
			System.out.print("Izaberite oblast za koju zelite da unesete novi pojmova: ");
			String odluka2 = new Scanner(System.in).next();
			
			if (odluka2.equals("1")) 
				o.ubaciNovuRec(app.filmovi, Aplikacija.Filmovifajl);
			else if (odluka2.equals("2"))
				o.ubaciNovuRec(app.reci, Aplikacija.Recifajl);
			else if (odluka2.equals("0"))
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
			System.out.println("1) Filmovi");
			System.out.println("2) Reci");
			System.out.println("0) Povratak na predhodni meni\n");
			System.out.print("Izaberite oblast iz koje zelite da pogadjate pojam: ");
			String odluka3 = new Scanner(System.in).next();
			
			PogadjanjePojma pp = new PogadjanjePojma();
			RandomPojam rp = new RandomPojam();
			if (odluka3.equals("1")) 
				pp.pogodiPojam(rp.izvuciRandomPojam(app.filmovi));
			else if (odluka3.equals("2")) 
				pp.pogodiPojam(rp.izvuciRandomPojam(app.reci));
			else if (odluka3.equals("0"))
				pomocniMeni3 = false;
			else
				System.out.println("Uneli ste pogresnu opciju! Unesite ponovo!");
		}
		while (pomocniMeni3 == true);
	}
	
	public void opcija4 () 
	{
		
	}
	
}
