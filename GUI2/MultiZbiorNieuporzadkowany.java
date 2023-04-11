package GUI2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MultiZbiorNieuporzadkowany extends MultiZbior {
    private int[] arr = new int[0];
    private int size = 0;

    @Override
    public void dodaj(int x) {
        size++;
        arr = Arrays.copyOf(arr, size); //kopia starej tablicy, nowa dlugosc
        arr[size - 1] = x;

    }

    @Override
    public int usunMax() throws BrakElementuException {
        if (size == 0) throw new BrakElementuException();

        int maxEl = arr[0];
        int maxIndex = 0;
        for (int i = 1; i < this.size; i++) {
            if (arr[i] > maxEl) {
                maxEl = arr[i];
                maxIndex = i;
            }
        }
        size--;
        arr[maxIndex] = arr[size];

        return maxEl;
    }
}
