package GUI3;

public enum DzienTygodnia {
    PN(1, "Poniedziałek"),
    WT(2, "Wtorek"),
    SR(3, "Środa"),
    CZ(4, "Czwartek"),
    PT(5, "Piątek"),
    SB(6, "Sobota"),
    ND(7, "Niedziela");

    private final int nr;
    private final String nazwa;

    DzienTygodnia(int nr, String nazwa) {
        this.nr = nr;
        this.nazwa = nazwa;
    }

    public boolean czyWeekend() {
        return this.nr == SB.nr || this.nr == ND.nr;
    }

    public int ileDniPo(DzienTygodnia day) {
        if (this.nr - day.nr < 0) {
            return 7 + this.nr - day.nr;
        } else
            return this.nr - day.nr;

    }

    public DzienTygodnia nastepny() {
        int index = this.nr;
        if(index <= 6)
            return DzienTygodnia.values()[index];
        else
            return DzienTygodnia.PN;
    }

    @Override
    public String toString() {
        return nazwa;
    }
}
