public class Culture {
    private boolean[][] culture;

    private boolean hasListener = false;
    private TickListener listener;

    public Culture(Seed seed, int rows, int cols) {
        culture = new boolean[rows][cols];
        for (int i = 0; i < culture.length; i++) {
            for (int j = 0; j < culture[i].length; j++) {
                if (seed.get(i,j)) culture[i][j] = true;
                else culture[i][j] = false;
            }
        }
    }

    public int getRows() {
        return culture.length;
    }

    public int getCols() {
        return culture[0].length;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < culture.length; i++) {
            for (int j = 0; j < culture[i].length; j++) {
                if (culture[i][j] && j != culture[i].length - 1) str += "1 ";
                else if (!culture[i][j] && j != culture[i].length - 1) str += "0 ";
                else if (culture[i][j] && j == culture[i].length - 1 && i != culture.length - 1) str += "1\n";
                else if (!culture[i][j] && j == culture[i].length - 1 && i != culture.length - 1) str += "0\n";
                else if (culture[i][j] && j == culture[i].length - 1 && i == culture.length - 1) str += "1";
                else if (!culture[i][j] && j == culture[i].length - 1 && i == culture.length - 1) str += "0";
            }
        }
        return str;
    }

    public boolean isAlive(int row, int col) {
        if ( (row >= 0 && row < culture.length) && (col >= 0 && col < culture[row].length) ) return culture[row][col];
        else return false;
    }

    public void tick() {
        tick(1);
    }

    public void tick(int howMany) {
        boolean[][] temp = new boolean[culture.length][culture[0].length];
        for (int i = 0; i < culture.length; i++) {
            for (int j = 0; j < culture[i].length; j++) {
                int neighbors = 0;
                boolean upSafe = i - 1 >= 0;
                boolean downSafe = i + 1 < culture.length;
                boolean leftSafe = j - 1 >= 0;
                boolean rightSafe = j + 1 < culture[i].length;
                boolean upLeftSafe = upSafe && leftSafe;
                boolean upRightSafe = upSafe && rightSafe;
                boolean downRightSafe = downSafe && rightSafe;
                boolean downLeftSafe = downSafe && leftSafe;
                if (upLeftSafe    && culture[i-1][j-1]) neighbors++;
                if (upSafe        && culture[i-1][j])   neighbors++;
                if (upRightSafe   && culture[i-1][j+1]) neighbors++;
                if (rightSafe     && culture[i][j+1])   neighbors++;
                if (downRightSafe && culture[i+1][j+1]) neighbors++;
                if (downSafe      && culture[i+1][j])   neighbors++;
                if (downLeftSafe  && culture[i+1][j-1]) neighbors++;
                if (leftSafe      && culture[i][j-1])   neighbors++;
                if (neighbors < 2 || neighbors > 3) temp[i][j] = false;
                if ( (neighbors == 2 || neighbors == 3) && culture[i][j] ) temp[i][j] = true;
                if ( !culture[i][j] && neighbors == 3) temp[i][j] = true;
            }
        }
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                culture[i][j] = temp[i][j];
            }
        }
        if (hasListener) listener.tickPerformed();
        if (howMany > 1) tick(howMany - 1);
    }

    public void addTickListener(TickListener listener) {
        this.hasListener = true;
        this.listener = listener;
    }
}
