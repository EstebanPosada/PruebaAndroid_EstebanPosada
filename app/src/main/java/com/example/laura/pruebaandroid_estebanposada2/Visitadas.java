package com.example.laura.pruebaandroid_estebanposada2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Visitadas extends AppCompatActivity {

    private RecyclerView recyclerView2;
    private List<Movie> movieList2 = new ArrayList<>();
    private MovieAdapter mAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitadas);

        recyclerView2 = (RecyclerView) findViewById(R.id.recyclerview2);
        mAdapter2 = new MovieAdapter(movieList2);
        RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(getApplicationContext());
        recyclerView2.setLayoutManager(mLayoutManager2);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        recyclerView2.setAdapter(mAdapter2);

        prepareMovieData();
    }
    private void prepareMovieData(){

        //String[]

        Movie movie = new Movie("Mad Max: Fury Road", "2h", "Action & Adventure", "2015", "100", "url");
        movieList2.add(movie);

        movie = new Movie("Inside Out", "2h", "Animation, Kids & Family", "2015", "100", "url");
        movieList2.add(movie);

        movie = new Movie("Shaun the Sheep", "2h", "Animation", "2015", "100", "url");
        movieList2.add(movie);

        mAdapter2.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_visitadas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
