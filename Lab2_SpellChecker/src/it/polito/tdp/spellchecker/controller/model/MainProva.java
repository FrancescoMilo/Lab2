package it.polito.tdp.spellchecker.controller.model;

import java.util.ArrayList;
import java.util.List;

public class MainProva {

	public static void main(String[] args) {
		
		EnglishDictionary i = new EnglishDictionary();
		i.loadDictionary();
		List<String> testo = new ArrayList<String>();
		testo.add("hello");
		testo.add("homme");
		testo.add("todayy");
		testo.add("tree");
		testo.add("two");
		testo.add("fourr");
		testo.add("tomorrow");
		testo.add("feel");
		testo.add("do");
		testo.add("anythiing");
		testo.add("my");
		testo.add("name");
		testo.add("iss");
		testo.add("livve");
		List<RichWord> risultato = i.spellCheckTest(testo);
		for(RichWord rw : risultato){
			if(rw.isCorretta()==true)
				System.out.println("Corretta: "+rw.getParola());
			else{
				System.out.println("La parola: "+rw.getParola()+" è errata e la correzione è: "+rw.getCorrezione());
			}
		}

	}

}
