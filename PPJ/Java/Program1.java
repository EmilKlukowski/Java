public class Program1{
	public static void main (String[] args){
	//1
	System.out.println(5+5);
	System.out.println(5-5);
	System.out.println(5*5);
	System.out.println(5/5);
	System.out.println(5%4);
	System.out.println(5.3 + .3);
	System.out.println(5.3 - .3);
	System.out.println(5.3 * .3);
	System.out.println(5.3 % .3);
	System.out.println('a' + 'b');
	System.out.println('a' - 'c');
	System.out.println('a' * 'c');
	System.out.println('a' % 'u');
	
	
	//2
	System.out.println('A');
	System.out.println('A' + 0); //Pokazuje się kod znaku A
	
	//3
	System.out.println('!' + '!'); //dwa znaki typu char i zamieniamy je na liczby kod 1 + kod 2 to suma tych dwoch znaków
	System.out.println((char)('!' + '!'));
	
	//4
	System.out.println(4.0/3);	//Należy zrobić .0 bo zmienia się z int na double
	
	//5
	System.out.println(true && false);
	System.out.println(true || false);
	System.out.println(false && true);
	System.out.println(false || true);
	
	//6
	int cal = 168;
	double rzec = 16.3;
	double pol = .2;
	float zmienna = 15.87f;
	double liczba = 3d;
	long liczba2 = 3l;
	boolean falsz = false;
	String hej = "Hello";
	char znak = 'A';
	int bin = 0b10101;
	
	//7
	int a = 2;
	int b = 4;
	
	System.out.println(a<b); //Typ wyrażeń logiczny, w konsoli wyświetla się true lub false
	System.out.println(a>=b);
	
	//8 
	byte male = (byte)-128;
	byte duze = (byte)0b000100100111;
	short smale	= (short)-32768;
	short sduze = (short)0x7FFF;
	int imale = -2147483648;
	int iduze = 2147483647;
	long lmale = -9223372036854775808l;
	long lduze = 9223372036854775807l;
	float fmale= -1.1111111f;
	float fduze = 1.1111111f;
	double dmale = -1.111111111111111d;
	double dduze = 1.111111111111111d;
	
	//9
	// Scanner scan = new Scanner(System.in);
    // System.out.println("Podaj liczbę");
    // int liczba3 = scan.nextInt();
	// scan.nextLine();
	// if (liczba % 2 == 0) {
		// System.out.println("Liczba jest parzysta");
	// }
	// else {
		// System.out.println("Liczba nie jest parzysta");
	// }
	
	//9 
	int liczba5 = 4;
	System.out.println(4/2);
	System.out.println("Liczba jest parzysta");
	
    
	
	//10
	int liczba4 = 153;
	System.out.println((1*1*1)+(5*5*5)+(3*3*3));
	System.out.println("Liczba jest narcystyczna");
	
	//11
	System.out.println(((1+2*3+4)/(5-6) + 78)/(9-10/11));
	
	// System.out.println(Double.MIN_VALUE);
	
	
	
	
	
	
	

	
	
	
	
	}
}
