package core;

import entidades.Livro;
import entidades.Revista;
import entidades.Tese;

import java.time.LocalDate;
import entidades.Usuario;
import entidades.Aluno;
import entidades.Biblioteca;
import entidades.Emprestimo;
import entidades.ItemBiblioteca;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = LocalDate.parse("27/03/2024", formatter);
		Aluno aluno = new Aluno("Andrew Rodrigues", "106", data);
		
		Biblioteca biblioteca = new Biblioteca();

		Livro livro1 = new Livro("O mochileiro das galaxias", "Sci-fi", "Arqueiro", "Douglas Adams", 5, 300,"9");
		Livro livro2 = new Livro("O Imperador amarelo", 2, 250);
		Livro livro3 = new Livro("A garota que roubava livros", 8, 413);
		
		biblioteca.addItem(livro1);
		biblioteca.addItem(livro2);
		biblioteca.addItem(livro3);
		
		biblioteca.adduser(aluno);
		
		Scanner scan = new Scanner(System.in);
		
		int controle =0;
	do {
		System.out.println("1 - menu item");
		System.out.println("2 - menu usuario");
		System.out.println("3 - emprestimo");
		System.out.println("4 - devolvolução");
		System.out.println("5 - listar emprestimos ativos");
		System.out.println("Digite 6 para listar emprestimos finalizados");
		System.out.println("Digite 7 listar por tipo");
		System.out.println("Digite 0 para finalizar o programa");
		controle = scan.nextInt();
		scan.nextLine();
		
		switch (controle) {
		case 1:
			ItemMenu(scan, biblioteca);
		case 2:
			UserMenu(scan, biblioteca);
		case 7: //pega emprestimo
			System.out.println("Digite o nome completo do usuario");
			Usuario user;
			ItemBiblioteca item;
			user = biblioteca.BuscarUsuario(scan.nextLine());
			
			System.out.println("Digite o titulo do item");
			item = biblioteca.BuscarItem(scan.nextLine());
			
			if(item == null && user == null) {
				System.out.println("Usuario ou item invalido\n");
			}else
				biblioteca.Emprestar(biblioteca, user, item);
			break;
		case 8: //devolver emprestimo
			Emprestimo emprestimo;
			System.out.println("Digite o nome completo do usuario");
			user = biblioteca.BuscarUsuario(scan.nextLine());
			
			System.out.println("Digite o titulo do item");
			item = biblioteca.BuscarItem(scan.nextLine());
			
			if(item == null && user == null) {
				System.out.println("Usuario ou item invalido");
			}else{
				emprestimo = biblioteca.BuscarEmprestimo(user, item);
				if(emprestimo == null) {
					System.out.println("Emprestimo não encontrado");
				}else
					biblioteca.Devolver(biblioteca, user, item, emprestimo);
			}
			break;
		case 9: //listar emprestimos ativos
			biblioteca.ListarEmprestimosAtivos();
			break;
		case 10: //listar emprestimos finalizados
			biblioteca.ListarEmprestimosFinalizados();
			break;
		case 12: //listar por tipo
			biblioteca.ListarTipo(scan);
		case 0:
			break;
		default:
			System.out.println("Digite um numero valido");
		}
	}while (controle!=0);
	scan.close();
	}
	private static void UserMenu(Scanner scan, Biblioteca biblioteca) {
		Integer opcao;
		Usuario user;
		do {
			System.out.println("1 - cadastrar um Usuario");
			System.out.println("2 - listar usuários");
			System.out.println("3 - listar emprestimos do usuario");
			System.out.println("0 - voltar");
			opcao = scan.nextInt();
			scan.nextLine();
			switch (opcao){
			case 0:
				break;
			case 1:
				biblioteca.adduser(Aluno.cadastrarAluno(scan));
				break;
			case 2:
				biblioteca.ListarUsers();
				break;
			case 3:
				System.out.println("Digite o nome completo");
				user = biblioteca.BuscarUsuario(scan.nextLine());
				user.ExibirEmprestimos();
				break;
			default:
				System.out.println("Opção incorreta");
			}
		}while(opcao !=0);
	}
	
	private static void ItemMenu(Scanner scan, Biblioteca biblioteca) {
		Integer opcao;
		ItemBiblioteca item;
		do {
			System.out.println("\n1 - cadastrar livro");
			System.out.println("2 - cadastrar revista");
			System.out.println("3 - cadastrar tese");
			System.out.println("4 - listar itens");
			System.out.println("5 - listar emprestimos do usuario");
			System.out.println("0 - voltar");
			opcao = scan.nextInt();
			scan.nextLine();
			switch (opcao){
			case 0:
				break;
			case 1:
				biblioteca.addItem(Livro.CadastrarLivros(scan));
				break;
			case 2:
				biblioteca.addItem(Revista.CadastrarRevista(scan));
				break;
			case 3:
				biblioteca.addItem(Tese.CadastrarTese(scan));
				break;
			case 4:
				biblioteca.ListarTodos();
				break;
			case 5:
				System.out.println("Digite o nome completo");
				user = biblioteca.BuscarUsuario(scan.nextLine());
				user.ExibirEmprestimos();
				break;
			default:
				System.out.println("Opção incorreta");
			}
		}while(opcao !=0);
	}

}
