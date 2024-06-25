package application;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
	Scanner input = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	try {
	
		System.out.print("Número do quarto: ");
		int numeroQuarto = input.nextInt();
		
		System.out.print("CheckIn date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(input.next());
		
		System.out.print("CheckOut date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(input.next());
		
		Reservation reserva = new Reservation(numeroQuarto, checkIn, checkOut); // instanciando um obj da classe reservation
		System.out.println(reserva.toString()); 
		System.out.println();
		
		// atualizando a data da reserva
		System.out.println("Insira a nova data da reserva: ");
		System.out.print("CheckIn date (dd/MM/yyyy): ");
		checkIn = sdf.parse(input.next());
		
		System.out.print("CheckOut date (dd/MM/yyyy): ");
		checkOut = sdf.parse(input.next());
			
		reserva.atualizarReserva(checkIn, checkOut); // variável erro faz referência ao objeto reserva				
		System.out.println(reserva.toString());		
		
	}
	catch(ParseException exception) {
		System.out.println("Invalid date format.");
	}
	catch(DomainException exception) {
		System.out.println(exception.getMessage());
	}
	catch(RuntimeException exception) {
		System.out.println("Unexpected error");
	}
	
	input.close();

	}

}