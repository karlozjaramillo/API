package com.cj.api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.cj.api.ApiManager.RetrofitClient;
import com.cj.api.models.Characters;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listCharacters;
    Characters myCharacters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listCharacters = findViewById(R.id.lvCharacters);
        getCharactersFromApi();
        listCharacters.setOnItemClickListener(this);
    }

    private void getCharactersFromApi() {
        Call<Characters> call = RetrofitClient.getInstance().getMyApi().getCharacters();
        call.enqueue(new Callback<Characters>() {
            @Override
            public void onResponse(Call<Characters> call, Response<Characters> response) {
                myCharacters = response.body();
                String message = "";

                CharacterAdapter adapter = new CharacterAdapter(MainActivity.this, myCharacters.getCharacterList());
                listCharacters.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Characters> call, Throwable t) {
                Toasty.error(getApplicationContext(), "Ocurrió un error", Toast.LENGTH_SHORT, true).show();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, CharacterDetail.class);
        intent.putExtra("id", myCharacters.getCharacterList().get(position).getIdCharacter());
        startActivity(intent);
    }
}