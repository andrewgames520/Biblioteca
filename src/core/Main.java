package core;

import entidades.Livro;
import java.time.LocalDate;
import entidades.Usuario;
import entidades.Biblioteca;
import java.time.format.DateTimeFormatter;



public class Main {

	public static void main(String[] args) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = LocalDate.parse("27/03/2024", formatter);
		Usuario usuario = new Usuario("Andrew", "106", data);
		
		Biblioteca biblioteca = new Biblioteca();

		Livro livro1 = new Livro("O mochileiro das galaxias", "sci-fi", 4, 300);
		Livro livro2 = new Livro("O Imperador amarelo","Fabulas", 2, 250);
		Livro livro3 = new Livro("A garota que roubava livros","Romance", 8, 413);
		
		biblioteca.addlivro(livro1);
		biblioteca.addlivro(livro2);
		biblioteca.addlivro(livro3);
		biblioteca.addlivro(Livro.criarLivros());

		biblioteca.listarLivros();
		biblioteca.ListartituloEqnt();
		livro1.Mostrarqnt(livro1);
		
		System.out.println(usuario.getDataNasc());
	

	}

}
