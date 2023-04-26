package GUI6;

import java.util.*;


public class PrimesArray {
    ArrayList<Long> primeNumbers = new ArrayList<>();

    public void count() {
        long n = 2;
        while (true) {
            if (Thread.interrupted()) {
                System.err.println("Thread was interrupted.");
                return;
            }
            boolean isPrime = true;
            for (long p : primeNumbers) {
                if (p * p > n)
                    break;
                if (n % p == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                addToList(n);
            }
            n++;
        }
    }

    public synchronized void addToList(long n) {
        primeNumbers.add(n);
    }

    public synchronized void findPrime(int givenNum) {
        System.out.println("Thread started");
        double start = System.currentTimeMillis();
        System.out.println("The " + givenNum + "th prime number is " + primeNumbers.get(givenNum - 1));
        double end = System.currentTimeMillis();
        System.out.println("Calculation time: " + (end - start) / 1000 + "s.");
    }

}

