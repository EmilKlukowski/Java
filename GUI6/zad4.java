package GUI6;

import java.util.*;


public class zad4 {
    public static void main(String[] args) {
        PrimesArray2 tp = new PrimesArray2();
        List<Thread> threads = new LinkedList<>();
        Thread mainThread = new Thread(tp::count);
        mainThread.start();
        threads.add(mainThread);

        System.out.println("Which prime number do you want to know?");
        Scanner sc = new Scanner(System.in);

        while (true) {
            int givenNum = sc.nextInt();
            if (givenNum == -1) {
                for (Thread thread : threads){
                    thread.interrupt();
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Finished!");
                return;
            }
            if(givenNum > 0){
                synchronized (tp) {
                    while (givenNum > tp.primeNumbers.size()) {
                        try {
                            tp.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    Thread thread = new Thread(() -> {
                        try {
                            tp.findPrime(givenNum);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    thread.start();
                    threads.add(thread);
                    tp.notifyAll();
                }
            }
        }
    }
}

