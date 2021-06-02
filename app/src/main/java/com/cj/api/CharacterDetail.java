package com.cj.api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.cj.api.ApiManager.RetrofitClient;
import com.cj.api.models.Character;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterDetail extends AppCompatActivity {

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_detail);

        Bundle bundle = getIntent().getExtras();

        id = bundle.getString("id");

//        Toasty.success(this, id, Toasty.LENGTH_LONG).show();

        getCharacterById(id);
    }

    private void getCharacterById(String id){
        Call<Character> call = RetrofitClient.getInstance().getMyApi().getCharacter(id);
        call.enqueue(new Callback<Character>() {
            @Override
            public void onResponse(Call<Character> call, Response<Character> response) {
                Character myCharacter = response.body();
                Toasty.success(getApplicationContext(), myCharacter.getNameCharacter(), Toast.LENGTH_SHORT, true).show();
            }

            @Override
            public void onFailure(Call<Character> call, Throwable t) {
                Toasty.error(getApplicationContext(), "Ocurrió un error", Toast.LENGTH_SHORT, true).show();
            }
        });
    }
}