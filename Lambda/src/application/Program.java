package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.entities.Product;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter file full path: ");
		String strFile = sc.next();

		File file = new File(strFile);

		try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
			String line = bf.readLine();
			
			while(line != null){
				String[] fields = line.split(",");
				list.add(new Product(fields[0],Double.parseDouble(fields[1])));
				line = bf.readLine();
			}
			double averagePrice = list.stream()
					.map(x -> x.getPrice())
					.reduce(0.0, (x,y) -> x+y / list.size());
			
			System.out.println("Avarage price " + String.format("%.2f", averagePrice));
			
			Comparator<String> comparator = (s1,s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
			
			List<String> names = list.stream()
					.filter(x -> x.getPrice() < averagePrice)
					.map(x -> x.getName())
					.sorted(comparator.reversed())
					.collect(Collectors.toList());
					
			names.forEach(System.out::println);
			
		} catch (IOException e) {
			e.getStackTrace();
		}

		sc.close();
	}

}
