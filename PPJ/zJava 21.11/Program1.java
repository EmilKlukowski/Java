public class Program1{
	public static void main (String[] args){
		
		//1 zadanie ======================
		int i;
		int j;
		int k;
		
		
		int[] arrX = {1, 2, 3, 6};
		int[] arrY= {4, 1, 6, 2};
		
		int minX = arrX[0];
		int maxX = arrX[0];
		int minY = arrY[0];
		int maxY = arrY[0];
		
		for(i=0; i<arrX.length; i++){
			if(minX>arrX[i]){
				minX=arrX[i];
			}
			if(maxX<arrX[i]){
				maxX=arrX[i];
			}
		}
		
		for(i=0; i<arrY.length; i++){
			if(minY>arrY[i]){
				minY=arrY[i];
			}
			if(maxY<arrY[i]){
				maxY=arrY[i];
			}
		}
	
		int a = maxX-minX+1;
		int b = maxY-minY+1;
		//współżędne środka
		int s1 = maxX/2;
		int s2 = maxY/2;
		System.out.println("Wpolrzedne srodka to: "
		+ s1 + " " + s2 + ", szerokosc to: " + a + ", a wysokosc: " + b);
		
		//zadanie 2 ==============================================================
		
		int[] arr2 = new int[5];
		int min1 = arr2[0];
		int min2 = arr2[0];
		
		int random = (int)(-3+Math.random()*10);
		for (i=0; i<arr2.length; i++){
			random = (int)(-3+Math.random()*10);
			arr2[i]=random;
		}
	
		//wyswietlanie
		// for (i=0; i<arr2.length; i++){
			// System.out.println(arr2[i]);
		// }
	
		for (i=0; i<arr2.length; i++){
			if(min1>arr2[i]){
			min1=arr2[i];
			}
		}		
		
		
		for (i=0; i<arr2.length; i++){
			if(min2>min1 && min2>arr2[i]){
				
			}
		}
		
		//zadanie 3 =======================================================================
		
		System.out.println("Zadanie 3");
		
		int n1 = 8;
		int[] arr3 = new int[n1];
		int counter3=0;
		String rozneLiczby = "";
		
		for (i=0; i<arr3.length; i++){
			random = (int)(Math.random()*5);
			arr3[i]= random;
		}
		
		
		for (i=0; i<arr3.length; i++){
			System.out.println(arr3[i]);
		}
		
		//porównujemy do siebie wszystkie elementy tablicy, szukamy róźniących się elementów
		//porównujemy 8 razy indeks 0 do innych elementów tablicy
		for (i=0; i<arr3.length; i++){
			for(j=0; j<arr3.length; j++){
				if(arr3[i]!=arr3[j]){
					rozneLiczby += " "+ arr3[i];
				}
			}
		}
		System.out.println(rozneLiczby);
		
		
		
		
		
		
		
		
	
		
		//zadanie 4 ==================================================================
		int n=8;
		int[] arr4 = new int[n];
		int counter4 = 0;
		String liczby="";
		
		
		for (i=0; i<arr4.length; i++){
			random = (int)(Math.random()*5);
			arr4[i]= random;
		}
		
		for (i=0; i<arr4.length; i++){
			System.out.println(arr4[i]);
		}
		
		
		for(i=0; i<arr4.length; i++){            //musimy porównać każdy z każdym element
												//jeśli równają sie sobie to powtarzają sie 
			for(j=i+1; j<arr4.length; j++){
				
				if(arr4[i]==arr4[j]){
						counter4++;
						liczby += " " + arr4[j];
						break;
				}
				
			}
			
		}
		
		liczby += "  " + liczby;    //nie działa gdy losuje 3 takie same liczby 
		System.out.println();
		System.out.println(liczby);
		System.out.println("counter: "+counter4);
		
		if (counter4>=(int)(n/2)){
			System.out.println("Liczby powtarzaly sie: " + counter4 + " razy");
		} else {
			System.out.println("Liczby nie powtarzaly sie przynajmniej " + n/2 + " razy");
		}
		
		
		System.out.println();
		System.out.println();
		
		//5 ================================================================================
		//porównujemy ze sobą elementy tablic i indeksujemy do tablicy C
		
		int[] arrA ={2, 4, 6, 8, 10};
		int[] arrB ={14, 12, 10, 9, 8};
	
		int[] arrC = new int[arrA.length+arrB.length];
		
		
	
		for (i=0; i<arrA.length; i++){
				
			for (j=arrB.length; j<arrB.length; j--){
					
				if(arrA[i]<arrB[j]){
					arrC[i]=arrA[i];
				} else {
					arrC[i+1]=arrB[j];
				}
			}
		}
	
		
	
		
		
		System.out.println("Tablica A");
		for (i=0; i<arrA.length; i++){
			System.out.println(arrA[i]);
		}
		System.out.println();
		
		System.out.println("Tablica B");
		for (i=0; i<arrB.length; i++){
			System.out.println(arrB[i]);
		}
		System.out.println();
		
		System.out.println("Tablica C");
		for (i=0; i<arrC.length; i++){
			System.out.println(arrC[i]);
		}
		
		System.out.println();
		
		
		//6 ===================================================================================
		
		random = (int)(Math.random()*10);
		int[] arr5 = new int[random];
		random = (int)(Math.random()*10);
		int[] arr6 = new int[random];
		random = (int)(Math.random()*10);
		int[] arr7= new int[random];
		
		
		for (i=0; i<arr5.length; i++){
			random = (int)(Math.random()*10);
			arr5[i]=random;
		}
		for (i=0; i<arr6.length; i++){
			random = (int)(Math.random()*10);
			arr6[i]=random;
		}
		for (i=0; i<arr7.length; i++){
			random = (int)(Math.random()*10);
			arr7[i]=random;
		}
		
		
		int[][] collArr = new int[3][];
		
		collArr[0]=arr5;
		collArr[1]=arr6;
		collArr[2]=arr7;
		
		
		
		for(i=0;i<collArr.length; i++){
			for(j=0; j<collArr[i].length;j++){
				System.out.println(collArr[i][j]);
			}
		}
	
	
	}
}