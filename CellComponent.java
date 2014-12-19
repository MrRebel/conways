import javax.swing.JComponent;
import java.awt.*;

public class CellComponent extends JComponent {
    private final int CELL_WIDTH = 5;
    private final int CELL_HEIGHT = CELL_WIDTH;
    private final int BORDER_WIDTH = CELL_WIDTH/5;
    private final Dimension CELL_DIMENSION = new Dimension(CELL_WIDTH,CELL_HEIGHT);

    private boolean alive;

    public CellComponent() {
        alive = false;
    }

    public CellComponent(boolean alive) {
        this.alive = alive;
    }

    public void setState(boolean alive) {
        this.alive = alive;
    }

    public boolean getState() {
        return alive;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2d g2 = (Graphics2D) g;

        if (alive) alivePaint(g2);
        else deadPaint(g2);

        g2.dispose();
    }

    private void alivePaint(Graphics2D g2) {
        g2.setStroke(new BasicStroke(BORDER_WIDTH) ));
        g2.setColor(Color.BLACK);
        g2.fillRect(0+BORDER_WIDTH, 0+BORDER_WIDTH,
        CELL_WIDTH-BORDER_WIDTH, CELL_HEIGHT-BORDER_WIDTH)
        // print border
        g2.setColor(Color.GRAY);
        g2.drawLine(0,0,CELL_WIDTH,0);
        g2.drawLine(CELL_WIDTH,0,CELL_WIDTH,CELL_HEIGHT);
        g2.drawLine(CELL_WIDTH,CELL_HEIGHT,0,CELL_HEIGHT);
        g2.drawLine(0,CELL_HEIGHT,0,0);
    }

    private void deadPaint(Graphics2D g2) {
        g2.setStroke(new BasicStroke(BORDER_WIDTH) ));
        g2.setColor(Color.WHITE);
        g2.fillRect(0+BORDER_WIDTH, 0+BORDER_WIDTH,
                CELL_WIDTH-BORDER_WIDTH, CELL_HEIGHT-BORDER_WIDTH)
        // print border
        g2.setColor(Color.GRAY);
        g2.drawLine(0,0,CELL_WIDTH,0);
        g2.drawLine(CELL_WIDTH,0,CELL_WIDTH,CELL_HEIGHT);
        g2.drawLine(CELL_WIDTH,CELL_HEIGHT,0,CELL_HEIGHT);
        g2.drawLine(0,CELL_HEIGHT,0,0);
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
