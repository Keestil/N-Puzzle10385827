package nl.mprog.projects.npuzzle10385827;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;

public class DifficultyActivity extends ActionBarActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_difficulty);
		
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
		getMenuInflater().inflate(R.menu.difficulty, menu);
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
			case R.id.easy:
				Intent intent1 = new Intent(this, ImageActivity.class);
				startActivity(intent1);
				break;

			case R.id.medium:
				Intent intent2 = new Intent(this, ImageActivity.class);
				startActivity(intent2);
				break;

			case R.id.hard:
				Intent intent3 = new Intent(this, ImageActivity.class);
				startActivity(intent3);
				break;							
		}	
	}
}

