package com.example.android.shubhamquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

 private Button submit;
    int correctAnswers;
    private EditText quetion3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(submitButtonOnClickListener);
        quetion3=(EditText)findViewById(R.id.answerTeamName);

    }

    private void checkQuestionOneAnswers(){
        CheckBox questionOneViratKohli = (CheckBox) findViewById(R.id.checkboxQuest1AnswerViratKohli);
        CheckBox questionOneSureshRaina = (CheckBox) findViewById(R.id.checkboxQuest1AnswerSureshRaina);
        CheckBox questionOneRohitSharma = (CheckBox) findViewById(R.id.checkboxQuest1AnswerRohitSharma);
        boolean isQuestionOneViratKohliChecked = questionOneViratKohli.isChecked();
        boolean isQuestionOneSureshRainaChecked = questionOneSureshRaina.isChecked();
        boolean isQuestionOneRohitSharmaChecked = questionOneRohitSharma.isChecked();

        if (isQuestionOneViratKohliChecked && isQuestionOneSureshRainaChecked && !isQuestionOneRohitSharmaChecked){
            correctAnswers += 1;
        }
    }

    private void checkQuestionTwoAnswers(){
        RadioButton radioButton22 = (RadioButton) findViewById(R.id.radio_22);
        boolean isQuestionTwo22Checked = radioButton22.isChecked();
        if (isQuestionTwo22Checked){
            correctAnswers += 1;
        }
    }

    private String getQuestionThreeUserInput() {
        EditText userTeamName = (EditText) findViewById(R.id.answerTeamName);
        String name = userTeamName.getText().toString();
        return name;
    }

    private void checkQuestionThreeAnswer(){
        String name = getQuestionThreeUserInput();
        if (name.trim().equalsIgnoreCase("england")){
            correctAnswers += 1;
        }
        else
            quetion3.setError("Incorrect Team name");

    }

    private void checkQuestionFourAnswers(){
        RadioButton radioButton0 = (RadioButton) findViewById(R.id.radio_0);
        boolean isQuestionFour0Checked = radioButton0.isChecked();
        if (isQuestionFour0Checked){
            correctAnswers += 1;
        }
    }

    private void checkQuestionFiveAnswers(){
        CheckBox questionFiveVirenderSehwag = (CheckBox) findViewById(R.id.checkboxQuest5VirenderSehwag);
        CheckBox questionFiveViratKohli = (CheckBox) findViewById(R.id.checkboxQuest5ViratKohli);
        CheckBox questionFiveKarunNair = (CheckBox) findViewById(R.id.checkboxQuest5KarunNair);
        boolean isQuestionFiveVirenderSehwagChecked = questionFiveVirenderSehwag.isChecked();
        boolean isQuestionFiveViratKohliChecked = questionFiveViratKohli.isChecked();
        boolean isQuestionFiveKarunNairChecked = questionFiveKarunNair.isChecked();

        if (isQuestionFiveVirenderSehwagChecked && !isQuestionFiveViratKohliChecked && isQuestionFiveKarunNairChecked){
            correctAnswers += 1;
        }
    }

    private void checkAllQuestions(){
        checkQuestionOneAnswers();
        checkQuestionTwoAnswers();
        checkQuestionThreeAnswer();
        checkQuestionFourAnswers();
        checkQuestionFiveAnswers();
    }

    private void resetCounterCorrectAnswers(){
        correctAnswers = 0;
    }

    final View.OnClickListener submitButtonOnClickListener = new View.OnClickListener() {
        public void onClick(final View v){
            checkAllQuestions();
            Toast.makeText(MainActivity.this, "Correct Answers: " + correctAnswers + "/5",
                    Toast.LENGTH_LONG).show();
            resetCounterCorrectAnswers();
        }
    };
}
