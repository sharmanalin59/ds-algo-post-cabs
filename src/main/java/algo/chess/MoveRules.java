package algo.chess;

public enum MoveRules {
    //king
    left_one("block"),
    right_one("block"),
    top_one("block"),
    bottom_one("block"),
    top_right_one("block"),
    top_left_one("block"),
    bottom_right_one("block"),
    bottom_left_one("block"),

    //pawn
    white_pawn_top_one("block"),
    black_pawn_bottom_one("block"),
    pawn_capture_left_right("block"),

    //knight
    knight_top_right("nonBlock"),
    knight_top_left("nonBlock"),
    knight_bottom_right("nonBlock"),
    knight_bottom_left("nonBlock"),

    //rook
    horizontal_many("block"),
    vertical_many("block"),

    //bishop
    left_diagonal_many("block"),
    right_diagonal_many("block");

    private final String type;
    private MoveRules(final String type) {
        this.type = type;
    }
}
