package nl.mprog.projects.npuzzle10385827;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MenuActivity extends ActionBarActivity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		Button reset_button = (Button) findViewById(R.id.resetbutton);
		reset_button.setOnClickListener(this);
		
		Button difficulty_button = (Button) findViewById(R.id.difficultybutton);
		difficulty_button.setOnClickListener(this);
		
		Button quit_button = (Button) findViewById(R.id.quitbutton);
		quit_button.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

	@Override
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
			case R.id.resetbutton:
				Intent intent1 = new Intent(this, GameActivity.class);
				startActivity(intent1);
				break;

			case R.id.difficultybutton:
				Intent intent2 = new Intent(this, DifficultyActivity.class);
				startActivity(intent2);
				break;

			case R.id.quitbutton:
				Intent intent3 = new Intent(this, MainActivity.class);
				startActivity(intent3);
				break;
		}
	}
}
