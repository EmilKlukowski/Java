import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String s = "A9";
        System.out.println(isHex(s));

        //2
        String s1 = "A.B.C.D.";
        System.out.println(abcd(s1));

        //3
        String s2 = "wieś w Polsce położona w województwie  wielkopolskim, w powiecie kolskim, w gmienie Olszówka" +
                "W latach 1975-1998 miejscowość położona była w województwie końskim.";


        //5 rozwiazanie String regex5 = "[01]<[01][01]>*";

    }
    public static boolean isHex(String s){
        Pattern p = Pattern.compile("[A-F]|[0-9$]"); // \d
        Matcher matcher = p.matcher(s);
        return matcher.find();
    }

    public static boolean abcd(String s){
        Pattern p = Pattern.compile("([A-Z]\\.){4}");
        Matcher matcher = p.matcher(s);
        return matcher.find();
    }

    public static int liczbyWtekscie(String s){
        Pattern p = Pattern.compile("[0-9]+[0-9]");
        Matcher matcher = p.matcher(s);
        return matcher.find(); //dopóki find zwraca true to licznik++
    }


}
