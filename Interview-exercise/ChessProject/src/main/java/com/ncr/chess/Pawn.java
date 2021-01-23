package com.ncr.chess;

public class Pawn {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    private void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    public void move(MovementType movementType, int newX, int newY) throws PawnException{
    	if(movementType == MovementType.MOVE) {
    		Boolean Status = CheckMoveOfPawn(newX,newY);
    		if(Status) {
    			throw new PawnException();
    		}
    	}
    	else if(movementType == MovementType.CAPTURE) {
    		Boolean Status = CheckCaptureOfPawn(newX,newY);
    		if(Status) {
    			throw new PawnException();    		
    		}
    	}
    	else {
            throw new PawnException();		
    	}
    	this.setXCoordinate(newX);
    	this.setYCoordinate(newY);
    	
    }

	private Boolean CheckMoveOfPawn(int newX, int newY) {
        if(this.getXCoordinate()-newX>=2 || this.getXCoordinate()-newX<=-1 || this.getYCoordinate()-newY==-1||this.getYCoordinate()-newY==1) {
        	return true;
         }
        return false;
	}
	@Override
    public String toString() {
        return getCurrentPositionAsString();
    }

    protected String getCurrentPositionAsString() {
        String eol = System.lineSeparator();
        return String.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, xCoordinate, yCoordinate, pieceColor);
    }
    
    private Boolean CheckCaptureOfPawn(int newX, int newY) {
		// TODO Auto-generated method stub
		return null;
	}
}
