package com.cj.api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.cj.api.ApiManager.RetrofitClient;
import com.cj.api.models.Locations;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationActivity extends AppCompatActivity {

    ListView lvLocations;
    Locations locations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        lvLocations = findViewById(R.id.lvLocations);
        getLocationsFromApi();
    }

    private void getLocationsFromApi(){
        Call<Locations> call = RetrofitClient.getInstance().getMyApi().getLocations();
        call.enqueue(new Callback<Locations>() {
            @Override
            public void onResponse(Call<Locations> call, Response<Locations> response) {
                locations = response.body();

                LocationAdapter adapter = new LocationAdapter(LocationActivity.this, locations.getLocationList());
                lvLocations.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Locations> call, Throwable t) {

            }
        });
    }
}