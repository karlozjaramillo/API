package com.cj.api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.cj.api.ApiManager.RetrofitClient;
import com.cj.api.models.Episodes;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EpisodesActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lvEpisodes;
    Episodes episodes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episodes);

        lvEpisodes = findViewById(R.id.lvEpisodes);
        getEpisodesFromApi();
        lvEpisodes.setOnItemClickListener(this);
    }

    private void getEpisodesFromApi(){
        Call<Episodes> call = RetrofitClient.getInstance().getMyApi().getEpisodes();
        call.enqueue(new Callback<Episodes>() {
            @Override
            public void onResponse(Call<Episodes> call, Response<Episodes> response) {
                episodes = response.body();

                EpisodeAdapter adapter = new EpisodeAdapter(EpisodesActivity.this, episodes.getEpisodeList());
                lvEpisodes.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Episodes> call, Throwable t) {
                Toasty.error(getApplicationContext(), "Ocurrió un error", Toast.LENGTH_SHORT, true).show();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, EpisodeDetail.class);
        intent.putExtra("id", episodes.getEpisodeList().get(position).getIdEpisode());
        startActivity(intent);
    }
}