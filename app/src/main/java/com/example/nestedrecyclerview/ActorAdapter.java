package com.example.nestedrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nestedrecyclerview.model.Actor;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.MyViewHolder> {

    private List<Actor> actorList;

    public ActorAdapter(List<Actor> _actorList) {
        this.actorList = _actorList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View rootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_actor, viewGroup, false);

        return new MyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int position) {


        Actor actor = actorList.get(position);
       viewHolder.textViewActorView.setText(actor.getName());

    }

    @Override
    public int getItemCount() {
        return actorList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.actor_name)
        TextView textViewActorView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
