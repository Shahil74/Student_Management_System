package studentclass;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import admin.AdminSignin;
import teacher.TeacherLogs;

public class StudentManagement {
	static List<Student> list = new LinkedList<Student>();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("-----Student Management System-----");
		int ch=0;
		do {
			System.out.println("1.Admin");
			System.out.println("2.Teacher");
			System.out.println("3.Exit");
			ch = sc.nextInt();			
			switch(ch) {
			case 1: AdminSignin.signMenu();
					break;
			case 2: TeacherLogs.signMenu();
					break;
			case 3: System.out.println("Exiting....");
					break;
			default: System.out.println("Invalid Choice");
			}		
		}while(ch!=3);
	}
}
