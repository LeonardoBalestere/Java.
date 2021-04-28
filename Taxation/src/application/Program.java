package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entitites.JuridicalPerson;
import entitites.Person;
import entitites.PhysicalPerson;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Person> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		for(int i=0; i<n;i++) {
			System.out.println("Tax payer #" + (i+1) + " data:");
			System.out.print("Physical or Juridical(p/j)? ");
			char iorc = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Annual income: ");
			double anualIncome = sc.nextDouble();
			if(iorc == 'p') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				list.add(new PhysicalPerson(name, anualIncome, healthExpenditures));				
			}
			if(iorc == 'j') {
				System.out.print("Number of Employees: ");
				int numberOfEmployees = sc.nextInt();
				list.add(new JuridicalPerson(name, anualIncome, numberOfEmployees));
				
			}
		}
		System.out.println();
		System.out.println("TAXES PAID:");
		double totalTaxes = 0;
		for(Person person : list) {
			System.out.println(person);
			totalTaxes += person.taxToPay();
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $" + totalTaxes);
		sc.close();
	}

}
