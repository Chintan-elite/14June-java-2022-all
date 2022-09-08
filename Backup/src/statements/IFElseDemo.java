package statements;

public class IFElseDemo {
	public static void main(String[] args) {
		
		int marks = 100;
		
		if(marks>=90)
		{
			System.out.println("Grade A");
		}
		else if(marks>=70 && marks<90)
		{
			System.out.println("Grade B");
		}
		else if(marks>=50 && marks<70)
		{
			System.out.println("grade c");
		}
		else
		{
			System.out.println("fail");
		}
		
	}
}
