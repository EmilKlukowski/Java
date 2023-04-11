package PPJ21;

public class Main {
    public static void main(String[] args) {
        //1 Zadanie=================================
    //Prostokat
    Prostokat p1 = new Prostokat(20, 10);
    p1.poleProstokata();
    p1.showPoleProstokata();

    //Prostopadloscian
    Prostopadloscian prostop1 = new Prostopadloscian(
            20, 10, 10);

    prostop1.showObjProstopadloscianu();
    prostop1.showPoleProstopadloscianu();

    //trojkat
    Trojkat t1 = new Trojkat(10, 5);
    t1.showpoleTrojkata();

    //ostroslup
    Ostroslup o1 = new Ostroslup(10.0,
            5, 10);
    o1.showObjOstroslupa();
    o1.showPoleOstroslupa();
    //graniastoslup
    Graniastoslup g1 = new Graniastoslup(10, 5, 10);
    g1.showObjGraniastoslupa();
    g1.showPoleGraniastoslupa();


    }
}
