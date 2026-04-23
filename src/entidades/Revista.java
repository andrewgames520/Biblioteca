package entidades;

import java.util.Scanner;

public class Revista extends ItemBiblioteca{
	
	private String editor;
	private String mesPublicacao;
	
	
	
	public Revista(String titulo, Integer QntDisponivel, Integer qntpg, String editor, String mesPublicacao) {
		super(titulo, QntDisponivel, qntpg);
		this.editor = editor;
		this.mesPublicacao = mesPublicacao;
	}
	
	public Revista(String titulo, Integer QntDisponivel, Integer qntpg) {
		super(titulo, QntDisponivel, qntpg);
	}

	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public String getMesPublicacao() {
		return mesPublicacao;
	}
	public void setMesPublicacao(String mesPublicacao) {
		this.mesPublicacao = mesPublicacao;
	}
	
	@Override
	public void exibirDetalhes() {
		System.out.println(this.getTitulo() + " - " + this.getMesPublicacao());
	}
	
	public static Revista CadastrarRevista(Scanner scan) {
		String titulo;
		Integer qntdisponivel = null;
		Integer qntpg;
		
		do {
			System.out.println("Digite o titulo da revista");
			titulo = scan.nextLine();
			if(titulo.isBlank()) {
				System.out.println("O titulo não pode ser vazio");
			}
		}while(titulo.isBlank());
		
		do {
			System.out.println("Digite a quantidade disponivel da revista");
			try {
				qntdisponivel = scan.nextInt();
				scan.nextLine();
				if(qntdisponivel<0) {
					System.out.println("Quantidade disponivel não pode ser negativa\n");
				}
			}catch(java.util.InputMismatchException e) {
				System.out.println("Digite um numero inteiro valido\n");
				scan.nextLine();
			}
		}while(qntdisponivel<0);
		
		do {
			System.out.println("Digite a quantidade de paginas da revista");
			qntpg = scan.nextInt();
			if(qntpg<1)
				System.out.println("Quantidade de paginas não pode ser menor que 1");
		}while(qntpg<1);
			
			scan.nextLine();
			Revista revista = new Revista(titulo, qntdisponivel, qntpg);
			return revista;
	}
	
}
