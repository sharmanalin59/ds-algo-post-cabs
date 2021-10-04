package algo.chess;

import java.util.List;

public class ApplyRules implements RuleInterface {

    boolean validateCoordinates(ChessBoard board, int from_row, int from_col,
                                int to_row, int to_col) {
        return true;
    }

    boolean validatePlayer(Color play, ChessBoard board, int from_row, int from_col, int to_row, int to_col) {
        return (board.arr[from_row][from_col].piece != null)
                && board.arr[from_row][from_col].piece.color == play
                && board.arr[to_row][to_col].piece.color != play;
    }

    public boolean is_valid_left_one(ChessBoard board,
                      int from_row, int from_col, int to_row, int to_col) {
        if(from_col -1 == to_col && from_row == to_row) {
            return true;
        }
        return false;
    }
    public Piece left_one(ChessBoard board,
                              int from_row, int from_col, int to_row, int to_col) {
        //is valid
            Piece from = board.arr[from_row][from_col].piece;
            board.arr[from_row][from_col].piece = null;
            Piece to = board.arr[to_row][to_col].piece;
            board.arr[to_row][to_col].piece = from;
            return to;
    }

    @Override
    public Piece moveCaptured(Color play, ChessBoard board,
                                int from_row, int from_col, int to_row, int to_col,
                                List<MoveRules> moveRules) {
        if(!validatePlayer(play, board, from_row, from_col, to_row, to_col)) {
            throw new RuntimeException("Exception... Play only "+ play.name());
        }
        if(!validateCoordinates(board, from_row, from_col, to_row, to_col)) {
            throw new RuntimeException("Exception... Play only " + play.name());
        }

        for(MoveRules moveRule: moveRules) {
            switch (moveRule) {
                case left_one:
                    if(is_valid_left_one(board,from_row,from_col,to_row,to_col)) {
                        return left_one(board, from_row, from_col, to_row, to_col);
                    }
                    break;
                case right_one:
                    break;
                case top_one:
                    break;
                case bottom_one:
                    break;
                case top_right_one:
                    break;
                case top_left_one:
                    break;
                case bottom_right_one:
                    break;
                case bottom_left_one:
                    break;

                    //pawn
                case white_pawn_top_one:
                    break;
                case black_pawn_bottom_one:
                    break;
                case pawn_capture_left_right:
                    break;

                    //knight
                case knight_top_right:
                    break;
                case knight_top_left:
                    break;
                case knight_bottom_right:
                    break;
                case knight_bottom_left:
                    break;

                    //rook
                case horizontal_many:
                    break;
                case vertical_many:
                    break;

                    //bishop
                case left_diagonal_many:
                    break;
                case right_diagonal_many:
                    break;
            }
        }
        throw new RuntimeException("Invalid move..");
        //return to_col >= 0 && from_col - to_col == 1;
    }

}
