package nl.mprog.projects.npuzzle10385827;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LeaderActivity extends ActionBarActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_leader);
		
		Button high_button = (Button) findViewById(R.id.high);
		high_button.setOnClickListener(this);
		
		Button w_high_button = (Button) findViewById(R.id.w_high);
		w_high_button.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.leader, menu);
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
			case R.id.high:
				Intent intent1 = new Intent(this, ImageActivity2.class);
				startActivity(intent1);
				break;

			case R.id.w_high:
				Intent intent2 = new Intent(this, ImageActivity3.class);
				startActivity(intent2);
				break;

			case R.id.button3:
				Intent intent3 = new Intent(this, LeaderActivity.class);
				startActivity(intent3);
				break;							
		}	
	}
}
