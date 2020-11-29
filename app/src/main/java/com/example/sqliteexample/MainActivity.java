package com.example.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    ArrayList<Pokemon> pokemonList;
    PokemonAdapter adapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide(); //<< this

        listView = findViewById(R.id.listview);

        Pokemon pk1 = new Pokemon("dedenne", "electricity", R.drawable.dedenne);
        Pokemon pk2 = new Pokemon("gengar", "earth", R.drawable.gengar);
        Pokemon pk3 = new Pokemon("togekiss", "mental", R.drawable.togekiss);

        pokemonList = new ArrayList<Pokemon>();
        pokemonList.add(pk1);
        pokemonList.add(pk2);
        pokemonList.add(pk3);

        adapter = new PokemonAdapter(pokemonList,MainActivity.this);
        listView.setAdapter(adapter);











        db = openOrCreateDatabase(Utils_Sqlite.DATABASE_NAME, Context.MODE_PRIVATE , null);

        String create_query = "create table if not exists tbl_pokemons(name text, type text,pic int)";
        db.execSQL(create_query);

        db.execSQL("INSERT INTO tbl_pokemons VALUES ('gengar', 'electricity','"+R.drawable.gengar+"')");

        String delete_query = "DELETE FROM tbl_pokemons WHERE name ='gengar'";
        db.execSQL(delete_query);

        //slkdlksad
            
    }
}