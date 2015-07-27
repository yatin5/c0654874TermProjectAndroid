package com.example.termproject;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
//import com.example.termproject.R;

public class MainActivity extends Activity {
	
	private TacTacToeGame Game;
	private Button gameBoardButtons[];
	private TextView infoTextView;
	private TextView tieCount;
	private TextView userTotal;
	 private TextView cpuTotal;
	private int userIncerement = 0;
	private int cpuIncerement = 0;
	private int tieIncerement = 0;
	
	private boolean userFirst = true;
	private boolean gameOver = false;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
	gameBoardButtons = new Button[TacTacToeGame.getBoardsize()];
	gameBoardButtons[0] = (Button) findViewById(R.id.one);
	gameBoardButtons[1] = (Button)findViewById(R.id.two);
	gameBoardButtons[2] = (Button)findViewById(R.id.three);
	gameBoardButtons[3] = (Button)findViewById(R.id.four);
	gameBoardButtons[4] = (Button)findViewById(R.id.five);
	gameBoardButtons[5] = (Button)findViewById(R.id.six);
	gameBoardButtons[6] = (Button)findViewById(R.id.seven);
	gameBoardButtons[7] = (Button)findViewById(R.id.eight);
	gameBoardButtons[8] = (Button)findViewById(R.id.nine);
	
	 infoTextView = (TextView) findViewById(R.id.Information);
	 userTotal = (TextView) findViewById(R.id.userTotal);
	 tieCount = (TextView) findViewById(R.id.tieCount);
	 cpuTotal = (TextView) findViewById(R.id.cpuTotal);	
	 
	 userTotal.setText(Integer.toString(userIncerement));
	 tieCount.setText(Integer.toString(tieIncerement));
	 cpuTotal.setText(Integer.toString(cpuIncerement));
	 
	 Game = new TacTacToeGame();
	 
	 startNewGame();
	 	
}
	private void startNewGame()
	{
		Game.cleanBoard();
		
		for(int i = 0; i < gameBoardButtons.length; i++)
		{
			gameBoardButtons[i].setText(" ");
			gameBoardButtons[i].setEnabled(true);
			gameBoardButtons[i].setOnClickListener(new ButtonClickListener(i));
		}
		if(userFirst)
		{
			infoTextView.setText(R.string.User);
			userFirst = false;
		}
		else
		{
			infoTextView.setText(R.string.turn_cpu);
			int move = Game.getBoardMove();
			setMove(TacTacToeGame.cpu, move);
			userFirst = true;
		}
		
		gameOver = false;
	}
	
	private class ButtonClickListener implements View.OnClickListener {
		int location;
		public ButtonClickListener(int location) {
			this.location = location;
		}
		public void onClick(View view) {
			if(!gameOver){
				if(gameBoardButtons[location].isEnabled()){
					setMove(TacTacToeGame.user, location);
					int winner = Game.checkForWinner();
					
					if(winner == 0){
						infoTextView.setText(R.string.turn_cpu);
						int move = Game.getBoardMove();
						setMove(TacTacToeGame.cpu, move);
						winner = Game.checkForWinner();
					}
					
				 if (winner == 0) {
						infoTextView.setText(R.string.turn_user);
					}
				 
					else if(winner == 1) {
						infoTextView.setText(R.string.tie);
						tieIncerement++;
						tieCount.setText(Integer.toString(tieIncerement));
						gameOver = true;
					}
				 
					else if(winner == 2) {
						infoTextView.setText(R.string.user_wins);
						userIncerement++;
						userTotal.setText(Integer.toString(userIncerement));
						gameOver = true;
					}
				 
					else {
						infoTextView.setText(R.string.cpu_wins);
						cpuIncerement++;
						cpuTotal.setText(Integer.toString(cpuIncerement));
						gameOver = true;
					}
				}
			}
		}
	}
	
	private void setMove(char player, int location)
	{
		Game.setMove(player, location);
		gameBoardButtons[location].setEnabled(false);
		gameBoardButtons[location].setText(String.valueOf(player));
		if(player == TacTacToeGame.user)
		{
			gameBoardButtons[location].setTextColor(Color.BLACK);
			
		}
		else {
			gameBoardButtons[location].setTextColor(Color.RED);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		 MenuInflater inflater = getMenuInflater();  
		 inflater.inflate(R.menu.main, menu);  
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		 switch(item.getItemId())  
		  {  
		   	case R.id.newGame:  
		             startNewGame();  
		               break;  
		    case R.id.exitGame:  
		               MainActivity.this.finish();  
		               break;  
	}
		 return true;

}
	
}
