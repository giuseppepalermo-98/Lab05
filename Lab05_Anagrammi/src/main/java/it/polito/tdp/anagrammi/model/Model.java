package it.polito.tdp.anagrammi.model;

import java.util.List;
import java.util.Set;

public class Model {
	
	Ricerca ricerca=new Ricerca();
	
	public void anagramma(String parola) {
		ricerca.calcolaAnagrammi(parola);
	}
	
	public Set<String> getparoleCorrette(){
		return ricerca.getSoluzione();
	}
	
	public Set<String> getparoleErrate(){
		return ricerca.getErrate();
	}
	
}
