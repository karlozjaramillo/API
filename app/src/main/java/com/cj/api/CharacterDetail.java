package com.cj.api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cj.api.ApiManager.RetrofitClient;
import com.cj.api.models.Character;
import com.squareup.picasso.Picasso;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterDetail extends AppCompatActivity {

    private String id;
    private ImageView imgCharacterDetail;
    private TextView txtNameCharacterDetail;
    private TextView txtStatusCharacterDetail;
    private TextView txtSpeciesCharacterDetail;
    private TextView txtGenderCharacterDetail;
    private TextView txtCreatedCharacterDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_detail);

        Bundle bundle = getIntent().getExtras();

        id = bundle.getString("id");
        imgCharacterDetail = findViewById(R.id.imgCharacterDetail);
        txtNameCharacterDetail = findViewById(R.id.txtNameCharacterDetail);
        txtStatusCharacterDetail = findViewById(R.id.txtStatusCharacterDetail);
        txtSpeciesCharacterDetail = findViewById(R.id.txtSpeciesCharacterDetail);
        txtGenderCharacterDetail = findViewById(R.id.txtGenderCharacterDetail);
        txtCreatedCharacterDetail = findViewById(R.id.txtCreatedCharacterDetail);

//        Toasty.success(this, id, Toasty.LENGTH_LONG).show();

        getCharacterById(id);
    }

    private void getCharacterById(String id) {
        Call<Character> call = RetrofitClient.getInstance().getMyApi().getCharacter(id);
        call.enqueue(new Callback<Character>() {
            @Override
            public void onResponse(Call<Character> call, Response<Character> response) {
                Character myCharacter = response.body();
                Picasso.get()
                        .load(myCharacter.getImageCharacter())
                        .resize(300, 300)
                        .centerCrop()
                        .error(R.mipmap.ic_launcher)
                        .into(imgCharacterDetail);
                txtNameCharacterDetail.setText(myCharacter.getNameCharacter());
                txtStatusCharacterDetail.setText(myCharacter.getStatusCharacter());
                txtSpeciesCharacterDetail.setText(myCharacter.getSpeciesCharacter());
                txtGenderCharacterDetail.setText(myCharacter.getGenderCharacter());
                txtCreatedCharacterDetail.setText(myCharacter.getCreatedCharacter());
//                Toasty.success(getApplicationContext(), myCharacter.getNameCharacter(), Toast.LENGTH_SHORT, true).show();
            }

            @Override
            public void onFailure(Call<Character> call, Throwable t) {
                Toasty.error(getApplicationContext(), "Ocurrió un error", Toast.LENGTH_SHORT, true).show();
            }
        });
    }
}