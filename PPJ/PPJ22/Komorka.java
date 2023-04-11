public class Komorka extends Telefon{

    private String[] spisPol=new String[10];
    private int i=0;

    public Komorka(String kolor) {
        super(kolor);
    }

    @Override
    public void zadzwon(String numer) {
//        System.out.println(numer);
        spisPol[i]=numer;
        i++;
        if(spisPol[9]!=null){
            i=0;
        }
    }

    public void wyswietlSpis(){

        for (int j = 0; j < spisPol.length; j++) {
            if(spisPol[j]!=null){
                System.out.println(spisPol[j]);
            }
        }

    }

    public void wyswietlHistoriePolaczen(){
        System.out.println("Ostatnie polaczenia: ");
        for (int j = 0; j < spisPol.length; j++) {
            if(spisPol[j]!=null) {
                System.out.println(spisPol[j]);
            }
        }
    }

}








