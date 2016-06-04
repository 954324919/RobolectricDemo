package com.example.autohome.robolectricdemo;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.test.suitebuilder.annotation.Suppress;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

/**
 * Created by Jack on 2016-06-04.
 */
public class LoginActivity extends FragmentActivity implements View.OnClickListener {
    public static final int ZHUANGBI_MODE=0;
    public static final int YAOFAN_MODE=1;
    public static final int FLY_MODE=2;

    public static FragmentManager fragmentManager;
    private int mMode=ZHUANGBI_MODE;
    private Fragment mFragment;
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        LinearLayout menu1,menu2,menu3;
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login);

        menu1=(LinearLayout)this.findViewById(R.id.menu_1);
        menu1.setOnClickListener(this);
        menu2=(LinearLayout)this.findViewById(R.id.menu_2);
        menu2.setOnClickListener(this);
        menu3=(LinearLayout)this.findViewById(R.id.menu_3);
        menu3.setOnClickListener(this);

        fragmentManager=getSupportFragmentManager();//getFragmentManager();
        /*fragmentManager.beginTransaction()获取FragmentTransaction对象
         * hide(mFragment)隐藏当前的fragment
         * */
        fragment1=new Fragment1();
        if (fragment1.isAdded()) {
            fragmentManager.beginTransaction().show(fragment1).hide(mFragment).commit();
        } else {
            fragmentManager.beginTransaction().add(R.id.root, fragment1)
                    .show(fragment1).commit();
        }
        mFragment = fragment1;
    }
    @Override
    public void onClick(View v){
        int mode=ZHUANGBI_MODE;
        switch (v.getId()){
            case R.id.menu_1:
                mode=ZHUANGBI_MODE;
                break;
            case R.id.menu_2:
                mode=YAOFAN_MODE;
                break;
            case R.id.menu_3:
                mode=FLY_MODE;
                break;
        }
        if (mMode == mode)
            return;
        mMode = mode;
        FragmentTransaction fragmentTransaction;
        fragmentTransaction = fragmentManager.beginTransaction();
        if (mode == ZHUANGBI_MODE) {
            if (fragment1 == null) {
                fragment1 = new Fragment1();
            }

            if (fragment1.isAdded()) {
                fragmentTransaction.show(fragment1).hide(mFragment).commit();
            } else {
                fragmentTransaction.add(R.id.root, fragment1)
                        .show(fragment1).hide(mFragment).commit();
            }
            mFragment = fragment1;
        } else if (mode == YAOFAN_MODE) {
            if (fragment2 == null) {
                fragment2 = new Fragment2();
            }

            if (fragment2.isAdded()) {
                fragmentTransaction.show(fragment2).hide(mFragment).commit();
            } else {
                fragmentTransaction.add(R.id.root, fragment2)
                        .show(fragment2).hide(mFragment).commit();
            }
            mFragment = fragment2;
        } else if (mode == FLY_MODE) {
            if (fragment3 == null) {
                fragment3 = new Fragment3();
            }

            if (fragment3.isAdded()) {
                fragmentTransaction.show(fragment3).hide(mFragment).commit();
            } else {
                fragmentTransaction.add(R.id.root, fragment3)
                        .show(fragment3).hide(mFragment).commit();
            }
            mFragment = fragment3;
        }
    }
}
