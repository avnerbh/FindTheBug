package com.example.findthebug;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
           , OnRequestPermissionsResultCallback
{
    private static final String TAG =
            MainActivity.class.getSimpleName();
    private static final int MY_PERMISSIONS_REQUEST_RECV_SMS = 2;

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews()
    {
        button = findViewById(R.id.button_main); // 1 - missing , 2 - rename
        button.setOnClickListener(this);

        checkForSmsPermission();
    }

    @Override
    public void onClick(View view)
    {
        Intent intent = new Intent(this,SecondStageActivity.class); // 16
        intent.putExtra(getString(R.string.success),"almost"); // move to resorce
        startActivity(intent); // 3 - missing

    }

    private void checkForSmsPermission() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.RECEIVE_SMS) !=
                PERMISSION_GRANTED) {
            Log.d(TAG, getString(R.string.permission_not_granted));
            // Permission not yet granted. Use requestPermissions().
            // MY_PERMISSIONS_REQUEST_RECV_SMS is an
            // app-defined int constant. The callback method gets the
            // result of the request.
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.RECEIVE_SMS},
                    MY_PERMISSIONS_REQUEST_RECV_SMS);
        } else {
            // Permission already granted. Enable the SMS button.
//            enableSmsButton();
            Log.d(TAG, getString(R.string.permission_was_granted));

        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_RECV_SMS: {
                if (permissions[0].equalsIgnoreCase
                        (Manifest.permission.RECEIVE_SMS)
                        && grantResults[0] ==
                        PERMISSION_GRANTED) {
                    // Permission was granted. Enable sms button.
                    //enableSmsButton();
                } else {
                    // Permission denied.
                    Log.d(TAG, getString(R.string.failure_permission));
                    Toast.makeText(this,
                            getString(R.string.failure_permission),
                            Toast.LENGTH_LONG).show();
                    // Disable the sms button.
//                    disableSmsButton();
                }
            }
        }
        // Other 'case' lines to check for other
        // permissions this app might request.
    }
}