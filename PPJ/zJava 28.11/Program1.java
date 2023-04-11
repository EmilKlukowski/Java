public class Program1{
	public static void main (String[] args){
		show(10);
		int wrt = 5;
		System.out.println("Przed: " + wrt);
		modifyValue(wrt);
		System.out.println("Po: " + wrt); //nie zmienia się wrt, bo jest modyfikowana w metodzie,
		//poza tym co w metodzie nic sie nie zmienia;
		
		findMax(1, 12, 70);	
		
		char[] znaki = {'A', 'l', 'a', ' ', 'm', 'a', ' ', 'k', 'o', 't', 'a', '.'};
		zadanie5(znaki);
		
		
		//zadanie 1
		
		int[][] tab = {
			{1, 0, 0, 0, 0},
			{0, 1, 0, 0},
			{0, 0, 1},
		};
		
		//okreslenie wielkosci tablicy jednowymiarowej
		int size=0;
		for(int i=0; i<tab.length; i++){
			size=size+tab[i].length;
		}
		
		System.out.println("Size: " + size);
		int[] arr = new int[size];
		
		
		
		int increment = 0;
		//przypisanie jednej tablicy do drugiej
		for(int i=0; i<tab.length; i++){
			for(int j=0; j<tab[i].length; j++){
				arr[increment]=tab[i][j];
				increment++;
			}
		}
			
		//wyświetlanie drugiej tablicy
		for(int j=0; j<arr.length; j++){
				System.out.print(arr[j]);
		}
	}

	//zadanie 2
	static void show(int x){
		System.out.println("Given num: " + x);
	}
	
	//zadanie 3
	static void modifyValue(int x){
		System.out.println("Wartosc dostarczonej zmiennej: " + x);
		x = x*5;
		System.out.println("Zmodyfikowana wartosc: " + x);
	}
	
	//zadanie 4
	static void findMax(int x, int y, int z){
		int maxVal=0;
		if(x>y && x>z){
			maxVal=x;
		} else {
			if(y>z){
				maxVal=y;
			} else{
				//y>x i y<z   z najwieksze
				maxVal=z;
			}
		}
		System.out.println("Najwieksza: " + maxVal);
	}
	 
	//zadanie 5
	//podstawic inny znak pod indeks tablicy lub sprawdzic cala tablice do tylu czy nie powtarzaja sie te same znaki
	static void zadanie5(char[] wynik){
		int counter =1;
			for(int i=0; i<wynik.length; i++){
				counter=1;
				for(int j = i+1; j<wynik.length; j++){
					if(wynik[i]==wynik[j]){
						counter++;
						wynik[j] = '\\';
					}
				}
				if(wynik[i]!='\\'){
					System.out.println(wynik[i]+ " wystapil " + counter + " razy.");
				}
				
			}
		
	}
}

	
	
