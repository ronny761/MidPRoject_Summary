package com.example.sqliteexample;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Ronny Ruben on 11/28/2020
 */
class Utils_Sqlite {

    final static String DATABASE_NAME = "pokemons_db_v1";
    final static String TABLE_POKEMON_NAME = "tbl_pokemon";
    final static String TABLE_POKEMON_COL_NAME = "pokemon_name";
    final static String TABLE_POKEMON_COL_TYPE = "pokemon_type";
    final static String TABLE_POKEMON_COL_PIC = "pokemon_pic";


    public static void createDB(SQLiteDatabase db) {
       /* db.execSQL("create table if not exists tbl_pokemon(pokemon_name text,
        pokemon_type text, pokemon_pic int)");*/
        db.execSQL("create table if not exists " +
                TABLE_POKEMON_NAME + "(" + TABLE_POKEMON_COL_NAME + " text, " +
                TABLE_POKEMON_COL_TYPE + " text, " +
                TABLE_POKEMON_COL_PIC + " int)");

    }



    /**
     * just add /** before the header method
     *
     * @param db
     * @param p
     */
    public static void insert_pokemon(SQLiteDatabase db, Pokemon p) {
        db.execSQL("insert into " + TABLE_POKEMON_NAME + " values('" + p.getName() + "'," +
                "'" + p.getType() + "','" + p.getPic() + "');");
    }

    /**
     * .
     *
     * @param db
     * @param name
     */
    public static void delete_pokemon_by_name(SQLiteDatabase db, String name) {
        db.execSQL("delete from " + TABLE_POKEMON_NAME + " where " + TABLE_POKEMON_COL_NAME + "='" +
                name + "'");

    }
}
