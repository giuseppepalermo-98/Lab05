package it.polito.tdp.anagrammi.model;

public class TestRicerca {

	public static void main(String[] args) {

		Ricerca r=new Ricerca();
		//System.out.println(r.anagrammi("eat"));
		r.calcolaAnagrammi("cane");
		
		System.out.println(r.getErrate());
		System.out.println(r.getSoluzione());
	}

}
