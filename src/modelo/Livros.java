package modelo;

public class Livros {
	
	private String titulo;
	private String autor;
	private String anoEdicao;
	
	
	
	public Livros(String titulo, String autor, String anoEdicao) {
		this.titulo = titulo;
		this.autor = autor;
		this.anoEdicao = anoEdicao;		
	};

	
	public String getTitulo() {
		return titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public String getAnoEdicao() {
		return anoEdicao;
	}
}
