package week3.day1;
//Method Overloading
public class Students {
	
	public static void getStudentInfo(int studentId) {
		System.out.println(studentId);
	}
	public void getStudentInfo(int studentId, String studentName) {
		System.out.println(studentId + studentName);
	}
	public void getStudentInfo(String email, int phoneNumber) {
		System.out.println(email + phoneNumber);
	}
	public static void main(String[] args){
		Students sd=new Students();
		Students.getStudentInfo(123);
		sd.getStudentInfo(456, " Jyothi");
		sd.getStudentInfo("jyo@gmail.com ", 12345678);
	}

}
