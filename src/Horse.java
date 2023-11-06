public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return "H";
    }

    @Override
    public String getColor() {
        return super.color;
    }

    /**
     *
     * @param chessBoard
     * @param line
     * @param column
     * @param toLine
     * @param toColumn
     * @return
     */
    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line != toLine && column != toColumn) {
            if ((line > 7 || line < 0) || (column > 7 || column < 0) || (toLine > 7 || toLine < 0)) {
                return false;
            } else {
                return (column - 1 == toColumn && line + 2 == toLine) || (column + 1 == toColumn && line + 2 == toLine) || (column - 1 == toColumn && line - 2 == toLine) || (column + 1 == toColumn && line - 2 == toLine) ||
                        (column - 2 == toColumn && line + 1 == toLine) || (column - 2 == toColumn && line - 1 == toLine) || (column + 2 == toColumn && line - 1 == toLine) || (column + 2 == toColumn && line + 1 == toLine);
            }
        }

        return false;
    }
}