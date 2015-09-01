package com.bignerdranch.android.geoquiz;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private static final String EXTRA_ANSWER_IS_TRUE = BuildConfig.APPLICATION_ID + "answer_is_true";
    private static final String EXTRA_ANSWER_SHOWN = BuildConfig.APPLICATION_ID + "answer_is_shown";

    private boolean     mAnswerIsTrue;
    private Button      mShowAnswerBtn;
    private TextView    mAnswerTv;



//Navigation
    public static Intent newIntent(Context packageContext, boolean answerIsTrue) {
        Intent i = new Intent(packageContext, CheatActivity.class);
        i.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return i;
    }

    private void setAnswerShownForActivityResult(boolean isAnswerShown) {
        Intent i = new Intent();
        i.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, i);
    }

    public static boolean wasAnswerShown(Intent result) {
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);
    }



//    Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        retrieveIntentsDatas();
        fetchViews();
        bindViewActions();
    }



    // Views
    private void fetchViews() {
        mAnswerTv = (TextView)findViewById(R.id.answerTv);
        mShowAnswerBtn = (Button)findViewById(R.id.show_answer_btn);
    }



    //  Events
    private void bindViewActions() {
        mShowAnswerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateAnswer();
                setAnswerShownForActivityResult(true);
            }
        });
    }

    private void updateAnswer() {
        if (mAnswerIsTrue) {
            mAnswerTv.setText(R.string.true_btn);
        } else {
            mAnswerTv.setText(R.string.false_btn);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int cx = mShowAnswerBtn.getWidth() / 2;
            int cy = mShowAnswerBtn.getHeight() / 2;
            float radius = mShowAnswerBtn.getWidth();
            Animator anim = ViewAnimationUtils.createCircularReveal(mShowAnswerBtn, cx, cy, radius, 0);
            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    mAnswerTv.setVisibility(View.VISIBLE);
                    mShowAnswerBtn.setVisibility(View.INVISIBLE);
                }
            });
            anim.start();
        } else {
            mAnswerTv.setVisibility(View.VISIBLE);
            mAnswerTv.setVisibility(View.INVISIBLE);
        }
    }


    //    Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cheat, menu);
        return true;
    }

    private void retrieveIntentsDatas() {
        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
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
