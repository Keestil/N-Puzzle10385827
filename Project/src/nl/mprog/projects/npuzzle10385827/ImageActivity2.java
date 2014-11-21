package nl.mprog.projects.npuzzle10385827;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class ImageActivity2 extends ActionBarActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_activity2);
		ImageButton fire_button = (ImageButton) findViewById(R.id.imagefire);
		fire_button.setOnClickListener(this);
		
		ImageButton girl_button = (ImageButton) findViewById(R.id.imagegirl);
		girl_button.setOnClickListener(this);
		
		ImageButton hawk_button = (ImageButton) findViewById(R.id.imagehawk);
		hawk_button.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.image_activity2, menu);
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
			case R.id.imagegirl:
				Intent intent1 = new Intent(this, LocalActivity.class);
				startActivity(intent1);
				break;

			case R.id.imagehawk:
				Intent intent2 = new Intent(this, LocalActivity.class);
				startActivity(intent2);
				break;

			case R.id.imagefire:
				Intent intent3 = new Intent(this, LocalActivity.class);
				startActivity(intent3);
				break;							
		}	
	}
}

