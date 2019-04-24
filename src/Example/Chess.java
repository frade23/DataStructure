package Example;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Chess extends JFrame {
    private final int ROWS;
    private final int COLS;
    private int CELL_WIDTH = 70;
    private int CELL_HEIGHT = 70;
    private int frameTopBorder;
    private int frameBorder;
    private final String emptyImagePath = "../images/empty.png";
    private final String blackImagePath = "../images/black.png";
    private final String whiteImagePath = "../images/white.png";
    private Logic logic;
    private JPanel jp;
    private JLabel[][] cells;
    private ImageIcon emptyImage;
    private ImageIcon blackImage;
    private ImageIcon whiteImage;

    public static void main(String[] var0) {
        Chess var1 = new Chess(16, 16);
        var1.run();
    }

    public Chess(int var1, int var2) {
        this.ROWS = var1;
        this.COLS = var2;
        this.emptyImage = new ImageIcon((new ImageIcon("../images/empty.png")).getImage().getScaledInstance(this.CELL_WIDTH, this.CELL_HEIGHT, 0));
        this.blackImage = new ImageIcon((new ImageIcon("../images/black.png")).getImage().getScaledInstance(this.CELL_WIDTH, this.CELL_HEIGHT, 0));
        this.whiteImage = new ImageIcon((new ImageIcon("../images/white.png")).getImage().getScaledInstance(this.CELL_WIDTH, this.CELL_HEIGHT, 0));
        this.init();
    }

    private void init() {
        this.logic = new Logic(this.ROWS, this.COLS);
        this.jp = new JPanel();
        this.jp.setLayout(new GridLayout(this.ROWS, this.COLS, 0, 0));
        this.cells = new JLabel[this.ROWS][this.COLS];

        for(int var1 = 0; var1 < this.ROWS; ++var1) {
            for(int var2 = 0; var2 < this.COLS; ++var2) {
                this.cells[var1][var2] = new JLabel();
                this.cells[var1][var2].setBorder((Border)null);
                this.jp.add(this.cells[var1][var2]);
            }
        }

        this.addListener();
        this.add(this.jp);
        this.draws();
    }

    private void addListener() {
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent var1) {
                int var2 = (var1.getY() - Chess.this.frameTopBorder) / Chess.this.CELL_HEIGHT;
                int var3 = (var1.getX() - Chess.this.frameBorder) / Chess.this.CELL_WIDTH;
                if (!Chess.this.logic.getOver()) {
                    Chess.this.logic.update(new WCoordinate(var2, var3));
                    Chess.this.draws();
                }

            }
        });
    }

    public void run() {
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo((Component)null);
        this.setVisible(true);
        this.setDefaultCloseOperation(3);
        this.frameBorder = (this.getWidth() - this.COLS * this.CELL_WIDTH) / 2;
        this.frameTopBorder = this.getHeight() - this.ROWS * this.CELL_HEIGHT - this.frameBorder;
    }

    private void draws() {
        int[][] var1 = this.logic.getMap();

        for(int var2 = 0; var2 < this.ROWS; ++var2) {
            for(int var3 = 0; var3 < this.COLS; ++var3) {
                this.cells[var2][var3].setSize(this.CELL_WIDTH, this.CELL_HEIGHT);
                switch(var1[var2][var3]) {
                    case 0:
                        this.cells[var2][var3].setIcon(this.emptyImage);
                        break;
                    case 1:
                        this.cells[var2][var3].setIcon(this.blackImage);
                        break;
                    case 2:
                        this.cells[var2][var3].setIcon(this.whiteImage);
                }
            }
        }

        int var10000 = this.logic.getCurrentRole();
        Logic var10001 = this.logic;
        if (var10000 == 1) {
            this.setTitle("轮黑方走棋   黑方:" + this.logic.getBlack() + " 白方:" + this.logic.getWhite());
        } else {
            this.setTitle("轮白方走棋   黑方:" + this.logic.getBlack() + " 白方:" + this.logic.getWhite());
        }

        if (this.logic.isOver()) {
            String var4 = " 平手 ";
            if (this.logic.getBlack() > this.logic.getWhite()) {
                var4 = " 黑方赢了 ";
            } else if (this.logic.getBlack() < this.logic.getWhite()) {
                var4 = " 白方赢了 ";
            }

            String var5 = "结束。结果:" + var4 + " 黑方:" + this.logic.getBlack() + " 白方:" + this.logic.getWhite();
            this.setTitle(var5);
            this.msg(var5);
        }

    }

    private void msg(String var1) {
        Object[] var2 = new Object[]{"再来一次", "退出"};
        Integer var3 = JOptionPane.showOptionDialog((Component)null, var1, "Information", -1, 1, (Icon)null, var2, var2[0]);
        switch((Integer)var3) {
            case 0:
                this.init();
                break;
            case 1:
                System.exit(0);
        }

    }

    public void update(Graphics var1) {
    }
}