import java.util.Scanner;

public class Program1{
	public static void main(String[] args){
	System.out.println(27944);
	System.out.println(0x6D28);
	System.out.println(0b0110_1101_0010_1000);
	
	//2 Zadanie
	double zadanie2 = 0;
	System.out.println(zadanie2);
	
	
	//3 Zadanie
	double sqTwo = Math.sqrt(2);
	System.out.println(sqTwo);
	
	double wynik = ((sqTwo)*(sqTwo))-2;
	System.out.println(wynik);
	
	//Operator wyboru 
	
	String check = (zadanie2<wynik)?"wynik w zadaniu 2 jest mniejszy":"wynik w zadaniu 2 nie jest mniejszy";
	System.out.println(check);
	
	//4 Zadanie
	
	int x = 5;
	System.out.println((x=4) * x);
	//(x=4) daje wartość 4, więc x=4, 4*4=16
	
	//5 Zadanie
	Scanner scan = new Scanner(System.in);
    System.out.println("Podaj temperaturę w Farenheit");
    double temperatureF = scan.nextInt();
	System.out.println("Temperatura w Farenheit to " + temperatureF);
	double temperatureCels = ((temperatureF-32.0)*5.0/9);
	System.out.println("Temperatura w Celsjuszach to" + temperatureCels);



	//6 Zadanie 
	Scanner reader = new Scanner(System.in);
	System.out.println("Wprowadz liczbe!");
	int year = reader.nextInt();
	System.out.println("Wprowadzona liczba to " + year);
	System.out.println( ((year%4 == 0) && (year%100!= 0)) || (year%400 ==0)?"Rok " + year + " jest przestępny ":"Rok " + year + " nie jest przestępny");
	
	
	}
}
