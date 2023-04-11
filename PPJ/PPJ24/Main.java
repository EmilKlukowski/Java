package PPJ24;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int number = 10;
        int b = 11;

        if ((number & 1) % 2 == 0) {
            System.out.println("Parzysta");
        } else
            System.out.println("Nieparzysta");




    /*
        while((number&1)%2==1 && number!=0){
            number = number>>2;
        }
    */
        //rozwiązanie
        boolean evenbit1 = true;
        int n = 10;
        while (evenbit1 && n != 0) {
            if ((n & 1) == 0) evenbit1 = false;
            n = n >> 2;
        }


        //2==========================================
        int liczba;

        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj liczbe");
        liczba = scan.nextInt();

        shifts(liczba);

        //3================================================
        rgba(127);
        //4===============================================
        odbicie(20);
        //5=================================================
        System.out.println();
        System.out.println();
        System.out.println("5 zad:");
        zmianaBitow(-5);
    }

    public static void shifts(int liczba) {
        String s = "";
        int tmp = liczba;

        //binarnie
        for (int i = 0; i < 32; i++) {
            s = (tmp & 0b1) + s;
            tmp = tmp >> 1;
        }

        System.out.println("Binarnie: " + s);
        s = "";

        //quad

        tmp = liczba;
        for (int i = 0; i < 16; i++) {
            s = (tmp & 0b11) + s;
            tmp = tmp >> 2;
        }

        System.out.println("Czworkowy: " + s);
        s = "";

        //oct
        tmp = liczba;
        for (int i = 0; i < 11; i++) {
            s = (tmp & 0b111) + s;
            tmp = tmp >> 3;
        }

        System.out.println("Okt: " + s);
        s = "";

        //hex
        tmp = liczba;

        for (int i = 0; i < 8; i++) {
            int x = (tmp & 0b1111);

            if (x >= 10) {
                s = (char) (x - 10 + 'A') + s;
            } else {
                s = x + s;
            }
            tmp = tmp >> 4;
        }
        System.out.println("Hex: " + s);
    }

    public static void rgba(int color) {
        //rozwiazanie
        System.out.println((color >> 24) & 255);
        System.out.println((color >> 16) & 255);
        System.out.println((color >> 8) & 255);
        System.out.println((color >> 0) & 255);
    }

    public static void odbicie(int y) {
        int z = 0;
        for (int i = 0; i < 32; i++) {
            z = z << 1;
            System.out.print(y & 1);
            z = z + (y & 1);
            y = y >> 1;
        }
    }

    public static void zmianaBitow(int num) {
        int counter = 0;
        int bit = (num & 1);
        int lastBit = (num & 1);
        //bit=lastBit
        String changes = "";
        int poz = 0;

        for (int i = 0; i < 32; i++) {
            System.out.println(lastBit + ", " + (num & 1));
            bit = (num & 1);
            if (bit != lastBit) {   //1 poz        //2 poz
                changes += "(" + (poz - 1) + ", " + poz + ")";
                poz++;
                counter++;
            } else
                poz++;

            lastBit = bit;
            num = num >> 1;    //o jeden przesuwamy
        }

        System.out.println();
        System.out.println(changes);
    }

}