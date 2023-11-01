/**
 * Class to help create two-dimensional abstractions for one-dimensional arrays
 */

package Assets;

public class MatrixGenerator {
    private int x = 0;
    private int y = 0;
    private int i = 0;
    private final int rows;
    private final int columns;
    private final boolean horizontal;

    public MatrixGenerator(int rows, int columns, boolean horizontal) {
        this.rows = rows;
        this.columns = columns;
        this.horizontal = horizontal;
    }

    public void next() {
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

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }
    public int i() {return i;}

}