package core;

import entidades.Livro;
import entidades.Usuario;
import entidades.Biblioteca;

public class Main {

	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca();
		Livro livro1 = new Livro();
		Livro livro2 = new Livro();
		Livro livro3 = new Livro();
		
		livro1.setTitulo("O mochileiro das galaxias");
		livro2.setTitulo("O Imperador amarelo");
		livro3.setTitulo("A garota que roubava livros");
		
		livro1.setGenero(null);
		
		livro1.setQntdisponivel(4);
		livro2.setQntdisponivel(2);
		livro3.setQntdisponivel(8);
		
		biblioteca.addlivro(livro1);
		biblioteca.addlivro(livro2);
		biblioteca.addlivro(livro3);
		
		//biblioteca.removerlivro(livro1);
		
		biblioteca.listarLivros();
		//biblioteca.ListartituloEqnt();
		livro1.Mostrarqnt(livro1);
	

	}

}
