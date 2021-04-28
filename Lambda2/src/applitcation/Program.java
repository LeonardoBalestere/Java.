package applitcation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Employee> list = new ArrayList<>();

		System.out.print("Enter file full path: ");
		String strFile = sc.next();

		File file = new File(strFile);

		try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
			String line = bf.readLine();

			while (line != null) {
				String[] fields = line.split(",");
				list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
				line = bf.readLine();
			}
			System.out.println("Enter salary: ");
			double salaryToGet = sc.nextDouble();

			List<String> emails = list.stream().filter(x -> x.getSalary() > salaryToGet).map(x -> x.getEmail()).sorted().collect(Collectors.toList());

			System.out.println("Email of people whose salary is more than " + String.format("%.2f", salaryToGet) + ": ");
			emails.forEach(System.out::println);

			double sum = list.stream().filter(x -> x.getName().charAt(0) == 'M').map(x -> x.getSalary()).reduce(0.0, (x, y) -> x + y);

			System.out.print("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", sum));

		} catch (IOException e) {
			e.getStackTrace();
		}
		sc.close();
	}

}
