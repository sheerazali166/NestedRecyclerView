package com.example.nestedrecyclerview.model;

import java.util.List;

public class Movie {

    String name;
    List<Actor> actorList;

    public Movie(String _name) {
        this.name = _name;
    }

    public String getName() {

        return name;
    }

    public List<Actor> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actor> _actorList) {
        this.actorList = _actorList;
    }
}
