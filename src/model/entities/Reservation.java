package model.entities;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	// ATRIBUTOS
	private Integer numeroDoQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	// CONSTRUTOR
	public Reservation(Integer numeroDoQuarto, Date checkin, Date checkout) throws DomainException {
		
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Erro: a data de Check-out precisa vir após a data de Check-in.");
		}
		
		this.numeroDoQuarto = numeroDoQuarto;
		this.checkIn = checkin;
		this.checkOut = checkout;
	}

	// GETTERS E SETTERS
	public Integer getNumeroDoQuarto() {
		return numeroDoQuarto;
	}

	public void setNumeroDoQuarto(Integer numeroDoQuarto) {
		this.numeroDoQuarto = numeroDoQuarto;
	}

	public Date getCheckin() {
		return checkIn;
	}
	
	public Date getCheckout() {
		return checkOut;
	}

	// METODOS PUBLICOS
	public long duracaoReserva() {
		long diferencaDatas = checkOut.getTime() - checkIn.getTime(); // retorna a diferença entre as datas em milissegundos
		return TimeUnit.DAYS.convert(diferencaDatas, TimeUnit.MILLISECONDS); // converte milissegundos para dias
	}
	
	public void atualizarReserva(Date checkin, Date checkout) throws DomainException {
		
		// verificando se as novas datas não são anteriores as datas iniciais
		Date dataAtual = new Date(); // pegar data atual
		
		if (checkIn.before(dataAtual) || checkOut.before(dataAtual)) {
			throw new DomainException("ERRO: as datas da reserva precisam ser datas futuras.");
		}
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Erro: a data de Check-out precisa vir após a data de Check-in.");
		}
		
		this.checkIn = checkin;
		this.checkOut = checkout;

	}

	@Override
	public String toString() {
		System.out.println();
		return "====== Reserva ======" + 
				"\nNumero do quarto: " + numeroDoQuarto + 
				"\ncheckIn: " + sdf.format(checkIn) + 
				"\ncheckOut: " + sdf.format(checkOut) +
				"\nDuração: " + duracaoReserva() + " noites";
	}
	
}