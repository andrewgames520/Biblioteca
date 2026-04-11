package entidades;

import java.util.Date;

public class Usuario {
	private String nome;
	private String registro;
	private Date dataNasc;
	
	
	
	
	public Usuario(String nome, String registro, Date dataNasc) {
		super();
		this.nome = nome;
		this.registro = registro;
		this.dataNasc = dataNasc;
	}
	
	public Usuario() {
		
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
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	
}
