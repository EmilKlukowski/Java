public class Main {
    public static void main(String[] args) {
        Telefon t1 = new Telefon("czarny");
        t1.zadzwon("572_283_812");
        t1.wyswietlHistoriePolaczen();
        //2
        System.out.println("=============================");
        Komorka k1 = new Komorka("czarny");
        k1.zadzwon("562-123-123");
        k1.zadzwon("250-123-123");
        k1.zadzwon("224-123-123");
        k1.wyswietlSpis();
        k1.wyswietlHistoriePolaczen();
    }
}
