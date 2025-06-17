package teacher;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TeacherLogs {
	static List<Teacher> teacherList = new LinkedList<Teacher>();
	static Scanner sc = new Scanner(System.in);
	public static void signMenu() {
		int ch;
		do {
			System.out.println("1.Sign In");
			System.out.println("2.Sign Up");
			System.out.println("3.Exit");
			ch = sc.nextInt();
			switch(ch) {
			case 1: signIn();
					break;
			case 2: signUp();
					break;
			case 3: break;
			default: System.out.println("Invalid choice");
			}
		}while(ch!=3);
		System.out.println("Exiting....");
	}
	public static void signUp() {
		try(FileOutputStream fos =new FileOutputStream("teacher.txt",true)){
			ObjectOutputStream objout = new ObjectOutputStream(fos);
			System.out.println("Enter the username: ");
			String uname = sc.next();
			System.out.println("Enter the password: ");
			String password = sc.next();
			Teacher teacher = new Teacher(uname,password);
			objout.writeObject(teacher);
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void signIn() {
		try(ObjectInputStream objin = new ObjectInputStream(new FileInputStream("teacher.txt"))){
			System.out.println("Enter the username:");
			String uname = sc.next();
			System.out.println("Enter the password");
			String password = sc.next();
			teacherList.clear();
			while(true) {
				try {
				Teacher teacher=(Teacher)objin.readObject();
				teacherList.add(teacher);
				}
			catch(EOFException e) {
				break;
			}
			}
			Iterator<Teacher> iterator = teacherList.iterator();
			while(iterator.hasNext()) {
				Teacher teacher = (Teacher)iterator.next();
				if(teacher.getUsername().equals(uname) && teacher.getPassword().equals(password)) {
					System.out.println("Login successfull");
					TeacherMethods.teacherDashboard();
				}
				else {
					System.out.println("Invalid Credentials please retry");
				}
			}
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}	
	}
}
