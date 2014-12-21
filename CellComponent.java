import javax.swing.JComponent;
import java.awt.*;

public class CellComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 10;
    private static final int DEFAULT_HEIGHT = DEFAULT_WIDTH;
    private static final Dimension DEFAULT_DIMENSION = new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);

    private final int CELL_WIDTH;
    private final int CELL_HEIGHT;
    private final int BORDER_WIDTH;
    private final Dimension CELL_DIMENSION;
    private final boolean PRINT_BORDER;

    private boolean alive;

    public CellComponent() {
        this(false, DEFAULT_DIMENSION, true);
    }

    public CellComponent(boolean alive) {
        this(alive, DEFAULT_DIMENSION, true);
    }

    public CellComponent(boolean alive, boolean printBorder) {
        this(alive, DEFAULT_DIMENSION, printBorder);
    }

    public CellComponent(boolean alive, int width, int height) {
        this(alive, new Dimension(width, height), true);
    }

    public CellComponent(boolean alive, int width, int height, boolean printBorder) {
        this(alive, new Dimension(width, height), printBorder);
    }

    public CellComponent(int width, int height) {
        this(false, new Dimension(width, height), true);
    }

    public CellComponent(int width, int height, boolean printBorder) {
        this(false, new Dimension(width, height), printBorder);
    }

    public CellComponent(boolean alive, Dimension dimensions, boolean printBorder) {
        this.alive = alive;
        CELL_WIDTH = (int) dimensions.getWidth();
        CELL_HEIGHT = (int) dimensions.getHeight();
        BORDER_WIDTH = CELL_WIDTH < CELL_HEIGHT ? CELL_WIDTH/5 : CELL_HEIGHT/5;
        CELL_DIMENSION = new Dimension(dimensions);
        PRINT_BORDER = printBorder;
    }

    public void setState(boolean alive) {
        this.alive = alive;
    }

    public boolean getState() {
        return alive;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        if (alive) alivePaint(g2);
        else deadPaint(g2);

        g2.dispose();
    }

    private void alivePaint(Graphics2D g2) {
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, CELL_WIDTH, CELL_HEIGHT);
        borderPaint(g2);
    }

    private void deadPaint(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, CELL_WIDTH, CELL_HEIGHT);
        borderPaint(g2);
    }

    private void borderPaint(Graphics2D g2) {
        if (PRINT_BORDER) {
            g2.setStroke(new BasicStroke(BORDER_WIDTH) );
            g2.setColor(Color.GRAY);
            g2.drawRect(0, 0, CELL_WIDTH, CELL_HEIGHT);
        }
    }

    @Override
    public Dimension getMinimumSize() {
        return CELL_DIMENSION;
    }
    @Override
    public Dimension getPreferredSize() {
        return CELL_DIMENSION;
    }
    @Override
    public Dimension getMaximumSize() {
        return CELL_DIMENSION;
    }
}
