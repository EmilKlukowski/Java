package egz;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {


        File inFile = new File("C:\\Users\\Emil\\OneDrive\\Pulpit\\GUI\\src\\egz\\slowa");
        FileInputStream fis = new FileInputStream(inFile);
        int counter = 0;
        int b = fis.read();
        while (b != -1) {
            System.out.print((char) b);
            b = fis.read();
            counter++;
        }
        System.out.println();
        System.out.println("Liczba znakow: " + counter);


        //2 =======================================
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj ilosc plikow");
        int iloscPlikow = sc.nextInt();

        counter = 0;
        while (counter != iloscPlikow) {
            File dataX = new File("C:\\Users\\Emil\\OneDrive\\Pulpit\\GUI\\src\\egz\\data" + counter + ".txt");
            FileWriter fw = new FileWriter(dataX);

            int[] liczby = new int[10];
            for (int i = 0; i < liczby.length; i++) {
                liczby[i] = (int) (Math.random() * 10000);
            }


            //bubble sort ==============================

//            for (int i = 0; i < liczby.length - 1; i++) {
//                for (int j = 0; j < liczby.length - 1 - i; j++) {
//                    if (liczby[j] > liczby[j + 1]) {
//                        int tmp = liczby[j];
//                        liczby[j] = liczby[j + 1];
//                        liczby[j + 1] = tmp;
//                    }
//                }
//            }

            bubleSort(liczby);

            //zapisywanie do pliku ===========

            for (int i = 0; i < liczby.length; i++) {
                fw.write(liczby[i] + "" + '\n');

            }
            fw.close();
            counter++;
        }

        //3 ============================

        File plik = new File("C:\\Users\\Emil\\OneDrive\\Pulpit\\GUI\\src\\egz\\liczby");
        FileReader fr = new FileReader(plik);

        int counter2 = 0;

        while (fr.read() != -1) {
            System.out.println((char) fr.read());


            counter2++;
        }

        System.out.println("ilosc okrozen petli: " + counter2);

        /////////////////////PATTERNY PPJ 27

        String s = "8";
        System.out.println(isHex(s));

        //2 zad

        String s1 = "Z.E.C.F.";
        System.out.println(abcd(s1));

        //3 zadanie

        String s2 = "wieś w Polsce położona w województwie  wielkopolskim, w powiecie kolskim, w gmienie Olszówka" +
                "W latach 1975-1998 miejscowość położona była w województwie końskim. W 1990. Za 50 lat";

        System.out.println("Ilosc par liczb w tekscie: "
                + liczbyWtekscie(s2));

        //4 zadanie

        String s3 = "2003-3-1";
        System.out.println(data(s3));

        //5 zadanie

        String s4 = "011";
        System.out.println(bity(s4));
    }

    public static int[] bubleSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        return arr;
    }
    //PATERNY PPJ 27 //////////////////////////////

    public static boolean isHex(String s) {
        Pattern p = Pattern.compile("[A-F]|[0-9]");
        Matcher matcher = p.matcher(s);

        return matcher.find();
    }

    public static boolean abcd(String s) {
        Pattern p = Pattern.compile("([A-Z]\\.){4}");
        Matcher matcher = p.matcher(s);
        return matcher.matches();
    }

    public static int liczbyWtekscie(String s) {
        int counter = 0;
        Pattern p = Pattern.compile("[0-9][0-9]");
        Matcher matcher = p.matcher(s);
        while (matcher.find()) {
            counter++;
        }

        return counter;
    }

    public static boolean data(String s) {
        Pattern p = Pattern.compile("([0-9]{4}\\-[0-9]{2}\\-[0-9]{2})|([0-9]{4}\\-[0-9]\\-[0-9])");
        Matcher matcher = p.matcher(s);

        return matcher.matches();
    }

    public static boolean bity(String s){
        Pattern p = Pattern.compile("([0-1][0-1])+[0-1]");
        Matcher matcher = p.matcher(s);

        return matcher.find();
    }
}
