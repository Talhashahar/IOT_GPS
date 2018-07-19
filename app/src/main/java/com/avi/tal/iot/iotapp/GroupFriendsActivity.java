package com.avi.tal.iot.iotapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.avi.tal.iot.R;
import com.avi.tal.iot.iotapp.entities.TrackerUser;

import java.util.ArrayList;

public class GroupFriendsActivity extends BaseActivity {



    private RecyclerView mTrackerUsers;
    private TextView mLightAvg;
    private ArrayList<TrackerUser> myGroups;
    private float sumLight = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_friends_layout);

        myGroups = getIntent().getParcelableArrayListExtra("groupFriends");

        mTrackerUsers = findViewById(R.id.users_recycler);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mTrackerUsers.setLayoutManager(mLayoutManager);

        mLightAvg = findViewById(R.id.light_avg);


        if(myGroups != null) {

            for(TrackerUser user : myGroups) {
                sumLight += user.getMaxLight();
            }
            sumLight /= myGroups.size();

            mLightAvg.setText(String.valueOf(sumLight));
            mTrackerUsers.setAdapter(new TrackerAdapter(this, myGroups));
        }

    }

    private class TrackerAdapter extends RecyclerView.Adapter<TrackerAdapter.TrackerViewHolder> {

        private ArrayList<TrackerUser> mUsers;
        private Context mContext;

        public TrackerAdapter(Context context, ArrayList<TrackerUser> users) {
            mUsers = users;
            mContext = context;
        }

        @NonNull
        @Override
        public TrackerAdapter.TrackerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new TrackerViewHolder(LayoutInflater.from(mContext).inflate(R.layout.tracker_user_item_layout, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull TrackerAdapter.TrackerViewHolder holder, int position) {
            holder.mTrackerUserName.setText(mUsers.get(position).getDisplayName());
        }

        @Override
        public int getItemCount() {
            return mUsers.size();
        }

        public class TrackerViewHolder extends RecyclerView.ViewHolder{
            private TextView mTrackerUserName;

            public TrackerViewHolder(View itemView) {
                super(itemView);

                mTrackerUserName = itemView.findViewById(R.id.name);
            }
        }


    }

}
