package PPJ21;

public class Prostopadloscian extends Prostokat {
    private double wysokosc;

    public Prostopadloscian(int dl, int sze, double wysokosc) {
        super(dl, sze); //super to wywołanie konstruktora nadklasy
        //nazwy nie maja znaczenia
        this.wysokosc = wysokosc;
    }
    public void showObjProstopadloscianu(){
        System.out.println("Objetosc prostopadloscianu " + super.poleProstokata()*this.wysokosc);
    }
    public void showPoleProstopadloscianu(){
        System.out.println("Pole Prostopadloscianu: " +
                6*super.poleProstokata());
    }
}
