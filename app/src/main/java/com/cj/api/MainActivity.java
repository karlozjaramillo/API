package com.cj.api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.cj.api.ApiManager.RetrofitClient;
import com.cj.api.models.Civilization;
import com.cj.api.models.Civilizations;

import java.util.List;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getCivilizations();
    }

    private void getCivilizations() {
        Call<Civilizations> call = RetrofitClient.getInstance().getMyApi().getCivilizations();
        call.enqueue(new Callback<Civilizations>() {
            @Override
            public void onResponse(Call<Civilizations> call, Response<Civilizations> response) {
                Civilizations myCivilizations = response.body();
                String message = "";
                for (int i = 0; i < myCivilizations.getCivilizationList().size(); i++) {
                    message = message + myCivilizations.getCivilizationList().get(i).getNameCivilization() + " - ";
                }
                Toasty.success(getApplicationContext(), message, Toast.LENGTH_LONG, true).show();
//                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Civilizations> call, Throwable t) {
                Toasty.error(getApplicationContext(), "Ocurrió un error", Toast.LENGTH_SHORT, true).show();
//                Toast.makeText(getApplicationContext(), "Ocurrió un error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}