package entidades;

import java.util.Scanner;
import entidades.Biblioteca;
import java.util.List;
import java.util.stream.Collectors;


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
	
	public Livro(String titulo, String genero, Integer qntdisponivel, Integer qntpg) {
		this.titulo = titulo;
		this.genero = genero;
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
	
	//metodo qnt e titulo
	public void Mostrarqnt(Livro livro) {
			System.out.println(livro.titulo+"\nQuantidade disponivel: "+livro.qntdisponivel);
		}
	public static Livro criarLivros() {
		Scanner scan = new Scanner(System.in);
			System.out.println("Digite o titulo do livro");
			String titulo = scan.nextLine();
			if(titulo.isBlank()) {
					 System.out.println("O titulo não pode ser vazio");
			}
			System.out.println("Digite o genero do livro");
			String genero = scan.nextLine();
			System.out.println("Digite a quantidade disponivel do livro");
			Integer qntdisponivel = scan.nextInt();
			if(qntdisponivel<0)
				System.out.println("Quantidade disponivel não pode ser negativa");
			System.out.println("Digite a quantidade de paginas do livro");
			Integer qntpg = scan.nextInt();
			if(qntpg<=0)
				System.out.println("Quantidade de paginas não pode ser menor que 1");
			scan.nextLine();
			Livro livro = new Livro(titulo, genero, qntdisponivel, qntpg);
			return livro;
	}
}
