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
		System.out.println("\nDigite 1 para cadastrar um livro");
		System.out.println("Digite 2 para cadastrar uma revista");
		System.out.println("Digite 3 para cadastrar uma tese");
		System.out.println("Digite 4 para cadastrar um aluno");
		System.out.println("Digite 5 para listar usuários");
		System.out.println("Digite 6 para listar os items");
		System.out.println("Digite 7 para pegar um emprestimo");
		System.out.println("Digite 8 para devolver um emprestimo");
		System.out.println("Digite 9 para listar emprestimos ativos");
		System.out.println("Digite 10 para listar emprestimos finalizados");
		System.out.println("Digite 11 listar todos emprestimos de um usuario");
		System.out.println("Digite 12 listar por tipo");
		System.out.println("Digite 0 para finalizar o programa");
		controle = scan.nextInt();
		scan.nextLine();
		
		switch (controle) {
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
			biblioteca.adduser(Aluno.cadastrarAluno(scan));
			break;
		case 5:
			biblioteca.ListarUsers();
			break;
		case 6:
			biblioteca.ListarTodos();
			break;
		case 7:
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
		case 8:
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
		case 9:
			biblioteca.ListarEmprestimosAtivos();
			break;
		case 10:
			biblioteca.ListarEmprestimosFinalizados();
			break;
		case 11:
			System.out.println("Digite o nome completo");
			user = biblioteca.BuscarUsuario(scan.nextLine());
			user.ExibirEmprestimos();
			break;
		case 12:
			biblioteca.ListarTipo(scan);
		case 0:
			break;
		default:
			System.out.println("Digite um numero valido");
		}
	}while (controle!=0);
	scan.close();
	}

}
