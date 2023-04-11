public class Program1{
	public static void main (String [] args){
		// zadanie 1 ==================================
		// losowanie wielkosci tablicy 1
		int random1=(int)(Math.random()*2);
		int random=(int)(Math.random()*2);
		int arr1[][] = new int[random1][random];
		
		// losowanie wielkosci tablicy 2
		random1=(int)(Math.random()*2);
		random=(int)(Math.random()*2);
		int arr2[][] = new int[random1][random];
		
		
		random=(int)(Math.random()*2);
		for(int i=0; i<arr1.length; i++){
			for(int j=0; j<arr1[i].length; j++){
			random=(int)(Math.random()*2);
			arr1[i][j]=random;
			}
		}
		
		for(int i=0; i<arr2.length; i++){
			for(int j=0; j<arr2[i].length; j++){
			random=(int)(Math.random()*2);
			arr2[i][j]=random;
			}
		}
		
		
		//Testowanie
		// int arr3 [][] = {{1, 2, 3},{3, 4, 5},{9}};
		// int arr4 [][] = {{1, 2, 3},{3, 4, 5},{9}};
		
		
		System.out.println(jestRowna(arr1, arr2));	
		
		for(int i : splitToDigits(123))
			System.out.println(i + " ");
		
		System.out.println("Liczba narcystyczna");
		System.out.println(isArmstrongNumber(407));
		
		
		
		
		//zadanie 4 =================================================
		System.out.println("Zadanie 4");
		calculateSquares(200, 100, 50);
	
  	
	}
	
	public static boolean jestRowna(int arr1[][], int arr2[][]){
		
		boolean checkSize = false;
		if(arr1.length==arr2.length){	
			checkSize = true;
		}
		
		boolean checkSize2 = false;
		if (checkSize == true){
			for(int i=0; i<arr1.length; i++){
				if(arr1[i].length==arr2[i].length){
					checkSize2=true;
				} else{
					checkSize2=false;
					break;
				}
			}
		}
		
		
		
		boolean checkSame=false;
		
		if(checkSize2==true){
			e: for(int i=0; i<arr1.length; i++){
				for(int j=0; j<arr1[i].length; j++){
					if(arr1[i][j]==arr2[i][j]){
						checkSame=true;
					}else{
						checkSame=false;
						break e;
					}
				}
			}
		}
		boolean all = false;
		if(checkSize && checkSize2 && checkSame){
			all=true;
		}
		
		return all;
		
	}
	static int[] splitToDigits(int x){
		int tmp = x;
		int cyfra;
		int ileCyfr=0;
		while(tmp!=0){
			tmp=tmp/10;
			ileCyfr++;
		}
		int[] arr5 = new int[ileCyfr];
		tmp=x;
		for(int i=(arr5.length-1); i>=0; i--){
			cyfra=tmp%10;
			tmp=(tmp-cyfra)/10;
			arr5[i]=cyfra;
		}
		
		return arr5;
	}
	
	static boolean isArmstrongNumber (int x){
			int ileCyfr = 0;
			int tmp = x;
            while (tmp != 0) {
                tmp /= 10;
                ileCyfr += 1;
            }
            int sumaPoteg = 0;
            tmp = x;
            while (tmp != 0) {
                int cyfra = tmp % 10;
                tmp = (tmp - cyfra) / 10;
                int potega = 1, licznik = 0;
                while (licznik < ileCyfr) {
                    potega *= cyfra;
                    licznik += 1;
                }
                sumaPoteg += potega;
            }
			boolean isArmstrong = false;
            if (sumaPoteg == x) {
               isArmstrong=true;
            }
       
		
		return isArmstrong;
	}
	
	public static int[][] calculateSquares(int screenWidth, int screenHeight, int side){
		int ileKwadratow = (screenWidth/side)*(screenHeight/side);
		int[][] wyniki = new int[ileKwadratow][2];
		int x=0;
		int y=0;
		int counter=0;
		for(int i=0; x<=(screenWidth-side); i++){
			wyniki[i][0]=x;
			wyniki[i][1]=y;
			x+=side;
			counter++;
		}
		x=0;
		y+=side;
		
		for(int i=counter; x<=(screenWidth-side); i++){
			wyniki[i][0]=x;
			wyniki[i][1]=y;
			x+=side;
			counter++;
		}
		


		return wyniki;
		//Ekran 200x100
		//kwadrat o boku 50
		//tablica wyniki[][]
		// 0 0 
		// 50 0 
		// 100 0 
		// 150 0 
		// 0 50 
		// 50 50 
		// 100 50 
		// 150 50 
	}
	
}