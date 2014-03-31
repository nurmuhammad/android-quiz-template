package com.nicolatesser.androidquiztemplate.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.nicolatesser.androidquiztemplate.R;
import com.nicolatesser.androidquiztemplate.quiz.Game;
import com.nicolatesser.androidquiztemplate.quiz.Session;

public class EndOfGameActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_end_of_game);
		
		showStats();
		
		((Button)findViewById(R.id.restart)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				restart();
				
			}
		});
	}
	
	public void showStats() {
		Game game = Game.getInstance();
		if (game!=null) {
			Session session = game.getSession();
			((TextView)findViewById(R.id.totalAnswers)).setText("Total Answers: "+session.getTotalAttempts());
			((TextView)findViewById(R.id.correctAnswers)).setText("Correct Answers: "+session.getCorrectAttempts());
			((TextView)findViewById(R.id.correctAnswersRate)).setText("Correctness Rate: "+session.getCorrectnessRate());
			((TextView)findViewById(R.id.bestSequence)).setText("Best correct Sequence: "+session.getBestConsecutiveAttempts());
			((TextView)findViewById(R.id.overallRecord)).setText("Record: "+"0");	
		}
	}
	
	public void restart() {
		Game.getInstance().reset();
		Session session = Game.getInstance().getSession();
		//serialize session
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.end_of_game, menu);
		return true;
	}

}
