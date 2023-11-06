public class King extends ChessPiece {

    /**
     * @param color
     */
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    /**
     * @param chessBoard
     * @param line
     * @param column
     * @return
     */
    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        if (!checkIsInField(line) || !checkIsInField(column)) {
            return false;
        }

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (chessBoard.board[i][j] != null) {
                    if (!chessBoard.board[i][j].getColor().equals(color) && chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    /**
     * @param chessBoard
     * @param line
     * @param column
     * @param toLine
     * @param toColumn
     * @return
     */
    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!checkIsInField(line) || !checkIsInField(column) || !checkIsInField(toLine) || !checkIsInField(toColumn)) {
            return false;
        }

        if (Math.abs(line - toLine) > 1 || Math.abs(column - toColumn) > 1 || isUnderAttack(chessBoard, toLine, toColumn)) {
            return false;
        }

        if (chessBoard.board[toLine][toColumn] != null) {
            return !chessBoard.board[toLine][toColumn].getColor().equals(color);
        }

        return true;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

}