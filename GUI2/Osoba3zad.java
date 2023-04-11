package GUI2;

public class Osoba3zad {
    private final String imie, nazwisko, email, adres, nrDowodu;

    public Osoba3zad(String imie, String nazwisko, String email, String adres, String nrDowodu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.adres = adres;
        this.nrDowodu = nrDowodu;
    }

    static class Builder {
        private String imie, nazwisko, email, adres, nrDowodu;

        public Builder setImie(String imie) {
            this.imie = imie;
            return this;
        }

        public Builder setNazwisko(String nazwisko) {
            this.nazwisko = nazwisko;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setAdres(String adres) {
            this.adres = adres;
            return this;
        }

        public Builder setNrDowodu(String nrDowodu) {
            this.nrDowodu = nrDowodu;
            return this;
        }

        public Osoba3zad build() {
            return new Osoba3zad(imie, nazwisko, adres, email, nrDowodu);
        }
    }
}
