package nl.mprog.projects.npuzzle10385827;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.content.Intent;
import android.content.SharedPreferences;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	SharedPreferences data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Making button 1 and 2.

		Button start_button = (Button) findViewById(R.id.button1);
		start_button.setOnClickListener(this);

		Button difficulty_button = (Button) findViewById(R.id.button2);
		difficulty_button.setOnClickListener(this);

		Button resume_button = (Button) findViewById(R.id.button3);
		resume_button.setOnClickListener(this);

		// Here we check if the player has played a game.
		data = getSharedPreferences("savedstate", 0);
		
		boolean game = data.getBoolean("game", false);

		if (game == false) {
			resume_button.setVisibility(View.INVISIBLE);
		}
	}

	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

	public void onClick(View v) {
		// Checking which button is clicked and giving it extra information for
		// the next activity

		switch (v.getId()) {
		case R.id.button1:
			data = getSharedPreferences("savedstate", 0);
			int prefdifficulty = data.getInt("prefdifficulty", 1);
			Intent intent1 = new Intent(this, ImageActivity.class);
			intent1.putExtra("difficulty", prefdifficulty);
			intent1.putExtra("newgame", true);
			startActivity(intent1);
			break;

		case R.id.button2:
			Intent intent2 = new Intent(this, DifficultyActivity.class);
			intent2.putExtra("newgame", true);
			startActivity(intent2);
			break;

		case R.id.button3:
			Intent intent3 = new Intent(this, GameActivity.class);
			intent3.putExtra("newgame", false);
			startActivity(intent3);
			break;

		}
	}
}
