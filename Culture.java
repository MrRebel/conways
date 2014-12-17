public class Culture {
    private boolean[][] culture;

    public Culture(Seed seed, int rows, int cols) {
        culture = new boolean[rows][cols];
        for (int i = 0; i < culture.length; i++) {
            for (int j = 0; j < culture[i].length; j++) {
                if (seed.get(i,j)) culture[i][j] = true;
                else culture[i][j] = false;
            }
        }
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
}
