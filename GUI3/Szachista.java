package GUI3;

public class Szachista extends Osoba{

    private int ranking;


    public Szachista(String imie, String nazwisko, long pesel, int ranking) {
        super(imie, nazwisko, pesel);
        this.ranking = ranking;
    }

    public int getRanking() {
        return ranking;
    }

    @Override
    public String toString() {
        return "Szachista{" +
                "ranking=" + ranking +
                ", imie='" + getImie() + '\'' +
                '}';
    }
}
