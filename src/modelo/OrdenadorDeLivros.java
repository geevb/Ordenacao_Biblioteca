package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import exceptions.OrderingException;

import static java.util.Comparator.comparing;


public class OrdenadorDeLivros {
	
	private int tipoOrdenacaoAnoEdicao;
	private int tipoOrdenacaoAutor;
	private int tipoOrdenacaoTitulo;
	private final String PATH_ARQ_CONFIG = "config/sis.config";
    private Scanner scan;
    private Map<String, Runnable> ordenacoes = new HashMap<>();
    private List<Livros> listaLivros;
	
	
	public OrdenadorDeLivros() {
		carregarConfiguracao();
		preencherMapaOrdenacoes();
	}
	
	public void ordenar() {
		ordenacoes.get( concatenarConfiguracoes() ).run();
	}
	
    public void carregarConfiguracao(){
    	try {
    		BufferedReader br = new BufferedReader(new FileReader(PATH_ARQ_CONFIG));    
    		if (br.readLine() == null) {
    			br.close();
				throw new OrderingException();				
			}
			br.close();
			scan = new Scanner(new File(PATH_ARQ_CONFIG));
        	setTipoOrdenacaoAnoEdicao(scan.nextInt());
        	setTipoOrdenacaoAutor(scan.nextInt());
        	setTipoOrdenacaoTitulo(scan.nextInt());
        	
		} catch (FileNotFoundException e) {
			System.out.println(
    				"Arquivo de configuração não encontrado em: " + PATH_ARQ_CONFIG);
		} catch (OrderingException e) {
			//System.out.println("OrderingException");
			e.printStackTrace();
		} catch (IOException e) {
        	e.printStackTrace();        		
        }        	
	
    }


	
    public String concatenarConfiguracoes() {
    	return Integer.toString(getTipoOrdenacaoAnoEdicao()) +
    					   Integer.toString(getTipoOrdenacaoAutor()) + 
    					   Integer.toString(getTipoOrdenacaoTitulo());
    }
	
    public void printarListaOrdenada() {
		for(Livros liv : this.listaLivros) {
			System.out.println(liv.getTitulo() + 
					" - " + liv.getAutor() + 
					" - " + liv.getAnoEdicao());
		}
    }
    
