package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class SpellCheckerController {

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

    }

    @FXML
    void doSpellCheck(ActionEvent event) {

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

