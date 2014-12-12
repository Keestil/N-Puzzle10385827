package nl.mprog.projects.npuzzle10385827;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Difficulty2Activity extends ActionBarActivity implements
		OnClickListener {

	int resource;
	SharedPreferences data;
	boolean newgame;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_difficulty2);

		Bundle extras = this.getIntent().getExtras();
		resource = extras.getInt("Image");
		newgame = extras.getBoolean("newgame");

		Button easy_button = (Button) findViewById(R.id.easy);
		easy_button.setOnClickListener(this);

		Button medium_button = (Button) findViewById(R.id.medium);
		medium_button.setOnClickListener(this);

		Button hard_button = (Button) findViewById(R.id.hard);
		hard_button.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.difficulty2, menu);
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

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.easy:
			Intent intent1 = new Intent(this, GameActivity.class);
			intent1.putExtra("difficulty", 0);
			intent1.putExtra("Image", resource);
			intent1.putExtra("newgame", newgame);
			
			// Saving the prefered game by the player
			data = getSharedPreferences("savedstate", 0);
			SharedPreferences.Editor editor0 = data.edit();
			editor0.putInt("prefdifficulty", 0);
			editor0.commit();
			startActivity(intent1);
			break;

		case R.id.medium:
			Intent intent2 = new Intent(this, GameActivity.class);
			intent2.putExtra("difficulty", 1);
			intent2.putExtra("Image", resource);
			intent2.putExtra("newgame", newgame);
			
			// Saving the prefered game by the player
			data = getSharedPreferences("savedstate", 0);
			SharedPreferences.Editor editor1 = data.edit();
			editor1.putInt("prefdifficulty", 1);
			editor1.commit();
			startActivity(intent2);
			break;

		case R.id.hard:
			Intent intent3 = new Intent(this, GameActivity.class);
			intent3.putExtra("difficulty", 2);
			intent3.putExtra("Image", resource);
			intent3.putExtra("newgame", newgame);
			
			// Saving the preffered game by the player
			data = getSharedPreferences("savedstate", 0);
			SharedPreferences.Editor editor3 = data.edit();
			editor3.putInt("prefdifficulty", 2);
			editor3.commit();
			startActivity(intent3);
			break;
		}
	}
}
