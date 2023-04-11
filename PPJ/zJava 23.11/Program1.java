import java.util.Scanner;
public class Program1{
	public static void main (String [] args){
		
		//zad 1 ===============================================
		float[][] arr1 = new float [8][8];
		float random = (float)(Math.random()*8);	
		int i;
		int j;
		int k;
		
		for(i=0; i<arr1.length; i++){
			for(j=0; j<arr1[i].length; j++){
				random = (float)(Math.random()*8);
				arr1[i][j]=random; 
			}
		}
		float sum =0;
		
		for(i=0; i<arr1.length; i++){
			sum+=arr1[i][i];
		}
		
		for(i=8, j=0; i<arr1.length; i--, j++){   //przekątna od prawej do lewej: 
			sum+= arr1[j][i];
		}
		
		System.out.println("Suma elementów: "+ sum);
		
		//zad 2 ===================================================
		
		int sum2=0;
		int [][] arr2 = new int [8][4];
		int random1 = (int)(Math.random()*4);
		for(i=0; i<arr2.length; i++){
			for(j=0; j<arr2[i].length; j++){
				random1 = (int)(Math.random()*8);
				arr2[i][j]=random1; 
				sum2=sum2+random1;
			}
		}
		
		System.out.println("Tablica prostokatna: ");
		for(i=0; i<arr2.length; i++){
			for(j=0; j<arr2[i].length; j++){
				System.out.print(arr2[i][j]);
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Suma elementow: "+sum2);
		int iloscEl=8*4;
		System.out.println("Ilosc elementow: " + iloscEl);
		
		//średnia-element
		
		double srArtTablicy =((double)sum2/(double)iloscEl);
		System.out.println("Srednia artm elemntow tablicy: " + srArtTablicy);
		
		double min = Math.abs(srArtTablicy-arr2[0][0]);
		int mi = 0, mj = 0;
		for(i=0; i<arr2.length; i++){
			for(j=0; j<arr2[i].length; j++){
				if(min > Math.abs(srArtTablicy-arr2[i][j])){
					min = Math.abs(srArtTablicy-arr2[i][j]);
					mi = i;
					mj = j;
				}
			}
		}
		
		System.out.println("Indeksy liczby to: " + mi +" " + mj);
	
		//zadanie 3 =====================================================
		System.out.println();
		System.out.println("Zadanie 3");
		
		int[][] arr3 = new int[8][4];
		for(i=0; i<arr3.length; i++){
			for(j=0; j<arr3[i].length; j++){
				random1 = (int)(Math.random()*8);
				arr3[i][j]=random1; 
			}
		}
		
		for(i=0; i<arr3.length; i++){
			for(j=0; j<arr3[i].length; j++){
				System.out.print(arr3[i][j]);
			}
			System.out.println();
		}
		
		
		int sumaWier = 0;
		int sumaKolu = 0;
		
		for(i=0, j=0; j<arr3[i].length; j++){
			sumaWier=sumaWier+arr3[i][j];
		}
		System.out.println();
		System.out.println(sumaWier);
		
		for(i=0; i<arr3.length; i++){
			for(j=0; j<arr3[i].length; j++){
				// if(sumaWier<0 ){
					// sumaWier = -||-
				// }
			}
			// System.out.println();
		}
		
		
		
		for(i=0, j=0; i<arr3.length; i++){
			sumaKolu=sumaKolu+arr3[i][j];
		}
		
		System.out.println(sumaKolu);
		
		//4=========================================================
		
		int kostka1 = (int)(1+Math.random()*6);
		int kostka2 = (int)(1+Math.random()*6);
		int[] wynik = new int [2];
		int[][] zbiorWynik = new int [20][2];
		Scanner scan = new Scanner(System.in);
		System.out.println("Wprowadz jeden ze znakow r, s, q");
		int counter=0;
		char sign;
		
		
		do{
			sign = scan.next().charAt(0);
			switch (sign){
				case 'r':
				
						kostka1 = (int)(1+Math.random()*6);
						kostka2 = (int)(1+Math.random()*6);
						wynik[0] = kostka1;
						wynik[1] = kostka2;
						for(i=0; i<wynik.length; i++){
							zbiorWynik[counter][i]=wynik[i];
						}
						counter++;
				
					break;
					
				case 's':
				
						for(i=0; i<zbiorWynik.length; i++){
							for(j=0; j<zbiorWynik[i].length; j++){
								System.out.println("Losowania: "+ zbiorWynik[i][j]);
							}
							System.out.println();
						}
						
					break;
					
				case 'q':
						System.out.println("Koniec gry");
					break;
					
				default:
						System.out.println("Blad! Wprowadz jeden ze znakow s, r, q");
					break;	
			}
		} while(sign!='q');
		
	}
}