import javax.swing.JFrame;

public class Conways {

    private static JFrame frame = new JFrame("Conway's Game of Life");
    private static Culture culture = new Culture(new Seed(),10,10);

    public static void main(String[] args) {
        System.out.println(culture);
    }
}
