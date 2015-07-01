package com.example.termproject;

import java.util.Random;

public class TacTacToeGame {

	
	private char gameBoard[];
	
	
	private final static int boardSize = 9;
	
	public static int getBoardsize() {
		return boardSize;
	}

	public static final char user = 'X';
	public static final char cpu = '0';
	public static final char emptySpace = ' ';
	private Random gameRand;
	

	public TacTacToeGame(){
		
		gameBoard = new char[boardSize];
		 for(int i=0; i < boardSize; i++)
			 gameBoard[i] = emptySpace;
		 gameRand = new Random();
	}
	
	public void cleanBoard(){
		
		for(int i=0; i<boardSize; i++){
			
			gameBoard[i] = emptySpace;
		}
	}
	
	public void setMove(char player, int location){
		
		gameBoard[location] = player;
	}
	
//	public int getBoardMove(){
//		
//		int move;
//		for (int i = 0; i < getBoardsize(); i++) {
//			if(gameBoard[i] != user && gameBoard[i]!= cpu){
//				{
//					char current = gameBoard[i];
//					gameBoard[i] = cpu;
//					
//					if(checkForWinner() == 3){
//						setMove(cpu,i);
//					}
//				}
//			}
//			
//		}	
//	}
}
