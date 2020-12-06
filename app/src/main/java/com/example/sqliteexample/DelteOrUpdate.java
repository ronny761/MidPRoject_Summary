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

    EditText et_name,et_type;
    ImageView iv_pic;

    Button btnUpdate, bt2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delte_or_update);

        Intent intent = getIntent();
        String name = intent.getExtras().getString("pokemonName");

        et_name=findViewById(R.id.name);
        et_type=findViewById(R.id.edit_type);
        iv_pic=findViewById(R.id.editPic);

        //phase1  - open database
        db = openOrCreateDatabase(Utils_Sqlite.DATABASE_NAME, Context.MODE_PRIVATE, null);

        //extract data from table by name
        Cursor c = db.rawQuery("select * from "+Utils_Sqlite.TABLE_POKEMON_NAME+
                " where "+Utils_Sqlite.TABLE_POKEMON_COL_NAME+"='"+name+"'",null);
        c.moveToFirst();



       et_name.setText(c.getString(0));
       et_type.setText(c.getString(1));
       //iv_pic.setImageDrawable(c.getInt(2));

        btnUpdate=findViewById(R.id.btnUpdate);
        bt2=findViewById(R.id.btn_delete);

        btnUpdate.setOnClickListener(this);
        bt2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(btnUpdate==view)
        {
            db.execSQL("UPDATE "+Utils_Sqlite.TABLE_POKEMON_NAME+" SET "+Utils_Sqlite.TABLE_POKEMON_COL_NAME+" = '"+
                    et_name.getText().toString()+"' WHERE "+Utils_Sqlite.TABLE_POKEMON_COL_TYPE+
                    " = '"+et_type.getText().toString()+"'");
            Toast.makeText(this, "update successfully", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(DelteOrUpdate.this, MainActivity.class));
            finish();
        }

        if(bt2==view)
        {
            /*db.execSQL("DELETE FROM students WHERE id='"+ev1.getText().toString()+"'");
            Intent refresh = new Intent(this, );
            startActivity(refresh);
            finish();*/
        }

    }
}
