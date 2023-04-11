package GUI2;

import java.util.Arrays;

public class MultiZbiorUporzadkowany extends MultiZbior{

    private int[] arr = new int[0];
    private int size = 0;

    @Override
    public void dodaj(int x) {
        size++;
        arr = Arrays.copyOf(arr, size);
        arr[size-1] = x;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i]<arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    @Override
    public int usunMax() throws BrakElementuException {
        if(size == 0)
            throw new BrakElementuException();

        size--;
        return arr[size];
    }
}
