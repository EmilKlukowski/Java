import javax.swing.*;

public class JOptPane {
    public static void main(String[] args) {

//        JOptionPane option = new JOptionPane();
//
//        JOptionPane.showMessageDialog(null, "hejj",
//                "title", -1);
//        JOptionPane.showMessageDialog(null, "hejj",
//                "title", 0);
//        JOptionPane.showMessageDialog(null, "hejj",
//                "title", 1);
//        JOptionPane.showMessageDialog(null, "hejj",
//                "title", 2);

        int answer = JOptionPane.showConfirmDialog(null, "How old are you"
                , "Title", JOptionPane.YES_NO_OPTION);
        if(answer == 0){
            System.out.println("Hej");
        }

        String name = JOptionPane.showInputDialog("What's your name?");
        System.out.println("Hej " + name);

        JOptionPane.showOptionDialog(null, "Option dialog", "title", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, null, 0);
    }
}
