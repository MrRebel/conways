import javax.swing.JFrame;
import java.util.Scanner;

public class Conways {

//    private static JFrame frame = new JFrame("Conway's Game of Life");
    private static Culture culture;

    public static void main(String[] args) {
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

    public static Seed beaconFromWiki() {
        Seed seed = new Seed();
        seed.add(1,1);
        seed.add(1,2);
        seed.add(2,1);
        seed.add(3,4);
        seed.add(4,4);
        seed.add(4,3);
        return seed;
    }

    public static Seed gliderFromWiki() {
        Seed seed = new Seed();
        seed.add(1,1);
        seed.add(1,3);
        seed.add(2,2);
        seed.add(2,3);
        seed.add(3,2);
        return seed;
    }
}
