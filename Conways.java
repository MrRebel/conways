import javax.swing.JFrame;
import java.util.Scanner;

public class Conways {

    private static JFrame frame;
    private static Culture culture;

    private static int FRAME_WIDTH = 500;
    private static int FRAME_HEIGHT = 500;

    public static void main(String[] args) {
        testFrame();
    }

    private static void testFrame() {
        frame = new JFrame("Conway's Game of Life");
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        ConwaysPanel panel = new ConwaysPanel(culture);
        frame.add((JPanel) panel);
        
        frame.setVisible(true);
    }

    private static void testText() {
        Scanner in = new Scanner(System.in);
        culture = new Culture(gliderFromWiki(), 30,60);
        System.out.println(culture);
        String input;
        do {
            input = in.nextLine();
            culture.tick();
            System.out.println(culture);
        } while (!input.equalsIgnoreCase("q"));
    }

    private static Seed beaconFromWiki() {
        Seed seed = new Seed();
        seed.add(1,1);
        seed.add(1,2);
        seed.add(2,1);
        seed.add(3,4);
        seed.add(4,4);
        seed.add(4,3);
        return seed;
    }

    private static Seed gliderFromWiki() {
        Seed seed = new Seed();
        seed.add(1,1);
        seed.add(1,3);
        seed.add(2,2);
        seed.add(2,3);
        seed.add(3,2);
        return seed;
    }
}
