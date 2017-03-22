package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.controller.model.Dictionary;
import it.polito.tdp.spellchecker.controller.model.EnglishDictionary;
import it.polito.tdp.spellchecker.controller.model.ItalianDictionary;
import it.polito.tdp.spellchecker.controller.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class SpellCheckerController {
	
	private Dictionary model;
	
	private ItalianDictionary italiano;
	
	private EnglishDictionary inglese;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtInput;

    @FXML
    private Button bttControllo;

    @FXML
    private TextArea txtResult;

    @FXML
    private Label lblRisultato;

    @FXML
    private Button bttClear;

    @FXML
    private Label lblTempistiche;
    
    @FXML
    private ComboBox<String> cbxLingua;

    @FXML
    void doClear(ActionEvent event) {
    	
    	txtResult.clear();
    	txtInput.clear();
    	model.clearDictionary();
    	lblTempistiche.setText("Tempistiche");
    	lblRisultato.setText("Risultato");

    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	
    	String lingua = cbxLingua.getValue();
    	if(lingua.equals("Italian")==true){
    		ItalianDictionary italiano = new ItalianDictionary();
    		italiano.loadDictionary();
    		model = italiano;
    	}
    	else{
    		EnglishDictionary inglese = new EnglishDictionary();
    		inglese.loadDictionary();
    		model = inglese;
    		
    	}
    	//model.loadDictionary();
    	String array[] = txtInput.getText().split(" ");
    	LinkedList<String> parametro = new LinkedList<String>();
    	for(int i = 0; i<array.length ; i++)
    		parametro.add(array[i]);
    	long t1 = System.nanoTime();
    	List<RichWord> risultato = model.spellCheckTest(parametro);
    	long t2 = System.nanoTime();
    	int countErrori = 0;
    	StringBuilder restituisci = new StringBuilder();
    	for(RichWord rw : risultato){
    		if(rw.isCorretta()==true)
    			restituisci.append(rw.getParola()+" ");
    		else{
    			countErrori++;
    			restituisci.append(rw.getCorrezione()+" ");
    		}
    	}
    	lblRisultato.setText("Ci sono "+countErrori+" errori");
    	lblTempistiche.setText("Tempo impiegato: "+((t2-t1)/1000000)+" millisecondi");
    	txtResult.setText(restituisci.toString());

    }
    
    public void setModel(Dictionary model){
    	this.model=model;
    }

    @FXML
    void initialize() {
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert bttControllo != null : "fx:id=\"bttControllo\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblRisultato != null : "fx:id=\"lblRisultato\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert bttClear != null : "fx:id=\"bttClear\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblTempistiche != null : "fx:id=\"lblTempistiche\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert cbxLingua != null : "fx:id=\"cbxLingua\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        cbxLingua.getItems().addAll("English", "Italian");
    }
}

