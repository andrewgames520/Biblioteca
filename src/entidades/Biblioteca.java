package entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
	
	private List <ItemBiblioteca> items;
	private List <Usuario> usuarios;
	private List <Emprestimo> emprestimos; 
	public Biblioteca() {
		this.items = new ArrayList<ItemBiblioteca>();
		this.usuarios = new ArrayList<Usuario>();
		this.emprestimos = new ArrayList<Emprestimo>();
	}
	
	//add livro
	public void addItem(ItemBiblioteca item) {
		this.items.add(item);
	}
	public void ListarItems() {
		for(ItemBiblioteca item : this.items) {
			item.ExibirTodosDetalhes();
			System.out.println();
		}
	}
	public void ListarLivrosDisponiveis() {
		for(ItemBiblioteca item : this.items) {
			if(item.getQntDisponivel()>0) {
				item.exibirDetalhes();;
				System.out.println();
			}
		}
	}
	public void ListarLivrosIndisponiveis() {
		for(ItemBiblioteca item : this.items) {
			if(item.getQntDisponivel()==0) {
				item.exibirDetalhes();
				System.out.println();
			}
		}
	}
	public void ListarTodos() {
		for(ItemBiblioteca item : items) {
			item.exibirDetalhes();
			System.out.println();
		}
	}

	public ItemBiblioteca BuscarItem(String titulo){
		for(ItemBiblioteca item : this.items) {
			if(item.getTitulo().equalsIgnoreCase(titulo)) {
				return item;
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
	
	public void Emprestar(Biblioteca biblioteca, Usuario usuario, ItemBiblioteca item) {
		if(item.getQntDisponivel()==0) {
			System.out.println("Nenhuma copia disponivel para emprestimo\n");
		}else {
			LocalDate dataEmprestimo = LocalDate.now();
			Emprestimo emprestimo = new Emprestimo(item, usuario, dataEmprestimo, dataEmprestimo.plusDays(7), "ativo");
			biblioteca.addemprestimo(emprestimo);
			item.EmprestarItem(item);
			System.out.println("Emprestimo realizado com sucesso\n");
		}
	}
	public void Devolver(Biblioteca biblioteca, Usuario usuario, ItemBiblioteca item, Emprestimo emprestimo) {
		if(emprestimo.getStatus().equals("Entregue")) {
			System.out.println("Este emprestimo já foi devolvido\n");
		}else {
			emprestimo.setStatus("Entregue");
			item.DevolverItem(item);
			emprestimo.CalcularMulta(emprestimo);
			System.out.println("Devolução realizada com sucesso\n");
		}
	}
	
	public Emprestimo BuscarEmprestimo(Usuario usuario, ItemBiblioteca item){
		for(Emprestimo emprestimo : this.emprestimos) {
			if(emprestimo.getUsuario().equals(usuario) && emprestimo.getItem().equals(item)) {
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
				System.out.println(emprestimo.getItem().getTitulo());
				System.out.println(emprestimo.getStatus());
				System.out.println();
			}
		}
	}
}
