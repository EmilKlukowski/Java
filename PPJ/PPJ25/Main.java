package PPJ25;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //jak chcemy zapisac dane do pliku --> out
        //!!!!musimy zamknąć strumień


        //file input stream // file output stream
        // int b=0;
        //while (b=fis.read()) != -1) -1 --> koniec pliku
        // b=fis.read()
        // if(b!= -1){exit=true }
        //else{ sb.append((char)b);
        // sout((char)b);}
        //fos.write(b);

        File inFile = new File("C:\\Users\\s27944\\IdeaProjects\\project\\Data\\text.txt");
        try {
            FileInputStream fis = new FileInputStream(inFile);
            int b = 0;
            b = fis.read();
            while (b != -1) {
                System.out.print((char) b);
                b = fis.read();
            }
            fis.close();
        } catch (IOException e) {
            System.out.println("Cos poszlo nie tak: " + e);
        }

        //2=================================
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj ilosc plikow");
        int iloscPlikow = scan.nextInt();
        scan.nextLine();
        int counter = 0;

        try {
            for (int i = 0; i < iloscPlikow; i++) {
                File plik = new File("C:\\Users\\s27944\\IdeaProjects\\project\\Data\\text" + i + ".txt");
                FileWriter fw = new FileWriter(plik);
                int n = 0;

                while (counter <= 10) {
                    int[] tenNumbers = new int[10];
                    while (n < 10) {
                        int random = (int) (Math.random() * 10000);
                        tenNumbers[n] = random;
                        n++;
                    }

                    int temp;
                    int zmiana = 1;
                    while (zmiana > 0) {
                        zmiana = 0;
                        for (int k = 0; k < tenNumbers.length - 1; k++) {
                            if (tenNumbers[k] > tenNumbers[k + 1]) {
                                temp = tenNumbers[k + 1];
                                tenNumbers[k + 1] = tenNumbers[k];
                                tenNumbers[k] = temp;
                                zmiana++;
                            }
                        }
                    }

                    for (int j = 0; j < tenNumbers.length; j++) {
                        fw.write(tenNumbers[j] + "" + '\n');
                    }

                    counter++;
                }

                fw.close();
                counter = 0;

            }


        } catch (IOException e) {
            System.out.println("Cos poszlo nie tak: " + e);
        }

        //3 czytamy znak po znaku az do spacji. to bedzie jedna liczba, i to w petli
        //zamiana ze znakow na liczbe z 1,2,3, 123


        sumaLiczb();

    }

    public static int sumaLiczb() {
        int finall = 0;
        int var = 0;
        String plik = "C:\\Users\\Emil\\OneDrive\\Pulpit\\PPJ18\\Data\\liczby.txt";
        try {
            FileInputStream fis2 = new FileInputStream(plik);
            while ((var = fis2.read())!=-1){
                if(((char)var != ' ')) finall += Character.getNumericValue(var);
            }
            fis2.close();
            System.out.println(finall);

        } catch (IOException e) {
            System.out.println("Cos poszlo nie tak: " + e);
        }


        return finall;
    }
}