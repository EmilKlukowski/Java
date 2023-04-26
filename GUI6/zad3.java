package GUI6;

import java.util.*;


public class zad3 {
    public static void main(String[] args) {
        PrimesArray tp = new PrimesArray();
        List<Thread> threads = new LinkedList<>();
        Thread mainThread = new Thread(tp::count);
        mainThread.start();
        threads.add(mainThread);

        System.out.println("Which prime number do you want to know?");
        Scanner sc = new Scanner(System.in);

//        mainThread.interrupt();
//        int i = 1;
//        for(Long prime : tp.primeNumbers){
//            System.out.println("Nr" + i + " " + prime);
//            i++;
//        }
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
            if(givenNum>0){
                Thread thread = new Thread(()->tp.findPrime(givenNum));
                thread.start();
                threads.add(thread);
            }
        }


    }
}
