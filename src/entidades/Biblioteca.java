package entidades;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	
	private List <Livro> livros;
	private List <Usuario> usuarios;
	public Biblioteca() {
		this.livros = new ArrayList<Livro>();
		this.usuarios = new ArrayList<Usuario>();
	}
	
	//add livro
	public void addlivro(Livro livro) {
		this.livros.add(livro);
	}
	//add usuario
	public void adduser(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	//listar livros
	public void ListarLivros() {
		for(Livro livro : this.livros) {
			livro.MostrarTudo(livro);
			System.out.println();
		}
	}

	public void ListarUsers() {
		for(Usuario usuario : this.usuarios) {
			System.out.println(usuario.getNome());
			System.out.println();
		}
	}
	public void ListarTodos() {
		for(Livro livro : livros) {
			livro.Mostrarprincipal(livro);
			System.out.println();
		}
	}
}
