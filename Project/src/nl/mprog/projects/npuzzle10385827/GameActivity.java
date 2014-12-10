package nl.mprog.projects.npuzzle10385827;

import java.util.ArrayList;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class GameActivity extends ActionBarActivity{
	
	SharedPreferences data;
	String filename = "savedstate";
	
	int resource; // R.drawable.hawk
	int difficulty;	
	ArrayList<Integer> ID = new ArrayList<Integer>();
	ArrayList<Integer> IDshuffle;
	ArrayList<Bitmap> crops = new ArrayList<Bitmap>();
	ArrayList<Bitmap> cropsshuffle;
	GridView grd;
	int w;
	int h;
	int counter;
	int counter2;
	ImageView firstimg;
	int firstclick;
	int tag1;
	int tag2;
	int size;
	int moves;
	int check;
	boolean timer;
	boolean newgame;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		data = getSharedPreferences(filename,0);
		
		//Import data and save it outside of the class.
		
		Bundle extras = this.getIntent().getExtras();		
		resource = extras.getInt("Image");
		difficulty = extras.getInt("difficulty");
		newgame = extras.getBoolean("newgame");
		
		if(newgame == false){
			resource = data.getInt("sharedpicture", 0);
			difficulty = data.getInt("shareddifficulty", 0);
			moves = data.getInt("sharedmoves", 0);
			counter2 = data.getInt("sharedcounter", 0);
			
		}
		
		// w = screenwidth and h = screenheight.
		
		w =  getResources().getDisplayMetrics().widthPixels;
		h =  getResources().getDisplayMetrics().heightPixels;
		
		
	    grd = (GridView) findViewById(R.id.gridview);
	    grd.setAdapter(new ImageAdapter(this,crops,ID));

	    //Turning the image R.drawable into a bitmap.
	    
	    Bitmap bmp = BitmapFactory.decodeResource(getResources(), resource);
		
	    //Cropping the images and making a ID list that coincide with the cropped images.
	    
	    divideImages(bmp);
		getID();
		
		//Save the cropped list and i IDlist the first time we crop them, because we are going to need these lists later on.
		
		IDshuffle = new ArrayList<Integer>(ID);
		cropsshuffle = new ArrayList<Bitmap>(crops);
		
		data = getSharedPreferences(filename,0);
		
		//Make a timer timer
		if(counter2 == 0){
			counter2++;
			new CountDownTimer(3000, 1000) {
				TextView mTextField = (TextView)findViewById(R.id.textView1);			 
				public void onTick(long millisUntilFinished) {
				
					//This boolean is supposed to prevent the player from playing if the timer is clicking.
				
					timer = true;
					mTextField.setText("Game starts in: " + millisUntilFinished / 1000);
				}

				public void onFinish() {
					mTextField.setText("Game on!");
					shuffle();
					timer = false;
				}
			}.start();
			
		}else{
			
		}

		grd.setOnItemClickListener(new OnItemClickListener() {
	        @Override
	        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	        	if(timer == true){
	        		Toast toast = new Toast(getApplicationContext());
	        		toast.makeText(getApplicationContext(),"The game has not started yet!", Toast.LENGTH_SHORT).show();

	        	}else{
	        		counter ++;
	        		
	        		//Because difficulty's are 0,1,2 the row/column dimensions are difficulty + 3
	        		
	        		size = (int) difficulty + 3;
	        		TextView movesText = (TextView)findViewById(R.id.textView2);
	        		
	        		//Checks if click is even or odd.
	        		
	        		if(counter % 2 == 1){
	        			firstimg = (ImageView) view;
	        			firstclick = position;
	        			tag1 = (int) firstimg.getTag();
  	        	
	        		}else if(counter % 2 == 0){
	        			ImageView secondimg = (ImageView) view;
	        			Bitmap swapImage = crops.get(position);
	        			Integer swapID = ID.get(position);
	        			tag2 = (int) secondimg.getTag();
	        			
	        			//To prevent cheaters to press twice on the same tile we set this if statement.
	        			
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
	        			
	        			//This usefull command rebuilds the imageviews
	        			
	        			grd.invalidateViews();
	        		}
	        	}
	    
	        }
	    });		
	}
	
	@Override
	public void onPause() {
	    super.onPause();// Always call the superclass method first
	    data = getSharedPreferences(filename,0);
	    SharedPreferences.Editor editor0 = data.edit();
	    editor0.putInt("sharedcounter", counter2);	    
	    editor0.putInt("shareddifficulty", difficulty);
	    editor0.putInt("sharedmoves", moves);
	    editor0.putInt("sharedpicture",resource);
	    editor0.putInt("ID_size", ID.size());
	
	   for(int i=0;i<ID.size();i++){
	        //editor0.remove("ID_"+i);
	        editor0.putInt("ID_" + i, ID.get(i));  
	    }
	    editor0.commit();
	}

	@Override
	public void onResume(){
	    super.onResume();
	    if(newgame == true){
	    	
	    }else{
	    	data = getSharedPreferences(filename,0);
	    	int sdifficulty = data.getInt("shareddifficulty", 0);
	    	int scounter = data.getInt("sharedcounter", 0);
	    	int smoves = data.getInt("sharedmoves",0);
	    	int listsize = data.getInt("ID_size", 0);
	    	int sresource = data.getInt("sharedpicture", 0);
	    	if(resource == sresource && sdifficulty == difficulty){
	    		difficulty = sdifficulty;
	    		resource = sresource;
	    		moves = smoves;
	    		counter2 = scounter;
	    		ID.clear();
	    		TextView movesText = (TextView)findViewById(R.id.textView2);
	    		TextView mTextField = (TextView)findViewById(R.id.textView1);
	    		movesText.setText("Moves: " + moves);
	    		mTextField.setText("Game on!");
	    		for(int i=0; i < listsize;i++){
	    			ID.add(data.getInt("ID_" + i,0));
	    		}
	    		crops.clear();
	    		for(int j=0;j<listsize;j++){
	    			crops.add(cropsshuffle.get((ID.get(j))));
	    		}
	    		SharedPreferences.Editor editor0 = data.edit();
	    		editor0.putBoolean("game", true);
	    		editor0.commit();
	    	}else{
	    	
	    	}
	    }
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
		for(int i=0;i<crops.size();i++){
			crops.set(i, cropsshuffle.get(i));
			ID.set(i,IDshuffle.get(i));
		}
		for(int i=0;i<Math.floor((crops.size()-1)/2)+1;i++){
			Bitmap swapImage = crops.get(i);
			Integer swapid = ID.get(i);
			crops.set(i, crops.get(crops.size()-2-i));
			ID.set(i, ID.get(ID.size()-2-i));
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
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.game, menu);
		return true;
	}

	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.reset:
	        	if(timer == true){
	        		
	        	}else{
		            shuffle();
		            moves = 0;
		            TextView movesText = (TextView)findViewById(R.id.textView2);
		            movesText.setText("Moves: " + moves);	        
	        	}

	            return true;
	        case R.id.difficulty:
				Intent intent = new Intent(this, Difficulty2Activity.class);
				intent.putExtra("Image",resource);
				intent.putExtra("newgame", true);
				startActivity(intent);
				return true;
	        case R.id.quit:
	        	data = getSharedPreferences(filename,0);
	    	    SharedPreferences.Editor editor0 = data.edit();
	    	    editor0.putBoolean("game", true);
	    	    editor0.commit();
				Intent intent3 = new Intent(this, MainActivity.class);
				startActivity(intent3);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
}

