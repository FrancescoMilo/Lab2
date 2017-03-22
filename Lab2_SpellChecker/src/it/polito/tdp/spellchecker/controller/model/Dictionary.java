package it.polito.tdp.spellchecker.controller.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dictionary {
	
	protected ArrayList<String> dizionario;
	
	public Dictionary(){
		dizionario = new ArrayList<String>();
	}
	
	public void loadDictionary(){
		
		
	}
	
	public List<RichWord> spellCheckTest(List<String> inputTextList){
		List<RichWord> risultato = new ArrayList<RichWord>();
		for(String s : inputTextList){
			boolean normale = false;
			boolean corr = false;
			
			/*
			
			// Algortimo con il contains (MIGLIORE)
			
			if(dizionario.contains(s)){
				risultato.add(new RichWord(s,true,null));
				normale=true;
				corr=true;
			}
			if(normale==false){
				for(String d : dizionario){
					if(d.charAt(0)==s.charAt(0)){
						LevenstheinDistance l = new LevenstheinDistance();
						int distance = l.Distance(s, d);
						if(distance<=1){
							risultato.add(new RichWord(s, false, d));
							corr = true;
							break;
							}
					}
					
				}
				if(corr== false)
					risultato.add(new RichWord(s, false, "nessuna correzione disponibile"));
			}
			
			*/
			
			/*
			
			//Algoritmo con ricerca dicotomica (SECONDO) - Errata
			
			if(dizionario.get((int) (dizionario.size()*0.5)).compareTo(s)==0){
				// parola trovata corretta
				risultato.add(new RichWord(s,true,null));
				normale=true;
				corr = true;
			}
			else if(dizionario.get((int) (dizionario.size()*0.5)).compareTo(s)<0){
				int j;
				for(j=(int) (dizionario.size()*0.5) ; j<dizionario.size() ; j++){
					if(s.equals(dizionario.get(j))){
						risultato.add(new RichWord(s,true,null));
						normale=true;
						corr=true;
					}
				}
			}
			else{
				int k;
				for(k=(int) (dizionario.size()*0.5) ; k>=0 ; k--){
					if(s.equals(dizionario.get(k))){
						risultato.add(new RichWord(s,true,null));
						normale=true;
						corr=true;
					}
				}
			}
			if(normale==false){
				for(String d : dizionario){
					if(d.charAt(0)==s.charAt(0)){
						LevenstheinDistance l = new LevenstheinDistance();
						int distance = l.Distance(s, d);
						if(distance<=1){
							risultato.add(new RichWord(s, false, d));
							corr = true;
							break;
							}
					}
					
				}
				if(corr== false)
					risultato.add(new RichWord(s, false, "nessuna correzione disponibile"));
			}
			
			*/
			
			/*
			 
			 // Algortimo con doppia ricerca dicotomica (PEGGIORE) - Errata
			 
			 boolean posizione = false;
			if(dizionario.get((int) (dizionario.size()*0.5)).compareTo(s)==0){
				// parola trovata corretta
				risultato.add(new RichWord(s,true,null));
				normale=true;
				corr = true;
			}
			else if(dizionario.get((int) (dizionario.size()*0.5)).compareTo(s)<0){
				posizione = true;
				int j;
				for(j=(int) (dizionario.size()*0.5) ; j<dizionario.size() ; j++){
					if(s.equals(dizionario.get(j))){
						risultato.add(new RichWord(s,true,null));
						normale=true;
						corr=true;
					}
				}
			}
			else{
				posizione = false;
				int k;
				for(k=(int) (dizionario.size()*0.5) ; k>=0 ; k--){
					if(s.equals(dizionario.get(k))){
						risultato.add(new RichWord(s,true,null));
						normale=true;
						corr=true;
					}
				}
			}
			if(normale==false){
				if(posizione==true){
					int j;
					for(j=(int) (dizionario.size()*0.5) ; j<dizionario.size() ; j++){
						LevenstheinDistance l = new LevenstheinDistance();
						int distance = l.Distance(s, dizionario.get(j));
						if(distance<=1){
							risultato.add(new RichWord(s, false, dizionario.get(j)));
							corr = true;
							break;
							}
					}
				}
				else{
					int k;
					for(k=(int) (dizionario.size()*0.5) ; k>=0 ; k--){
						LevenstheinDistance l = new LevenstheinDistance();
						int distance = l.Distance(s, dizionario.get(k));
						if(distance<=1){
							risultato.add(new RichWord(s, false, dizionario.get(k)));
							corr = true;
							break;
							}
					}
				}
				if(corr== false)
					risultato.add(new RichWord(s, false, "nessuna correzione disponibile"));
			}
			 
			 */
			
			
			
			// Algoritmo con vera ricerca dicotomica
			Collections.sort(dizionario);
			int start = 0;
			int end = dizionario.size()-1;
			while(normale==false && start<end){
				//List<String> temp =  dizionario.subList(start, end+1);
				if(dizionario.get((start+end)/2).compareTo(s)==0){
					risultato.add(new RichWord(s,true,null));
					normale=true;
					corr=true;
					//System.out.println("Trovata");
				}
				else if(dizionario.get((start+end)/2).compareTo(s)<0){
					start = (start+end)/2 +1;
					
					//System.out.println("Prima metà");
				}
				else{
					
					end = (start+end)/2 ;
					//System.out.println("Seconda metà");
				}
			}
			if(normale==false){
				for(String d : dizionario){
					if(d.charAt(0)==s.charAt(0)){
						LevenstheinDistance l = new LevenstheinDistance();
						int distance = l.Distance(s, d);
						if(distance<=1){
							risultato.add(new RichWord(s, false, d));
							corr = true;
							break;
							}
					}
					
				}
				if(corr== false)
					risultato.add(new RichWord(s, false, "nessuna correzione disponibile"));
			}
			
			
			
		}
		return risultato;
		
	}
	
	public void clearDictionary(){
		dizionario.clear();
	}
	
	

}
