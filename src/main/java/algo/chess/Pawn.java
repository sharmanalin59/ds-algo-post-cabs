package algo.chess;

import java.util.Arrays;
import java.util.List;

public class Pawn extends Piece {

    List<MoveRules> rules = Arrays.asList(MoveRules.horizontal_many, MoveRules.vertical_many);
    public Pawn(PieceType type, Color color, String name, String logo) {
        super(type, color, name, logo);
    }

    @Override
    boolean move(int from_row, int from_col, int to_row, int to_col) throws RuleBrokenException {
        return false;
    }
}
