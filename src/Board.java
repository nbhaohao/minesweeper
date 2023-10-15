import java.util.Random;

/**
 * 扫雷游戏棋盘
 */
public class Board {

    private static final double FACTOR = 0.15;

    /**
     * 单元格组成的二维矩阵
     */
    private final Cell[][] cells;
    /**
     * 棋盘高度
     */
    private final int height;
    /**
     * 棋盘宽度
     */
    private final int width;

    /**
     * 地雷个数
     */
    private int mineNumber;

    public Board(int height, int width) {
        this.height = height;
        this.width = width;
        this.cells = new Cell[height][width];
        this.mineNumber = (int) Math.round(height * width * FACTOR);
    }

    public Board(int height, int width, int mineNumber) {
        // TODO: 地雷个数大于棋盘单元格数量 异常情况处理
        if (mineNumber >= height * width) {
            // error?
        }
        this.height = height;
        this.width = width;
        this.mineNumber = mineNumber;
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

    private void initMines() {
        // Step 1: 随机生成坐标, 然后放置地雷.
        // Step 2: 计算每个非地雷格子周围地雷数量.
        Random random = new Random();
        // 随机生成坐标, 然后放置地雷, 地雷个数要减掉.
        for (int i = 0; i < mineNumber; i++) {
            int x, y;
            do {
                x = random.nextInt(width);
                y = random.nextInt(height);
            } while (cells[y][x].isMine());
            cells[y][x].setMine(true);
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Cell currentCell = cells[i][j];
                if (!currentCell.isMine()) {
                    int mineCount = 0;
                    // 坐标移动 (8个方向) dx = {-1, 0, 1}, dy= {-1, 0, 1}
                    for (int dy = -1; dy <= 1; dy++) {
                        for (int dx = -1; dx <= 1; dx++) {
                            int newY = i + dy;
                            int newX = j + dx;
                            if (checkMine(newX, newY)) {
                                mineCount++;
                            }
                        }
                    }
                    currentCell.setAdjacentMines(mineCount);
                }
            }
        }
    }

    private boolean checkMine(int newX, int newY) {
        return newX >= 0 && newY >= 0 && newX < width && newY < height && cells[newY][newX].isMine();
    }
}
