package com.avi.tal.iot.iotapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.avi.tal.iot.R;

import java.util.ArrayList;
import java.util.Vector;

public class group_friends extends AppCompatActivity {
    private RecyclerView recycler;
    private RecyclerView.LayoutManager manager;
    private RecyclerView.Adapter adapter;
    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<String[]> groups;
    private String[] MyGroups;
    private TextView textView;
    private String multiline = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_friends);
        textView = (TextView) findViewById(R.id.textview);
        //recycler = (RecyclerView) findViewById(R.id.recyclerView);
        //recycler.setHasFixedSize(true);
        //manager = new GridLayoutManager(this, 5, GridLayoutManager.VERTICAL, false);
        //recycler.setLayoutManager(manager);
        MyGroups = getIntent().getStringArrayExtra("groupFriends");
        //getList();    //initialize your list in this method
        for (int i = 0; i < MyGroups.length; ++i){
            //textView.setSingleLine(true);
            multiline+=String.valueOf(i) + ": " + MyGroups[i] + "\n";
            list.add(MyGroups[i]);

            //textView.setText(MyGroups[i]);
            //textView.append(String.valueOf(i) + ": " + MyGroups[i]);
        }
        textView.setText(multiline);
        /*adapter = new Adapter(list, this);
        recycler.setAdapter(adapter);*/
    }

}
