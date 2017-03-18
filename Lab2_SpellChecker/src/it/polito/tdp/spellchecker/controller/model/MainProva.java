package it.polito.tdp.spellchecker.controller.model;

import java.util.ArrayList;
import java.util.List;

public class MainProva {

	public static void main(String[] args) {
		
		ItalianDictionary i = new ItalianDictionary();
		i.loadDictionary();
		List<String> testo = new ArrayList<String>();
		/*testo.add("hello");
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
		testo.add("livve");*/
		testo.add("ciao");
		testo.add("casamatta");
		testo.add("casalese");
		testo.add("Francesco");
		testo.add("tutto");
		testo.add("caruncolo");
		testo.add("caruccio");
		long t1 = System.nanoTime();
		List<RichWord> risultato = i.spellCheckTest(testo);
		long t2 = System.nanoTime();
		for(RichWord rw : risultato){
			if(rw.isCorretta()==true)
				System.out.println("Corretta: "+rw.getParola());
			else{
				System.out.println("La parola: "+rw.getParola()+" è errata e la correzione è: "+rw.getCorrezione());
			}
		}
		System.out.println("Tempo: "+((t2-t1)/1000000) + " millisecondi");

	}

}
