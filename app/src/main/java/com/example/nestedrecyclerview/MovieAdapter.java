package com.example.nestedrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nestedrecyclerview.model.Actor;
import com.example.nestedrecyclerview.model.Movie;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    Context context;
    List<Movie> movieList;

    public MovieAdapter(Context _context, List<Movie> _movieList) {

        this.context = _context;
        this.movieList = _movieList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View rootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nested_recycler_actor, viewGroup, false);

        return new MyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int position) {

        Movie movie = movieList.get(position);
        viewHolder.textViewMovieName.setText(movie.getName() + " Cast:");
        addActorLayoutManager(viewHolder.recyclerViewActor, movie.getActorList());

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    private void addActorLayoutManager(RecyclerView recyclerViewActor, List<Actor> actorList) {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewActor.setLayoutManager(linearLayoutManager);
        ActorAdapter actorAdapter = new ActorAdapter(actorList);
        recyclerViewActor.setAdapter(actorAdapter);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.rv_actor) RecyclerView recyclerViewActor;
        @BindView(R.id.movieName) TextView textViewMovieName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
