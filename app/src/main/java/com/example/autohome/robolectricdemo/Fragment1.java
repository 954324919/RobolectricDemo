package com.example.autohome.robolectricdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.test.suitebuilder.annotation.Suppress;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Jack on 2016-06-04.
 */
//@Suppress("NewApi")
public class Fragment1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        return inflater.inflate(R.layout.fragment1, container,false);
    }

}
