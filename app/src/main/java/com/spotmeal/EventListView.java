package com.spotmeal;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EventListView extends AppCompatActivity {

    private ListView eventsListView;
    private String[] eventDetails;
    private ArrayList<Integer> eventsThumbnail = new ArrayList<Integer>(
            Arrays.asList(R.drawable.map_icon, R.drawable.map_icon, R.drawable.map_icon, R.drawable.map_icon) );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_list_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button viewMap = (Button) findViewById(R.id.view_map);
        viewMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EventListView.this, MapViewActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button filters = (Button) findViewById(R.id.filters);
        filters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        this.eventDetails = getResources().getStringArray(R.array.events);

         /* Get list view */
        eventsListView = (ListView) findViewById(android.R.id.list );

        /* Set Array Adapter for the ListView */
        eventsListView.setAdapter( new EventAdapter(this,this.eventDetails , this.eventsThumbnail));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_event_list_view, menu);

//         Associate searchable configuration with the SearchView
//        SearchManager searchManager =
//                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        SearchView searchView =
//                (SearchView) menu.findItem(R.id.search).getActionView();
//        searchView.setSearchableInfo(
//                searchManager.getSearchableInfo(getComponentName()));

        // Implement text change listener here
        return true;

    }
}
