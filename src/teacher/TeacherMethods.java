package teacher;

import java.time.LocalDate;
import java.util.*;
import admin.AdminMethods;
import studentclass.Student;

public class TeacherMethods {
	static Scanner sc = new Scanner(System.in);
	static List<Student> studentList = new LinkedList<Student>();
	public static void addMarks() {
		studentList=AdminMethods.viewStudent();
		if(studentList.isEmpty()) {
			System.out.println("The Student list is empty");
		}
		else {
		Iterator<Student> iterator = studentList.iterator();
		System.out.println("Enter the id whose marks needs to be changed");
		int id = sc.nextInt();
		System.out.println("Enter the mark:");
		int marks=sc.nextInt();
		while(iterator.hasNext()) {
			Student student =(Student)iterator.next();
			if(student.getsId()==id) {
				student.setMarks(marks);
				System.out.println("Marks added successfully");
				System.out.println(student);
			}
		}
		}
	}
	public static void markAttendance() {
		System.out.println("Enter the id for which attendance should be marked");
		int id = sc.nextInt();
		for(Student student:studentList) {
			System.out.println(student);
			if(student.getsId()==id) {
				System.out.println("Enter attendance status in (Present/absent)");
				String status = sc.next();
				student.markAttendance(LocalDate.now(), status);
				System.out.println("Attendance marked successfully");
			}
		}
	}
	public static void viewStudentT() {
		for(Student student:studentList) {
			System.out.println(student);
		}
	}
	public static void teacherDashboard() {
		int ch;
		do {
			System.out.println("1.Add marks to the student");
			System.out.println("2.Mark Attendance");
			System.out.println("3.View Student");
			System.out.println("4.Exit");
			ch=sc.nextInt();
			switch(ch) {
			case 1: addMarks();
					break;
			case 2: markAttendance();
					break;
			case 3: viewStudentT();
					break;
			case 4:System.out.println("Exiting....");
			       break;
			default:System.out.println("Invalid choice");
			}
		}while(ch!=4);
		
	}
}
