package com.example.findthebug;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FourthStage extends AppCompatActivity {

    private EditText etName,etAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_stage); // 9 order
        initViews();



    }

    private void initViews()
    {
        etName=findViewById(R.id.etFourthName);
        etAge=findViewById(R.id.etFourthAge);
    }

    //compare between data in shared preferences and intent received
    // if not equal activity finished  and returns to previous
    private boolean compareIntentAndSharedPref()
    {
        Intent intent =getIntent();
        int age = intent.getIntExtra("age",0);
        String name=intent.getStringExtra("name");

        SharedPreferences sharedPreferences = this.getSharedPreferences(getString(R.string.user_detailes),MODE_PRIVATE);

        int shared_age = sharedPreferences.getInt("age",0);
        String shared_Name = sharedPreferences.getString("name","");

        //int edit_age = Integer.parseInt(etAge.getText().toString()); // 11
        //String edit_name = etName.getText().toString();  // 12

        //if the are not equal finish
        if(age != shared_age || ! name.equals(shared_Name))
        {
            finish();
            return false;
        }
        // else set the fields accordingly
        else
        {
            etAge.setText(""+age);
            etName.setText(name);
            return true;
        }
    }



    public void onClick(View view)
    {
        if ( compareIntentAndSharedPref() ) // 13 , 14
        {
            //TODO - implement here so you can move to fifth
            Intent intent = new Intent(this, FifthActivity.class); // 12
            startActivity(intent);
        }
    }
}