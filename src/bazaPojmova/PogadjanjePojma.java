package bazaPojmova;

import java.util.Scanner;

public class PogadjanjePojma {

	public void pogodiPojam (String originalPojam) {
		int brojPokusaja = 0; //broji nam broj pokusaja, za svako uneto slovo ili pokusaj za uneti ceo pojam
		int brojSlova = 0; //broj slova reci za pogadjanje. svaki put kada se pogodi slovo smanjujemo promenjivu jer nam sluzi kao okidac u while petlji
							//kada brojac bude = 0 to znaci da su sva slova pogodjena i da treba da izadjemo iz petlje
		boolean nijePogodjenaRec = false; //ovo koristimo kao "prekidac" ukoliko odustanemo od pogadjanja da nam ne bi ispisao iz koliko puta je pogodjen pojam
		
		String pojam = originalPojam;
		StringBuffer pojamSB = new StringBuffer().append(pojam);
		String pojamPlus = pojam;
		StringBuffer pojamPlusSB = new StringBuffer();
		
		//pretvaramo slova u + da bi kasnije kada se pogodi slovo + zamenili pogodjenim slovom
		String pattSlova = "[a-zA-Z]";
		pojamPlus = pojam.replaceAll(pattSlova, "+");
		pojamPlusSB.append(pojamPlus);
		
		//brojimo broj slova za pogadjanje u pojmu
		for (int i = 0; i < pojam.length(); i++) {
			String slovo = Character.toString(pojam.charAt(i));
			if (slovo.matches(pattSlova)) 
				brojSlova++;
		}
		
		System.out.println("Vasa rec za pogadjanje ima " + brojSlova + " slova!");
		System.out.println(pojamPlus);
		do 
		{
			System.out.println("Unesite 1 za unos slova, 2 za pogadjanje reci, 0 ako odustajes od pogadjanja!" );
			String odluka = new Scanner(System.in).nextLine();
			
			if (odluka.equals("1")) 
			{
				System.out.print("Unesite slovo: ");
				String slovo = new Scanner(System.in).nextLine();
				String slovoM = slovo.toLowerCase(); //ovo je ubaceno da bi kada unesemo malo slovo ispisalo malo slovo u reci za pogadanje. 
													//Bez obzira da li smo uneli malo ili veliko slovo ukoliko slovo postoji racunace nam kao da smo pogodili slovo
				String slovoV = slovo.toUpperCase(); //ovo je ubaceno da bi kada unesemo veliko slovo ispisalo veliko slovo u reci za pogadanje
				if (slovo == null || slovo.isEmpty() || slovo.length() != 1) 
					System.out.println("Niste uneli slovo!");
				else 
				{
					brojPokusaja++;
					for (int i = 0; i < pojam.length(); i++) 
					{
						boolean prikazi = false; //sluzi kao prekidac, da bi nam ispisivao novu izmenjenu rec(sa pogodjenim slovom) kada pogodimo slovo
						if (pojamSB.charAt(i) == slovoM.charAt(0))
						{
							pojamPlusSB.replace(i, i+1, slovoM);
							prikazi = true;
							brojSlova--;
						}
						if (pojamSB.charAt(i) == slovoV.charAt(0))
						{
							pojamPlusSB.replace(i, i+1, slovoV);
							prikazi = true;
							brojSlova--;
						}
						if (prikazi == true)
							System.out.println(pojamPlusSB);
					}
				}
			}
			
			else if (odluka.equals("2")) 
			{
				System.out.println("Unesite rec: ");
				String unetaRec = new Scanner(System.in).nextLine();
				if (unetaRec == null || unetaRec.isEmpty()) 
					System.out.println("Niste uneli rec!");
				else 
				{
					if (unetaRec.equalsIgnoreCase(pojam) == true) {
						brojPokusaja++;
						brojSlova = 0;
					}
					else 
					{
						System.out.println("Niste pogodili rec!");
						brojPokusaja++;
					}
				}
			}
			else if (odluka.equals("0")) 
			{
				System.out.println("Odustao si hahahahahahah! Luzer hahahahah!");
				brojSlova = 0;
				nijePogodjenaRec = true;
			}
			else 
				System.out.println("Uneli ste pogresnu opciju! Unesite ponovo!");
		}
		
		while (brojSlova != 0);
		if (nijePogodjenaRec == false)
			System.out.println("Cestitamo!!! Pogodili ste rec iz " + brojPokusaja + " pokusaja");
	}
}
