package com.example.laura.pruebaandroid_estebanposada2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Laura on 28/08/2016.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private List<Movie> movieList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name, dura, gend, age, hora, url;

        public MyViewHolder(View view){
            super(view);
            name = (TextView) view.findViewById(R.id.idname);
            dura = (TextView) view.findViewById(R.id.iddura);
            gend = (TextView) view.findViewById(R.id.idgen);
            age = (TextView) view.findViewById(R.id.idage);
            hora = (TextView) view.findViewById(R.id.idhora);
            url = (TextView) view.findViewById(R.id.idurl);

        }
    }

    public MovieAdapter(List<Movie> movieList){
        this.movieList = movieList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_list, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        Movie movie = movieList.get(i);
        myViewHolder.name.setText(movie.getName());
        myViewHolder.dura.setText(movie.getDura());
        myViewHolder.gend.setText(movie.getGend());
        myViewHolder.age.setText(movie.getAge());
        myViewHolder.hora.setText(movie.getHora());
        myViewHolder.url.setText(movie.getUrl());
    }


    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
