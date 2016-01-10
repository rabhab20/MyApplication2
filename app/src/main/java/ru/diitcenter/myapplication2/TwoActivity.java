package ru.diitcenter.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);


        Intent intent = getIntent();
        String s  = intent.getStringExtra("name");

        TextView tx = (TextView) findViewById(R.id.textView);
        tx.setText(s);
    }
}
