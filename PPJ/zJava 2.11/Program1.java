 import java.util.Scanner;
 import java.lang.Math;
public class Program1{
	public static void main (String[] args){
		
		//Zadanie1 ============================
		// (char) 65 --> 'A'
		// (int) 'A' --->
		
		int i;
		for(i=74; i<=150; i++){
			System.out.println((char) i + "-" + i);
		}
		//Zadanie 2 ======================================
		
		//10 wierszy
		//10 elementów
		
		for (int j=1; j<=10; j++){
			System.out.println("");
			for(int k=1; k<=10; k++){
				System.out.print(j*k +" ");
			}
			System.out.println();
		}
		
		//Zadanie3 ========================================
		System.out.println("Podaj liczbe n");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int sum = 0;
		for (i=1;i<=n; i++){
			sum += i*(i+1);	
		}
		System.out.println(sum);
		System.out.println((n*(n+1)*(n+2))/3);
		
		//Wynik taki sam
		
		//2 wzór ===============
		
		sum = 0;
		for (i=1;i<=n;i++){
			sum += Math.pow(-1,(i-1))*Math.pow(i, 2);
			
		}	
		System.out.println(sum);
		System.out.println((Math.pow(-1,(n-1))*n*(n+1))/2);
		
		//Wynik taki sam
		
		
		
		
		
		
		//Zadanie 4 ====================================
		System.out.println("Wprowadz naturalna liczbe dodatnia");

		int x = scan.nextInt();
		int ileCyfr = 0;
		int tmp = x;
		int sumaPoteg=0;
		int cyfra;
		
		while (tmp!=0){
			tmp=tmp/10;
			ileCyfr=ileCyfr+1;
		} 
		
		
		tmp=x;	
		int potega=1;
		int licznik=0;
		
		
		while (tmp!=0){
			cyfra=tmp%10;                            
			tmp=(tmp-cyfra)/10;
			
			while (licznik<ileCyfr){
					
				potega=potega*cyfra;
				licznik=licznik+1;
				
			}
				sumaPoteg = sumaPoteg+potega;
				
		}
		
		//System.out.println(sumaPoteg +" "+ x);
		
		if (sumaPoteg==x){
				System.out.println("Jest liczba Amstronga");
			} else System.out.println("Nie jest liczba Amstronga");
		
		//W tym zadaniu nie wychodzi mi liczba Amstronga. Jestem w stanie stwierdzić że coś jest nie tak
		//ze zmienna sumaPoteg tylko nie wiem co. Przy wpisaniu 153 suma poteg wychodzi 81.
		
	
	
		// Zadanie 5 ======================================
		int j=0;
		
		for (i=1;i<=8;i++){
			
			for(j=1;j<=8;j++){
				
				if(i<=4){
					
					if(j>=i && j<=9-i){
						System.out.print("*");
					} else 
						System.out.print(" ");
					
				}	
				
				if (i>4){
					
					if (j<=i && j>=9-i){
						System.out.print("*");
					} else 
						System.out.print(" ");
				}
			}
			
			System.out.println();
		}
	
	

	
		//Zadanie 6=========================================

	
		for(int givenNum=2; givenNum<30; givenNum++){
			
			int counter=0;
			int p=givenNum;
			
			while(p!=0){
				if(givenNum%p==0){
				counter=counter+1;
				p=p-1;
				}else{
				p=p-1;
				}
			}
			if (counter ==2){
				System.out.println("Liczba pierwsza: " + givenNum);
			}
		}
	
		// Zadanie 7=============================================
		
		System.out.println("Wprowadz przedzial liczb od do 100");
		int givenNum1= scan.nextInt();
		int givenNum2= scan.nextInt();
		double ranNum = (Math.random()*100);
		
		if (ranNum>givenNum1 && ranNum<givenNum2){
			System.out.println("Liczba nalezy do przedzialu");
		} else {
				System.out.println("Wylosowana liczba to: " + ranNum + " znajduje sie poza przedzialem " + givenNum1 + ", " + givenNum2);
				int counter1 = 0;
				
				while(givenNum1>ranNum || givenNum2<ranNum){
				ranNum = (Math.random()*100);
				counter1++;
				}
					
				System.out.println("Wylosowana liczba to: " + ranNum + ".Ilosc prob: " + counter1);
			}
		
		
	
	
	

	
	
	
	
	}
}