package entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Queue;

public class Biblioteca {
	
	private List <ItemBiblioteca> items;
	private List <Usuario> usuarios;
	private List <Emprestimo> emprestimos; 
	private Queue<Usuario> filaReservas;
	private ItemBiblioteca itemReservado;
	 
	  public Biblioteca() {
	        this.items = new ArrayList<>();
	        this.usuarios = new ArrayList<>();
	        this.emprestimos = new ArrayList<>();
	        this.filaReservas = new LinkedList<>();
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
	
	public void ListarTipo(Scanner scan){
		System.out.println("Digite 1 para listar livros");
		System.out.println("Digite 2 para listar revistas");
		System.out.println("Digite 3 para listar Teses");
		Integer tipo = scan.nextInt();
		switch (tipo) {
		case 1:
			for(ItemBiblioteca item : this.items) {
				if(item instanceof Livro) {
					item.exibirDetalhes();
				}
			}
			break;
		case 2:
			for(ItemBiblioteca item : this.items) {
				if(item instanceof Revista) {
					item.exibirDetalhes();
				}
			}
			break;
		case 3:
			for(ItemBiblioteca item : this.items) {
				if(item instanceof Tese) {
					item.exibirDetalhes();
				}
			}
			
		}
		
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
		if(usuario.PodeFazerEmprestimo()) {
			if(item.getQntDisponivel()==0) {
				System.out.println("Nenhuma copia disponivel para emprestimo\n");
			}else {
				LocalDate dataEmprestimo = LocalDate.now();
				Emprestimo emprestimo = new Emprestimo(item, usuario, dataEmprestimo, dataEmprestimo.plusDays(7), true);
				biblioteca.addemprestimo(emprestimo);
				usuario.addemprestimoAtv(emprestimo);
				item.EmprestarItem(item);
				System.out.println("Emprestimo realizado com sucesso\n");
			}
		}else {
			System.out.println("Maximo de emprestimos simultaneos atingido");
		}
	}
	public void Devolver(Biblioteca biblioteca, Usuario usuario, ItemBiblioteca item, Emprestimo emprestimo) {
		if(emprestimo.getStatus()) {
			System.out.println("Este emprestimo já foi devolvido\n");
		}else {
			emprestimo.setStatus(false);
			item.DevolverItem(item);
			emprestimo.CalcularMulta(emprestimo);
			usuario.removeremprestimoAtv(emprestimo);
			System.out.println("Devolução realizada com sucesso\n");
		}
		 // Verificar fila de reserva
        if (!filaReservas.isEmpty() && item.equals(itemReservado)) {
            Usuario proximo = filaReservas.poll();
            System.out.println(" Próximo da fila de reserva: " + proximo.getNome());
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
			if(emprestimo.getStatus())
				emprestimo.EmprestimoPrincipal();
		}
	}
	public void ListarEmprestimosFinalizados() {
		for(Emprestimo emprestimo : this.emprestimos) {
			if(!emprestimo.getStatus())
				emprestimo.EmprestimoPrincipal();
		}
	}
	 public void adicionarReserva(ItemBiblioteca item, Usuario usuario) {
	        if (item.getQntDisponivel()!=0) {
	            System.out.println("Item disponível, não é necessário reserva!");
	            return;
	        }

	        if (itemReservado == null || !itemReservado.equals(item)) {
	            itemReservado = item;
	            filaReservas.clear();
	        }

	        filaReservas.add(usuario);
	        System.out.println("Usuário " + usuario.getNome() + " adicionado à fila de reserva de " + item.getTitulo());
	    }

	
}
