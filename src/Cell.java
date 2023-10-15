/**
 * 定义扫雷游戏单元格的属性和行为
 */
public class Cell {
    /**
     * 是否有雷
     */
    private boolean mine;

    /**
     * 是否被揭示
     */
    private boolean revealed;

    /**
     * 是否被标记
     */
    private boolean flagged;

    /**
     * 周围地雷个数
     */
    private int adjacentMines;

    public Cell() {
    }

    public Cell(boolean mine, boolean revealed, boolean flagged, int adjacentMines) {
        this.mine = mine;
        this.revealed = revealed;
        this.flagged = flagged;
        this.adjacentMines = adjacentMines;
    }

    public boolean isMine() {
        return mine;
    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public int getAdjacentMines() {
        return adjacentMines;
    }

    public void setAdjacentMines(int adjacentMines) {
        this.adjacentMines = adjacentMines;
    }

    @Override
    public String toString() {
        // 单元格被用户标记, 显示 F
        if (isFlagged()) {
            return "F";
        }
        // 没有揭示的时候, 单元格都显示 ?
        if (!isRevealed()) {
            return "?";
        }
        // 单元格被揭示后, 是地雷, 显示*提示用户踩到地雷
        if (isRevealed() && isMine()) {
            return "*";
        }
        // 单元格被揭示后, 不是地雷, 显示周围雷数量的数字
        if (isRevealed() && !isMine() && getAdjacentMines() > 0) {
            return String.valueOf(getAdjacentMines());
        }
        // 单元格自动被揭示, 显示“”
        return "";
    }
}
