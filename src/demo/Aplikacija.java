package demo;

import java.io.IOException;
import java.util.Scanner;

import bazaPojmova.Oblasti;

public class Aplikacija {

	public static void main(String[] args) throws IOException {
		
		boolean pocetniMeni = true;
		
		System.out.println("Dobro dosli u igricu VESANJE!!");
		System.out.println("==============================");
		new Vesala().nacrtajKonopac();
		
		do 
		{
			System.out.println("");
			System.out.println("1) Liste reci po oblastima!");
			System.out.println("2) Unos novog pojma!");
			System.out.println("3) Pogadjajte pojam! ");
			System.out.println("4) Backup/Restore baze pojmova ");
			System.out.println("0) Izlaz iz programa");
			System.out.println("");
			System.out.print("Izaberite opciju: ");
			
			Scanner unos = new Scanner(System.in);
			String odluka = unos.next();
		}
		while (pocetniMeni == true);
		
//		Oblasti.prikaziReciIzNekeOblasti(Oblasti.filmovi);
//
//		Oblasti.ubaciNovuRec(Oblasti.reci, "C:\\Users\\Slavko LapTop\\Desktop\\JAVA zadaci\\Eclipse\\IgricaVesanjeV2\\src\\fajlovi\\Reci.txt");
//		Oblasti.prikaziReciIzNekeOblasti(Oblasti.reci);
	}

}
