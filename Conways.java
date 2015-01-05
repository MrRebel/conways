import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.awt.Dimension;

public class Conways {

    private static JFrame frame;
    private static Culture culture;

    private static int FRAME_WIDTH = 1100;
    private static int FRAME_HEIGHT = 750;

    public static void main(String[] args) {
        Seed seed = getSeedFromCommandLineArgs(args);
        if (seed == null) {
            JOptionPane.showMessageDialog(null, "No seed given through command-line arguments or the arguments are misformatted.", "Seed Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        testFrame(seed);
    }

    private static void testFrame(Seed seed) {

        frame = new JFrame("Conway's Game of Life");
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        Dimension preferred = new CellComponent().getPreferredSize();
        int rows = (int) ( (frame.getSize().getHeight()-50) / preferred.getHeight() );
        int cols = (int) ( (frame.getSize().getWidth()-50) / preferred.getWidth() );
        culture = new Culture(seed, rows, cols);

        ConwaysComponent component = new ConwaysComponent(culture, false);
        culture.addTickListener(component);
        frame.add(component);

        frame.pack();

        frame.setVisible(true);

        while (true) {
            culture.tick();
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                System.out.println("Thread interrupted!");
            }
        }
    }

    private static void testText(Seed seed) {
        Scanner in = new Scanner(System.in);
        culture = new Culture(seed, 30,60);
        String input;
        do {
            System.out.println(culture);
            culture.tick();
            input = in.nextLine();
        } while (!input.equalsIgnoreCase("q"));
    }

    private static Seed getSeedFromCommandLineArgs(String[] args) {
        if (args.length < 1) return null;
        Seed seed = new Seed();
        for (String arg: args) {
            String newarg = "";
            for (int i = 0; i < arg.length(); i++) {
                if (arg.charAt(i) != ' ' && arg.charAt(i) != '(' && arg.charAt(i) != ')') newarg += arg.charAt(i);
            }
            arg = newarg;
            String[] strparts = arg.split(",");
            if (strparts.length != 2) return null;
            int[] intparts = new int[2];
            for (int i = 0; i < intparts.length; i++) {
                intparts[i] = Integer.parseInt(strparts[i]);
            }
            seed.add(intparts[0]-1, intparts[1]-1);
        }
        return seed;
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
