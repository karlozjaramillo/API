package com.cj.api;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cj.api.models.Episode;

import java.util.List;

public class EpisodeAdapter extends BaseAdapter {

    protected Activity activity;
    protected List<Episode> episodeList;

    public EpisodeAdapter(Activity activity, List<Episode> episodeList) {
        this.activity = activity;
        this.episodeList = episodeList;
    }

    @Override
    public int getCount() {
        return episodeList.size();
    }

    @Override
    public Object getItem(int position) {
        return episodeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.episode_item, null);
        }
        Episode episode = episodeList.get(position);
        TextView nameEpisode = view.findViewById(R.id.tvNameEpisode);
        TextView airDateEpisode = view.findViewById(R.id.tvAirDate);
        TextView episodeEpisode = view.findViewById(R.id.tvEpisode);
        TextView createdEpisode = view.findViewById(R.id.tvCreated);
        nameEpisode.setText(episode.getNameEpisode());
        airDateEpisode.setText(episode.getAirDateEpisode());
        episodeEpisode.setText(episode.getEpisodeEpisode());
        createdEpisode.setText(episode.getCreatedEpisode());

        return view;
    }
}
