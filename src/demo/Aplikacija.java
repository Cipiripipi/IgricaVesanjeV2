package demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import bazaPojmova.Oblasti;

public class Aplikacija {
	
	public static ArrayList<ArrayList<String>> oblasti = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		
		boolean pocetniMeni = true;
		oblasti.add(Oblasti.filmovi);
		oblasti.add(Oblasti.reci);
		
		System.out.println("Dobro dosli u igricu VESANJE!!");
		System.out.println("==============================");
		new Vesala().nacrtajKonopac();
		
		do 
		{
			System.out.println("");
			System.out.println("1) List pojmova po oblastima!");
			System.out.println("2) Unos novog pojma!");
			System.out.println("3) Pogadjajte pojam! ");
			System.out.println("4) Control Panel! U IZRADI");
			System.out.println("0) Izlaz iz programa");
			System.out.println("");
			System.out.print("Izaberite opciju: ");
			
			Scanner unos = new Scanner(System.in);
			String odluka = unos.next();
			
			if (odluka.equals("1")) 
				Menu.opcija1();
			
			else if (odluka.equals("2")) 
				Menu.opcija2();
			
			else if (odluka.equals("3")) 
				Menu.opcija3();
			
			else if (odluka.equals("4")) 
				Menu.opcija4();
				
			else if (odluka.equals("0")) 
				pocetniMeni = false;
			
			else System.out.println("Uneli ste pogresnu opciju! Unesite ponovo!");
		}
		while (pocetniMeni == true);
		System.out.println("Hvala sto ste se igrali sa nama!");
	}
}
