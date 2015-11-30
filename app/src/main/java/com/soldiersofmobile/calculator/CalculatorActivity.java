package com.soldiersofmobile.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    public static final String DISPLAY_ARG = "display";
    private static final String LOG_TAG = CalculatorActivity.class.getSimpleName();
    private String display = "";

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        textView = (TextView) findViewById(R.id.displayTextView);
        if(savedInstanceState != null) {
            display = savedInstanceState.getString(DISPLAY_ARG);
        }
        refreshDisplay();

        Log.d(LOG_TAG, "onCreate:" + savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    public void clicked(View view) {

        Button button = (Button) view;
        String key = button.getText().toString();
        if(key.equals("=")) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(DISPLAY_ARG, display);
            startActivity(intent);
        }

        display = textView.getText().toString() + key;
        refreshDisplay();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(DISPLAY_ARG, display);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }

    private void refreshDisplay() {
        textView.setText(display);
    }
}
