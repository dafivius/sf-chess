public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.color;
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
                checkIsInField(line) && checkIsInField(column) && checkIsInField(toLine) &&
                checkIsInField(toColumn) &&
                (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].color.equals(this.color)) &&
                chessBoard.board[line][column] != null) {
            if (!chessBoard.board[line][column].equals(this)) {
                return false;
            }

            if ((column == Math.min(column, toColumn) && line == Math.max(line, toLine)) ||
                    (toColumn == Math.min(column, toColumn) && toLine == Math.max(line, toLine))) {
                int fromLine = Math.max(line, toLine);
                int fromCol = Math.min(column, toColumn);
                int toCol = Math.max(column, toColumn);
                for (int i = 1; i < toCol - fromCol; i++) {
                    if (chessBoard.board[fromLine - i][fromCol + i] != null || chessBoard.board[fromLine - i][fromCol + i].color.equals(this.color) && fromLine - i == toLine) {
                        return false;
                    }
                }
                return true;
            } else {
                int fromLine = Math.min(line, toLine);
                int fromCol = Math.min(column, toColumn);
                int toCol = Math.max(column, toColumn);
                for (int i = 1; i < toCol - fromCol; i++) {
                    if (chessBoard.board[fromLine + i][fromCol + i] != null || chessBoard.board[fromLine + i][fromCol + i].color.equals(this.color) && fromLine + i == toLine) {
                        return false;
                    }
                }
                return true;
            }
        } else if (checkIsInField(line) && checkIsInField(column) && checkIsInField(toLine) && checkIsInField(toColumn)) {
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
                } else return true;
            } else return false;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }

}