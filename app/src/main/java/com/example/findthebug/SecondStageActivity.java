package com.example.findthebug;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondStageActivity extends AppCompatActivity implements View.OnClickListener {

    private String data;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_stage); // 4
        // intent.putExtra("success","almost");intent.putExtra("success","almost");
        if ( getIntent().hasExtra(getString(R.string.success))) {
            data = (String)getIntent().getExtras().get(getString(R.string.success)); // 5
        }

        Toast.makeText(this,getString(R.string.success) + ":" + data, Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onClick(View view)
    {
        Intent intent = new Intent(this,ThirdStage.class);
        startActivity(intent);
    }

}