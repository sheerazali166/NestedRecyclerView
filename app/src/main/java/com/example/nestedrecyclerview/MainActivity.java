package com.example.nestedrecyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nestedrecyclerview.model.Actor;
import com.example.nestedrecyclerview.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerViewMovie = findViewById(R.id.rv_movie);

//        MovieAdapter movieAdapter = new MovieAdapter(this,)

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewMovie.setLayoutManager(linearLayoutManager);
        recyclerViewMovie.setHasFixedSize(true);

        MovieAdapter movieAdapter = new MovieAdapter(this, createMoviesAndCasts());
        recyclerViewMovie.setAdapter(movieAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private List<Movie> createMoviesAndCasts() {

        // Create Casts
        List<Actor> castLion = new ArrayList<>();
        List<Actor> castLaLaLand = new ArrayList<>();
        List<Actor> castMoonLight = new ArrayList<>();
        List<Actor> castArrival = new ArrayList<>();
        List<Actor> castFences = new ArrayList<>();

        castLion.add(new Actor("Sunny Pawar"));
        castLion.add(new Actor("Abhishek Bharate"));
        castLion.add(new Actor("Priyanka Bose"));
        castLion.add(new Actor("Khushi Solanki"));
        castLion.add(new Actor("Shankar Nisode"));

        castLaLaLand.add(new Actor("Ryan Gosling"));
        castLaLaLand.add(new Actor("Emma Stone"));
        castLaLaLand.add(new Actor("Amiee Conn"));
        castLaLaLand.add(new Actor("Thom Shelton"));
        castLaLaLand.add(new Actor("Terry Walters"));
        castLaLaLand.add(new Actor("Cinda Adams"));

        castMoonLight.add(new Actor("Mahershala Ali"));
        castMoonLight.add(new Actor("Duan Sanderson"));
        castMoonLight.add(new Actor("Janelle Monae"));
        castMoonLight.add(new Actor("Asthon Sanders"));
        castMoonLight.add(new Actor("Patrick Decile"));

        castArrival.add(new Actor("Amy Adams"));
        castArrival.add(new Actor("Alexander Da Mota"));
        castArrival.add(new Actor("Akul Dang"));
        castArrival.add(new Actor("Frank Fiola"));

        castFences.add(new Actor("Denzel Washington"));
        castFences.add(new Actor("Lesley Boon"));
        castFences.add(new Actor("Denzel Washington"));
        castFences.add(new Actor("Jason Silvis"));
        castFences.add(new Actor("Viola Davis"));
        castFences.add(new Actor("Jovan Adepo"));

        // Create Movies
        Movie lion = new Movie("Lion");
        lion.setActorList(castLion);

        Movie lalaland = new Movie("La La Land");
        lalaland.setActorList(castLaLaLand);

        Movie moonLight = new Movie("Moonlight");
        moonLight.setActorList(castMoonLight);

        Movie arrival = new Movie("Arrival");
        arrival.setActorList(castArrival);

        Movie fences = new Movie("Fences");
        fences.setActorList(castFences);

        // Add movies to our list
        List<Movie> movieList = new ArrayList<>();

        movieList.add(lion);
        movieList.add(lalaland);
        movieList.add(moonLight);
        movieList.add(arrival);
        movieList.add(fences);

        return movieList;

    }
}