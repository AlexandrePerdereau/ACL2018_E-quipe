

import java.io.*;
public class Fichier {
	private BufferedWriter fW;
	private BufferedReader fR;
	private char mode;


	public void ouvrir(String nomDuFichier, String s) throws IOException{
		mode = (s.toUpperCase()).charAt(0);
		File f = new File(nomDuFichier);
		if (mode == 'R' || mode == 'L')
			fR = new BufferedReader(new FileReader(f));
		else if (mode == 'W' || mode == 'E')
			fW = new BufferedWriter(new FileWriter(f));
	}
	public void fermer() throws IOException {
		if (mode == 'R' || mode == 'L') fR.close();
		else if (mode == 'W' || mode == 'E') fW.close();
	}
	public String lire() throws IOException {
		String chaine = fR.readLine();
		return chaine;
	}
	public void ecrire(double tmp) throws IOException {
		String chaine = "";
		chaine = chaine.valueOf(tmp);
		if (chaine != null) {
			fW.write(chaine,0,chaine.length());
			fW.newLine();
		}
	} 
	
	public void ecrire(String tmp) throws IOException {
		
		
			fW.write(tmp,0,tmp.length());
			fW.newLine();
		
	} 

}
