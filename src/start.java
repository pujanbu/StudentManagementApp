import java.util.Scanner;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class start {
	public static void main(String[] args) {
		System.out.println("Welcome to Student management app");

		Scanner input = new Scanner(System.in);
		while (true) {

			System.out.println("1) ADD student");
			System.out.println("2) Delete student");
			System.out.println("3) Display student");
			System.out.println("4) exit app");
			int c = input.nextInt();
			input.nextLine();
			if (c == 1) {
				// add

				System.out.println("Enter Name");
				String name = input.nextLine();

				System.out.println("Enter user phone");
				String phone = input.nextLine();

				System.out.println("Enter city");
				String city = input.nextLine();

				// create Student object

				Student st = new Student(name, phone, city);
				boolean answer = StudentDao.insertStudentToDB(st);

				if (answer) {
					System.out.println("Student added successfully...");

				} else {
					System.out.println("Sorry ! something went wrong");
				}
				System.out.println(st);

			} else if (c == 2) {
				// delete
				System.out.println("Enter user id to delete");
				int userId = input.nextInt();
				boolean answer = StudentDao.deleteStudent(userId);

				if (answer) {
					System.out.println("Student deleted successfully...");

				} else {
					System.out.println("Sorry ! something went wrong");
				}
			} else if (c == 3) {
				// display
				StudentDao.showAllStudent();

			} else if (c == 4) {
				// exit
				break;
			} else {
				break;
			}
		}
		System.out.println("Thanks");

	}
}
