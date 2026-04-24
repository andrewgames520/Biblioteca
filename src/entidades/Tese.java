package entidades;

import java.util.Scanner;

public class Tese extends ItemBiblioteca {
	private String Autor;
	private String Orientador;
	private String AreaPesquisa;
	
	
	public Tese(String titulo, Integer  QntDisponivel, Integer Qntpg) {
		super(titulo, QntDisponivel, Qntpg);
	}

	
	public String getAutor() {
		return Autor;
	}


	public void setAutor(String autor) {
		Autor = autor;
	}


	public String getOrientador() {
		return Orientador;
	}


	public void setOrientador(String orientador) {
		Orientador = orientador;
	}


	public String getAreaPesquisa() {
		return AreaPesquisa;
	}


	public void setAreaPesquisa(String areaPesquisa) {
		AreaPesquisa = areaPesquisa;
	}


	public static Tese CadastrarTese(Scanner scan) {
		String titulo;
		Integer qntdisponivel = null;
		Integer qntpg;
		
		do {
			System.out.println("Digite o titulo da tese");
			titulo = scan.nextLine();
			if(titulo.isBlank()) {
				System.out.println("O titulo não pode ser vazio");
			}
		}while(titulo.isBlank());
		
		do {
			System.out.println("Digite a quantidade disponivel da tese");
			try {
				qntdisponivel = scan.nextInt();
				if(qntdisponivel<0) {
					System.out.println("Quantidade disponivel não pode ser negativa");
				}
			}catch(java.util.InputMismatchException e) {
				System.out.println("Digite um numero inteiro valido");
				scan.nextLine();
			}
		}while(qntdisponivel<0);
		
		do {
			System.out.println("Digite a quantidade de paginas da tese");
			qntpg = scan.nextInt();
			if(qntpg<1)
				System.out.println("Quantidade de paginas não pode ser menor que 1");
		}while(qntpg<1);
			
			scan.nextLine();
			Tese tese = new Tese(titulo, qntdisponivel, qntpg);
			return tese;
	}
}
