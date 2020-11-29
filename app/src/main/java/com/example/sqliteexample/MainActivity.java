package com.example.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide(); //<< this


        db = openOrCreateDatabase(Utils_Sqlite.DATABASE_NAME, Context.MODE_PRIVATE , null);

        String create_query = "create table if not exists tbl_pokemons(name text, type text,pic int)";
        db.execSQL(create_query);

        db.execSQL("INSERT INTO tbl_pokemons VALUES ('gengar', 'electricity','"+R.drawable.gengar+"')");

        String delete_query = "DELETE FROM tbl_pokemons WHERE name ='gengar'";
        db.execSQL(delete_query);

        //slkdlksad
            
    }
}