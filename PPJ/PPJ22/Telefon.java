
public class Telefon {
        private String kolor;

        public Telefon(String kolor) {
            this.kolor = kolor;
        }

        public void zadzwon(String numer){
            System.out.println(numer);
        }

        public String returnZadzwon(String numer){
            return numer;
        }

        public void wyswietlHistoriePolaczen(){
            System.out.println("Brak historii");
        }


}
