package algo.chess;

public class ChessBoard {

    ChessBoard() {
        init();
    }

    void init() {
        for(int i = 2; i < 6; i++) {
            for(int j = 0; j < 8; j++) {
                arr[i][j] = new Square(null);
            }
        }
        for(int j = 0; j < 8; j++) {
            arr[1][j] = new Square(new WhitePawn(PieceType.PAWN, Color.White, "", ""));
            arr[6][j] = new Square(new Pawn(PieceType.PAWN, Color.Black, "", ""));
        }

        arr[0][0] = new Square(new Rook(PieceType.ROOK, Color.Black, "", ""));
        arr[0][7] = new Square(new Rook(PieceType.ROOK, Color.Black, "", ""));
        arr[0][6] = new Square(new Pawn(PieceType.KNIGHT, Color.Black, "", ""));
        arr[0][1] = new Square(new Pawn(PieceType.KNIGHT, Color.Black, "", ""));
        arr[0][2] = new Square(new Pawn(PieceType.BISHOP, Color.Black, "", ""));
        arr[0][5] = new Square(new Pawn(PieceType.BISHOP, Color.Black, "", ""));
        arr[0][4] = new Square(new Pawn(PieceType.KING, Color.Black, "", ""));
        arr[0][3] = new Square(new Pawn(PieceType.QUEEN, Color.Black, "", ""));

        arr[7][0] = new Square(new Rook(PieceType.ROOK, Color.White, "", ""));
        arr[7][7] = new Square(new Rook(PieceType.ROOK, Color.White, "", ""));
        arr[7][6] = new Square(new Pawn(PieceType.KNIGHT, Color.White, "", ""));
        arr[7][1] = new Square(new Pawn(PieceType.KNIGHT, Color.White, "", ""));
        arr[7][2] = new Square(new Pawn(PieceType.BISHOP, Color.White, "", ""));
        arr[7][5] = new Square(new Pawn(PieceType.BISHOP, Color.White, "", ""));
        arr[7][4] = new Square(new Pawn(PieceType.KING, Color.White, "", ""));
        arr[7][3] = new Square(new Pawn(PieceType.QUEEN, Color.White, "", ""));
    }

    static class Square {
        Square(Piece p) {
            piece = p;
        }
        Piece piece;
    }

    void show() {
        for(int i = 0; i < 8; i++) {
            System.out.println();
            for (int j = 0; j < 8; j++) {
                Piece p = arr[i][j].piece;
                if(p != null)
                System.out.print(p.type+" "+p.color+ "     ");
                else
                    System.out.print("empty          ");
            }
        }
    }

    final Square arr [] [] = new Square[8][8];
}
