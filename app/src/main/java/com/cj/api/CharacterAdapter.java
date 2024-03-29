package com.cj.api;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.text.Html;

import com.cj.api.models.Character;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CharacterAdapter extends BaseAdapter {

    protected Activity activity;
    protected List<Character> myCharacters;

    public CharacterAdapter(Activity activity, List<Character> myCharacters) {
        this.activity = activity;
        this.myCharacters = myCharacters;
    }

    @Override
    public int getCount() {
        return myCharacters.size();
    }

    @Override
    public Object getItem(int position) {
        return myCharacters.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.character_item, null);
        }
        Character character = myCharacters.get(position);
        TextView nameCharacter = view.findViewById(R.id.tvNameCharacter);
        TextView statusCharacter = view.findViewById(R.id.tvStatus);
        TextView speciesCharacter = view.findViewById(R.id.tvSpecies);
        TextView genderCharacter = view.findViewById(R.id.tvGender);
        nameCharacter.setText(character.getNameCharacter());
        statusCharacter.setText(Html.fromHtml("<strong style='font-weight: bold;'>Status: </strong>") + character.getStatusCharacter());
        speciesCharacter.setText("Species: " + character.getSpeciesCharacter());
        genderCharacter.setText("Gender: " + character.getGenderCharacter());
        ImageView imageCharacter = view.findViewById(R.id.ivImageCharacter);

        Picasso.get()
                .load(character.getImageCharacter())
                .resize(100, 100)
                .centerCrop()
                .error(R.mipmap.ic_launcher)
                .into(imageCharacter);

        return view;
    }
}
