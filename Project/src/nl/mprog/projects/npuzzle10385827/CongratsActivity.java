package nl.mprog.projects.npuzzle10385827;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CongratsActivity extends ActionBarActivity implements OnClickListener {

	int moves;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_congrats);
		
		Bundle extras = this.getIntent().getExtras();
		moves = extras.getInt("Moves");
		
		TextView mTextField = (TextView)findViewById(R.id.moves);
		mTextField.setText("You needed " + moves + " moves");
		Button menu_button = (Button) findViewById(R.id.menubutton);
		menu_button.setOnClickListener(this);		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.congrats, menu);
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
			case R.id.menubutton:
				Intent intent1 = new Intent(this, MainActivity.class);
				startActivity(intent1);
				break;					
		}	
	}
}

