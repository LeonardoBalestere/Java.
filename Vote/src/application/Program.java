package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter file full path");
		File path = new File(sc.next());
		
		Map<String, Integer> votes = new LinkedHashMap<>();
		
		try(BufferedReader bf = new BufferedReader(new FileReader(path))) {
			String line = bf.readLine();
			while(line != null){
				String[] fields = line.split(",");
				String name = fields[0];
				int vote = Integer.parseInt(fields[1]);
				if(votes.containsKey(name)) {
					int votestoadd = votes.get(name);
					votes.put(name, vote + votestoadd);
				}
				else {
					votes.put(name, vote);
				}
				line = bf.readLine();
			}
			for(String key: votes.keySet()) {
				System.out.println(key + ": "+ votes.get(key));
			}
		}
		catch(IOException e) {
			e.getStackTrace();
		}
		
		sc.close();
	}

}
