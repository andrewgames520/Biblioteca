package entidades;

import java.time.LocalDate;

public class Professor extends Usuario {

	public Professor(String nome, String registro, LocalDate dataNasc) {
		super(nome, registro, dataNasc);
	}
	 @Override public int getEmprestimoMax() { return 4; }

}
