package com.dape.quizapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    private int points;
    private TextView txtResultFinal;
    private RadioGroup question2;
    private RadioGroup question3;
    private RadioGroup question4;
    private RadioGroup question5;
    private CheckBox check1;
    private CheckBox check2;
    private CheckBox check3;
    private CheckBox check4;
    private EditText artist;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        init();
    }
    public void reset(View view) {
        points = 0;
        check1.setChecked(false);
        check2.setChecked(false);
        check3.setChecked(false);
        check4.setChecked(false);
        question2.clearCheck();
        question3.clearCheck();
        question4.clearCheck();
        question5.clearCheck();
        artist.setText("");
        txtResultFinal.setText(String.valueOf(points));
        txtResultFinal.setTextColor(Color.TRANSPARENT);
    }
    public void resultFinal(View view) {
        if(check2.isChecked() &&! check3.isChecked() && check4.isChecked() &&! check1.isChecked()){
            points +=10;
        }else
            points = 0;
        if(question2.getCheckedRadioButtonId()==R.id.radio_aloe_blacc){
            points +=10;
        }else
            points = points +0;
        if(question3.getCheckedRadioButtonId()==R.id.radio_luis_fonsi2){
            points +=10;
        }else
            points = points +0;
        if(question4.getCheckedRadioButtonId()==R.id.radio_knan){
            points +=10;
        }else
            points = points +0;
        if(question5.getCheckedRadioButtonId()==R.id.radio_coldplay){
            points +=10;
        }else
            points = points +0;
        if (artist.getText().toString().trim().equalsIgnoreCase(name)) {
            points +=10;
        }else
            points = points +0;
        Toast.makeText(QuizActivity.this,getString(R.string.score_text)
                + " " + String.valueOf(points), Toast.LENGTH_LONG).show();
        txtResultFinal.setText(getString(R.string.score_text) + " " + String.valueOf(points));
        if (points <=50){
            txtResultFinal.setTextColor(Color.RED);
            points=0;
        }
        if (points >=50){
            txtResultFinal.setTextColor(Color.GREEN);
            points=0;
        }
    }
    private void init(){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        txtResultFinal = (TextView)findViewById(R.id.resultFinal);
        check1 = (CheckBox)findViewById(R.id.check_linkin);
        check2 = (CheckBox)findViewById(R.id.check_one_republic);
        check3 = (CheckBox)findViewById(R.id.check_justin_bieber);
        check4 = (CheckBox)findViewById(R.id.check_tiziano_ferro);
        question2 = (RadioGroup) findViewById(R.id.radio_group_question_two);
        question3 = (RadioGroup) findViewById(R.id.radio_group_question_three);
        question4 = (RadioGroup) findViewById(R.id.radio_group_question_four);
        question5 = (RadioGroup) findViewById(R.id.radio_group_question_five);
        artist = (EditText)findViewById(R.id.edt_question_six);
        name = getString(R.string.name);
        txtResultFinal.setTextColor(Color.TRANSPARENT);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
