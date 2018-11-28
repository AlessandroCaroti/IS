package test;

import videostore.Cliente;
import videostore.Film;
import videostore.Noleggio;

public class TestRendiconto {

	public static void main(String[] args) {
		Cliente cliente1 = new Cliente("Gianni");
		
		Film film1 = new Film("pippo", 0); // REGOLARE
		Film film2 = new Film("pluto", 1); // NOVITA'
		Film film3 = new Film("paperino", 2); // BAMBINI
		
		Noleggio noleggio1 = new Noleggio(film1 , 3);
		Noleggio noleggio2 = new Noleggio(film2, 5);
		Noleggio noleggio3 = new Noleggio(film3, 7);
		
		cliente1.addNoleggio(noleggio1);
		cliente1.addNoleggio(noleggio2);
		cliente1.addNoleggio(noleggio3);
		
		System.out.println(cliente1.rendiconto());
		
		String res = "Rendiconto noleggi per Gianni pippo 3.5 pluto 15.0 paperino 7.5 L'ammontare dovuto e' 26.0";
		
		if (res.equals(cliente1.rendiconto()))
			System.out.println("=============\n== test OK ==\n=============");
		else
			System.out.println("*************\n** test KO **\n*************");
	}
}
