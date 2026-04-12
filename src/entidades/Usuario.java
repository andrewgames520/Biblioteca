package entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

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
	
	public static Usuario cadastrarUser(Scanner scan) {
		String nome;
		String registro;
		LocalDate datanasc;
		String nasc;
		
		do {
			System.out.println("Digite o nome completo");
			nome = scan.nextLine();
			if(nome.isBlank()) {
				System.out.println("O nome não pode ser vazio");
			}
		}while(nome.isBlank());
		
		do {
			System.out.println("Digite o regsitro");
			registro = scan.nextLine();
			if(registro.isBlank()) {
				System.out.println("O registro não pode ser vazio");
			}
		}while(registro.isBlank());
		
			System.out.println("Digite a data de nascimento (DD/MM/AAAA)");
			nasc = scan.nextLine();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			datanasc = LocalDate.parse(nasc, formatter);
			
			//scan.nextLine();
			Usuario usuario = new Usuario(nome, registro, datanasc);
			return usuario;
	}
	
}
