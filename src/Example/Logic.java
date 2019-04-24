package Example;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Logic {
    public static final int EMPTY = 0;
    public static final int BLACK = 1;
    public static final int WHITE = 2;
    private final int ROWS;
    private final int COLS;
    private int[][] map;
    private List<WCoordinate> possessiveCellsList = new ArrayList();
    private int currentRole;
    private int black;
    private int white;
    private boolean over = false;

    public static void main(String[] var0) {
        Logic var1 = new Logic(2, 3);
        var1.run();
    }

    public Logic(int var1, int var2) {
        this.ROWS = var1;
        this.COLS = var2;
        this.map = new int[this.ROWS][this.COLS];
        this.init(1);
    }

    private void init(int var1) {
        this.currentRole = var1;
        this.black = 2;
        this.white = 2;
        this.map[this.ROWS / 2 - 1][this.COLS / 2 - 1] = this.currentRole;
        this.map[this.ROWS / 2 - 1][this.COLS / 2] = this.getNext(this.currentRole);
        this.map[this.ROWS / 2][this.COLS / 2 - 1] = this.getNext(this.currentRole);
        this.map[this.ROWS / 2][this.COLS / 2] = this.currentRole;
    }

    public void init() {
        for(int var1 = 0; var1 < this.ROWS; ++var1) {
            for(int var2 = 0; var2 < this.COLS; ++var2) {
                this.map[var1][var2] = 0;
            }
        }

        this.possessiveCellsList.clear();
        this.init(1);
    }

    public int getBlack() {
        return this.black;
    }

    public int getWhite() {
        return this.white;
    }

    public int getCurrentRole() {
        return this.currentRole;
    }

    public int[][] getMap() {
        return this.map;
    }

    public boolean getOver() {
        return this.over;
    }

    public void run() {
        while(true) {
            if (!this.isOver()) {
                this.showmap();
                Scanner var1 = new Scanner(System.in);
                String var2 = var1.next();
                if (!var2.equals("0")) {
                    WCoordinate var3 = this.getCoordinate(var2);
                    if (this.isInner(var3) && this.isEmpty(var3) && this.canPossessive(var3, false)) {
                        this.updateMap(this.possessiveCellsList);
                        this.currentRole = this.getNext(this.currentRole);
                    }
                    continue;
                }
            }

            this.showmap();
            this.caculate();
            System.out.println("game over, result is : black:" + this.black + " white:" + this.white);
            return;
        }
    }

    public int update(WCoordinate var1) {
        if (!this.isInner(var1)) {
            return -1;
        } else if (!this.isEmpty(var1)) {
            return -1;
        } else if (!this.canPossessive(var1, false)) {
            return -1;
        } else {
            this.updateMap(this.possessiveCellsList);
            this.currentRole = this.getNext(this.currentRole);
            return 0;
        }
    }

    public boolean isOver() {
        if (this.black != 0 && this.white != 0) {
            for(int var1 = 0; var1 < this.ROWS; ++var1) {
                for(int var2 = 0; var2 < this.COLS; ++var2) {
                    if (this.map[var1][var2] == 0 && this.canPossessive(new WCoordinate(var1, var2), true)) {
                        return false;
                    }
                }
            }

            this.over = true;
            this.caculate();
            this.currentRole = this.getNext(this.currentRole);
            return true;
        } else {
            this.over = true;
            this.caculate();
            this.currentRole = this.getNext(this.currentRole);
            return true;
        }
    }

    private void caculate() {
        this.black = 0;
        this.white = 0;

        for(int var1 = 0; var1 < this.ROWS; ++var1) {
            for(int var2 = 0; var2 < this.COLS; ++var2) {
                if (this.map[var1][var2] == 1) {
                    ++this.black;
                }

                if (this.map[var1][var2] == 2) {
                    ++this.white;
                }
            }
        }

    }

    private WCoordinate getCoordinate(String var1) {
        int var2 = Integer.parseInt(var1.split(",")[0]);
        int var3 = Integer.parseInt(var1.split(",")[1]);
        return new WCoordinate(var2, var3);
    }

    private boolean isInner(WCoordinate var1) {
        return var1.getRow() >= 0 && var1.getRow() < this.ROWS && var1.getCol() >= 0 && var1.getCol() < this.COLS;
    }

    private boolean isEmpty(WCoordinate var1) {
        return this.map[var1.getRow()][var1.getCol()] == 0;
    }

    private boolean canPossessive(WCoordinate var1, boolean var2) {
        this.possessiveCellsList.clear();
        this.eastProcess(var1);
        this.southEastProcess(var1);
        this.southProcess(var1);
        this.southWestProcess(var1);
        this.westProcess(var1);
        this.northWestProcess(var1);
        this.northProcess(var1);
        this.northEastProcess(var1);
        if (this.possessiveCellsList.size() > 0) {
            if (!var2) {
                this.map[var1.getRow()][var1.getCol()] = this.currentRole;
            }

            return true;
        } else {
            return false;
        }
    }

    private void updateMap(List<WCoordinate> var1) {
        WCoordinate var3;
        for(Iterator var2 = var1.iterator(); var2.hasNext(); this.map[var3.getRow()][var3.getCol()] = this.currentRole) {
            var3 = (WCoordinate)var2.next();
        }

        this.caculate();
    }

    private void eastProcess(WCoordinate var1) {
        ArrayList var2 = new ArrayList();
        boolean var3 = false;
        int var4 = var1.getRow();

        for(int var5 = var1.getCol() + 1; var5 < this.COLS; ++var5) {
            if (this.map[var4][var5] == this.currentRole) {
                var3 = true;
                break;
            }

            if (this.map[var4][var5] == 0) {
                var3 = false;
                break;
            }

            var2.add(new WCoordinate(var4, var5));
        }

        if (!var3) {
            var2.clear();
        }

        if (var2.size() > 0) {
            this.possessiveCellsList.addAll(var2);
        }

    }

    private void southEastProcess(WCoordinate var1) {
        ArrayList var2 = new ArrayList();
        boolean var3 = false;
        int var4 = var1.getRow() + 1;

        for(int var5 = var1.getCol() + 1; var5 < this.COLS && var4 < this.ROWS; ++var5) {
            if (this.map[var4][var5] == this.currentRole) {
                var3 = true;
                break;
            }

            if (this.map[var4][var5] == 0) {
                var3 = false;
                break;
            }

            var2.add(new WCoordinate(var4, var5));
            ++var4;
        }

        if (!var3) {
            var2.clear();
        }

        if (var2.size() > 0) {
            this.possessiveCellsList.addAll(var2);
        }

    }

    private void southProcess(WCoordinate var1) {
        ArrayList var2 = new ArrayList();
        boolean var3 = false;
        int var4 = var1.getRow() + 1;

        for(int var5 = var1.getCol(); var4 < this.ROWS; ++var4) {
            if (this.map[var4][var5] == this.currentRole) {
                var3 = true;
                break;
            }

            if (this.map[var4][var5] == 0) {
                var3 = false;
                break;
            }

            var2.add(new WCoordinate(var4, var5));
        }

        if (!var3) {
            var2.clear();
        }

        if (var2.size() > 0) {
            this.possessiveCellsList.addAll(var2);
        }

    }

    private void southWestProcess(WCoordinate var1) {
        ArrayList var2 = new ArrayList();
        boolean var3 = false;
        int var4 = var1.getRow() + 1;

        for(int var5 = var1.getCol() - 1; var4 < this.ROWS && var5 >= 0; --var5) {
            if (this.map[var4][var5] == this.currentRole) {
                var3 = true;
                break;
            }

            if (this.map[var4][var5] == 0) {
                var3 = false;
                break;
            }

            var2.add(new WCoordinate(var4, var5));
            ++var4;
        }

        if (!var3) {
            var2.clear();
        }

        if (var2.size() > 0) {
            this.possessiveCellsList.addAll(var2);
        }

    }

    private void westProcess(WCoordinate var1) {
        ArrayList var2 = new ArrayList();
        boolean var3 = false;
        int var4 = var1.getRow();

        for(int var5 = var1.getCol() - 1; var5 >= 0; --var5) {
            if (this.map[var4][var5] == this.currentRole) {
                var3 = true;
                break;
            }

            if (this.map[var4][var5] == 0) {
                var3 = false;
                break;
            }

            var2.add(new WCoordinate(var4, var5));
        }

        if (!var3) {
            var2.clear();
        }

        if (var2.size() > 0) {
            this.possessiveCellsList.addAll(var2);
        }

    }

    private void northWestProcess(WCoordinate var1) {
        ArrayList var2 = new ArrayList();
        boolean var3 = false;
        int var4 = var1.getRow() - 1;

        for(int var5 = var1.getCol() - 1; var4 >= 0 && var5 >= 0; --var5) {
            if (this.map[var4][var5] == this.currentRole) {
                var3 = true;
                break;
            }

            if (this.map[var4][var5] == 0) {
                var3 = false;
                break;
            }

            var2.add(new WCoordinate(var4, var5));
            --var4;
        }

        if (!var3) {
            var2.clear();
        }

        if (var2.size() > 0) {
            this.possessiveCellsList.addAll(var2);
        }

    }

    private void northProcess(WCoordinate var1) {
        ArrayList var2 = new ArrayList();
        boolean var3 = false;
        int var4 = var1.getRow() - 1;

        for(int var5 = var1.getCol(); var4 >= 0; --var4) {
            if (this.map[var4][var5] == this.currentRole) {
                var3 = true;
                break;
            }

            if (this.map[var4][var5] == 0) {
                var3 = false;
                break;
            }

            var2.add(new WCoordinate(var4, var5));
        }

        if (!var3) {
            var2.clear();
        }

        if (var2.size() > 0) {
            this.possessiveCellsList.addAll(var2);
        }

    }

    private void northEastProcess(WCoordinate var1) {
        ArrayList var2 = new ArrayList();
        boolean var3 = false;
        int var4 = var1.getRow() - 1;

        for(int var5 = var1.getCol() + 1; var4 >= 0 && var5 < this.COLS; ++var5) {
            if (this.map[var4][var5] == this.currentRole) {
                var3 = true;
                break;
            }

            if (this.map[var4][var5] == 0) {
                var3 = false;
                break;
            }

            var2.add(new WCoordinate(var4, var5));
            --var4;
        }

        if (!var3) {
            var2.clear();
        }

        if (var2.size() > 0) {
            this.possessiveCellsList.addAll(var2);
        }

    }

    private void showmap() {
        System.out.print("\n   ");

        int var1;
        for(var1 = 0; var1 < this.COLS; ++var1) {
            System.out.print(var1 + "  ");
        }

        System.out.println("");

        for(var1 = 0; var1 < this.ROWS; ++var1) {
            System.out.print(var1 + "  ");

            for(int var2 = 0; var2 < this.COLS; ++var2) {
                System.out.print(this.map[var1][var2] + "  ");
            }

            System.out.println("");
        }

    }

    private int getNext(int var1) {
        return var1 == 1 ? 2 : 1;
    }
}

