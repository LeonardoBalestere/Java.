package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.AllExceptions;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room numer:");
			int number = sc.nextInt();
			System.out.print("Check-in date(dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date(dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			System.out.println();
			
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date(dd/MM/yyyy): ");
			Date updatedcheckIn = sdf.parse(sc.next());
			System.out.print("Check-out date(dd/MM/yyyy): ");
			Date updatedcheckOut = sdf.parse(sc.next());
			reservation.updateDates(updatedcheckIn, updatedcheckOut);
			System.out.println("Reservation: " + reservation);
		}
		catch (ParseException e) {
			System.out.println("Invalid date format");
		}
		catch (AllExceptions e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("unexpect error");
		}
		
		sc.close();
	}

}
