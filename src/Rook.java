public class Rook extends ChessPiece {

    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
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

        if (column == toColumn) {
            for (int i = Math.min(line, toLine); i < Math.max(line, toLine); i++) {
                if (chessBoard.board[i][column] != null) {
                    if (chessBoard.board[i][column].getColor().equals(this.color) && i == toLine)
                        return false;
                    else if (!chessBoard.board[i][column].getColor().equals(this.color) && i == toLine)
                        return true;
                    else if (i != toLine && i != line) return false;
                }
            }

            if (chessBoard.board[toLine][column] != null) {
                if (chessBoard.board[toLine][column].getColor().equals(this.color) && chessBoard.board[toLine][column] != this)
                    return false;
                else
                    return !chessBoard.board[toLine][column].getColor().equals(this.color) && chessBoard.board[toLine][column] != this;
            } else return true;

        } else if (line == toLine) {

            for (int i = Math.min(toColumn, column); i < Math.max(column, toColumn); i++) {
                if (chessBoard.board[line][i] != null) {
                    if (chessBoard.board[line][i].getColor().equals(this.color) && i == toColumn)
                        return false;
                    else if (!chessBoard.board[line][i].getColor().equals(this.color) && i == toColumn)
                        return true;
                    else if (i != toLine && i != column) return false;
                }
            }

            if (chessBoard.board[toLine][toColumn] != null) {
                if (chessBoard.board[toLine][toColumn].getColor().equals(this.color) && chessBoard.board[toLine][toColumn] != this)
                    return false;
                else
                    return !chessBoard.board[toLine][toColumn].getColor().equals(this.color) && chessBoard.board[toLine][toColumn] != this;
            }
            return true;
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}