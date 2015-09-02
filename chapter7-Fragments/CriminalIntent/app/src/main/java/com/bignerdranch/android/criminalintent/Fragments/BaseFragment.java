package com.bignerdranch.android.criminalintent.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.android.criminalintent.R;

/**
 * Created by matan on 9/2/15.
 */
public class BaseFragment extends Fragment {

    protected View            mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_crime, container, false);

        fetchViews();
        bindViewsActions();

        return mView;
    }

//    overriding this method ensure that the code before the return of onCreateView will have a view ready to use
    @Override
    public View getView() {
        return mView;
    }

    protected void fetchViews() {

    }

    protected void bindViewsActions() {

    }


}
