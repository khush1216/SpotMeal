package com.spotmeal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by parneet on 11/12/17.
 */

public class EventAdapter extends BaseAdapter {

    private String[] mItems;
    private List<View> mEvents;
    private LayoutInflater mLayoutInflater;
    private ArrayList<Integer> eventImages;

    EventAdapter(Context context, String[] eventDetails, ArrayList<Integer> eventImages){
        super();
        this.mItems = eventDetails;
        this.eventImages = eventImages;
        /* Set layout Inflater */
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mEvents = new ArrayList<>(this.mItems.length);
    }

    @Override
    public int getCount() {

        return mItems.length;
    }

    @Override
    public Object getItem(int position) {

        return this.mEvents.get(position);
    }

    @Override
    public long getItemId(int i) {

        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {

        View event = convertView;
        if(event == null){
            /*Inflate imageView from a layout file.*/
            event = this.mLayoutInflater.inflate(R.layout.event_list_item,null);
            ((TextView)event.findViewById(R.id.event_details)).setText(this.mItems[position]);
            ((ImageView)event.findViewById(R.id.event_image)).setImageResource(this.eventImages.get(position));
            /* Set click listener for the grid items */
            event.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }

            });

            /* Add grid item to items */
            this.mEvents.add(event);

            /* Set on long click listener for the grid items */
            event.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
        return event;
    }
}
