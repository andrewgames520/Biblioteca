package entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ServidorAdministrativo extends Usuario {

	public ServidorAdministrativo(String nome, String registro, LocalDate dataNasc) {
		super(nome, registro, dataNasc);
	}
	 @Override public int getEmprestimoMax() { return 5; }
	public static Usuario cadastrarServidorAdministrativo(Scanner scan) {
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
			ServidorAdministrativo servidorAdministrativo = new ServidorAdministrativo(nome, registro, datanasc);
			return servidorAdministrativo;
	}
	
	
}
