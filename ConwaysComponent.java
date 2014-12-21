import javax.swing.JComponent;
import java.awt.*;

public class ConwaysComponent extends JComponent implements TickListener {
    private int cellWidth;
    private int cellHeight;
    private int compWidth;
    private int compHeight;
    private Dimension compDimension;
    private Culture culture;
    private CellComponent[][] components;

    private final boolean PRINT_BORDERS;

    public ConwaysComponent(Culture culture) {
        this(culture, true);
    }

    public ConwaysComponent(Culture culture, boolean printBorders) {
        this.PRINT_BORDERS = printBorders;
        this.setCulture(culture);
    }

    public void setCulture(Culture culture) {
        this.culture = culture;
        cellWidth = (int) new CellComponent().getPreferredSize().getWidth();
        cellHeight = (int) new CellComponent().getPreferredSize().getHeight();
        compWidth = cellWidth * culture.getCols();
        compHeight = cellHeight * culture.getRows();
        compDimension = new Dimension(compWidth, compHeight);
        makeCells();
    }

    private void makeCells() {
        this.setLayout(null);
        components = new CellComponent[culture.getRows()][culture.getCols()];
        for (int row = 0; row < components.length; row++) {
            for (int col = 0; col < components[row].length; col++) {
                components[row][col] = new CellComponent(culture.isAlive(row, col), PRINT_BORDERS);
                this.add(components[row][col]);
                components[row][col].setBounds(cellWidth*col, cellHeight*row, cellWidth, cellHeight);
            }
        }
    }

    public void tickPerformed() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        for (int row = 0; row < components.length; row++) {
            for (int col = 0; col < components[row].length; col++) {
                components[row][col].setState(culture.isAlive(row, col));
            }
        }
    }

    @Override
    public Dimension getMinimumSize() {
        return compDimension;
    }
    @Override
    public Dimension getPreferredSize() {
        return compDimension;
    }
    @Override
    public Dimension getMaximumSize() {
        return compDimension;
    }
}
