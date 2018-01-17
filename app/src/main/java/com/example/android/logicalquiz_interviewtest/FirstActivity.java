package com.example.android.logicalquiz_interviewtest;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {


    public Button startButton;
    public EditText editText;


    public void startQuiz(){

        startButton= (Button) findViewById(R.id.start_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText = findViewById(R.id.editText);
                final String name = editText.getText().toString();
                if (!name.isEmpty()) {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.good_luck_text) + name+"!", Toast.LENGTH_SHORT).show();
                    Intent moveToTheNextPage= new Intent(FirstActivity.this, MainActivity.class);
                    startActivity(moveToTheNextPage);
                }else{
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.enter_name_text), Toast.LENGTH_LONG).show();
                    }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        startQuiz();

    }


}
