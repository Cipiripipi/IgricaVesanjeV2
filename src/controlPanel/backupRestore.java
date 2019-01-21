package controlPanel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class backupRestore {

	public void backupAndRestore (String putanjaStaSeKopira, String putanjaGdeSeKopira) throws IOException 
	{
		try 
		{
			File original = new File(putanjaStaSeKopira);
			File kopija = new File(putanjaGdeSeKopira);
			if (original.exists()) 
			{
				FileUtils.copyDirectory(original, kopija);
				System.out.println("Uspesno ste odradili backup/restore baze podataka!");
			}
			else 
				System.out.println("Fajlovi nisu nadjeni! Doslo je do greske prilikom backup/restore baze podataka!");
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("Nije uspesno uradjen backup");
		}
	}
}
