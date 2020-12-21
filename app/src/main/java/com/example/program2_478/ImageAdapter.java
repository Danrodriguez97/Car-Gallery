package com.example.program2_478;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<Cars> cars;

    public ImageAdapter(Context c, ArrayList<Cars> car){
        //Constructor
        this.mContext=c;
        this.cars=car;
    }

    // Now the methods inherited from abstract superclass BaseAdapter

    // Return the number of items in the Adapter
    @Override
    public int getCount() {
        return cars.size();
    }

    // Return the data item at position
    @Override
    public Object getItem(int position) {
        return cars.get(position);
    }

    // Will get called to provide the ID that
    // is passed to OnItemClickListener.onItemClick()
    @Override
    public long getItemId(int position){ return 0; }

    // Return an ImageView for each item referenced by the Adapter
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inf= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inf.inflate(R.layout.activity_cars, parent,false);

        ImageView image =(ImageView) convertView.findViewById(R.id.imageView1);
        TextView txt= (TextView) convertView.findViewById(R.id.textView1);

        image.setImageResource(cars.get(position).getImage());
        txt.setText(cars.get(position).getMake());

        return convertView;


    }

}
