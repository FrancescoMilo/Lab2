package it.polito.tdp.spellchecker.controller.model;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {
	
	protected List<String> dizionario;
	
	public Dictionary(){
		dizionario = new ArrayList<String>();
	}
	
	public void loadDictionary(){
		
	}
	
	public List<RichWord> spellCheckTest(List<String> inputTextList){
		List<RichWord> risultato = new ArrayList<RichWord>();
		for(String s : inputTextList){
			String a = s.toLowerCase();
			boolean normale = false;
			boolean corr = false;
			for(String d : dizionario){
				if(a.equals(d)==true){
					risultato.add(new RichWord(s, true, null));
					normale = true;
					corr=true;
					break;
				}
			}
			if(normale==false){
				for(String d : dizionario){
					LevenstheinDistance l = new LevenstheinDistance();
					int distance = l.Distance(a, d);
					if(distance<=1){
						risultato.add(new RichWord(s, false, d));
						corr = true;
						break;
						}
					
				}
				if(corr== false)
					risultato.add(new RichWord(s, false, "nessuna correzione disponibile"));
			}
		}
		return risultato;
		
	}
	
	

}
