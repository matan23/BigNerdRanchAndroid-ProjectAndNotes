package com.bignerdranch.android.geoquiz;

/**
 * Created by matan on 8/28/15.
 */
public class Question {
    private String      mQuestionText;
    private boolean     mAnswerTrue;

    public Question(String questionText, boolean answerTrue) {
        mQuestionText = questionText;
        mAnswerTrue = answerTrue;
    }



    public String getQuestionText() {
        return mQuestionText;
    }

    public void setQuestionText(String questionText) {
        mQuestionText = questionText;
    }

    public boolean isAnswerCorrect(boolean answer) {
        return mAnswerTrue == answer;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }
}
