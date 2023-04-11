import java.util.Scanner;

public class Program1{
	public static void main (String [] args){
		//Zadanie 1 ==================================================
	int a = 3;
	int b = 3; //zaprzeczenie !(a<b) to b>=a
	boolean w1 = ((!(a<b) && !(a>b)));
	//a=b
	boolean w2 = (a==b);
	System.out.println(w1 + " " + w2);
		//Zadanie 2 =============================
		
		
		
	int wrt = 6;
	
	
	
	
	if ((wrt > -15 && wrt <=-10) || (wrt> -5 && wrt<0) || (wrt>5 && wrt<10)){
		System.out.println("Liczba należy do zbioru A");
	}
	
	if (wrt<= -13 || (wrt > -8 && wrt<=-3)){
		System.out.println("Liczba należy do zbioru B");
	}
	
	if (wrt>=-4){
		System.out.println("Liczba należy do zbioru C");
	}
	
		//Zadanie 3 ==============================
	Scanner scan = new Scanner(System.in);
        System.out.println("Podaj boki trójkąta");
        int kat1 = scan.nextInt();
        int kat2 = scan.nextInt();
        int kat3 = scan.nextInt();
		
		
		if ((kat1+kat2+kat3)!=180 ){
			System.out.println("Trójkąt nie może istnieć");
		}
		else {
			System.out.println("Trójkąt może istnieć");
			if (kat1<90 && kat2<90 && kat3<90){
				System.out.println("Trójkąt jest ostrokątny");	
			} else {
				System.out.println("Trójkąt nie jest ostrokątny");	
			}
		}			
			
		
		//Zadanie 4 =====================================
		System.out.print("Podaj znak: ");
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		char sign = scanner.next().charAt(0) ;
		if (sign == 'a' || sign == 'e' || sign == 'i' || sign == 'o' || sign == 'u' || sign == 'y' || 
		sign == 'A' || sign == 'E' || sign == 'I' || sign == 'O' || sign == 'U' || sign == 'Y'){
			System.out.println("Znak" + " " + sign + " jest samogłoską");
		}
		else {
			System.out.println("Znak" + " " + sign + " nie jest samogłoską");
		}
			
		//Zadanie 5 ==============================================
		System.out.println("Podaj miesiąc w liczbie");
        int month = scanner.nextInt();
        System.out.println("Podaj rok");
        int year = scanner.nextInt();
        
		if (((year%4==0) || (year%400==0)) && year%100!=0){
			switch (month){
				case 1: 
					System.out.println("Styczeń ma 31 dni");
					break;
				case 2:
					System.out.println("Luty ma 29 dni");
					break;
				case 3:
					System.out.println("Marzec ma 31 dni");
					break;
				case 4:
					System.out.println("Kwiecień ma 30 dni");
					break;
				case 5:
					System.out.println("Maj ma 31 dni");
					break;
				case 6:
					System.out.println("Czarwiec ma 30 dni");
					break;
				case 7:
					System.out.println("Lipiec ma 31 dni");
					break;
				case 8:
					System.out.println("Sierpień ma 31 dni");
					break;
				case 9:
					System.out.println("Wrzesień ma 30 dni");
					break;
				case 10:
					System.out.println("Październik ma 31 dni");
					break;
				case 11:
					System.out.println("Listopad ma 30 dni");
					break;
				case 12:
					System.out.println("Grudzień ma 31 dni");
					break;
			}		
					
					
					
		} else {
			switch (month){
				case 1: 
					System.out.println("Styczeń ma 31 dni");
					break;
				case 2:
					System.out.println("Luty ma 28 dni");
					break;
				case 3:
					System.out.println("Marzec ma 31 dni");
					break;
				case 4:
					System.out.println("Kwiecień ma 30 dni");
					break;
				case 5:
					System.out.println("Maj ma 31 dni");
					break;
				case 6:
					System.out.println("Czarwiec ma 30 dni");
					break;
				case 7:
					System.out.println("Lipiec ma 31 dni");
					break;
				case 8:
					System.out.println("Sierpień ma 31 dni");
					break;
				case 9:
					System.out.println("Wrzesień ma 30 dni");
					break;
				case 10:
					System.out.println("Październik ma 31 dni");
					break;
				case 11:
					System.out.println("Listopad ma 30 dni");
					break;
				case 12:
					System.out.println("Grudzień ma 31 dni");
					break;
			}		
		}


	}
}