package studentclass;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Student {
	private int sId;
	private String sName;
	private int marks=0;
	private Map<LocalDate,String> attendance = new HashMap<LocalDate,String>();
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public Student(int sId, String sName) {
		super();
		this.sId = sId;
		this.sName = sName;
	}
	public void markAttendance(LocalDate date,String status) {
		attendance.put(date, status);
	}
	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sName=" + sName + ", marks=" + marks + ", attendance=" + attendance + "]";
	}
}
