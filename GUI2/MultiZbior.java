package GUI2;

public abstract class MultiZbior {
    public abstract void dodaj(int x);
    public abstract int usunMax() throws BrakElementuException;

    public void wypiszIUsunNajwieksze(int k){
        for (int i = 0; i < k; i++) {
            try {
                int maxEl = usunMax();
                System.out.print(" " + maxEl);
            } catch (BrakElementuException e) {};
        }


    }

    public static class BrakElementuException extends Exception{};
}
