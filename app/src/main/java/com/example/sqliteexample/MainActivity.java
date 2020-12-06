package com.example.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        listView.setClickable(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Pokemon pokemon = pokemonList.get(position);
                Intent intent = new Intent(MainActivity.this, DelteOrUpdate.class);
                intent.putExtra("pokemonName", pokemon.getName());
                startActivity(intent);
            }
        });




        //phase 1- create or open dataBase
        db = openOrCreateDatabase(Utils_Sqlite.DATABASE_NAME, Context.MODE_PRIVATE , null);

        //phase 2 - create tables
        //String create_query_notRecommended= "create table if not exists tbl_pokemon(pokemon_name text, type text, pic int)";
        String create_query = "create table if not exists "+
                Utils_Sqlite.TABLE_POKEMON_NAME+"("+Utils_Sqlite.TABLE_POKEMON_COL_NAME+" text, "+
                Utils_Sqlite.TABLE_POKEMON_COL_TYPE+" text,"+Utils_Sqlite.TABLE_POKEMON_COL_PIC+" int)";
        db.execSQL(create_query);

        String delete_query = "DELETE FROM tbl_pokemons";
        db.execSQL(delete_query);
        //phase 2 - insert data into tables
        //db.execSQL("INSERT INTO tbl_pokemons VALUES ('gengar', 'electricity','"+R.drawable.gengar+"')");
        String insert_query = "insert into "+Utils_Sqlite.TABLE_POKEMON_NAME+" values('"+pk1.getName()+
                "', '"+pk1.getType()+"', '"+pk1.getPic()+"')";
        db.execSQL(insert_query);



        //slkdlksad
            
    }
}