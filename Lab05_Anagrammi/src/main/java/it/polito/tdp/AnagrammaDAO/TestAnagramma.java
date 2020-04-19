package it.polito.tdp.AnagrammaDAO;

public class TestAnagramma {

	public static void main(String[] args) {
		
		AnagrammaDao adao= new AnagrammaDao();
		boolean prova=adao.isCorrect("a");
		System.out.println(prova);
	}

}
