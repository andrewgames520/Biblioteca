package entidades;

import java.util.Scanner;



public class Livro extends ItemBiblioteca {
	private String autor;

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public Livro(String titulo, String genero, String editora, String autor, Integer qtdDisponivel, Integer qntpg,
			String classificacaoIndicativa) {
		super(titulo, genero, editora, qtdDisponivel, qntpg, classificacaoIndicativa);
		this.autor = autor;
	}
	public Livro(String titulo, String autor, Integer qtdDisponivel) {
		super(titulo, qtdDisponivel);
		this.autor = autor;
	}

	public Livro(String titulo, Integer qntDisponivel, Integer qntpg) {
		super(titulo, qntDisponivel, qntpg);
	}
	//exibe titulo e autor
	public void exibirDetalhes() {
		System.out.println(this.getTitulo() + " - " + this.getAutor());
	}
	//exibe todas as informações de um livro
	public void ExibirTodosDetalhes() {
		System.out.println(this.getTitulo()+"\nAutor:"+ this.autor + "\nEditora:" + this.getEditora() + "\nQuantidade disponivel: " + this.getQntDisponivel());
		System.out.println("Gênero:" + this.getGenero() + "\nQuantidade de paginas:" + this.getqntpg());
	}
	
	public static Livro CadastrarLivros(Scanner scan) {
		String titulo;
		Integer qntdisponivel = null;
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
			try {
				qntdisponivel = scan.nextInt();
				if(qntdisponivel<0) {
					System.out.println("Quantidade disponivel não pode ser negativa");
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println("Digite um numero inteiro válido");
				scan.nextLine();
			}
		}while(qntdisponivel <0 || qntdisponivel == null);
		
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
		
}
