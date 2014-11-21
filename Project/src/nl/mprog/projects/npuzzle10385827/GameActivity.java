package nl.mprog.projects.npuzzle10385827;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class GameActivity extends ActionBarActivity implements OnClickListener{

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		Button menu_button = (Button) findViewById(R.id.menu);
		menu_button.setOnClickListener(this);
		
		Button win_button = (Button) findViewById(R.id.win);
		win_button.setOnClickListener(this);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);		
	}
	
	public void onClick(View v){
		switch(v.getId()){
			case R.id.menu:
				Intent intent1 = new Intent(this, MenuActivity.class);
				startActivity(intent1);
				break;
			case R.id.win:
				Intent intent2 = new Intent(this, CongratsActivity.class);
				startActivity(intent2);
				break;	
		}	
	}
}

