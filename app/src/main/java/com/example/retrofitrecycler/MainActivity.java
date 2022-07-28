package com.example.retrofitrecycler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;


import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private RecyclerView courseRV;

    private CourseAdapter adapter;
    private ArrayList<CourseModel> courseModalArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        courseRV = findViewById(R.id.idRv);

        buildRecyclerView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();


        inflater.inflate(R.menu.search_menu, menu);


        MenuItem searchItem = menu.findItem(R.id.actionSearch);


        SearchView searchView = (SearchView) searchItem.getActionView();


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                filter(newText);
                return false;
            }
        });
        return true;
    }

    private void filter(String text) {

        ArrayList<CourseModel> filteredlist = new ArrayList<>();


        for (CourseModel item : courseModalArrayList) {

            if (item.getCourseName().toLowerCase().contains(text.toLowerCase())) {

                filteredlist.add(item);
            }
        }
        if (filteredlist.isEmpty()) {

            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show();
        } else {

            adapter.filterList(filteredlist);
        }
    }

    private void buildRecyclerView() {


        courseModalArrayList = new ArrayList<>();


        courseModalArrayList.add(new CourseModel("DSA", "DSA Self Paced Course"));
        courseModalArrayList.add(new CourseModel("JAVA", "JAVA Self Paced Course"));
        courseModalArrayList.add(new CourseModel("C++", "C++ Self Paced Course"));
        courseModalArrayList.add(new CourseModel("Python", "Python Self Paced Course"));
        courseModalArrayList.add(new CourseModel("Fork CPP", "Fork CPP Self Paced Course"));


        adapter = new CourseAdapter(courseModalArrayList, MainActivity.this);


        LinearLayoutManager manager = new LinearLayoutManager(this);
        courseRV.setHasFixedSize(true);


        courseRV.setLayoutManager(manager);


        courseRV.setAdapter(adapter);
    }
}