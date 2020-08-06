package com.example.findthebug;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class ThirdStage extends AppCompatActivity {

    private static final String TAG =
            ThirdStage.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_stage);
    }

    public void onClick(View view)
    {
        // get data from edit text fields 8 move to init views
        EditText editTextName = findViewById(R.id.etThirdName);
        EditText editTextAge = findViewById(R.id.etThirdAge); // 7

        String s = editTextAge.getText().toString();
        Log.d(TAG, "age is: " + s);
        int age = Integer.parseInt(s);
        Log.d(TAG, "age as int is: " + age);
        String name = editTextName.getText().toString();
        Log.d(TAG, "name is: " + name);

        // save in SharedPref
        SharedPreferences sharedPreferences = this.getSharedPreferences(getString(R.string.user_detailes),MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name",name);
        editor.putInt("age",age);
        editor.commit();


        // create intent and compare in next activity
        // notice if data is not the same -> we return here...
        Intent intent = new Intent(this,FourthStage.class);
        intent.putExtra("age",age); // move to resorce 9
        intent.putExtra("name",name); // move to resorce 10
        startActivity(intent);


    }
}