package core;

import entidades.Livro;
import java.time.LocalDate;
import entidades.Usuario;
import entidades.Biblioteca;
import entidades.Emprestimo;

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
		System.out.println("\nDigite 1 para cadastrar um livro");
		System.out.println("Digite 2 para cadastrar um usuário");
		System.out.println("Digite 3 para listar usuários");
		System.out.println("Digite 4 para listar livros");
		System.out.println("Digite 5 para pegar um emprestimo");
		System.out.println("Digite 6 para devolver um emprestimo");
		System.out.println("Digite 7 para listar emprestimos ativos");
		System.out.println("Digite 8 para listar emprestimos finalizados");
		System.out.println("Digite 9 listar todos emprestimos de um usuario");
		System.out.println("Digite 0 para finalizar o programa");
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
			System.out.println("Digite o nome completo do usuario");
			Usuario user;
			Livro livro;
			user = biblioteca.BuscarUsuario(scan.nextLine());
			
			System.out.println("Digite o titulo do livro");
			livro = biblioteca.BuscarLivro(scan.nextLine());
			
			if(livro == null && user == null) {
				System.out.println("Usuario ou livro invalido\n");
			}else
				biblioteca.Emprestar(biblioteca, user, livro);
			break;
		case 6:
			Emprestimo emprestimo;
			System.out.println("Digite o nome completo do usuario");
			user = biblioteca.BuscarUsuario(scan.nextLine());
			
			System.out.println("Digite o titulo do livro");
			livro = biblioteca.BuscarLivro(scan.nextLine());
			
			if(livro == null && user == null) {
				System.out.println("Usuario ou livro invalido");
			}else{
				emprestimo = biblioteca.BuscarEmprestimo(usuario, livro);
				if(emprestimo == null) {
					System.out.println("Emprestimo não encontrado");
				}else
					biblioteca.Devolver(biblioteca, usuario, livro, emprestimo);
			}
			break;
		case 7:
			biblioteca.ListarEmprestimosAtivos();
			break;
		case 8:
			biblioteca.ListarEmprestimosFinalizados();
			break;
		case 9:
			biblioteca.ListarEmprestimosUsuario(scan);
			break;
		case 0:
			break;
		default:
			System.out.println("Digite um numero valido");
		}
	}while (controle!=0);
	scan.close();
	}

}
