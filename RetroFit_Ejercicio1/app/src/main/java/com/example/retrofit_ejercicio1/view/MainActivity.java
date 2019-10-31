package com.example.retrofit_ejercicio1.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.retrofit_ejercicio1.R;
import com.example.retrofit_ejercicio1.model.Post;
import com.example.retrofit_ejercicio1.model.ServicePost;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textViewResult);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/bins/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ServicePost servicePost = retrofit.create(ServicePost.class);

        Call<List<Post>> call = servicePost.traerPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (!response.isSuccessful()) {
                    textView.setText("Codigo" + response.code());
                    return;
                }

                List<Post> posts = response.body();

                for (Post post : posts) {
                    String content = "";
                    content += "ID " + post.getObjectId() + "\n";
                    content += "TITULO " + post.getTitle() + "\n";
                    content += "LINK " + post.getFeed() + "\n\n";

                    textView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });

    }
}
