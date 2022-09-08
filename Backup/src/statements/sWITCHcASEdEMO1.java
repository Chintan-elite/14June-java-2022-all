package statements;

public class sWITCHcASEdEMO1 {
		public static void main(String[] args) {
			
			
			int a = 10;
			int b = 20;
			
			//1 : add
			//2 : sub
			//3 : mul
			//4 : div
			
			int choice = 2;
			
			switch(choice)
			{
			case 1 : 
				System.out.println("addition is : "+(a+b));
				break;
			case 2 : 
				System.out.println("substraction is : "+(a-b));
				break;
				default : 
					System.out.println("Invalid choice");
					
			}
			
			
		}
}
