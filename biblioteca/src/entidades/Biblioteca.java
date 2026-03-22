package entidades;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	
	private List<Livro> livros;
	private List<Usuario> usuarios;
	public Biblioteca() {
		this.livros = new ArrayList<Livro>();
		this.usuarios = new ArrayList<Usuario>();
	}
	
	//add livro
	public void addlivro(Livro livro) {
		this.livros.add(livro);
	}
	//listar
	public void listarLivros() {
		for(Livro livro : this.livros) {
			System.out.println(livro.getTitulo());
		}
	}

	//remove um livro
	
	//adiciona usuarios
	
	//list usuarios
	
	//filtra os livros por genero
}
