package View;

public class Main {

    public static void main(String[] args) {
        try {
            Home form = new Home();
            form.setVisible(true);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}