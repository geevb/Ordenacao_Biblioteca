package controle;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import modelo.Livros;
import modelo.OrdenadorDeLivros;

public class Controle {

	private final String PATH_ARQ_CONFIG = "config/sis.config";
	private final String configInicial = "0 0 0";
	
	private OrdenadorDeLivros ord;
	
	public Controle() {
		ord = new OrdenadorDeLivros();
		
		verificarSePastaConfigExiste();
		carregarConfiguracao();
	}
	
	
	public void verificarSePastaConfigExiste() {
		
		File PATH_DIR_CONFIG = new File("config");
		if (!PATH_DIR_CONFIG.exists()) {
    		PATH_DIR_CONFIG.mkdir();
    		criarArquivoConfiguracao();
    	}
	}
	
	public void criarArquivoConfiguracao() {
		try {
    		Files.write(Paths.get(PATH_ARQ_CONFIG), configInicial.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void carregarConfiguracao() {
		ord.carregarConfiguracao();
	}


	public void ordernarLista(ArrayList<Livros> list) {
		ord.setListaLivros(list);
		ord.ordenar();
		ord.printarListaOrdenada();		
	}
}
