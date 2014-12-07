package nl.mprog.projects.npuzzle10385827;

import java.util.ArrayList;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class GameActivity extends ActionBarActivity implements OnClickListener{
	

	int resource; // R.drawable.hawk
	int difficulty;	
	ArrayList<ImageView> imglist;
	ArrayList<Integer> ID = new ArrayList<Integer>();
	ArrayList<Bitmap> crops = new ArrayList<Bitmap>();
	GridView grd;
	int w;
	int h;
	int counter;
	ImageView firstimg;
	int firstclick;
	int tag1;
	int tag2;
	int size;
	int moves;
	int check;
	boolean timer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		Bundle extras = this.getIntent().getExtras();
		resource = extras.getInt("Image");
		difficulty = extras.getInt("difficulty");
		
		w =  getResources().getDisplayMetrics().widthPixels;//bmp.getWidth();
		h =  getResources().getDisplayMetrics().heightPixels;//bmp.getHeight();	
		
	    grd = (GridView) findViewById(R.id.gridview);
	    grd.setAdapter(new ImageAdapter(this,crops,ID));

	    Bitmap bmp = BitmapFactory.decodeResource(getResources(), resource);
		divideImages(bmp);
		getID();
		
		new CountDownTimer(3000, 1000) {
			TextView mTextField = (TextView)findViewById(R.id.textView1);			 
			public void onTick(long millisUntilFinished) {
				timer = true;
				mTextField.setText("Game starts in: " + millisUntilFinished / 1000);
			}

			public void onFinish() {
				mTextField.setText("Game on!");
				shuffle();
				timer = false;
			}
		}.start();

		grd.setOnItemClickListener(new OnItemClickListener() {
			
	        @Override
	        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	        	if(timer == true){
	        		Toast toast = new Toast(getApplicationContext());
	        		toast.makeText(getApplicationContext(),"The game has not started yet!", Toast.LENGTH_SHORT).show();

	        	}else{
	        		counter ++;
	        		size = (int) difficulty + 3;
	        		TextView movesText = (TextView)findViewById(R.id.textView2);
	        		if(counter % 2 == 1){
	        			firstimg = (ImageView) view;
	        			firstclick = position;
	        			tag1 = (int) firstimg.getTag();
  	        	
	        		}else if(counter % 2 == 0){
	        			ImageView secondimg = (ImageView) view;
	        			Bitmap swapImage = crops.get(position);
	        			Integer swapID = ID.get(position);
	        			tag2 = (int) secondimg.getTag();
	        			if (position == firstclick){
	        				counter = 1;
	        		
	        			}else if(tag1 != crops.size()-1 && tag2 != crops.size()-1){
	        			
	        			}else if((position - 1 != firstclick) && (position +1 != firstclick) && (position + size) != firstclick && ((position - size) != firstclick)){
	        			
	        			}else if(position - 1 == firstclick){
	        			
	        				if(position % size !=  0){
	        					//firstimg.setImageBitmap(swapImage);
	        					//secondimg.setImageBitmap(crops.get(firstclick));
	        			
	        					crops.set(position, crops.get(firstclick));
	        					ID.set(position, ID.get(firstclick));
	        					crops.set(firstclick, swapImage);
	        					ID.set(firstclick,swapID);
	        			
	        					//firstimg.setTag(tag2);
	        					//secondimg.setTag(tag1);
	        					moves ++;
	        					movesText.setText("Moves: " + moves);
	        					checkwin2();
	        				}else{
	        				
	        				}
	        			}else if(position + 1 == firstclick){
	        				if(position % size != (size - 1)){
	        					//firstimg.setImageBitmap(swapImage);
	        					//secondimg.setImageBitmap(crops.get(firstclick));
	        			
	        					crops.set(position, crops.get(firstclick));
	        					ID.set(position, ID.get(firstclick));
	        					crops.set(firstclick, swapImage);
	        					ID.set(firstclick,swapID);
	        			
	        					//firstimg.setTag(tag2);
	        					//secondimg.setTag(tag1);
	        					moves ++;
	        					movesText.setText("Moves: " + moves);
	        					checkwin2();
	        				}else{
	        				
	        				}
	        			}else if((position + size) != firstclick){
	        				//firstimg.setImageBitmap(swapImage);
	        				//secondimg.setImageBitmap(crops.get(firstclick));
	        			
	        				crops.set(position, crops.get(firstclick));
	        				ID.set(position, ID.get(firstclick));
	        				crops.set(firstclick, swapImage);
	        				ID.set(firstclick,swapID);
	        			
	        				//firstimg.setTag(tag2);
	        				//secondimg.setTag(tag1);
	        				moves ++;
	        				movesText.setText("Moves: " + moves);
	        				checkwin2();
	        			}else if((position - size) != firstclick){
	        				//firstimg.setImageBitmap(swapImage);
	        				//secondimg.setImageBitmap(crops.get(firstclick));
	        			
	        				crops.set(position, crops.get(firstclick));
	        				ID.set(position, ID.get(firstclick));
	        				crops.set(firstclick, swapImage);
	        				ID.set(firstclick,swapID);
	        			
	        				//firstimg.setTag(tag2);
	        				//secondimg.setTag(tag1);
	        			
	        				moves ++;
	        				movesText.setText("Moves: " + moves);
	        				checkwin2();
	        			}
	        			grd.invalidateViews();
	        		}
	        	}
	    
	        }
	    });
        //img.setImageResource(resource);
        
		Button menu_button = (Button) findViewById(R.id.menu);
		menu_button.setOnClickListener(this);		
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

	private void shuffle(){
		for(int i=0;i<Math.floor((crops.size()-1)/2)+1;i++){
			Bitmap swapImage = crops.get(i);
			Integer swapid = ID.get(i);
			crops.set(i, crops.get(crops.size()-2-i));
			ID.set(i, ID.get(ID.size()-1-i));
			crops.set(crops.size()-2-i, swapImage);
			ID.set(ID.size()-2-i,swapid);			
		}
		grd.invalidateViews();
	}
	
	private void getID(){
		for(int i=0;i<crops.size();i++){
			ID.add(i);
		}
	}
	
	private void checkwin(){
		check = 0;
		for(int i=0;i<ID.size();i++){
			if(ID.get(i)==i){
				check ++;
			}
		}
	}
	
	private void checkwin2(){
		checkwin();
		if(check == ID.size()){
				Intent intent0 = new Intent(this, CongratsActivity.class);
				intent0.putExtra("Moves", moves);
				startActivity(intent0);
				finish();
		}else{
			
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
		}	
	}
	
}

