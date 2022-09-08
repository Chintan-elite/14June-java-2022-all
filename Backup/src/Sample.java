
class Pen
{
	String color = "red";
	int price =10;
	String company = "Cello";
	
	public void toWrite()
	{
		System.out.println(color+" "+price+" "+company);
	}
}
class NoteBook extends Pen
{
	
	public void display()
	{
		System.out.println(color+" "+price+" "+company);
	}
}

public class Sample
{
	public static void main(String[] args)
	{
		System.out.println("Hello world...");
		Pen p = new Pen();
		p.toWrite();
		
		Pen p1 = new Pen();
		p1.color="Green";
		p1.price=50;
		p1.toWrite();
		
		NoteBook nb = new NoteBook();
		nb.color="white";
		nb.price=100;
		nb.company="classmate";
		nb.display();
		
	}
}
