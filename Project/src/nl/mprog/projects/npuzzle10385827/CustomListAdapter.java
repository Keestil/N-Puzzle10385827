package nl.mprog.projects.npuzzle10385827;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends BaseAdapter {

	private Context context;
	private String[] itemname;
	private Integer[] imgid;

	//defining the imported data from ImageActivity
	public CustomListAdapter(Context context, String[] itemname,
			Integer[] imgid) {
		this.context = context;
		this.itemname = itemname;
		this.imgid = imgid;
	}

	//This method shows us the images
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		
		ImageView imageView = new ImageView(context);
		imageView.setImageResource(imgid[position]);
		return imageView;
	}

	//Counts the elements of our listview
	@Override
	public int getCount() {
		return imgid.length;
	}

	
	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	};
}