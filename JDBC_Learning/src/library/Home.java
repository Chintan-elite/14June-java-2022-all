package library;

import java.util.Scanner;

public class Home {
	public static void main(String[] args) {
		
		int choice = 0;
		do
		{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice : ");
		System.out.println("0 : Exit");
		System.out.println("1 : Add Book");
		System.out.println("2 : View Book");
		System.out.println("3 : Delete Book");
		System.out.println("4 : Issue Book");
		choice = sc.nextInt();
		LibraryOpration opration = new LibraryOpration();
		switch (choice) {
		case 0 :
			System.out.println("You are out !! Exit");
			break;
		case 1:
			opration.addBook();
			break;
		case 2:
			opration.viewBook();
			break;
		case 3:
			opration.deletebook();
			break;
		case 4:
			opration.issueBook();
			break;

		default:
			System.out.println("Invalid Choice");
			break;
		}
		
		}while(choice !=0);
		
		
	}
}
