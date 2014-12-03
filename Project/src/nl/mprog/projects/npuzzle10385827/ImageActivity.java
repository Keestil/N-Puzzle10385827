package nl.mprog.projects.npuzzle10385827;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class ImageActivity extends ListActivity {

	String[] itemname ={
			"assassin",
			"smile",
			"man",
			"daffy",
			"fallout",
			"headphones"
			};
	
	Integer[] imgid ={
			R.drawable.assassin,
			R.drawable.smile,
			R.drawable.man,
			R.drawable.daffy,
			R.drawable.falout,
			R.drawable.headphones,
			};
	
	int difficulty; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Bundle extras = this.getIntent().getExtras();
		difficulty = extras.getInt("difficulty");
		setContentView(R.layout.activity_image);
		CustomListAdapter adapter=new CustomListAdapter(this, itemname, imgid);
		setListAdapter(adapter);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
			Intent intent0 = new Intent(this, GameActivity.class);
			intent0.putExtra("Image", imgid[position]);
			intent0.putExtra("difficulty", difficulty);
			startActivity(intent0);
			finish();

	}
			
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.image, menu);
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
