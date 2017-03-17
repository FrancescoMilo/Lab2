package it.polito.tdp.spellchecker.controller.model;

public class RichWord {
	
	private String parola;
	private boolean corretta;
	private String correzione;
	
	public RichWord(String parola, boolean corretta, String correzione) {
		this.parola = parola;
		this.corretta = corretta;
		this.correzione = correzione;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public boolean isCorretta() {
		return corretta;
	}

	public void setCorretta(boolean corretta) {
		this.corretta = corretta;
	}

	public String getCorrezione() {
		return correzione;
	}

	public void setCorrezione(String correzione) {
		this.correzione = correzione;
	}
	
	
	
	
	

}
