package com.example.sqliteexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PokemonAdapter extends BaseAdapter {
    ArrayList<Pokemon> pokemon_list;
    Context context;

    public PokemonAdapter(ArrayList<Pokemon> pokemon_list, Context context) {
        this.pokemon_list = pokemon_list;
        this.context = context;
    }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Pokemon pokemon = pokemon_list.get(i);

        view = LayoutInflater.from(context).inflate(R.layout.row_list_pokimon,null);
        TextView tv_type = view.findViewById(R.id.tv_type);
        TextView tv_name = view.findViewById(R.id.tv_name);
        ImageView iv_pic = view.findViewById(R.id.iv_pic);

        tv_name.setText(pokemon.getName());
        tv_type.setText(pokemon.getType());
        iv_pic.setImageResource(pokemon.getPic());

        return  view;

    }
}
