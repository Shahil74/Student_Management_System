package admin;

import java.io.*;
import java.util.Scanner;

public class AdminSignin{
	public static Scanner sc = new Scanner(System.in);
	public static void signMenu() {
		int ch;
		do {
			System.out.println("1.Sign In");
			System.out.println("2.Sign up");
			System.out.println("3.Exit");
			 ch = sc.nextInt();
			switch(ch) {
			case 1: adminSignin();
					break;
			case 2: adminSignUp();
					break;
			case 3: System.out.println("Exiting");
					break;
			default: System.out.println("Invalid choice ");
			}
		}while(ch!=3);
	}
	public static void adminSignUp() {
		try(ObjectOutputStream owriter=new ObjectOutputStream(new FileOutputStream("signup.txt",true))){
			sc = new Scanner(System.in);
			System.out.println("Enter the Admin username: ");
			String uname=sc.next();
			System.out.println("Enter the password: ");
			String pass = sc.next();
			Admin admin = new Admin(uname,pass);
			owriter.writeObject(admin);
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}

	}
	public static void adminSignin() {
		try(ObjectInputStream oreader = new ObjectInputStream(new FileInputStream("signup.txt"))){
			Admin admin=(Admin)oreader.readObject();
			System.out.println("Enter the username");
			String uname = sc.next();
			System.out.println("Enter the password");
			String password = sc.next();
			String ouname=admin.getUsername();
			String opassword = admin.getPassword();
			if(ouname.equals(uname)) {
				if(opassword.equals(password)){
					System.out.println("Login successfull!!!");
					AdminSignin.adminDashBoard();
				}
				else {
					System.out.println("Password is wrong");
				}
			}
			else {
				System.out.println("Username is wrong");
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void adminDashBoard() {
		int choice;
		do {
			System.out.println("-----Admin Dashboard-----");
			System.out.println("1.Add student");
			System.out.println("2.View Student list");
			System.out.println("3.Remove Student");
			System.out.println("4.Update Student Information");
			System.out.println("5. Exit");
			System.out.println();
			System.out.println("Enter the choice");
			choice=sc.nextInt();
			switch(choice) {
			case 1: AdminMethods.addStudent();
					break;
			case 2: AdminMethods.viewStudent();
					break;
			case 3: AdminMethods.removeStudent();
					break;
			case 4: AdminMethods.updateStudent();
					break;
			case 5:System.out.println("Exiting.....");
					break;
			default: System.out.println("Please enter a correct option");
			}			
		}while(choice!=5);
	}
}
