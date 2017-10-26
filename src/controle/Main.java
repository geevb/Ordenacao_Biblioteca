package controle;

import java.util.ArrayList;

import modelo.*;

public class Main {	

	public static void main(String[] args) {
		
		Controle ctr = new Controle();

		// Declaração da lista de exemplo
		ArrayList<Livros> listaDeLivros = new ArrayList<Livros>();
		listaDeLivros.add(new Livros("Java How To Program", "Deitel & Deitel", "2007"));
		listaDeLivros.add(new Livros("Patterns of Enterprise Application Architecture", "Martin Fowler", "2002"));
		listaDeLivros.add(new Livros("Head First Design Patterns", "Elisabeth Freeman", "2004"));
		listaDeLivros.add(new Livros("Internet & World Wide Web: How to Program", "Deitel & Deitel", "2007"));
		
		
		ctr.ordernarLista(listaDeLivros);	
	}

}
