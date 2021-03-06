package com.example.quarantinerecs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class MovieActivity extends AppCompatActivity {

    EditText searchBar;
    TextView plotTextView;
    TextView ratedTextView;
    TextView runtimeTextView;
    TextView imdbRatingTextView;
    ImageView moviePosterImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        searchBar = findViewById(R.id.search_bar);
        plotTextView = findViewById(R.id.plot_tv);
        ratedTextView = findViewById(R.id.rated_tv);
        runtimeTextView = findViewById(R.id.runtime_tv);
        imdbRatingTextView = findViewById(R.id.imdb_rating_tv);
        moviePosterImageView = findViewById(R.id.movie_poster_iv);
    }

    public void fetchData(View view) {

        String movieSearched = searchBar.getText().toString();

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://www.omdbapi.com/?apikey=388d5f18&t=" + movieSearched;

        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String plotText = response.getString("Plot");
                            plotTextView.setText(plotText);
                            String ratedText = "Rated: " + response.getString("Rated");
                            ratedTextView.setText(ratedText);
                            String runtimeText = "Runtime: " + response.getString("Runtime");
                            runtimeTextView.setText(runtimeText);
                            String imdbRatingText = "IMDB Rating: " + response.getString("imdbRating");
                            imdbRatingTextView.setText(imdbRatingText);
                            String moviePosterUrl = response.getString("Poster");
                            Picasso.get().load(moviePosterUrl).into(moviePosterImageView);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(stringRequest);
    }

}