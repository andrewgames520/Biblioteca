package entidades;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {
private ItemBiblioteca item;
private Usuario usuario;
private LocalDate DataEmprestimo;
private LocalDate DataDev;
private String Status;
private Double Multa;
private Boolean ativo;

public Emprestimo(ItemBiblioteca item, Usuario usuario, LocalDate dataEmprestimo, LocalDate dataDev, String status) {
	this.item = item;
	this.usuario = usuario;
	DataEmprestimo = dataEmprestimo;
	DataDev = dataDev;
	Status = status;
}

public boolean isAtivo() { return ativo; }

public ItemBiblioteca getItem() {
	return item;
}

public void setItem(ItemBiblioteca item) {
	this.item = item;
}

public Usuario getUsuario() {
	return usuario;
}

public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}

public LocalDate getDataEmprestimo() {
	return DataEmprestimo;
}

public void setDataEmprestimo(LocalDate dataEmprestimo) {
	DataEmprestimo = dataEmprestimo;
}

public LocalDate getDataDev() {
	return DataDev;
}

public void setDataDev(LocalDate dataDev) {
	DataDev = dataDev;
}

public String getStatus() {
	return Status;
}

public void setStatus(String status) {
	Status = status;
}


public Double getMulta() {
	return Multa;
}

public void setMulta(Double multa) {
	Multa = multa;
}

public void CalcularMulta(Emprestimo emprestimo) {
	long dias =  ChronoUnit.DAYS.between(emprestimo.DataDev, LocalDate.now());
	if(dias <= 0) {
		emprestimo.setMulta(0.);
	}else if(dias<3) {
		emprestimo.setMulta(dias*2.);
	}else {
		emprestimo.setMulta(dias*5.);
	}
}
public void EmprestimoPrincipal() {
	System.out.printf("Nome do usuario: %s\n Titulo: %s\n", usuario.getNome(), item.getTitulo());
	System.out.println();
}
}

