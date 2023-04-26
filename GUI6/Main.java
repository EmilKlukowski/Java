package GUI6;

import java.util.*;


public class Main{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Thread> threads = new LinkedList<>();
        while (true) {
            System.out.print("Podaj liczbę (-1, aby zakonczyć): ");
            int k = sc.nextInt();
            if (k == -1) {
                for (Thread thread : threads) {
                    thread.interrupt();
                    try {
                        thread.join(); //wywołujemy żeby upewnić się że wątek potomny zakończył działanie
                    } catch (InterruptedException e) {}
                }
                System.out.println("Koniec");
                return;
            }
            if (k > 0) {
                Thread thread = new Thread(() -> obliczPierwsza(k));
                //thread.run( () -> obliczPierwsza(k) );
                //to nie działa bo metoda run nie przyjmuje żadnych argumentów
                //jako że runnable to interfejs funkcyjny (ma jedną metodę abstr)
                //to możemy użyc lambdy i wywołujemy metodę run.
                thread.start(); //startujemy wątek
                threads.add(thread);
            }
        }
    }

    public static void obliczPierwsza(int ktora) {
        long[] tab = new long[ktora];
        long start = System.currentTimeMillis();
        int pos = 0;
        long n = 2;
        System.err.println("Praca wątku sprawdzającego dla k=" + ktora + " rozpoczęła się");
        while (pos < ktora) {

            if (Thread.interrupted()) {
                System.err.println("Praca wątku została przerwana");
                return;
            }


            boolean czyPierwsza = true;
            for (int i = 0; i < pos; i++) {
                if (tab[i] * tab[i] > n)
                    break;
                if (n % tab[i] == 0) {
                    czyPierwsza = false;
                    break;
                }
            }
            if (czyPierwsza) {
                tab[pos] = n;
                pos++;
            }
            n++;
        }
        long end = System.currentTimeMillis();
        long wynik = tab[ktora - 1];
        System.out.println(ktora + "-ta liczba pierwsza to " + wynik + " (czas obliczeń: " + (end - start) + "ms)");
    }

}
