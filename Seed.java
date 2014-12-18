import java.util.ArrayList;

public class Seed {
    private ArrayList<ArrayList<Integer>> coords = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> rowValues = new ArrayList<Integer>();
    private ArrayList<Integer> colValues = new ArrayList<Integer>();

    public Seed() {
        coords.add(rowValues);
        coords.add(colValues);
    }

    public void add(int row, int col) {
        coords.get(0).add(row);
        coords.get(1).add(col);
    }

    public boolean get(int row, int col) {
        boolean rowBool = false;
        boolean colBool = false;
        for (int i = 0; i < coords.get(1).size(); i++) {
            if (coords.get(0).get(i) == row) rowBool = true;
            if (coords.get(1).get(i) == col) colBool = true;
            if (rowBool && colBool) return true;
            rowBool = false;
            colBool = false;
        }
        return false;
    }
}
