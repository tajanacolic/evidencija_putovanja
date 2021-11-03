package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Model.Putovanje;

public class Kontroler {

	Putovanje putovanje;
	public ArrayList<Putovanje> listaPutovanja = new ArrayList<>();

	// unos u listu
	public void unesiPodatke(String datum, String grad_polazak, String grad_destinacija, String prezime,
			double cijena) {

		putovanje = new Putovanje();
		putovanje.setDatum(datum);
		putovanje.setGrad_polazak(grad_polazak);
		putovanje.setGrad_destinacija(grad_destinacija);
		putovanje.setPrezime(prezime);
		putovanje.setCijena(cijena);

		listaPutovanja.add(putovanje);
	}

	public String ispisPutovanja() {
		String ispis = "";
		if (listaPutovanja.isEmpty()) {
			ispis = "Nema unosa u listi.";
		} else {
			for (int i = 0; i < listaPutovanja.size(); i++) {
				ispis = ispis + "" + (i + 1) + "." + "               " + listaPutovanja.get(i).getDatum() + "        "
						+ listaPutovanja.get(i).getPrezime() + "              "
						+ listaPutovanja.get(i).getGrad_polazak() + "           "
						+ listaPutovanja.get(i).getGrad_destinacija() + "             "
						+ listaPutovanja.get(i).getCijena() + "\n";
			}
		}
		return ispis;
	}

	/*
	 * //ispis datuma public String ispisiPodatkeDatum (){
	 * 
	 * String text="";
	 * 
	 * for(int i=0;i<listaPutovanja.size();i++){
	 * 
	 * text = text + " " + (listaPutovanja.get(i).getDatum()+"\n");
	 * 
	 * } return text; }
	 * 
	 * //ispis grad_polazak public String ispisiPodatkeGrad_polazak (){
	 * 
	 * String text="";
	 * 
	 * for(int i=0;i<listaPutovanja.size();i++){
	 * 
	 * text = text + " " + (listaPutovanja.get(i).getGrad_polazak()+"\n");
	 * 
	 * } return text; }
	 * 
	 * //ispis grad_destinacija public String ispisiPodatkeGrad_destinacija (){
	 * 
	 * String text="";
	 * 
	 * for(int i=0;i<listaPutovanja.size();i++){
	 * 
	 * text = text + " " + (listaPutovanja.get(i).getGrad_destinacija()+"\n");
	 * 
	 * } return text; }
	 * 
	 * //ispis prezime public String ispisiPodatkePrezime (){
	 * 
	 * String text="";
	 * 
	 * for(int i=0;i<listaPutovanja.size();i++){
	 * 
	 * text = text + " " + (listaPutovanja.get(i).getPrezime()+"\n");
	 * 
	 * } return text; }
	 * 
	 * //ispis cijena public String ispisiPodatkeCijena (){
	 * 
	 * String text="";
	 * 
	 * for(int i=0;i<listaPutovanja.size();i++){
	 * 
	 * text = text + " " + (listaPutovanja.get(i).getCijena()+"\n");
	 * 
	 * } return text; }
	 */

	// brisanje
	public String izbrisiPutovanje(int i) {
		i = i - 1;
		String poruka = "";
		if (i < 0 || i > listaPutovanja.size() - 1) {
			return "Uneseni redni broj je manji ili je jednak nuli ili ne postoji u podatku.";
		} else {
			listaPutovanja.remove(i);
			return poruka;
		}
	}

	// pretraga
	public String pretraziPutovanje(String datum, String prezime) {
		String ispis = "";
		if (listaPutovanja.isEmpty()) {
			ispis = "Nema unosa u listi.";
		}
		for (int i = 0; i < listaPutovanja.size(); i++) {
			if (listaPutovanja.get(i).getDatum().equals(datum) && listaPutovanja.get(i).getPrezime().equals(prezime)) {
				ispis = ispis + "" + (i + 1) + "." + "               " + listaPutovanja.get(i).getDatum() + "        "
						+ listaPutovanja.get(i).getPrezime() + "              "
						+ listaPutovanja.get(i).getGrad_polazak() + "           "
						+ listaPutovanja.get(i).getGrad_destinacija() + "             "
						+ listaPutovanja.get(i).getCijena() + "\n";
			}
		}
		if (ispis.equals("")) {
			return "Putovanje ne postoji!";
		}
		return ispis;
	}

	// spremanje u datoteku
	public void spremiUDatoteku() throws IOException {

		PrintWriter pw = new PrintWriter(new FileOutputStream(new File("Rezervacije.txt"), true));

		for (Putovanje putovanje : listaPutovanja) {

			pw.print(putovanje.getDatum());
			pw.print(",");
			pw.print(putovanje.getGrad_polazak());
			pw.print(",");
			pw.print(putovanje.getGrad_destinacija());
			pw.print(",");
			pw.print(putovanje.getPrezime());
			pw.print(",");
			pw.print(putovanje.getCijena());
			pw.println();

		}
		pw.close();

	}

	// èitanje iz datoteke
	public void citanjeIzDatoteke() throws IOException {

		try (BufferedReader br = new BufferedReader(new FileReader("Rezervacije.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] row = line.split(",");
				Putovanje putovanje = new Putovanje();
				putovanje.setDatum(row[0]);
				putovanje.setGrad_polazak(row[1]);
				putovanje.setGrad_destinacija(row[2]);
				putovanje.setPrezime(row[3]);
				putovanje.setCijena(Double.parseDouble(row[4]));
				listaPutovanja.add(putovanje);
			}
		}

	}

}
