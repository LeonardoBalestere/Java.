package aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutSoucedEmployee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Employee> list = new ArrayList<>();
		
		System.out.print("Enter the number of employees: ");
		int N = sc.nextInt();
		for(int i=0;i<N;i++) {			
			System.out.println("Employee #" + (i+1) +" data:");
			System.out.print("OutSourced (y/n)?");
			char yorn = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			System.out.print("Value per hour: ");
			double valueperhour = sc.nextDouble();
			if(yorn == 'y') {
				System.out.print("Additional charge: ");
				double additionalcharge = sc.nextDouble();
				list.add(new OutSoucedEmployee(name, hours, valueperhour, additionalcharge));
			}
			else{
				list.add(new Employee(name, hours, valueperhour));
			}
		}
		
		System.out.println();
		System.out.println("Payment");
		for(Employee emp : list) {
			System.out.println(emp.getName() + " - $ " + String.format("%.2f",emp.payment()));
		}
		sc.close();
	}

}
