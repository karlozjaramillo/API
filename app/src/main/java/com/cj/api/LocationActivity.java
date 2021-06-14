package com.cj.api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.cj.api.ApiManager.RetrofitClient;
import com.cj.api.models.Locations;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lvLocations;
    Locations locations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        lvLocations = findViewById(R.id.lvLocations);
        getLocationsFromApi();
        lvLocations.setOnItemClickListener(this);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, LocationDetail.class);
        intent.putExtra("id", locations.getLocationList().get(position).getIdLocation());
        startActivity(intent);
    }
}