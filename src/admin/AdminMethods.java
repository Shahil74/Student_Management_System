package admin;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import studentclass.Student;

public class AdminMethods {
	public static List<Student> studentList = new LinkedList<Student>();
	static Scanner sc = new Scanner(System.in);
	public static void addStudent() {
		System.out.println("Enter the id of the student");
		int sid = sc.nextInt();
		for(Student student:studentList) {
			if(student.getsId()==sid) {
				System.out.println("ID already exists please re-enter the id ");
				sid=sc.nextInt();
			}
		}
		System.out.println("Enter the name of the student");
		String sname = sc.next();
		Student sdetails = new Student(sid, sname);
		studentList.add(sdetails);
		System.out.println("Student added successfully!!");
	}
	public static List<Student> viewStudent() {
		for(Student student:studentList) {
			System.out.println(student);
		}
		return studentList;
	}
	public static void removeStudent() {
		System.out.println("Enter the id for the removal:");
		int sid = sc.nextInt();
		boolean found=false;
		Iterator<Student> iterator = studentList.iterator();
		while(iterator.hasNext()) {
			Student student = (Student)iterator.next();
			if(student.getsId()==sid) {
				iterator.remove();
				found=true;
			}
		}
			if(!found) {
				System.out.println("Student not found on entered id");
			}
			else {
				System.out.println("Student with the id" +sid+" have been deleted successfully");
			}
	}
	public static void updateStudent() {
		System.out.println("Enter the id: ");
		int sid=sc.nextInt();
		boolean found=false;
		for(Student student:studentList) {
			if(student.getsId()==sid) {
				System.out.println("Current details of the student: "+student);
				System.out.println("Enter the name to update ");
				String uname = sc.next();
				student.setsName(uname);
				System.out.println("Name updated successfully");
				found=true;
			}
		}
		if(!found) {
			System.out.println("No id found on that");
		}		
	}
	public static void displayTeacher() {
		
	}
}
