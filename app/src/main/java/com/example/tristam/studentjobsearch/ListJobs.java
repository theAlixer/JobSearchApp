package com.example.tristam.studentjobsearch;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListJobs extends AppCompatActivity {

    private RecyclerView recyclerView;

    private RecyclerView.Adapter mAdapter;
    private ArrayList<Jobs> jobsList;
    DrawerLayout drawerLayout2;

    private ActionBarDrawerToggle mToggle;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_jobs);
        jobsList = new ArrayList<>();
        Jobs job1 = new Jobs("Web Developer", "Wellington", "IT", "Full-Time");
        Jobs job2 = new Jobs("Designer", "Auckland", "Art", "One-Off");
        Jobs job3 = new Jobs("Accountant", "Canterbury", "accounting", "Permanent");
        jobsList.add(job1);
        jobsList.add(job2);
        jobsList.add(job3);

        recyclerView = findViewById(R.id.myRecycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ListJobAdapter(jobsList);
        recyclerView.setAdapter(mAdapter);

//        firebaseAuth = FirebaseAuth.getInstance();
//
//        drawerLayout2 = findViewById(R.id.drawer_layout);
//        mToggle = new ActionBarDrawerToggle(this, drawerLayout2, R.string.open, R.string.close);
//
//        //drawerLayout2.addDrawerListener(mToggle);
//        mToggle.syncState();
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
//
//    private void Logout(){
//        firebaseAuth.signOut();
//        finish();
//        startActivity(new Intent(ListJobs.this, Login.class));
//    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        if(mToggle.onOptionsItemSelected(item)){
//            return true;
//        }
//        switch(item.getItemId()){
//            case R.id.logoutMenu:
//                Logout();
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_search_jobs, menu);
//        return true;
//    }

}

//    //testing
//    private void displayListItems(){
//       job = new Jobs();
//
//        final ArrayList<String> jobTitleList = new ArrayList<>();
//        final ArrayList<String> categoryList = new ArrayList<>();
//        final ArrayList<String> regionList = new ArrayList<>();
//        final ArrayList<String> jobTypeList = new ArrayList<>();
//
//
//       final FirebaseRecyclerAdapter<Jobs, ListJobAdapter> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Jobs, ListJobAdapter>
//                (Jobs.class, R.layout.list_jobs_holder, ListJobAdapter.class, mDatabase){
//
//            @Override
//            protected void onBindViewHolder(@NonNull ListJobAdapter viewHolder, int position, @NonNull Jobs model) {
//
//                viewHolder.setJobTitle(model.getTitle());
//                viewHolder.setCategory(model.getCategory());
//                viewHolder.setRegion(model.getRegion());
//                viewHolder.setJobType(model.getType());
//            }
//        };
//
//       recyclerView.setAdapter(firebaseRecyclerAdapter);
//
//
//        adapter = new ArrayAdapter<String>(this, R.layout.list_jobs_holder, R.id.textView_job_title);
//        mDatabase.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                //finds the items listed under assignment1 database
//                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){
//                    ArrayList<String> fullJobList = new ArrayList<>();
//
//                    job = postSnapshot.getValue(Jobs.class);
//                    fullJobList.add(job.getTitle());
//                    fullJobList.add(job.getCategory());
//                    fullJobList.add(job.getRegion());
//                    fullJobList.add(job.getType());
//
//                }
//                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }


