
public class Demo {
	public static void main(String[] args) {
		
		int a = 32768;
		byte b = 10;
		short s = 5892;
		long l = 569856;
		
		
		float f = 569.35f;
		double d = 5689.565656;
		
		char ch = 'a';
		boolean bool = false;
		
		String str = "hello";
		
		//widening //implicite
		int k = 10;
		long j = k;
		
		//nerrowing //explicite
		long m = 9223372036854775807l;
		System.out.println(m);
		int n =(int) m;
		System.out.println(n);
		
		
		int x = 'A';
		System.out.println(x);
		
		char c = 43;
		System.out.println(c);
		
	}
}
