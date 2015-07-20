package com.example.isweixin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;

public class TestAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private Context con;

    public TestAdapter (Context context) {
        // Cache the LayoutInflate to avoid asking for a new one each time.
   	    con = context;
        mInflater = LayoutInflater.from(context);
    }
    /*
    public int getCount() {
        return list.size();
    }
    public Object getItem(int position) {
        return position;
    }
    public long getItemId(int position) {
        return position;
    }        
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {   
            convertView = mInflater.inflate(R.layout.list, null);
            holder = new ViewHolder();
            holder.bt01 = (Button) convertView.findViewById(R.id.bt01);
            holder.bt02 = (Button) convertView.findViewById(R.id.bt02);
            holder.bt03 = (Button) convertView.findViewById(R.id.bt03);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

final int arg = position;
        
        //bt01µã»÷
        holder.bt01.setOnClickListener(new ImageView.OnClickListener(){
			public void onClick(View v) {
				
			}    	    
	    });
        //bt02µã»÷
        holder.bt02.setOnClickListener(new ImageView.OnClickListener(){
			public void onClick(View v) {
				
			}    	    
	    });
        //bt03µã»÷
        holder.bt03.setOnClickListener(new ImageView.OnClickListener(){
			public void onClick(View v) {
				
			}    	    
	    });
        return convertView;
    }
    class ViewHolder {
    	Button bt01;
    	Button bt02;
            Button bt03;
    }*/

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}
}