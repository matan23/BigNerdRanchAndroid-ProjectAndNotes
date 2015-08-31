package com.bignerdranch.android.geoquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class QuizActivty extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();

    private static final String KEY_INDEX = "index";

    private Button      mTrueBtn;
    private Button      mFalseBtn;
    private Button      mNextBtn;
    private TextView    mQuestionTv;

    private int         mCurrentIndex = 0;
    private Question[]  mQuestionsBank;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logProbe();

        setContentView(R.layout.activity_quiz);

        fetchViews();

        restoreState(savedInstanceState);

        bindViewActions();

        fetchQuestions();

        updateQuestion();
    }

    @Override
    protected void onStart() {
        super.onStart();
        logProbe();
    }

    @Override
    protected void onPause() {
        super.onPause();
        logProbe();
    }

    @Override
    protected void onResume() {
        super.onResume();
        logProbe();
    }

    @Override
    protected void onStop() {
        super.onStop();
        logProbe();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logProbe();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        logProbe();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        logProbe();

        outState.putInt(KEY_INDEX, mCurrentIndex);
    }

    private void restoreState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX);
        }
    }

    private void logProbe() {
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        StackTraceElement e = stacktrace[3];//maybe this number needs to be corrected
        String methodName = e.getMethodName();
        Log.d(TAG, methodName);
    }

    private void fetchViews() {
        mTrueBtn = (Button)findViewById(R.id.true_btn);
        mFalseBtn = (Button)findViewById(R.id.false_btn);
        mQuestionTv = (TextView)findViewById(R.id.question_tv);
        mNextBtn = (Button)findViewById(R.id.next_btn);
    }

    private void bindViewActions() {
        mTrueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        mFalseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextQuestion();
                updateQuestion();
            }
        });
    }

    private Question[] fetchQuestions() {
        Map<String, Boolean> questionsAnswers = parseStringArray(R.array.questions_hash);
        ArrayList<Question> questions = new ArrayList<>();

        for (Map.Entry<String, Boolean> entry : questionsAnswers.entrySet()) {
            questions.add(new Question(entry.getKey(), entry.getValue()));
        }

        mQuestionsBank = questions.toArray(new Question[questions.size()]);
        return mQuestionsBank;
    }

    private void updateQuestion() {
        mQuestionTv.setText(mQuestionsBank[mCurrentIndex].getQuestionText());
    }

    private void nextQuestion() {
        mCurrentIndex = (mCurrentIndex + 1) % mQuestionsBank.length;
        updateQuestion();
    }

    private void checkAnswer(boolean userPressedTrue) {
        Question question = mQuestionsBank[mCurrentIndex];

        Toast.makeText(this,
                getMessageForAnswerResult(question.isAnswerCorrect(userPressedTrue)),
                Toast.LENGTH_SHORT)
                .show();
    }

    private int getMessageForAnswerResult(boolean correct) {
        return correct ? R.string.correct_toast : R.string.incorrect_toast;
    }

    private Map<String, Boolean> parseStringArray(int stringArrayResourceId) {
        String[] stringArray = getResources().getStringArray(stringArrayResourceId);
        HashMap<String, Boolean> outputArray = new HashMap<>(stringArray.length);

        for (String entry : stringArray) {
            String[] splitResult = entry.split("\\|", 2);
            outputArray.put(splitResult[0], splitResult[1].equals("1") ? true : false);
        }
        return outputArray;
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        
        return super.onOptionsItemSelected(item);
    }


}
