package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exeption.DomainExceptions;

public class Program {

	public static void main(String[] args){
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		Reservation reservation = new Reservation();
		
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			
			System.out.print("Check-in: (dd/MM/yyyy) ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Check-out: (dd/MM/yyyy) ");
			Date checkout = sdf.parse(sc.next());
			reservation = new Reservation(number, checkin, checkout);
			System.out.println(reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in: ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out: ");
			checkout = sdf.parse(sc.next());
			
			reservation.updateDates(checkin, checkout);
			System.out.println("Reservation: " + reservation);
		
		}
		catch(ParseException e) {
			System.out.println("Error date format");
		}
		catch(DomainExceptions e) {
			System.out.println(e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Eror unexpected!");
		}
		sc.close();

	}

}
