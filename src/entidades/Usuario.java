package entidades;

import java.time.LocalDate;

public class Usuario {
	private String nome;
	private String registro;
	private LocalDate dataNasc;
	
	
	public Usuario(String nome, String registro, LocalDate dataNasc) {
		super();
		this.nome = nome;
		this.registro = registro;
		this.dataNasc = dataNasc;
	}
	
	
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
	
	
}
