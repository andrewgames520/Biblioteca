package core;

import entidades.Livro;
import java.time.LocalDate;
import entidades.Usuario;
import entidades.Biblioteca;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = LocalDate.parse("27/03/2024", formatter);
		Usuario usuario = new Usuario("Andrew Rodrigues", "106", data);
		
		Biblioteca biblioteca = new Biblioteca();

		Livro livro1 = new Livro("O mochileiro das galaxias", 300, "Douglas Adams", "Sci-fi", "Arqueiro", 4);
		Livro livro2 = new Livro("O Imperador amarelo", 2, 250);
		Livro livro3 = new Livro("A garota que roubava livros", 8, 413);
		
		biblioteca.addlivro(livro1);
		biblioteca.addlivro(livro2);
		biblioteca.addlivro(livro3);
		
		biblioteca.adduser(usuario);
		
		Scanner scan = new Scanner(System.in);
		
		int controle =0;
	do {
		System.out.println("Digite 1 para cadastrar um livro");
		System.out.println("Digite 2 para cadastrar um usuário");
		System.out.println("Digite 3 para listar usuários");
		System.out.println("Digite 4 para listar livros");
		System.out.println("Digite 5 para finalizar o programa");
		controle = scan.nextInt();
		scan.nextLine();
		
		switch (controle) {
		case 1:
			biblioteca.addlivro(Livro.cadastrarLivros(scan));
			break;
		case 2:
			biblioteca.adduser(Usuario.cadastrarUser(scan));
			break;
		case 3:
			biblioteca.ListarUsers();
			break;
		case 4:
			biblioteca.ListarTodos();
			break;
		case 5:
			break;
		default:
			System.out.println("Digite um numero valido");
		}
	}while (controle!=5);
	scan.close();
	}

}
