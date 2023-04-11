public class Program1{
	//Zadanie 1 
	public static void main (String[] args){
		// int num1 = 13; 
		// int x = 0;
		// int p = num1;
		// if(num1%p == 0){
			// x=x+1;
			// p=p-1;
		// } else {p=p-1}

		// if(p==0){
			// if (x==2){
				// System.out.println("Liczba jest pierwsza");
				// } else { System.out.println("Liczba nie jest pierwsza");
		// } else {
			// if(num1%p == 0){
			// x=x+1;
			// p=p-1;
		// }
		
		
		//Zadanie 2===========================================
		boolean czyPada = true;
		if(czyPada==true){
			System.out.println("Pada");
			} else {
			System.out.println("Nie pada");
		}
		
		
		//Zadanie 3 =========================================
		int liczba1;
		boolean czyPada1 = true;
		if (czyPada1 == true){
			liczba1 = 5;
			System.out.println(liczba1);
		} else {
			liczba1 = 8;
			System.out.println(liczba1);
		}
		
		//Zadanie 4 ==============================================
		boolean czyPada2 = true;
		boolean czySwieciSlonce = false;
		if (czyPada2 == true){
			if (czySwieciSlonce == true){
			System.out.println("Jest tęcza");
			} else {
			System.out.println("Pada");
			}	
		}else {
			if (czySwieciSlonce == true){
			System.out.println("Jest słonecznie");
			} else {
				System.out.println("Jest pochmurno");
			}
		}	
		//Zadanie 5 =========================================
		if (3 < 5 * 2)//Jeżeli będzie false to nie zobaczymy 1 komunikatu, nie ma nawiasów, PPJ zawsze się wyświetli bo nie należy do if
		System.out.print("Hello");
		System.out.print(" PPJ");
		System.out.println() ;
		
		//Zadanie 6 ===========================================
		
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		System.out.println("Podaj liczbę");
		int num1 = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Podaj drugą liczbę");
		int num2 = scanner.nextInt();
		if (num1>0 && num2>0){
			System.out.println(num1-num2);
		} else {
			System.out.println(num1 + num2);
		}
		
		//Zadanie 7 =================================
		System.out.println("Podaj dodatnią liczbę");
		int givenNum = scanner.nextInt();
		System.out.println("Podaj drugą dodatnią liczbę");
		int givenNum2 = scanner.nextInt();
		if (givenNum%givenNum2 == 0){
			System.out.println("Liczba pierwsza jest wielokrotnością drugiej");
		} else {
			System.out.println("Liczba pierwsza nie jest wielokrotnością drugiej");
		}
		
		//Zadanie 8 ========================================
		//Kod 1 
		//Założenia
		// dla a = -3, Negative, Absolute value is 3
		// dla a = 0, Positive, Absolute value is 0
		// dla a = 5, Positive, Absolute value is 5 
		//Sprawdzenie 
		int a = 0;
		if (a<0){
			System.out.println("Negative");
			a = a*-1;
			System.out.println("Absolute value is " + a);
		} else {
			System.out.println("Positive");
			System.out.println("Absolute value is " + a);
		}
	
			System.out.println("Kod 2");
			System.out.println();
			System.out.println();
		//Kod2
		//Założenia
		//dla a=-3, Negative, Absolute value is 3
		//dla a=0, Positive, Absolute value is 0
		//dla a= 5, Positive, Absolute value is 5
		//Sprawdzenie
		if (a<0){
			System.out.println("Negative");
			a = a*-1;
			System.out.println("Absolute value is " + a);
		} 
		if (a>=0){
			System.out.println("Positive");
			System.out.println("Absolute value is " + a);
		}
	
		//Zadanie 9 ====================================
		double n1 = Math.random();
		double n2 = Math.random();
		double n3 = Math.random();
		if (n1 > 0.2 && n2>0.2 && n3>0.2){
			
		
		
		
		
		
	}
}