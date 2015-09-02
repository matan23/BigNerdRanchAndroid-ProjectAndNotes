package com.bignerdranch.android.criminalintent.Fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.bignerdranch.android.criminalintent.Models.Crime;
import com.bignerdranch.android.criminalintent.R;

/**
 * Created by matan on 9/2/15.
 */
public class CrimeFragment extends BaseFragment {
    private EditText        mTitleTF;


    private Crime           mCrime;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCrime = new Crime();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }




    //region Events
    @Override
    protected void fetchViews() {
        mTitleTF = (EditText)this.getView().findViewById(R.id.crime_title);
    }

    @Override
    protected void bindViewsActions() {
        mTitleTF.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    //endregion
}
