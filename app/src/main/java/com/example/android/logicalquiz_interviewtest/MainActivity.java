package com.example.android.logicalquiz_interviewtest;

import android.content.Context;
import android.content.Intent;

import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int numberHintButtonPressed=0;
    private int totalNumberOfPoints=0;
    private int correctAnswers=0;
    private TextView countDownText;
    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds=600000;//10 minutes
    private CheckBox jakAnswer;
    private CheckBox halAnswer;
    private CheckBox kajAnswer;
    private CheckBox jaiAnswer;
    private CheckBox hgfAnswer;
    private CheckBox cabAnswer;
    private CheckBox jklAnswer;
    private CheckBox tsrAnswer;
    boolean  allButtonsEnabled=true;
    RadioButton[] allRadioButtons;
    CheckBox[] allCheckBoxes;
    Button[] hintButton;
    Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startTimer();
        countDownText= findViewById(R.id.coutdown_text);
        allRadioButtons= new RadioButton[]{findViewById(R.id.radio_button52),findViewById(R.id.radio_button56),findViewById(R.id.radio_button96),
                findViewById(R.id.radio_button80), findViewById(R.id.radio_button_108),findViewById(R.id.radio_button_148),findViewById(R.id.radio_button162),
                findViewById(R.id.radio_button216), findViewById(R.id.dish_answer),findViewById(R.id.soup_answer),findViewById(R.id.spoon_answer),
                findViewById(R.id.food_answer), findViewById(R.id.symphony_answer),findViewById(R.id.musician_answer),findViewById(R.id.piano_answer),
                findViewById(R.id.percussion_answer),findViewById(R.id.answer1_question5),findViewById(R.id.answer2_question5),findViewById(R.id.answer3_question5),
                findViewById(R.id.answer4_question5),findViewById(R.id.answer1_question6),findViewById(R.id.answer2_question6),findViewById(R.id.answer3_question6),
                findViewById(R.id.answer4_question6),findViewById(R.id.answer1_question7),findViewById(R.id.answer2_question7),findViewById(R.id.answer3_question7),
                findViewById(R.id.answer4_question7),findViewById(R.id.answer1_question8),findViewById(R.id.answer2_question8),findViewById(R.id.answer3_question8),
                findViewById(R.id.answer4_question8) };
        //setting the color, text, font type of the radio buttons text
        for(int i=0;i<allRadioButtons.length;i++) {
            allRadioButtons[i].setTextColor(getResources().getColor(R.color.buttons_color));
            allRadioButtons[i].setScaleX(0.8f);
            allRadioButtons[i].setScaleY(0.8f);
            allRadioButtons[i].setTextSize(22);
            allRadioButtons[i].setTypeface(null, Typeface.BOLD);                                        }

        jakAnswer=findViewById(R.id.jak_answer);
        halAnswer=findViewById(R.id.hal_answer);
        kajAnswer=findViewById(R.id.kaj_answer);
        jaiAnswer=findViewById(R.id.jai_answer);
        hgfAnswer=findViewById(R.id.hgf_answer);
        cabAnswer=findViewById(R.id.cab_answer);
        jklAnswer=findViewById(R.id.jkl_answer);
        tsrAnswer=findViewById(R.id.tsr_answer);
        allCheckBoxes= new CheckBox[]{jakAnswer,halAnswer,kajAnswer,jaiAnswer, hgfAnswer,cabAnswer,jklAnswer,tsrAnswer};
        //setting the color, size, font type of the check boxes text
        for(int i=0;i<allCheckBoxes.length;i++) {
            allCheckBoxes[i].setTextColor(getResources().getColor(R.color.buttons_color));
            allCheckBoxes[i].setScaleX(0.8f);
            allCheckBoxes[i].setScaleY(0.8f);
            allCheckBoxes[i].setTextSize(22);
            allCheckBoxes[i].setTypeface(null, Typeface.BOLD);
        }

        Button restartButton= findViewById(R.id.restart_button);

        //creating an array for all 10 hint buttons
        hintButton= new Button[]{findViewById(R.id.hint_button1), findViewById(R.id.hint_button2),findViewById(R.id.hint_button3),
                        findViewById(R.id.hint_button4),findViewById(R.id.hint_button5), findViewById(R.id.hint_button6),
                        findViewById(R.id.hint_button7),findViewById(R.id.hint_button8),findViewById(R.id.hint_button9),findViewById(R.id.hint_button10)};
        //creating an array of Strings for the text displayed when a hint button is pressed
        final String[] textHintButton= new String[]{getString(R.string.toast_hint1),getString(R.string.toast_hint2),getString(R.string.toast_hint3),
                        getString(R.string.toast_hint4),getString(R.string.toast_hint5), getString(R.string.toast_hint6),getString(R.string.toast_hint7),
                        getString(R.string.toast_hint8),getString(R.string.toast_hint9),getString(R.string.toast_hint10)};
        //within this method, every time, a hint button is pressed, a toast message is shown and the app updates the number of points and how many times, a hint button was pressed
        for(int i=0;i<hintButton.length;i++) {
            final int j=i;
            hintButton[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), textHintButton[j], Toast.LENGTH_LONG).show();
                    numberHintButtonPressed += 1;
                    totalNumberOfPoints -= 5;
                }
            });
        }
        submitButton= findViewById(R.id.submit_button);
        // this method goes to the first page when the restart button is pressed
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restartQuiz();
            }
        });
        //within this method, when the submit button is pressed, a toast message shows the user how many correct answers he got, total number of points,
        //how many times he pressed the hint button, the timer stops and the buttons became disable.
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when the user click submit button, timer stops
                stopTimer();
                //checking if the correct answers were selected
                if(allRadioButtons[1].isChecked()){addPointsAndCorrectAnswers();}
                if(allRadioButtons[6].isChecked()){addPointsAndCorrectAnswers();}
                if(allRadioButtons[9].isChecked()){addPointsAndCorrectAnswers();}
                if(allRadioButtons[13].isChecked()){addPointsAndCorrectAnswers();}
                if(allRadioButtons[16].isChecked()){addPointsAndCorrectAnswers();}
                if(allRadioButtons[20].isChecked()){addPointsAndCorrectAnswers();}
                if(allRadioButtons[26].isChecked()){addPointsAndCorrectAnswers();}
                if(allRadioButtons[29].isChecked()){addPointsAndCorrectAnswers();}
                if ((jakAnswer.isChecked())&& (kajAnswer.isChecked())&& (!halAnswer.isChecked())&& (!jaiAnswer.isChecked())) {
                    addPointsAndCorrectAnswers();}
                if ((tsrAnswer.isChecked())&& (hgfAnswer.isChecked())&& (!cabAnswer.isChecked())&& (!jklAnswer.isChecked())) {
                   addPointsAndCorrectAnswers();}

                //toast message with the score
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.message_user_score) +" "+ totalNumberOfPoints +
                        getResources().getString(R.string.message_hint_button_pressed)+" "+
                        numberHintButtonPressed+" "+getResources().getString(R.string.message_times)+getResources().getString(R.string.message_correct_answers)+" "+ correctAnswers, Toast.LENGTH_LONG).show();
                //Radio buttons and check buttons will be disabled
                        for(int i=0;i<allRadioButtons.length;i++){allRadioButtons[i].setEnabled(false);}
                        for(int i=0;i<allCheckBoxes.length;i++){allCheckBoxes[i].setEnabled(false);}
                        for (int i=0;i<hintButton.length;i++){hintButton[i].setEnabled(false);}
                        submitButton.setEnabled(false);
                        allButtonsEnabled=false;
            }

        });

    }

    public void startTimer(){
        if(countDownTimer != null) stopTimer();
        countDownTimer=new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds=l;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }
    public void stopTimer(){
        countDownTimer.cancel();
    }

    public void updateTimer(){
        int minutes= (int) timeLeftInMilliseconds/60000;
        int seconds= (int) timeLeftInMilliseconds %60000/1000;
        String timeLeftText;
        timeLeftText= "" +minutes;
        timeLeftText+= ":";
        if (seconds<10) timeLeftText+="0";
        timeLeftText+= seconds;
        countDownText.setText(timeLeftText);
        if((minutes==0)&&(seconds==1)){
            for(int i=1;i<2;i++){
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.message_out_of_time), Toast.LENGTH_LONG).show();}
            restartQuiz();
        }
        //this toast will announce users when they need to hurry in order to press submit button before time will end.
        if((minutes==0)&&(seconds==59)){
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.message_one_minute_left), Toast.LENGTH_LONG).show();}
    }
    public void restartQuiz(){
        Intent moveToTheFirstPage= new Intent(MainActivity.this, FirstActivity.class);
        startActivity(moveToTheFirstPage);
    }
    //this method add points to total score and increments correct answers
    public void addPointsAndCorrectAnswers()
    {totalNumberOfPoints += 10;
    correctAnswers += 1;}

   @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        numberHintButtonPressed = savedInstanceState.getInt("numberHintButtonPressed");
        totalNumberOfPoints=savedInstanceState.getInt("totalNumberOfPoints");
        correctAnswers=savedInstanceState.getInt("correctAnswers");
        timeLeftInMilliseconds=savedInstanceState.getLong("timeLeftInMilliseconds");
        startTimer();
        allButtonsEnabled=savedInstanceState.getBoolean("allButtonsEnabled");
        if(!allButtonsEnabled){
            stopTimer();
            for(int i=0;i<allRadioButtons.length;i++){allRadioButtons[i].setEnabled(false);}
            for(int i=0;i<allCheckBoxes.length;i++){allCheckBoxes[i].setEnabled(false);}
            for (int i=0;i<hintButton.length;i++){hintButton[i].setEnabled(false);}
            submitButton.setEnabled(false);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("numberHintButtonPressed", numberHintButtonPressed);
        outState.putInt("totalNumberOfPoints", totalNumberOfPoints);
        outState.putInt("correctAnswers", correctAnswers);
        outState.putLong("timeLeftInMilliseconds", timeLeftInMilliseconds);
        outState.putBoolean("allButtonsEnabled",allButtonsEnabled);
    }

    public void onDestroy(){
        super.onDestroy();
        if(countDownTimer != null)
        {
            stopTimer();

        }

    }
    }



