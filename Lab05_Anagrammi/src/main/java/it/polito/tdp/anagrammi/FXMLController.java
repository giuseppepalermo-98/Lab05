package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParolaInserita;

    @FXML
    private Button btnCalcolaAnagrammi;

    @FXML
    private TextArea txtAnagrammiCorretti;

    @FXML
    private TextArea txtAnagrammiErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doAnagrammi(ActionEvent event) {
    	this.txtAnagrammiCorretti.clear();
    	this.txtAnagrammiErrati.clear();
    	
    	String parola=this.txtParolaInserita.getText();
    	
    	if(parola.contains(" ")) {
    		System.out.println("Devi inserire solo una parola priva di spazi!");
    		return;
    	}
   
    	for(int i=0; i<parola.length(); i++) {
    		if(Character.isDigit(parola.charAt(i))) {
    			System.out.println("Devi inserire solo lettere!");
    			return;
    		}
    	}
    	
    	this.model.anagramma(parola);
    	
    	for(String s: model.getparoleCorrette()) {
    		txtAnagrammiCorretti.appendText(s+"\n");
    	}
    	//this.txtAnagrammiCorretti.appendText(this.model.getparoleCorrette().toString()+"\n");
    	for(String s: model.getparoleErrate()) {
    		txtAnagrammiErrati.appendText(s+"\n");
    	}
    	//this.txtAnagrammiErrati.appendText(this.model.getparoleErrate().toString()+ "\n");
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	this.txtAnagrammiCorretti.clear();
    	this.txtAnagrammiErrati.clear();
    	this.txtParolaInserita.clear();
    }

    @FXML
    void initialize() {
        assert txtParolaInserita != null : "fx:id=\"txtParolaInserita\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcolaAnagrammi != null : "fx:id=\"btnCalcolaAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiCorretti != null : "fx:id=\"txtAnagrammiCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiErrati != null : "fx:id=\"txtAnagrammiErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		this.model=model;
	}
}