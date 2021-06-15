package com.cj.api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.cj.api.ApiManager.RetrofitClient;
import com.cj.api.models.Location;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationDetail extends AppCompatActivity {

    private String id;
    TextView txtNameLocationDetail;
    TextView txtTypeLocationDetail;
    TextView txtDimensionLocationDetail;
    TextView txtCreatedLocationDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_detail);

        Bundle bundle = getIntent().getExtras();
        id = bundle.getString("id");

        txtNameLocationDetail = findViewById(R.id.txtNameLocationDetail);
        txtTypeLocationDetail = findViewById(R.id.txtTypeLocationDetail);
        txtDimensionLocationDetail = findViewById(R.id.txtDimensionLocationDetail);
        txtCreatedLocationDetail = findViewById(R.id.txtCreatedLocationDetail);

        getLocationById(id);
    }

    private void getLocationById(String id) {
        Call<Location> call = RetrofitClient.getInstance().getMyApi().getLocation(id);
        call.enqueue(new Callback<Location>() {
            @Override
            public void onResponse(Call<Location> call, Response<Location> response) {
                Location myLocation = response.body();
                txtNameLocationDetail.setText(myLocation.getNameLocation());
                txtTypeLocationDetail.setText(myLocation.getTypeLocation());
                txtDimensionLocationDetail.setText(myLocation.getDimensionLocation());
                txtCreatedLocationDetail.setText(myLocation.getCreatedLocation());
            }

            @Override
            public void onFailure(Call<Location> call, Throwable t) {
                Toasty.error(getApplicationContext(), "Ocurrió un error", Toast.LENGTH_SHORT, true).show();
            }
        });
    }
}