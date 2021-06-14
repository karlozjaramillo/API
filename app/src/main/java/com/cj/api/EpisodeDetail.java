package com.cj.api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.cj.api.ApiManager.RetrofitClient;
import com.cj.api.models.Episode;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EpisodeDetail extends AppCompatActivity {

    private String id;
    TextView txtNameEpisodeDetail;
    TextView txtAirDateEpisodeDetail;
    TextView txtEpisodeCodeEpisodeDetail;
    TextView txtEpisodeCreatedDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episode_detail);

        Bundle bundle = getIntent().getExtras();
        id = bundle.getString("id");

        txtNameEpisodeDetail = findViewById(R.id.txtNameEpisodeDetail);
        txtAirDateEpisodeDetail = findViewById(R.id.txtAirDateEpisodeDetail);
        txtEpisodeCodeEpisodeDetail = findViewById(R.id.txtEpisodeCodeEpisodeDetail);
        txtEpisodeCreatedDetail = findViewById(R.id.txtEpisodeCreatedDetail);
        getEpisodeById(id);
    }

    private void getEpisodeById(String id) {
        Call<Episode> call = RetrofitClient.getInstance().getMyApi().getEpisode(id);
        call.enqueue(new Callback<Episode>() {
            @Override
            public void onResponse(Call<Episode> call, Response<Episode> response) {
                Episode myEpisode = response.body();
                txtNameEpisodeDetail.setText(myEpisode.getNameEpisode());
                txtAirDateEpisodeDetail.setText("Air Date: " + myEpisode.getAirDateEpisode());
                txtEpisodeCodeEpisodeDetail.setText("Code: " + myEpisode.getEpisodeEpisode());
                txtEpisodeCreatedDetail.setText("Created: " + myEpisode.getCreatedEpisode());
            }

            @Override
            public void onFailure(Call<Episode> call, Throwable t) {
                Toasty.error(getApplicationContext(), "Ocurrió un error", Toast.LENGTH_SHORT, true).show();
            }
        });
    }
}