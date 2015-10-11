package com.example.manny.wordquizgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Handler;


public class GameActivity extends AppCompatActivity {
    private static final String TAG = "GameActivity";

    private int mNumChoices;

    private ArrayList<String> mFileNameList;
    private ArrayList<String> mQuizWordList;
    private ArrayList<String> mChoiceWordList;

    private int mScore;
    private int mTotalGuesses;
    private String mAnswerFileName;

    private Random mRandom;
    private Handler mHandler;

    private TextView mQuestionNumberTextView;
    private ImageView mQuestionImageView;
    private TableLayout mButtonTableLayout;
    private TextView mAnswerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        int level = intent.getIntExtra(MainActivity.KEY_DIFFICULTY , 0);

        Log.i(TAG, "Difficulty = " + level);

        switch(level){
            case 0 : mNumChoices = 2 ; break;
            case 1 : mNumChoices = 4 ; break;
            case 2 : mNumChoices = 6 ; break;
        }
        
        setupViews();
    }

    private void setupViews() {
        mQuestionNumberTextView = (TextView)findViewById(R.id.questionNumberTextView);
        mQuestionImageView = (ImageView) findViewById(R.id.questionImageView);
        mButtonTableLayout = (TableLayout) findViewById(R.id.buttonTableLayout);
        mAnswerTextView = (TextView) findViewById(R.id.answerTextView);
    }
}
