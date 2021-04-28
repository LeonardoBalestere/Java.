package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> list = new ArrayList<>();

		System.out.println("Enter the file path: ");
		String StringModeFile = sc.nextLine();

		File path = new File(StringModeFile);
		String StringModeFolder = path.getParent();

		boolean success = new File(StringModeFolder + "\\out").mkdir();
		String fileToWrite = StringModeFolder + "\\out\\summary.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(StringModeFile))) {
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);
				list.add(new Product(name, price, quantity));

				line = br.readLine();
			}
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileToWrite))) {
				for (Product items : list) {
					bw.write(items.toString());
					bw.newLine();
				}
				
				System.out.println(fileToWrite + " created successfuly.");

			} catch (IOException e) {
				System.out.println("Write error" + e.getMessage());
			}
		} catch (IOException e) {
			System.out.println("Read error: " + e.getMessage());
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		sc.close();
	}

}
