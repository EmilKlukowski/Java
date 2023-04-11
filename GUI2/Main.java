package GUI2;

import javax.sound.sampled.SourceDataLine;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Main {
    public static void main(String[] args) {

        //1 =============================
        Pies pies1 = new Pies();
        for (int i = 0; i < pies1.ilePowtorzen(); i++) {
            pies1.koncert();
        }


        Kot kot1 = new Kot();
        for (int i = 0; i < kot1.ilePowtorzen(); i++) {
            kot1.koncert();
        }


        Krowa krowa1 = new Krowa();
        for (int i = 0; i < krowa1.ilePowtorzen(); i++) {
            krowa1.koncert();
        }


        //2 ===========================
        Osoba adam = new Osoba("Adam", 100);

        Osoba.Pupil filek = adam.new Pupil("Filek", "kot", 10);

        try {
            filek.nakarm();
        } catch (BankruptException e) {
            System.out.println(e);
        }

        //3==========================================
        System.out.println(new Osoba3zad.Builder()
                .setEmail("jan.kowalski@pja.edu.pl")
                .setNrDowodu("ABC123456")
                .setNazwisko("Kowalski")
                .setImie("Jan")
                .setAdres("Koszykowa 86, Warszawa")
                .build());

        //4================================
        testuj(new MultiZbiorNieuporzadkowany());
        testuj(new MultiZbiorUporzadkowany());


        //5 =======================================

        showWindow();
        showWindow();

    }
    //4 ============================================
    static void testuj(MultiZbior z) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            z.dodaj(5);
            z.dodaj(2);
            z.dodaj(4);
            z.dodaj(15);
            z.wypiszIUsunNajwieksze(2);
            z.dodaj(1);
            z.dodaj(7);
            z.dodaj(3);
            z.dodaj(-2);
            z.wypiszIUsunNajwieksze(10);
        }
        long end = System.currentTimeMillis();
        System.out.println("--- czas: " + (end - start) + " milisekund");
    }

    public static void showWindow(){
        Frame frame = new Frame();
        frame.setSize(300, 300);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            int counter = 0;

            @Override
            public void windowClosing(WindowEvent e) {
                counter++;

                if(counter==3){
                    frame.setVisible(false);
                }
            }
        });
    }
}
