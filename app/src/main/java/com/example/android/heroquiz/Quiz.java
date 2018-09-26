package com.example.android.heroquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.Locale;

public class Quiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);
    }

    /**
     * Calculate score
     */
    private String calculateScore(int correctAnswers) {
        //Set the single point value
        double point = 6.666666667;
        //Reset score
        double score;

        //If correctAnswers is equal 0 avoid process the result and set 0 to String already
        if (correctAnswers == 0) {
            return "0";
        } else {
            //Set point times how many correct answers
            score = point * correctAnswers;
            //Round data type double score to String format
            return String.format(Locale.getDefault(), "%.0f", score);
        }
    }

    /**
     * Get answers
     */
    private int getCorrectAnswers() {
        //Reset number of correct answers (accumulator)
        int correctAnswers = 0;

        //Get all correct and relevant answers
        RadioButton q1a2RadioButton = findViewById(R.id.question1_answer2_radio_button);
        RadioButton q2a3RadioButton = findViewById(R.id.question2_answer3_radio_button);
        CheckBox q3a1CheckBox = findViewById(R.id.question3_answer1_check_box);
        CheckBox q3a2CheckBox = findViewById(R.id.question3_answer2_check_box);
        CheckBox q3a3CheckBox = findViewById(R.id.question3_answer3_check_box);
        CheckBox q3a4CheckBox = findViewById(R.id.question3_answer4_check_box);
        CheckBox q3a5CheckBox = findViewById(R.id.question3_answer5_check_box);
        CheckBox q3a6CheckBox = findViewById(R.id.question3_answer6_check_box);
        RadioButton q4a3RadioButton = findViewById(R.id.question4_answer3_radio_button);
        EditText q5a1EditText = findViewById(R.id.question5_answer_edit_text);
        String q5a1String = q5a1EditText.getText().toString();
        String q5a1Valid1 = getString(R.string.jessica_jones);
        String q5a1Valid2 = getString(R.string.jessica_campbell_jones);
        RadioButton q6a3RadioButton = findViewById(R.id.question6_answer3_radio_button);
        CheckBox q7a1CheckBox = findViewById(R.id.question7_answer1_check_box);
        CheckBox q7a2CheckBox = findViewById(R.id.question7_answer2_check_box);
        CheckBox q7a3CheckBox = findViewById(R.id.question7_answer3_check_box);
        CheckBox q7a4CheckBox = findViewById(R.id.question7_answer4_check_box);
        RadioButton q8a1RadioButton = findViewById(R.id.question8_answer1_radio_button);
        CheckBox q9a1CheckBox = findViewById(R.id.question9_answer1_check_box);
        CheckBox q9a2CheckBox = findViewById(R.id.question9_answer2_check_box);
        CheckBox q9a3CheckBox = findViewById(R.id.question9_answer3_check_box);
        CheckBox q9a4CheckBox = findViewById(R.id.question9_answer4_check_box);
        RadioButton q10a2RadioButton = findViewById(R.id.question10_answer2_radio_button);

        //Check all correct answers
        //If answer true, add 1 to correctAnswers
        if (q1a2RadioButton.isChecked()) correctAnswers++;
        if (q2a3RadioButton.isChecked()) correctAnswers++;
        if (q3a1CheckBox.isChecked() && !q3a3CheckBox.isChecked() && !q3a6CheckBox.isChecked())
            correctAnswers++;
        if (q3a2CheckBox.isChecked() && !q3a3CheckBox.isChecked() && !q3a6CheckBox.isChecked())
            correctAnswers++;
        if (q3a4CheckBox.isChecked() && !q3a3CheckBox.isChecked() && !q3a6CheckBox.isChecked())
            correctAnswers++;
        if (q3a5CheckBox.isChecked() && !q3a3CheckBox.isChecked() && !q3a6CheckBox.isChecked())
            correctAnswers++;
        if (q4a3RadioButton.isChecked()) correctAnswers++;
        if (q5a1String.equals(q5a1Valid1) || q5a1String.equals(q5a1Valid2)) correctAnswers++;
        if (q6a3RadioButton.isChecked()) correctAnswers++;
        if (q7a3CheckBox.isChecked() && !q7a1CheckBox.isChecked() && !q7a2CheckBox.isChecked())
            correctAnswers++;
        if (q7a4CheckBox.isChecked() && !q7a1CheckBox.isChecked() && !q7a2CheckBox.isChecked())
            correctAnswers++;
        if (q8a1RadioButton.isChecked()) correctAnswers++;
        if (q9a1CheckBox.isChecked() && !q9a2CheckBox.isChecked() && !q9a4CheckBox.isChecked())
            correctAnswers++;
        if (q9a3CheckBox.isChecked() && !q9a2CheckBox.isChecked() && !q9a4CheckBox.isChecked())
            correctAnswers++;
        if (q10a2RadioButton.isChecked()) correctAnswers++;

        return correctAnswers;
    }

    /**
     * Call Score.java and send roundedScore
     */
    private void submitScore(String roundedScore) {
        Intent intent = new Intent(Quiz.this, Score.class);
        intent.putExtra("com.example.android.heroquiz.roundedScore", roundedScore);
        //Start the new activity
        startActivity(intent);
    }

    /**
     * Set score
     */
    public void setScore(View view) {
        //Get total of correct Answers
        int correctAnswers = getCorrectAnswers();
        //Calculate score
        String finalScore = calculateScore(correctAnswers);
        //send score
        submitScore(finalScore);
    }
}
