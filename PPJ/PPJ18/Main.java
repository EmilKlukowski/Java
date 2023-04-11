package PPJ18;

public class Main {
    public static void main(String[] args){

    }
    public static void bubbleSort(int[] tab) {
        int tmp;
        for (int i = 0; i < tab.length - 1; i++) {
            if (tab[i] > tab[i + 1]) {
                tmp = tab[i + 1];
                tab[i + 1] = tab[i];
                tab[i] = tmp;
            }
        }
    }
    Person person = new Person();

}