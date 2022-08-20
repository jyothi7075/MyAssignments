package org.student;

import org.department.Department;

public class Student extends Department{
	public void studentName() {
		System.out.println("Student name is Jyo");
	}
	public void studentDept() {
		System.out.println("Student department is ECE");
	}
	public void studentId() {
		System.out.println("student Id is 1234");
	}
	public static void main(String[] args) {
		Student sd=new Student();
		sd.collegeName();
		sd.collegeCode();
		sd.collegeRank();
		sd.departmentName();
		sd.studentName();
		sd.studentDept();
		sd.studentId();
	}

}
