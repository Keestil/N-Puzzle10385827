package nl.mprog.projects.npuzzle10385827;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class SolutionActivity extends ActionBarActivity {
	int resource;
	int difficulty;
	int w;
	int h;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_solution);
		Bundle extras = this.getIntent().getExtras();
		resource = extras.getInt("Image");
		difficulty = extras.getInt("difficulty");
		w =  getResources().getDisplayMetrics().widthPixels;//bmp.getWidth();
		h =  getResources().getDisplayMetrics().heightPixels;//bmp.getHeight();	
		ImageView img = (ImageView)findViewById(R.id.single_image);
		img.setImageResource(resource);
		
		new CountDownTimer(3000, 1000) {
			
			TextView mTextField = (TextView)findViewById(R.id.textView1);			 
		    public void onTick(long millisUntilFinished) {
		        mTextField.setText("Game starts in: " + millisUntilFinished / 1000);
		    }

		    public void onFinish() {
		    Intent intent = new Intent(SolutionActivity.this, GameActivity.class);
			intent.putExtra("Image", resource);
			intent.putExtra("difficulty", difficulty);
			startActivity(intent);
			finish();
		     }
		  }.start();
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.solution, menu);
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
}
