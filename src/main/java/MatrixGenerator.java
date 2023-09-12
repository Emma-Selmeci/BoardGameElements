public class MatrixGenerator {
    private int x = 0;
    private int y = 0;
    private int i = 0;
    private final int rows;
    private final int columns;
    private final boolean horizontal;

    MatrixGenerator(int rows, int columns, boolean horizontal) {
        this.rows = rows;
        this.columns = columns;
        this.horizontal = horizontal;
    }

    void next() {
        i++;
        if(horizontal) {
            if(x == columns-1) {
                x = 0;
                y++;
            } else x++;
        } else {
            if(y == rows-1) {
                y = 0;
                x++;
            } else y++;
        }
    }

    int x() {
        return x;
    }

    int y() {
        return y;
    }
    int i() {return i;}

}