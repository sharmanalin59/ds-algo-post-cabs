package algo.chess;

import java.util.Arrays;
import java.util.List;

public class King extends Piece {

    List<MoveRules> rules = Arrays.asList(
            MoveRules.left_one,
            MoveRules.right_one,
            MoveRules.top_one,
            MoveRules.bottom_one,
            MoveRules.top_left_one,
            MoveRules.top_right_one,
            MoveRules.bottom_left_one,
            MoveRules.bottom_right_one
    );

    public King(PieceType type, Color color, String name, String logo) {
        super(type, color, name, logo);
    }

    @Override
    boolean move(int from_row, int from_col, int to_row, int to_col) throws RuleBrokenException {
        return false;
    }
/*
    @Override
    boolean move(int from_row, int from_col, int to_row, int to_col) throws RuleBrokenException {
        return false;
    }*/
}
