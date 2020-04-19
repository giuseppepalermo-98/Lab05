package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.polito.tdp.AnagrammaDAO.AnagrammaDao;

public class Ricerca {

	AnagrammaDao Adao;
	
	//NB. Sono costretto ad usare gli insieme in modo che le parole angrammate
	//in caso presentino più lettere uguali nnon mi diano più anagrammi uguali
	Set<String> soluzione;
    Set<String> errate;
	
	public void calcolaAnagrammi(String parola) {
		this.soluzione = new HashSet<>() ;
		this.errate = new HashSet<>();
		Adao= new AnagrammaDao();
		
		parola=parola.toLowerCase() ;
		
		List<Character> disponibili = new ArrayList<>() ;
		for(int i=0; i<parola.length(); i++) {
			disponibili.add(parola.charAt(i)) ;
		}
		
		// avvia la ricorsione
		cerca("", 0, disponibili) ; 
		
		//return this.soluzione ;
	}

	private void cerca(String parziale, int livello, List<Character> disponibili) {
		//Condizione di terminazione
		if(disponibili.size() == 0) {
			
			if(Adao.isCorrect(parziale))
				soluzione.add(parziale);
			
			else
				errate.add(parziale);
			
			return;
		}
		
		for(Character c: disponibili) {
			String tentativo =parziale + c;
			
			List<Character> rimanenti = new ArrayList<>(disponibili);
			rimanenti.remove(c);
			
			cerca(tentativo, livello+1, rimanenti);
		}
		
	}

	public Set<String> getSoluzione() {
		return soluzione;
	}

	public Set<String> getErrate() {
		return errate;
	}
	
	
	//QUESTO MI SERVE SOLO NEL CASO INVECE DI PASSARE UN INSIEME IN CERCA GLI PASSO LA PAORLA
	//E LA SCANDISCO LA' DENTRO 
	
	/*private int charCounter(String stringa, char c) {
		int count=0;
		
		for(int i=0; i<stringa.length(); i++) {
			if(stringa.charAt(i) == c)
				count++;
		}
		
		return count;
	}*/
	
}
