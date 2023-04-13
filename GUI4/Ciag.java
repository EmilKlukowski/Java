package GUI4;

import java.util.Iterator;

public class Ciag implements Iterable<Integer>{
    private int a, b;

    public Ciag(int a, int b) {
        this.a = a;
        this.b = b;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int value = a;
            @Override
            public boolean hasNext() {
                return value < b;
            };

            @Override
            public Integer next() {
                return value++;
            }
        };
    }
}