package algo.chess;

import java.util.List;

public interface RuleInterface {
    public Piece moveCaptured(Color play, ChessBoard board,
                                int from_row, int from_col, int to_row, int to_col,
                                List<MoveRules> moveRule);

    default void moveleft() {

    }
}
