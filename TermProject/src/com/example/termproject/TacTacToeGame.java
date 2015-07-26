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

	public TacTacToeGame() {

		gameBoard = new char[boardSize];
		for (int i = 0; i < boardSize; i++)
			gameBoard[i] = emptySpace;
		gameRand = new Random();
	}

	public void cleanBoard() {

		for (int i = 0; i < boardSize; i++) {

			gameBoard[i] = emptySpace;
		}
	}

	public void setMove(char player, int location) {

		gameBoard[location] = player;
	}

	public int getBoardMove() {

		int move;
		for (int i = 0; i < getBoardsize(); i++) {
			if (gameBoard[i] != user && gameBoard[i] != cpu) {
				{
					char current = gameBoard[i];
					gameBoard[i] = cpu;

					if (checkForWinner() == 3) {
						setMove(cpu, i);
						return i;
					} else
						gameBoard[i] = current;
				}
			}
		}
		for (int i = 0; i < getBoardsize(); i++) {
			if (gameBoard[i] != user && gameBoard[i] != cpu) {
				{
					char current = gameBoard[i];
					gameBoard[i] = user;

					if (checkForWinner() == 2) {
						setMove(cpu, i);
						return i;
					} else
						gameBoard[i] = current;
				}
			}
		}
		do
		{
			move = gameRand.nextInt(getBoardsize());
		}while(gameBoard[move] == user || gameBoard[move] == cpu);
		
		setMove(cpu, move);
	return move;
	}
	
	public int checkForWinner() {
		
		for(int i = 0; i <= 6; i += 3){
			if(gameBoard[i] == user && gameBoard[i+1] == user && gameBoard[i+2] == user ){
				return 2;}
			if(gameBoard[i] == cpu && gameBoard[i+1] == cpu && gameBoard[i+2] == cpu ){
				return 3;}
		}
		for(int i = 0; i <= 2; i ++ ){
			if(gameBoard[i] == user && gameBoard[i+3] == user && gameBoard[i+6] == user ){
				return 2;}
			if(gameBoard[i] == cpu && gameBoard[i+3] == cpu && gameBoard[i+6] == cpu ){
				return 3;}
		}
		if(gameBoard[0] == user && gameBoard[4] == user && gameBoard[8] == user || gameBoard[2] == user && gameBoard[4] == user && gameBoard[6] == user )
		{
			return 2;
		}
		if(gameBoard[0] == cpu && gameBoard[4] == cpu && gameBoard[8] == cpu || gameBoard[2] == cpu && gameBoard[4] == cpu && gameBoard[6] == cpu )
		{
			return 3;
		}
		for(int i = 0; i < getBoardsize(); 	i++){
			if(gameBoard[i] != user && gameBoard[i] != cpu){
				return 0;
			}
		}
		return 1;
	}

}
