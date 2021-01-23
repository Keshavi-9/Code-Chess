package com.ncr.chess;

public class ChessBoard {

    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;

    private Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];
    }

    public void addPiece(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) throws PawnException {
    	Boolean Status = isLegalBoardPosition(xCoordinate, yCoordinate);
    	if(Status) {
    		pawn.setXCoordinate(xCoordinate);
    		pawn.setYCoordinate(yCoordinate);
    		pawn.setChessBoard(this);
    		pieces[xCoordinate][yCoordinate] = pawn;
    	}
    	else {
            throw new PawnException();
    	}
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) throws PawnException{
    	if(xCoordinate>MAX_BOARD_WIDTH ||xCoordinate<0 || yCoordinate>MAX_BOARD_HEIGHT ||yCoordinate<0) {
    		return false;
    	}
    	return true;
    }
}
