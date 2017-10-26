package controle;

import java.util.ArrayList;

import modelo.*;

public class Main {	

	public static void main(String[] args) {
		
		OrdenadorDeLivros ord = new OrdenadorDeLivros();
		
		ArrayList<Livros> list = new ArrayList<Livros>();
		list.add(new Livros("Java How To Program", "Deitel & Deitel", "2007"));
		list.add(new Livros("Patterns of Enterprise Application Architecture", "Martin Fowler", "2002"));
		list.add(new Livros("Head First Design Patterns", "Elisabeth Freeman", "2004"));
		list.add(new Livros("Internet & World Wide Web: How to Program", "Deitel & Deitel", "2007"));
		
		ord.setListaLivros(list);
		ord.ordenar();
		ord.printarListaOrdenada();
		
	}

}
