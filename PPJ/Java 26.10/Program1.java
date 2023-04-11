import java.util.Scanner;


public class Program1{
	public static void main (String[] args){
	//Zadanie 1 
	
	  Scanner scan = new Scanner(System.in);
	  /*
        System.out.println("Wprowadź a");
        int a = scan.nextInt();  
		System.out.println("Wprowadź b");
		int b = scan.nextInt();
		System.out.println("Wprowadź c");
		int c = scan.nextInt();
		double delta=(b*b)-4*a*c;
	
		if (delta>=0){	
			
			double pierwDelta = Math.sqrt((b*b)-4*a*c);
			
			if (a!=0){
				double x1 = (-b-pierwDelta)/(2*a);
				double x2 = (-b+pierwDelta)/(2*a);
				System.out.println("Miejsca zerowe funkcji to: " + x1 + " i " + x2);
			} 
		} else {
			System.out.println("Funkcja nie ma miejsc zerowych");
		}
		*/
			
	// Zadanie 3 ============================================
	for (int i=1; i<=10; i++){
		System.out.println(i);
	}
	
	System.out.println();
	System.out.println();
	
	// Zadanie 4 ============================================
	
		int wrt = 4;
		
		
		for (int i=1; i<=10; i++){
			System.out.println(i*wrt);		
		}
	
	
	System.out.println();
	System.out.println();
	
	// Zadanie 5 =====================================
	
	int val = 1;
	
	System.out.println("Pętla while");
	while (val<2){
		val++;
	}
	System.out.println(val);
	
	
	System.out.println("Pętla do-while");
	do {
		val++;
	} while (val<2);
	System.out.println(val);
	
	//Zadanie 6 =====================================
	
	int iloliczb = 0;
	int num = scan.nextInt();
	int sum = 0;
	
	do {
		iloliczb++;
		sum += num;
	} while ((num = scan.nextInt())!=0);
	
	System.out.println("Ilość wpisanych liczb: " + iloliczb);
	System.out.println("Suma to: " + sum);
	
	//Zadanie 7
	
		int n = 0;
		double suma = 0;
		for (n=0; n<10; n++){
			double pot = Math.pow(2, n);
			double elem = 1/pot;
			suma = suma + elem; 
			System.out.println("Elementy to: " + suma);
			
			
		}
		
		
	}
}