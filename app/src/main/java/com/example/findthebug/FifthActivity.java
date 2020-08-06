package com.example.findthebug;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.webkit.WebView;

import java.util.Locale;

public class FifthActivity extends AppCompatActivity {

    private TextToSpeech tts;
    private static final String TAG =
            FifthActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        Log.d(TAG, "onCreate: started");

        initViews();

    }

    private void initViews()
    {
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener()
        {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.US);
                    tts.speak( " you are amazing!",TextToSpeech.QUEUE_FLUSH,null,"1");
                }
            }
        });
        WebView wv = (WebView) findViewById(R.id.wvFifth);
        wv.loadUrl("file:///android_asset/fireworks.gif");

    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: started");
        super.onDestroy();
        Log.d(TAG, "onDestroy: after super");
        if (tts != null)
            Log.d(TAG, "onDestroy: stopping TTS");
            tts.stop();
            tts.shutdown();
      }
}