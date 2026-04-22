package entidades;

import java.util.Scanner;



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
	
	public Livro(String titulo, Integer qntdisponivel, Integer qntpg) {
		this.titulo = titulo;
		this.qntdisponivel = qntdisponivel;
		this.qntpg = qntpg;
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
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	//exibe titulo, qntdisponivel, qntpg do livro
	public void MostrarPrincipal(Livro livro) {
		System.out.println(livro.titulo+"\nQuantidade disponivel:"+ livro.qntdisponivel +"\nQuantidade de paginas: "+livro.qntpg);
		}
	//exibe todas as informações de um livro
	public void MostrarTudo(Livro livro) {
		System.out.println(livro.titulo+"\nAutor:"+ livro.autor + "\nEditora:" + livro.editora + "\nQuantidade disponivel: "+livro.qntdisponivel);
		System.out.println("Gênero:" + livro.genero + "\nQuantidade de paginas:" + livro.qntpg);
	}
	
	public static Livro cadastrarLivros(Scanner scan) {
		String titulo;
		Integer qntdisponivel;
		Integer qntpg;
		
		do {
			System.out.println("Digite o titulo do livro");
			titulo = scan.nextLine();
			if(titulo.isBlank()) {
				System.out.println("O titulo não pode ser vazio");
			}
		}while(titulo.isBlank());
		
		do {
			System.out.println("Digite a quantidade disponivel do livro");
			qntdisponivel = scan.nextInt();
			if(qntdisponivel<0) {
				System.out.println("Quantidade disponivel não pode ser negativa");
			}
		}while(qntdisponivel<0);
		
		do {
			System.out.println("Digite a quantidade de paginas do livro");
			qntpg = scan.nextInt();
			if(qntpg<1)
				System.out.println("Quantidade de paginas não pode ser menor que 1");
		}while(qntpg<1);
			
			scan.nextLine();
			Livro livro = new Livro(titulo, qntdisponivel, qntpg);
			return livro;
	}
	public void EmprestarLivro(Livro livro) {
				livro.setQntdisponivel(livro.getQntdisponivel()-1);
		}
	public  void DevolverLivro(Livro livro) {
			livro.setQntdisponivel(livro.getQntdisponivel()+1);
		}
}