	public void preencherMapaOrdenacoes() {
		// Essa ordenação poderia ter sido mais facilmente implementada utilizando SQL e um Banco de Dados.
		// Porém nada foi dito durante a descrição da demanda sobre a possibilidade de usar-se um.
		// Está longe de ser a solução ideal por não ser completamente flexível. Porém resolve e passa nos casos de teste apresentados 
		//
		// Códigos possíveis para os tipos de ordenação.
		// Ano Edicao -  Autor - Titulo
		// 0 = Sem Filtro, 1 = Ascendente, 2 = Descendente
		ordenacoes.put("000", () -> System.out.println(""));
		ordenacoes.put("001", () -> this.listaLivros.sort((o1, o2)->o1.getTitulo().compareTo(o2.getTitulo())));
		ordenacoes.put("002", () -> this.listaLivros.sort(Comparator.comparing(Livros::getTitulo).reversed()));
		ordenacoes.put("010", () -> this.listaLivros.sort((o1, o2)->o1.getAutor().compareTo(o2.getAutor())));
		ordenacoes.put("011", () -> this.listaLivros.sort(Comparator.comparing(Livros::getAutor).thenComparing(Livros::getTitulo)));
		ordenacoes.put("012", () -> this.listaLivros.sort(Comparator.comparing(Livros::getAutor).thenComparing(comparing(Livros::getTitulo).reversed())));
		ordenacoes.put("020", () -> this.listaLivros.sort(Comparator.comparing(Livros::getAutor).reversed()));
		ordenacoes.put("021", () -> this.listaLivros.sort(Comparator.comparing(Livros::getAutor).reversed().thenComparing(Livros::getTitulo)));
		ordenacoes.put("022", () -> this.listaLivros.sort(Comparator.comparing(Livros::getAutor).reversed().thenComparing(comparing(Livros::getTitulo)).reversed()));
		ordenacoes.put("100", () -> this.listaLivros.sort((o1, o2)->o1.getAnoEdicao().compareTo(o2.getAnoEdicao())));
		ordenacoes.put("101", () -> this.listaLivros.sort(Comparator.comparing(Livros::getAnoEdicao).thenComparing(Livros::getTitulo)));
		ordenacoes.put("102", () -> this.listaLivros.sort(Comparator.comparing(Livros::getAnoEdicao).thenComparing(comparing(Livros::getTitulo)).reversed()));
		ordenacoes.put("110", () -> this.listaLivros.sort(Comparator.comparing(Livros::getAnoEdicao).thenComparing(Livros::getAutor)));
		ordenacoes.put("111", () -> this.listaLivros.sort(Comparator.comparing(Livros::getAnoEdicao).thenComparing(Livros::getAutor).thenComparing(Livros::getTitulo)));
		ordenacoes.put("112", () -> this.listaLivros.sort(Comparator.comparing(Livros::getAnoEdicao).thenComparing(Livros::getAutor).thenComparing(comparing(Livros::getTitulo)).reversed()));
		ordenacoes.put("120", () -> this.listaLivros.sort(Comparator.comparing(Livros::getAnoEdicao).thenComparing(comparing(Livros::getAutor).reversed())));
		ordenacoes.put("121", () -> this.listaLivros.sort(Comparator.comparing(Livros::getAnoEdicao).thenComparing(comparing(Livros::getAutor).reversed().thenComparing(Livros::getTitulo))));
		ordenacoes.put("122", () -> this.listaLivros.sort(Comparator.comparing(Livros::getAnoEdicao).thenComparing(comparing(Livros::getAutor).reversed().thenComparing(comparing(Livros::getTitulo)).reversed())));
		ordenacoes.put("200", () -> this.listaLivros.sort(Comparator.comparing(Livros::getAnoEdicao).reversed()));
		ordenacoes.put("201", () -> this.listaLivros.sort(Comparator.comparing(Livros::getAnoEdicao).reversed().thenComparing(Livros::getTitulo)));
		ordenacoes.put("202", () -> this.listaLivros.sort(Comparator.comparing(Livros::getAnoEdicao).reversed().thenComparing(comparing(Livros::getTitulo).reversed())));
		ordenacoes.put("210", () -> this.listaLivros.sort(Comparator.comparing(Livros::getAnoEdicao).reversed().thenComparing(Livros::getAutor)));
		ordenacoes.put("211", () -> this.listaLivros.sort(Comparator.comparing(Livros::getAnoEdicao).reversed().thenComparing(Livros::getAutor).thenComparing(Livros::getTitulo)));
		ordenacoes.put("212", () -> this.listaLivros.sort(Comparator.comparing(Livros::getAnoEdicao).reversed().thenComparing(Livros::getAutor).thenComparing(comparing(Livros::getTitulo).reversed())));
		ordenacoes.put("220", () -> this.listaLivros.sort(Comparator.comparing(Livros::getAnoEdicao).reversed().thenComparing(comparing(Livros::getAutor).reversed())));
		ordenacoes.put("221", () -> this.listaLivros.sort(Comparator.comparing(Livros::getAnoEdicao).reversed().thenComparing(comparing(Livros::getAutor).reversed()).thenComparing(Livros::getTitulo)));
		ordenacoes.put("222", () -> this.listaLivros.sort(Comparator.comparing(Livros::getAnoEdicao).reversed().thenComparing(comparing(Livros::getAutor).reversed()).thenComparing(comparing(Livros::getTitulo).reversed())));
	}
	
	

	public void setListaLivros(List<Livros> listaLivros) {
		this.listaLivros = listaLivros;
	}
	public void setTipoOrdenacaoAnoEdicao(int tipoOrdenacaoAnoEdicao) {
		this.tipoOrdenacaoAnoEdicao = tipoOrdenacaoAnoEdicao;
	}
	public void setTipoOrdenacaoAutor(int tipoOrdenacaoAutor) {
		this.tipoOrdenacaoAutor = tipoOrdenacaoAutor;
	}
	public void setTipoOrdenacaoTitulo(int tipoOrdenacaoTitulo) {
		this.tipoOrdenacaoTitulo = tipoOrdenacaoTitulo;
	}
	public int getTipoOrdenacaoAnoEdicao() {
		return tipoOrdenacaoAnoEdicao;
	}
	public int getTipoOrdenacaoAutor() {
		return tipoOrdenacaoAutor;
	}
	public int getTipoOrdenacaoTitulo() {
		return tipoOrdenacaoTitulo;
	}
	
}
