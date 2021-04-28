package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.UserLog;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter file full path");
		File file = new File(sc.next());
		/* Conteúdo contido na pasta
			amanda 2018-08-26T20:45:08Z
			alex86 2018-08-26T21:49:37Z
			bobbrown 2018-08-27T03:19:13Z
			amanda 2018-08-27T08:11:00Z
			jeniffer3 2018-08-27T09:19:24Z
			alex86 2018-08-27T22:39:52Z
			amanda 2018-08-28T07:42:19Z
		 */
		Set<UserLog> set = new HashSet<>();

		
		try (BufferedReader bf = new BufferedReader(new FileReader(file))){
			String line = bf.readLine();
			while(line != null) {
				String[] userStatus = line.split(" ");
				String name = userStatus[0];
				Date date = Date.from(Instant.parse(userStatus[1]));
				set.add(new UserLog(name,date));
				line = bf.readLine();
			}
			System.out.println("Total users: " + set.size());
		}
		catch(IOException e) {
			e.getStackTrace();
		}
		
		
		sc.close();
	}

}
