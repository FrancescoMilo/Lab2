package it.polito.tdp.spellchecker.controller.model;

import java.io.BufferedReader;
import java.io.FileReader;

public class ItalianDictionary extends Dictionary {
	
	public ItalianDictionary(){
		super();
	}

	@Override
	public void loadDictionary() {
		try{
			FileReader fr = new FileReader("rsc/Italian.txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while((word = br.readLine())!=null){
				dizionario.add(word);
			}
			br.close();
		}
		catch (Exception e){
			System.out.println("Erorre nella lettura del file!");
			
		}
	}	
	

}
