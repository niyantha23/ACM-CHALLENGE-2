package com.dev5151.acmchallenge2.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dev5151.acmchallenge2.R;

public class MainActivity extends AppCompatActivity {

    Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ExampleActivity.class));
                finish();
            }
        });
    }

    private void initViews() {
        sendButton = findViewById(R.id.btn_example);
    }

}
