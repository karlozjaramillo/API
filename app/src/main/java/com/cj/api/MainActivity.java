package com.cj.api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.cj.api.ApiManager.RetrofitClient;
import com.cj.api.models.Characters;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getCharacters();
    }

    private void getCharacters() {
        Call<Characters> call = RetrofitClient.getInstance().getMyApi().getCharacters();
        call.enqueue(new Callback<Characters>() {
            @Override
            public void onResponse(Call<Characters> call, Response<Characters> response) {
                Characters myCharacters = response.body();
                String message = "";
                for (int i = 0; i < myCharacters.getCharacterList().size(); i++) {
                    message = message + myCharacters.getCharacterList().get(i).getnameCharacter() + " - ";
                }
                Toasty.success(getApplicationContext(), message, Toast.LENGTH_LONG, true).show();
//                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Characters> call, Throwable t) {
                Toasty.error(getApplicationContext(), "Ocurrió un error", Toast.LENGTH_SHORT, true).show();
//                Toast.makeText(getApplicationContext(), "Ocurrió un error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}