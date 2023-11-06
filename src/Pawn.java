public class Pawn extends ChessPiece {
    public Pawn(String color) {
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
        if (line == toLine && column == toColumn) {
            return false;
        }
        if ((line > 7 || line < 0) || (column > 7 || column < 0) || (toLine > 7 || toLine < 0)) {
            return false;
        }

        if (this.getColor().equals("White")) {
            if (line == 1) {
                return (line + 1 == toLine && column == toColumn) || (line + 2 == toLine && column == toColumn);
            }

            return line + 1 == toLine && column == toColumn;
        } else {
            if (line == 6) {
                return (line - 1 == toLine && column == toColumn) || (line - 2 == toLine && column == toColumn);
            }
            return line - 1 == toLine && column == toColumn;
        }
    }

    @Override
    public String getSymbol() {
        return "P";
    }


}