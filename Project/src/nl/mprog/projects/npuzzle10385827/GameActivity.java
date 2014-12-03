package nl.mprog.projects.npuzzle10385827;

import java.util.ArrayList;


import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
public class GameActivity extends ActionBarActivity implements OnClickListener{
	
	
	int resource; // R.drawable.hawk
	int difficulty;
	GridView grd;
	
	ArrayList<Bitmap> crops = new ArrayList<Bitmap>();
	int w;
	int h;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle extras = this.getIntent().getExtras();
		resource = extras.getInt("Image");
		difficulty = extras.getInt("difficulty");
		
		w =  getResources().getDisplayMetrics().widthPixels;//bmp.getWidth();
		h =  getResources().getDisplayMetrics().heightPixels;//bmp.getHeight();
		
		setContentView(R.layout.activity_game);
		ImageView img = (ImageView)findViewById(R.id.single_image);		
		
		grd = (GridView) findViewById(R.id.gridview);
	    grd.setAdapter(new ImageAdapter(this,crops));
	    
        //img.setImageResource(resource);
        img.setOnClickListener(this);
        
		Button menu_button = (Button) findViewById(R.id.menu);
		menu_button.setOnClickListener(this);		
		Button win_button = (Button) findViewById(R.id.win);
		win_button.setOnClickListener(this);
		
		Bitmap bmp = BitmapFactory.decodeResource(getResources(), resource);
		divideImages(bmp);
	}
	
	private void divideImages(Bitmap bmp) {
		
		int width = bmp.getWidth();
		float w_ratio = (float) w/width;
		int scaledwidth = (int) (bmp.getWidth()*w_ratio);
		int scaledheight = (int) (bmp.getHeight()*w_ratio);
		Bitmap scaledbmp = Bitmap.createScaledBitmap(bmp,scaledwidth,scaledheight,true);
		
		switch(difficulty){
			case 0:
				for(int i=0;i<3;i++){
					for(int j=0;j<3;j++){
						if(i==2 && j==2){
							Bitmap cropimage  = Bitmap.createBitmap(scaledwidth/3,scaledheight/3,Bitmap.Config.ARGB_8888);
					        crops.add(cropimage);
					        cropimage = null;
						}
					   else{
					        int startx =  (int) ((scaledwidth*j)/3);
							int starty =  (int) ((scaledheight*i)/3);
							Bitmap croppimage  = Bitmap.createBitmap(scaledbmp,startx,starty,scaledwidth/3,scaledheight/3);
							crops.add(croppimage);
							croppimage = null;
					   	}
					}
					grd.setNumColumns(3);
				}
				break;				        	      
			case 1:
				for(int i=0;i<4;i++){
					for(int j=0;j<4;j++){
						if(i==3 && j==3){
							Bitmap croppimage  = Bitmap.createBitmap(scaledwidth/4,scaledheight/4,Bitmap.Config.ARGB_8888);
							crops.add(croppimage);
							croppimage = null;
				        }
						else{
							int startx = (int) ((scaledwidth*j)/4);
							int starty = (int) ((scaledheight*i)/4);
							Bitmap croppimage  = Bitmap.createBitmap(scaledbmp,startx,starty,scaledwidth/4,scaledheight/4);
							crops.add(croppimage);
							croppimage = null;
						}
					}
					grd.setNumColumns(4);
				}
				break;
			case 2:
				for(int i=0;i<5;i++){
					for(int j=0;j<5;j++){
						if(i==4 && j==4){
							Bitmap croppimage  = Bitmap.createBitmap(scaledwidth/5,scaledheight/5,Bitmap.Config.ARGB_8888);
					        crops.add(croppimage);
					        croppimage = null;
						}
						else{
							int startx = (int) ((scaledwidth*j)/5);
							int starty = (int) ((scaledheight*i)/5);
							Bitmap croppimage  = Bitmap.createBitmap(scaledbmp,startx,starty,scaledwidth/5,scaledheight/5);
							crops.add(croppimage);
							croppimage = null;
						}
					}
					grd.setNumColumns(5);
				}
				break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
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
	
	

	@Override
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

