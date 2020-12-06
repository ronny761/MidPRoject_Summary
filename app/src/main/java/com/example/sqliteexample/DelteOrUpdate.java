package com.example.sqliteexample;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DelteOrUpdate extends AppCompatActivity implements View.OnClickListener {

    SQLiteDatabase db;

    EditText et_name,et_type,ev3;
    ImageView iv_pic;

    Button bt1, bt2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delte_or_update);

        Intent intent = getIntent();
        String pokemonName =intent.getExtras().getString("pokemonName");


        //phase1  - open database
        db = openOrCreateDatabase(Utils_Sqlite.DATABASE_NAME, Context.MODE_PRIVATE, null);

        Cursor c = db.rawQuery("SELECT * FROM "+Utils_Sqlite.TABLE_POKEMON_NAME+
                " WHERE "+Utils_Sqlite.TABLE_POKEMON_COL_NAME+"='"+pokemonName+"'",null);


        c.moveToFirst();

        et_name=findViewById(R.id.name);
        et_type=findViewById(R.id.edit_type);
        iv_pic=findViewById(R.id.editPic);

       et_name.setText(c.getString(0));
       et_type.setText(c.getString(1));
       ev3.setText(c.getString(2));
       //ev4.setText(c.getString(3));

        bt1=findViewById(R.id.btdel);
        bt2=findViewById(R.id.btupdate);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(bt1==view)
        {
            /*db.execSQL("DELETE FROM students WHERE id='"+ev1.getText().toString()+"'");
            Intent refresh = new Intent(this, );
            startActivity(refresh);
            finish();*/
        }

        if(bt2==view)
        {
            
        }

    }
}
