package com.cj.api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.cj.api.ApiManager.RetrofitClient;
import com.cj.api.models.Episodes;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EpisodesActivity extends AppCompatActivity {

    ListView lvEpisodes;
    Episodes episodes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episodes);

        lvEpisodes = findViewById(R.id.lvEpisodes);
        getEpisodesFromApi();
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
}