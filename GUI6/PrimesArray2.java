package GUI6;

import com.sun.source.tree.Tree;

import java.util.*;


public class PrimesArray2 {
    public ArrayList<Long> primeNumbers = new ArrayList<>();
    public TreeSet<Integer> orders = new TreeSet<>();
    public boolean interrupted = false;

    public synchronized void count() {
        long n = 2;
        while (!interrupted) {
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
        if (orders.contains(primeNumbers.size())) {
            this.notifyAll();
        }
    }

    public synchronized void findPrime(int givenNum) throws InterruptedException {
        System.out.println("Thread started");
        double start = System.currentTimeMillis();
        while (!interrupted && (givenNum > primeNumbers.size() || (orders.contains(givenNum) && !primeNumbers.isEmpty()))) {
            this.wait();
        }
        if (!interrupted) {
            System.out.println("The " + givenNum + "th prime number is " + primeNumbers.get(givenNum - 1));
            double end = System.currentTimeMillis();
            System.out.println("Calculation time: " + (end - start) / 1000 + "s.");
        }
    }

    public synchronized void setInterrupted() {
        this.interrupted = true;
        this.notifyAll();
    }

    public synchronized void addOrder(int order) {
        orders.add(order);
        this.notifyAll();
    }
}