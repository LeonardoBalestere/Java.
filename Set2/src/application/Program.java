package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Set<Integer> courseA = new HashSet<>();
		Set<Integer> courseB = new HashSet<>();
		Set<Integer> courseC = new HashSet<>();
		
		System.out.print("How many studends for course A? ");
		Integer StudentsA = sc.nextInt();
		for(int i=0;i<StudentsA;i++) {
			int student = sc.nextInt();
			courseA.add(student);
		}
		
		System.out.print("How many studends for course B? ");
		Integer StudentsB = sc.nextInt();
		for(int i=0;i<StudentsB;i++) {
			int student = sc.nextInt();
			courseB.add(student);
		}
		
		System.out.print("How many studends for course C? ");
		Integer StudentsC = sc.nextInt();
		for(int i=0;i<StudentsC;i++) {
			int student = sc.nextInt();
			courseC.add(student);
		}
		
		Set<Integer> totalStudens = new HashSet<>(courseA);
		totalStudens.addAll(courseB);
		totalStudens.addAll(courseC);
		
		System.out.println("Total students: "+ totalStudens.size());
		
		sc.close();
	}

}
