package GUI2;

public class Osoba {
    private String imie;
    private float stanPortfela;

    public Osoba(String imie, float stanPortfela) {
        this.imie = imie;
        this.stanPortfela = stanPortfela;

    }


    class Pupil {
        private String imie;
        private String nazwaGatunku;
        private float cenaKarmy;

        public Pupil(String imie, String nazwaGatunku, float cenaKarmy) {
            this.imie = imie;
            this.nazwaGatunku = nazwaGatunku;
            this.cenaKarmy = cenaKarmy;
        }

        public void nakarm() throws BankruptException {
            stanPortfela = stanPortfela - cenaKarmy;
            if (stanPortfela < 0) {
                throw new BankruptException("Bankrupt");
            } else {
                System.out.println("Nakarmiono kota" + " koszt " + cenaKarmy);
            }
        }
    }

}
