package entidades;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {
private ItemBiblioteca item;
private Usuario usuario;
private LocalDate DataEmprestimo;
private LocalDate DataDev;
private Boolean Status;
private Double Multa;


public Emprestimo(ItemBiblioteca item, Usuario usuario, LocalDate dataEmprestimo, LocalDate dataDev, Boolean status) {
	this.item = item;
	this.usuario = usuario;
	this.DataEmprestimo = dataEmprestimo;
	this.DataDev = dataDev;
	this.Status = status;
}

public boolean isAtivo() { return Status; }

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

public Boolean getStatus() {
	return Status;
}

public void setStatus(Boolean status) {
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

