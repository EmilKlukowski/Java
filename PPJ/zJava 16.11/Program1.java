public class Program1{
	public static void main (String[] args){
		
		//1 =================================================================================
		int tab[] = {1, 2, 3, 4, 4, 3, 2, 1,};
		int i;
		int j;
		int k;
		boolean read = false;
		int counterfalse=0;
		
		// for(i=0; i<tab.length; i++){
			// if(tab[i]==tab[tab.length-1-i]){
				// read=true;
			// } else 
				// counterfalse++;
		// }
		
		// if(counterfalse>=1){
			// read=false;
			// System.out.println(counterfalse + "nieprawdziwe" + read);
		// } else {
			// System.out.println(read);
		// }
		//2================================================================================
		boolean[] tab2= new boolean[10];
		int random=(int)(Math.random()*10);
		System.out.println(random);
		int counterTrue=0;
		int counterFalse=0;
		for (i=0; i<tab2.length; i++){
			
			random = (int)(Math.random()*10);
			
			if(random>5){
				tab2[i]=true;
				counterTrue++;
			} else {
				tab2[i]=false;
				counterFalse++;
			}
			
			System.out.println(tab2[i]);
		}
		System.out.println("Ilosc true " + counterTrue+ "    Ilosc false "+ counterFalse);
		
		boolean[] tabTrue = new boolean[counterTrue];
		boolean[] tabFalse= new boolean[counterFalse];
		
		for(j=0; j<tabTrue.length; j++){
			tabTrue[j]=true;
		}
		
		//tablica false ma domyślnie same false, wiec nie trzeba jej robić
		for(j=0; j<tabFalse.length; j++){
			tabFalse[j]=false;
		}
		
		//SPRAWDZENIE=======
		for(i=0; i<tab2.length; i++){
			System.out.print(tab2[i]+" ");
		}
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Tablica True");
		
		for(i=0; i<tabTrue.length; i++){
			System.out.print(tabTrue[i]+" ");
		}
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Tablica False");
		
		for(i=0; i<tabFalse.length; i++){
			System.out.print(tabFalse[i]+" ");
		}
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		//3====================================================================================
		int[] arr1 = new int[2];
		int[] arr2 = new int[5];
		
		//Przypisanie random int do tablic
		for(i=0; i<arr1.length; i++){
			random = (int)(Math.random()*10);
			arr1[i]=random;
			
		}
		//Przypisanie random int do tablic
		for(i=0; i<arr2.length; i++){
			random = (int)(Math.random()*10);
			arr2[i]=random;
		}
		
		
		//tablica o długości dwóch poprzednich razem
		int[] arr3 = new int[arr1.length+arr2.length];
		
		for(i=0; i<arr1.length; i++){
			arr3[i] = arr1[i];
		}
		
		for(i=arr1.length; i < arr3.length; i++){
			arr3[i] = arr2[i-arr1.length];
		}
		
		
		//Wyświetlanie tablic
		System.out.println();
		System.out.println("Pierwsza tablica");
		
		for (i=0; i<arr1.length; i++){
			System.out.println(arr1[i]);
		}
		
		System.out.println();
		System.out.println("Druga tablica");
		
		
		for (i=0; i<arr2.length; i++){
			System.out.println(arr2[i]);
		}
		
		System.out.println();
		System.out.println("Trzecia tablica");
		
		
		for (i=0; i<arr3.length; i++){
			System.out.println(arr3[i]);
		}
		System.out.println();
		
		// 3 podpunkt B ==========================================================
		
		int[] arr4 = new int[arr1.length+arr2.length];
		
		for (i = 0; i < arr1.length; i++){
			
			for (j = 0; j < arr2.length; j++){
				
				if (arr1[i] == arr2[j]){
					arr4[i]=arr1[i];
				}
				
				
			}
		}
		
		//3 podpunkt C ==============================================================
		
		int maxVal=arr1[0];
		int minVal=arr1[0];
		
		//Najmniejsza i największa wartość tablicy arr1
		for(i=0; i<arr1.length; i++){
			if(maxVal<arr1[i]){
				maxVal=arr1[i];
			}
			if(minVal>arr1[i]){
				minVal=arr1[i];
			}
		}
		
		//Najmniejsza i największa wartość tablic
		for(i=0; i<arr2.length; i++){
			if(maxVal<arr2[i]){
				maxVal=arr2[i];
			}
			if(minVal>arr2[i]){
				minVal=arr2[i];
			}
		}
		
		int range = maxVal-minVal;
		int[] arr5 = new int[range];
		int fill = minVal;
		
		//nie działa przypisanie liczb do tablicy arr5
		for (i=0; i<arr5.length; i++){
			
			for (j = 0; j < arr1.length; j++){
				
				for (k = 0; k < arr2.length; k++){
				
					if(fill==arr1[j] && fill==arr2[k]){
						fill++;
						arr5[i]= fill;
					}
				}	
			}
		}
		
		
		System.out.println("Pierwsza tablica");
		for (i=0; i<arr1.length; i++){
			System.out.println(arr1[i]);
		}
		
		System.out.println("Druga tablica");
		for (i=0; i<arr2.length; i++){
			System.out.println(arr2[i]);
		}
		
		System.out.println("Piata tablica");
		for (i=0; i<arr5.length; i++){
			System.out.println(arr5[i]);
		}
		
		
		
		
	
		
		//Sprawdzenie	
		//arr1[0]=2
		//arr1[1]=1
		//arr1[2]=8

		//maxVal=2 (arr1[0])
		//minVal=2	(arr1[0])
		//i=0
		//if(2<2) nie 
		//if 2>2 nie
		//
		//i=1
		//
		//if(2<1) nie
		//if2>1) tak, minVal=arr1[1] ===== minVal=1
		//
		//i=2
		//minVal=1
		//
		//if(2<8)? tak, maxVal=8
		//if(1>8)? nie 
		
		
	
		
		//4 ================================================================================
		System.out.println();
		System.out.println();
		System.out.println();
		
		int length = (int)(Math.random()*100);
		long[] arr6= new long[length];
		long minVal2=0;
		long maxVal2=0;
		
		for(i=0; i<arr6.length-1; i++){
			arr6[i+1]=arr6[i]+1;
		}
		
		
		for(i=0; i<arr6.length; i++){
			if(arr6[0]>arr6[i]){
				minVal2=arr6[i];
			}
			if (arr6[0] < arr6[i]) {
				maxVal2 = arr6[i];
			}
		}
		
		//zakres losowania, losowanie dwóch indexów tablicy
		int num1 =(int)(Math.random()*(maxVal2-minVal2+1)+minVal2);
		int num2 =(int)(Math.random()*(maxVal2-minVal2+1)+minVal2);
		int counter=0;
		while (arr6[num1] != arr6[num2]){
			num1 =(int)(Math.random()*(maxVal2-minVal2+1)+minVal2);
			num2 =(int)(Math.random()*(maxVal2-minVal2+1)+minVal2);
			counter++;
		}
		
		System.out.println(arr6[num1]);
		System.out.println(arr6[num2]);
		System.out.println("Liczba prob zamiany: "+ counter);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//5 ================================================================================
	
		// int[] arr7 = {153, 333, 370, 515, 407, 80};
		
        // for (i = 0; i < arr7.length; i++) {
            // int x = arr7[i];
			// int ileCyfr = 0;
			// int tmp = x;
            // while (tmp != 0) {
                // tmp /= 10;
                // ileCyfr += 1;
            // }
            // int sumaPoteg = 0;
            // tmp = x;
            // while (tmp != 0) {
                // int cyfra = tmp % 10;
                // tmp = (tmp - cyfra) / 10;
                // int potega = 1, licznik = 0;
                // while (licznik < ileCyfr) {
                    // potega *= cyfra;
                    // licznik += 1;
                // }
                // sumaPoteg += potega;
            // }
            // if (sumaPoteg == x) {
                // System.out.println("liczba " + x + " jest liczba narcystyczna");
            // }
        // }
		
		
	}
}