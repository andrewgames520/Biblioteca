package entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
	private String nome;
	private String registro;
	private LocalDate dataNasc;
	private List <Emprestimo> emprestimoAtivos;
	
	public Usuario(){
		this.emprestimoAtivos = new ArrayList<Emprestimo>();
	}
	public Usuario(String nome, String registro, LocalDate dataNasc) {
		this();
		this.nome = nome;
		this.registro = registro;
		this.dataNasc = dataNasc;
	}
	
	public abstract int getEmprestimoMax();
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public LocalDate getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	public void addemprestimoAtv(Emprestimo emprestimo) {
		this.emprestimoAtivos.add(emprestimo);
	}
	public void removeremprestimoAtv(Emprestimo emprestimo) {
		this.emprestimoAtivos.remove(emprestimo);
	}
	
	public Integer ContarEmprestimos() {
		return this.emprestimoAtivos.size();
	}
	
	 public boolean PodeFazerEmprestimo() {
	        return this.emprestimoAtivos.size() < getEmprestimoMax();
	    }

	
	public void ExibirEmprestimos() {
		if(this.ContarEmprestimos()==0) {
			System.out.println(this.nome + " não possui nenhum empréstimo ativo");
		}else {
			for(Emprestimo emprestimo : this.emprestimoAtivos) {
				System.out.println(emprestimo.getItem().getTitulo());
			}
		}
	}
}
