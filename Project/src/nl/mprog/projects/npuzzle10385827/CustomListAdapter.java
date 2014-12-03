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

	public CustomListAdapter(Context context, String[] itemname,
			Integer[] imgid) {
		this.context = context;
		this.itemname = itemname;
		this.imgid = imgid;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		
		ImageView imageView = new ImageView(context);
		imageView.setImageResource(imgid[position]);
		return imageView;
		
		/*LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.my_list, null, true);
		TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
		TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);
		txtTitle.setText(itemname[position]);
		imageView.setImageResource(imgid[position]);
		extratxt.setText("Description " + itemname[position]);
		return rowView;*/
	}

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