package entidades;

public class ItemBiblioteca {
	
	private String titulo;
	private String genero;
	private String editora;
	private Integer QntDisponivel;
	private Integer qntpg;
	private String classificacaoIndicativa;
	
	public ItemBiblioteca(String titulo, String genero, String editora, Integer QntDisponivel,
			Integer qntpg, String classificacaoIndicativa) {
		this.titulo = titulo;
		this.genero = genero;
		this.editora = editora;
		this.QntDisponivel = QntDisponivel;
		this.qntpg = qntpg;
		this.classificacaoIndicativa = classificacaoIndicativa;
	}
	
	public ItemBiblioteca(String titulo, Integer QntDisponivel, Integer qntpg) {
		this.titulo = titulo;
		this.QntDisponivel = QntDisponivel;
		this.qntpg = qntpg;
	}
	public ItemBiblioteca(String titulo, Integer QntDisponivel) {
		this.titulo = titulo;
		this.QntDisponivel = QntDisponivel;
	}

	public String getClassificacaoIndicativa() {
		return classificacaoIndicativa;
	}
	public void setClassificacaoIndicativa(String classificacaoIndicativa) {
		this.classificacaoIndicativa = classificacaoIndicativa;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
	public Integer getQntDisponivel() {
		return QntDisponivel;
	}
	public void setQntDisponivel(Integer QntDisponivel) {
		this.QntDisponivel = QntDisponivel;
	}
	public Integer getqntpg() {
		return qntpg;
	}
	public void setqntpg(Integer qntpg) {
		this.qntpg = qntpg;
	}
	
	public void exibirDetalhes() {
		System.out.println(this.getTitulo() + " - " + this.getQntDisponivel());
	}
	
	public void EmprestarItem(ItemBiblioteca item) {
		item.setQntDisponivel(item.getQntDisponivel()-1);
	}
	
	public  void DevolverItem(ItemBiblioteca item) {
		item.setQntDisponivel(item.getQntDisponivel()+1);
	}
	
	//exibe todas as informações de um livro
		public void ExibirTodosDetalhes() {
			System.out.println(this.getTitulo()+"\nEditora:" + this.getEditora() + "\nQuantidade disponivel: " + this.getQntDisponivel());
			System.out.println("Gênero:" + this.getGenero() + "\nQuantidade de paginas:" + this.getqntpg());
		}
}
