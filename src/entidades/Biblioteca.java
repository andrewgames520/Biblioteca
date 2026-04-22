package entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
	
	private List <Livro> livros;
	private List <Usuario> usuarios;
	private List <Emprestimo> emprestimos; 
	public Biblioteca() {
		this.livros = new ArrayList<Livro>();
		this.usuarios = new ArrayList<Usuario>();
		this.emprestimos = new ArrayList<Emprestimo>();
	}
	
	//add livro
	public void addlivro(Livro livro) {
		this.livros.add(livro);
	}
	public void ListarLivros() {
		for(Livro livro : this.livros) {
			livro.MostrarTudo(livro);
			System.out.println();
		}
	}
	public void ListarLivrosDisponiveis() {
		for(Livro livro : this.livros) {
			if(livro.getQntdisponivel()>0) {
				livro.MostrarPrincipal(livro);
				System.out.println();
			}
		}
	}
	public void ListarLivrosIndisponiveis() {
		for(Livro livro : this.livros) {
			if(livro.getQntdisponivel()==0) {
				livro.MostrarPrincipal(livro);
				System.out.println();
			}
		}
	}
	public void ListarTodos() {
		for(Livro livro : livros) {
			livro.MostrarPrincipal(livro);
			System.out.println();
		}
	}

	public Livro BuscarLivro(String titulo){
		for(Livro livro : this.livros) {
			if(livro.getTitulo().equalsIgnoreCase(titulo)) {
				return livro;
			}
		}
		return null;
	}
	//add usuario
	public void adduser(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	public void ListarUsers() {
		for(Usuario usuario : this.usuarios) {
			System.out.println(usuario.getNome());
			System.out.println();
		}
	}
	public Usuario BuscarUsuario(String nome){
		for(Usuario usuario : this.usuarios) {
			if(usuario.getNome().equalsIgnoreCase(nome)) {
				return usuario;
			}
		}
		return null;
	}
	
	
	//add emprestimo
	public void addemprestimo(Emprestimo emprestimo) {
		this.emprestimos.add(emprestimo);
	}
	
	public void Emprestar(Biblioteca biblioteca, Usuario usuario, Livro livro) {
		if(livro.getQntdisponivel()==0) {
			System.out.println("Nenhuma copia disponivel para emprestimo\n");
		}else {
			LocalDate dataEmprestimo = LocalDate.now();
			Emprestimo emprestimo = new Emprestimo(livro, usuario, dataEmprestimo, dataEmprestimo.plusDays(7), "ativo");
			biblioteca.addemprestimo(emprestimo);
			livro.EmprestarLivro(livro);
			System.out.println("Emprestimo realizado com sucesso\n");
		}
	}
	public void Devolver(Biblioteca biblioteca, Usuario usuario, Livro livro, Emprestimo emprestimo) {
		if(emprestimo.getStatus().equals("Entregue")) {
			System.out.println("Este emprestimo já foi devolvido\n");
		}else {
			emprestimo.setStatus("Entregue");
			livro.DevolverLivro(livro);
			emprestimo.CalcularMulta(emprestimo);
			System.out.println("Devolução realizada com sucesso\n");
		}
	}
	
	public Emprestimo BuscarEmprestimo(Usuario usuario, Livro livro){
		for(Emprestimo emprestimo : this.emprestimos) {
			if(emprestimo.getUsuario().equals(usuario) && emprestimo.getLivro().equals(livro)) {
				return emprestimo;
			}
		}
		return null;
	}
	public void ListarEmprestimosAtivos() {
		for(Emprestimo emprestimo : this.emprestimos) {
			if(emprestimo.getStatus().equals("ativo"))
				emprestimo.EmprestimoPrincipal();
		}
	}
	public void ListarEmprestimosFinalizados() {
		for(Emprestimo emprestimo : this.emprestimos) {
			if(emprestimo.getStatus().equals("Entregue"))
				emprestimo.EmprestimoPrincipal();
		}
	}
	public void ListarEmprestimosUsuario(Scanner scan) {
		System.out.println("Digite o nome completo do usuario");
		String nome = scan.nextLine();
		for(Emprestimo emprestimo : emprestimos) {
			if(emprestimo.getUsuario().getNome().equals(nome)) {
				System.out.println(emprestimo.getLivro().getTitulo());
				System.out.println(emprestimo.getStatus());
				System.out.println();
			}
		}
	}
}
