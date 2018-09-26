package com.example.android.heroquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Score extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);

        //get score from Quiz.java
        String score = getIntent().getStringExtra("com.example.android.heroquiz.roundedScore");

        showScore(score);
    }

    /**
     * Set received score to text on TextView
     */
    private void showScore(String score) {
        TextView scoreTextView = findViewById(R.id.score_text_view);
        scoreTextView.setText(score);
    }

    /**
     * Call Quiz.java
     */
    public void restartQuiz(View view) {
        Intent intent = new Intent(Score.this, Quiz.class);
        //start the new activity
        startActivity(intent);
    }
}
