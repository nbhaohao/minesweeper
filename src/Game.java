public class Game {
    private boolean gameOver;
    private Board board;

    public Game(Board board) {
        this.board = board;
    }

    public void start() {
        System.out.println("Minesweeper is starting");
//        while (!gameOver) {
        // 显示当前棋盘状态
        board.printBoard();
//        }
    }

    public static void main(String[] args) {
        Game game = new Game(new Board(8, 10, 10));
        game.start();
    }
}
