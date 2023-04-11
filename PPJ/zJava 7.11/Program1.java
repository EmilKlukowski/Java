import java.util.Scanner;

public class Program1{
	public static void main (String[] args){
		//1 
		// byte a = 40, b = 50;
		// byte suma = (byte) a + b;
		// System.out.println(suma);
		
		//2=====================
		// int x = 4;
		// long y = x*4 - x++;
		// if (y<10) System.out.println("za mało");
		// else System.out.println("w sam raz");
		// wynik w sam raz, inkrementacja się zrobi
	
		//3 =======================
		// błąd bo nie ma przypisanej wartości, nie ma elsa ifie
		// double x = 0; trzeba zrobić
		// lub dać drugiego if w elsie pierwszego ifa
		// (1)if 
		// else {
		//	(2)if
		//}
		
		//4 ===============================================
		//11+13 bo działa postinkrementacja po plusie  = 24
		
		//5 ===================================
		//s = "123456789"
		
		//6 ===================================================
		// y=20;
		//20!=10 prawda || (z=(przypisywanie)= false) (z==false)--> czy z jest false?
		//x = (y!=10) || (z=false); to jest lub warunkowy jeżeli pierwsze jest true to drugi
		//nie ma znaczenia, nie jest brany pod uwagę
		//true, 20, true
		
		//7=================================================
		//wieksze niz 11;
		
		
		
		//8=====================================
		//y umiera po } bo deklarujemy w bloku do
		
		// do {
			// int y =3;
			// System.out.println(++y + " ");
		// } while (y<=10);
		
		
		
		//9 =================================
		// res = 7
		// boolean wykonuj = true;
		// int res = 15, i =10;
		// do{
			// i--;
			// if (i==6)
				// wykonuj=false;
			// res -=2;
		// }while(wykonuj);
		// System.out.println(res);
		
		//10 =====================
		//
		// for (int i=0; i<3; i++)
			// for(int j=i; j<3; j++)
				// System.out.println(j-i);
		
		//11
		
		char sign = 'x';
		
		if((sign >= '0' && sign <='9') || (sign >= 'a' && sign<='f') || (sign >='A' && sign <='F')){
			System.out.println(sign + " --> " + ((int)sign));
		} else {
			System.out.println(-1);
		}
		
		//12 
		Scanner scanner = new Scanner(System.in);
		System.out.println("Podaj liczby od a do f");
		double a = scanner.nextDouble();
		double b = scanner.nextDouble();
		double c = scanner.nextDouble();
		double d = scanner.nextDouble();
		double e = scanner.nextDouble();
		double f = scanner.nextDouble();
		double z, x, y;
		z = a * e - b * d;
		//z przekształcenia:
        x = (c * e - b * f);
        y = (a * f - d * c);
		
		if (z != 0) {
                System.out.println("Uklad ma jedno rozwiazanie: X:" + x / z + " i Y:" + y / z);
        } else {
            if (x == 0 && y == 0) {
                System.out.println("Układ ma nieskonczenie wiele rozwiązań");
            } else {
                System.out.println("Uklad nie ma rozwiazan");
            }
        }
		//13 ============== liczba doskonała
		
		System.out.println("Podaj liczbe");
		int givenNum = scanner.nextInt();
		int test=givenNum;
		int wynik=0;
		int cyfra;
		
		while (givenNum>0){
			cyfra=givenNum%10;
			wynik=10*wynik+cyfra;
			givenNum=givenNum/10;
		}
		if (test==wynik){
			System.out.println("Jest doskonala");
		}else{
		System.out.println("Nie jest doskonala");
		}
		
		//14
		
		int direction = 0;
        System.out.print("-> ");
        char l = scanner.next().charAt(0);
        while (l != 'e') {
				direction = switch (l) {
				case 'A' -> direction + 90;
				case 'D' -> direction - 90;
				default -> 0;
				};

			if (direction == 360 || direction == -360) {
				direction = 0;
			}

			switch (direction) {
				case 0 -> System.out.println("North");
				case 90, -270 -> System.out.println("East");
				case 180, -180 -> System.out.println("South");
				case -90, 270 -> System.out.println("West");
			}
			l = scanner.next().charAt(0);
		}
		
		//15===============================
            System.out.println("Podaj n");
            int n = scanner.nextInt();
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    System.out.print((char) ('a' + j));
                }
                System.out.println();
            }
            for (int i = n - 2; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    System.out.print((char) ('a' + j));
                }
                System.out.println();
            }
		
		
		
		
	}	
}