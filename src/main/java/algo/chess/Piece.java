package algo.chess;

import java.util.List;

public abstract class Piece {
    PieceType type;
    Color color;
    String name;
    String logo;
    List<MoveRules> rules;

    public Piece(PieceType type, Color color, String name, String logo) {
        this.type = type;
        this.color = color;
        this.name = name;
        this.logo = logo;
        //this.rules = rules;
    }

    abstract boolean move(int from_row, int from_col, int to_row, int to_col) throws RuleBrokenException;
}
