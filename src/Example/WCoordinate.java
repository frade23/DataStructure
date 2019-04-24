package Example;

public class WCoordinate {
    private int row;
    private int col;

    public WCoordinate(int var1, int var2) {
        this.row = var1;
        this.col = var2;
    }

    public void setRow(int var1) {
        this.row = var1;
    }

    public int getRow() {
        return this.row;
    }

    public void setCol(int var1) {
        this.col = var1;
    }

    public int getCol() {
        return this.col;
    }

    public String toString() {
        return " row: " + this.row + " col: " + this.col + " ";
    }
}

