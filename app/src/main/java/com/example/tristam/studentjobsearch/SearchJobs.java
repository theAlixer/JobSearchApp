package com.example.tristam.studentjobsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SearchJobs extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mToggle;
    private FirebaseAuth firebaseAuth;

    // Testing - try to display the result
//    FirebaseDatabase jobDB;

    // Job Values
    ArrayList<Jobs> jobArrayList = new ArrayList<>(); // 9/8

    // Search components
    private EditText searchValue;
    private Button searchButton;
    public ArrayList<String> list = new ArrayList<>();

    // Testing - try to display the result
//    private RecyclerView resultRV;
//    private SearchJobAdapter searchJobAdapter;

    // Spinners' values
    public String region="";
    public String category= "";
    public String type="";

    // Firebase URL
//    public String url = "https://assignment1-ba25d.firebaseio.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_jobs);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Search component
        searchValue = findViewById(R.id.editText);
        searchButton = findViewById(R.id.searchButton);

        // Testing - try to display the result
//        resultRV = findViewById(R.id.result_recyclerView);

        // jobDB
//        FirebaseDatabase jobDB = FirebaseDatabase.getInstance();
//        DatabaseReference jobRef = jobDB.getReference();


        //listArray
        list.add("potato");
        list.add("tomato");
        list.add("potatomato");

        // Result - RecyclerView
//        resultRV.setHasFixedSize(true);
//        resultRV.setLayoutManager(new LinearLayoutManager(this));
//        resultRV.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        // Testing - try to display the result
//        searchValue.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable text) {
//                if (!text.toString().isEmpty()){
//                    setAdapter(text.toString());
//                } else {
//                    jobArrayList.clear();
//                }
//
//            }
//        });

        // Spinners
        Spinner regionSpinner = findViewById(R.id.regionSpinner);
        Spinner categorySpinner = findViewById(R.id.categorySpinner);
        Spinner jobTypeSpinner = findViewById(R.id.jobTypeSpinner);

        ArrayAdapter<CharSequence> regionAdapter = ArrayAdapter.createFromResource(this,R.array.regions, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> categoryAdapter = ArrayAdapter.createFromResource(this,R.array.categories, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> jobTypeAdapter = ArrayAdapter.createFromResource(this,R.array.jobType, android.R.layout.simple_spinner_item);

        regionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        regionSpinner.setAdapter(regionAdapter);
        regionSpinner.setOnItemSelectedListener(this);

        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(categoryAdapter);
        categorySpinner.setOnItemSelectedListener(this);

        jobTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jobTypeSpinner.setAdapter(jobTypeAdapter);
        jobTypeSpinner.setOnItemSelectedListener(this);

        firebaseAuth = FirebaseAuth.getInstance();

        drawerLayout = findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        searchButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startSearch();
            }
        });
    }

    // Testing - try to display the result
//    private void setAdapter (final String searching){
//        FirebaseDatabase jobDB = FirebaseDatabase.getInstance("jobs");
//        jobDB.getReference().addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                int counter = 0;
//                jobArrayList.clear();
//
//                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
//                    String ID = snapshot.getKey();
//                    String title = snapshot.child("title").getValue(String.class);
//                    String region = snapshot.child("region").getValue(String.class);
//                    String category = snapshot.child("category").getValue(String.class);
//                    String type = snapshot.child("type").getValue(String.class);
//
//                    if (title.toLowerCase().contains(searching.toLowerCase())){
//                        Job job = new Job(title,region,category,type);
//                        jobArrayList.add(job);
//                        counter++;
//                    } else if (title.contains(null)) {
//                        System.out.println(counter + " matching result found.");
//                        break;
//                    }
//                }
//                searchJobAdapter = new SearchJobAdapter(SearchJobs.this,jobArrayList);
//                resultRV.setAdapter(searchJobAdapter);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//            }
//        });
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        switch(item.getItemId()){
            case R.id.logoutMenu:
                Logout();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search_jobs, menu);
        return true;
    }

    private void startSearch() {
        String search = searchValue.getText().toString();

        if (TextUtils.isEmpty(search)) {
            Toast.makeText(SearchJobs.this, "Please enter keyword to search", Toast.LENGTH_SHORT).show();
        } else if (list.contains(search.toLowerCase())) {         //result found
            setContentView(R.layout.activity_search_result);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            Toast.makeText(SearchJobs.this, search + "found.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(SearchJobs.this,  "No matching result for " + search, Toast.LENGTH_SHORT).show();
        }
    }

    private void Logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(SearchJobs.this, Login.class));
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (i > 0) {
            switch (adapterView.getId()) {
                case R.id.regionSpinner:
                    region = adapterView.getItemAtPosition(i).toString();
                    break;
                case R.id.categorySpinner:
                    category = adapterView.getItemAtPosition(i).toString();
                    break;
                case R.id.jobTypeSpinner:
                    type = adapterView.getItemAtPosition(i).toString();
                    break;
            }
        } else {
            switch (adapterView.getId()) {
                case R.id.regionSpinner:
                    region = "";
                    break;
                case R.id.categorySpinner:
                    category = "";
                    break;
                case R.id.jobTypeSpinner:
                    type = "";
                    break;
            }
        }
        //testing spinners'output
        Toast.makeText(adapterView.getContext(), "Region: " + region + "\nCategory: " + category + "\nJob Type: " + type , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
