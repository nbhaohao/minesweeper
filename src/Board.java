/**
 * 扫雷游戏棋盘
 */
public class Board {
    /**
     * 单元格组成的二维矩阵
     */
    private Cell[][] cells;
    /**
     * 棋盘高度
     */
    private int height;
    /**
     * 棋盘宽度
     */
    private int width;

    public Board(int height, int width) {
        this.height = height;
        this.width = width;
        this.cells = new Cell[height][width];
    }

    public Cell[][] getCells() {
        return cells;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
