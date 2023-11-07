public class Bishop extends ChessPiece {

    /**
     * @param color
     */
    public Bishop(String color) {
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
     * @param toLine
     * @param toColumn
     * @return
     */
    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line != toLine && column != toColumn &&
                Math.max(line, toLine) - Math.min(line, toLine) == Math.max(column, toColumn) - Math.min(column, toColumn) &&
                checkIsInField(line) && checkIsInField(column) && checkIsInField(toLine) && checkIsInField(toColumn) &&
                (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].color.equals(this.color)) &&
                chessBoard.board[line][column] != null) {
            if (!chessBoard.board[line][column].equals(this)) {
                return false;
            }

            if ((column == Math.min(column, toColumn) && line == Math.max(line, toLine)) ||
                    (toColumn == Math.min(column, toColumn) && toLine == Math.max(line, toLine))) {
                int fromLine = Math.max(line, toLine);
                int fromColumn = Math.min(column, toColumn);
                int toCol = Math.max(column, toColumn);
                for (int i = 1; i < toCol - fromColumn; i++) {
//                    System.out.println(chessBoard.board[fromLine - i][fromColumn + i]);
                    if (chessBoard.board[fromLine - i][fromColumn + i] != null || chessBoard.board[fromLine - i][fromColumn + i].color.equals(this.color) && fromLine - i == toLine) {
                        return false;
                    }
                }
                return true;
            } else {
                int fromLine = Math.min(line, toLine);
                int fromColumn = Math.min(column, toColumn);
                int toC = Math.max(column, toColumn);
                for (int i = 1; i < toC - fromColumn; i++) {
                    System.out.println(chessBoard.board[fromLine - i][fromColumn + i]);
                    if (chessBoard.board[fromLine + i][fromColumn + i] != null || chessBoard.board[fromLine + i][fromColumn + i].color.equals(this.color) && fromLine + i == toLine) {
                        return false;
                    }
                }
                return true;
            }
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }

}