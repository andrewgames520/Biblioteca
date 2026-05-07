package core;

import entidades.Livro;
import entidades.Professor;
import entidades.Revista;
import entidades.ServidorAdministrativo;
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
		Livro livro2 = new Livro("O Imperador amarelo", "Huangdi ", 8);
		Livro livro3 = new Livro("A garota que roubava livros", "Markus Zusak", 5);
		Revista revista1 = new Revista("Revista Tech", 5, 15, "Joao Silva","Janeiro");
      	Revista revista2 = new Revista("Super Interessante", 3, 29, "Maria Santos", "Março");
      	Tese tese1 = new Tese("IA na Educacao", 1, "Ana Paula", "Dr. Ricardo", "Tecnologia Educacional");
      	biblioteca.addItem(tese1);

		
		biblioteca.addItem(livro1);
		biblioteca.addItem(livro2);
		biblioteca.addItem(livro3);
		biblioteca.addItem(revista1);
		biblioteca.addItem(revista2);
		
		biblioteca.adduser(aluno);
		
		Scanner scan = new Scanner(System.in);
		
		int controle =0;
	do {
		System.out.println("1 - Menu item");
		System.out.println("2 - Menu usuario");
		System.out.println("3 - Emprestimo");
		System.out.println("4 - Devolução");
		System.out.println("5 - Reservar");
		System.out.println("6 - Listar emprestimos ativos");
		System.out.println("7 - Listar emprestimos finalizados");
		System.out.println("0 - Sair");
		controle = scan.nextInt();
		scan.nextLine();
		
		switch (controle) {
		case 1:
			ItemMenu(scan, biblioteca);
			break;
		case 2:
			UserMenu(scan, biblioteca);
			break;
		case 3: //pega emprestimo
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
		case 4: //devolver emprestimo
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
		case 5:
			System.out.println("Digite o nome completo do usuario");
			user = biblioteca.BuscarUsuario(scan.nextLine());
			
			System.out.println("Digite o titulo do item");
			item = biblioteca.BuscarItem(scan.nextLine());
			
			if(item == null && user == null) {
				System.out.println("Usuario ou item invalido");
			}else{
				biblioteca.adicionarReserva(item, user);
			}
			break;
		case 6: //listar emprestimos ativos
			biblioteca.ListarEmprestimosAtivos();
			break;
		case 7: //listar emprestimos finalizados
			biblioteca.ListarEmprestimosFinalizados();
			break;
		case 0:
			break;
		default:
			System.out.println("Digite um numero valido");
		}
	}while (controle!=0);
	scan.close();
	System.out.println("Programa encerrado");
	}
	private static void UserMenu(Scanner scan, Biblioteca biblioteca) {
		Integer opcao;
		Usuario user;
		do {
			System.out.println("1 - cadastrar Usuario");
			System.out.println("2 - listar usuários");
			System.out.println("3 - listar emprestimos do usuario");
			System.out.println("0 - voltar");
			opcao = scan.nextInt();
			scan.nextLine();
			switch (opcao){
			case 0:
				break;
			case 1:
				CadastrarUsuarios(scan, biblioteca);
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
		do {
			System.out.println("\n1 - cadastrar livro");
			System.out.println("2 - cadastrar revista");
			System.out.println("3 - cadastrar tese");
			System.out.println("4 - listar itens");
			System.out.println("5 - listar tipo");
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
				biblioteca.ListarTipo(scan);
				break;
			default:
				System.out.println("Opção incorreta");
			}
		}while(opcao !=0);
	}
	
	private static void CadastrarUsuarios(Scanner scan, Biblioteca biblioteca) {
		Usuario user = null;
		Boolean valido = false;
		Integer tipo = null;
			System.err.println("1 - Cadastrar aluno");
			System.err.println("2 - Cadastrar professor");
			System.err.println("3 - Cadastrar Servidor administrativo");
			while(!valido) {
				tipo = scan.nextInt();
				scan.nextLine();
				if(tipo>0 && tipo<4) {
					valido= true;
				}else {
					System.out.println("Escolha uma opção válida");
				}
			}
			try {
			switch (tipo) {
				case 1:
					user = Aluno.cadastrarAluno(scan);
					break;
				case 2:
					user = Professor.cadastrarProfessor(scan);
					break;
				case 3: 
					user = ServidorAdministrativo.cadastrarServidorAdministrativo(scan);
					System.out.println("Tipo de usuario inválido");
			}
			biblioteca.adduser(user);
			}catch(IllegalArgumentException e) {
				System.out.println("Erro ao cadastrar usuario" + e.getMessage());
			}
	}
}
