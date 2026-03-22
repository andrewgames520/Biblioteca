package entidades;

public class Livro {
	private String titulo;
	private Integer qntpg;
	private String autor;
	private String genero;
	private String editora;
	private Integer qntdisponivel;
	
	
	
	
	public Livro(String titulo, Integer qntpg, String autor, String genero, String editora, Integer qntdisponivel) {
		this.titulo = titulo;
		this.qntpg = qntpg;
		this.autor = autor;
		this.genero = genero;
		this.editora = editora;
		this.qntdisponivel = qntdisponivel;
	}
	
	public Livro() {
		
	}
	
	public Integer getQntdisponivel() {
		return qntdisponivel;
	}

	public void setQntdisponivel(Integer qntdisponivel) {
		this.qntdisponivel = qntdisponivel;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getQntpg() {
		return qntpg;
	}
	public void setQntpg(Integer qntpg) {
		this.qntpg = qntpg;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	//metodo qnt e titulo

}
