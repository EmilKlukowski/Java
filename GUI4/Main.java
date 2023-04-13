package GUI4;

public class Main {
    public static void main(String[] args) {

        //1=====
        
        Wypozyczalnia w = new Wypozyczalnia();
        try {
            w.zaloz("s123");
            w.wypozycz("s123");
            w.stan("s123");
            w.stan("s123");
//            w.zaloz("s123");
//            w.wypozycz("s456");
            w.wypozycz("s123");
//            w.wypozycz("s123");
            w.usun("s123");
            w.zaloz("s123");
            w.zaloz("s456");
            w.wypiszWszystkich();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        

        //2==========================================
        WypozyczalniaB wypozyczalniaB = new WypozyczalniaB();
        try {
            wypozyczalniaB.wypozycz("s123", "Avatar");
            wypozyczalniaB.zapros("s123", "s456");
            wypozyczalniaB.wypozycz("s456", "Król Lew");
            wypozyczalniaB.wypiszStan("s123");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //3 =============================================
        Ciag ciag = new Ciag(0, 10);
        for (int x : ciag) {
            System.out.println(x);
        }
        for (int x : ciag) {
            System.out.println(x);
        }

        for (int x : ciag){
            for (int y : ciag){
                System.out.print(" " + x*y);
            }
            System.out.println();
        }
    }
}
