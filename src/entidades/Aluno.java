package entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Aluno extends Usuario{

	public Aluno(String nome, String registro, LocalDate dataNasc) {
		super(nome, registro, dataNasc);
	}
	 @Override public int getEmprestimoMax() { return 1; }
	public static Aluno cadastrarAluno(Scanner scan) {
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
			System.out.println("Digite o registro");
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
			Aluno aluno = new Aluno(nome, registro, datanasc);
			return aluno;
	}
	
	
}

