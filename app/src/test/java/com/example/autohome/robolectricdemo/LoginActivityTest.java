package com.example.autohome.robolectricdemo;


import android.support.v4.app.Fragment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by Jack on 2016-06-04.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class,sdk=17)
public class LoginActivityTest {
    @Test
    public void testFragment(){
        Fragment fragment1=new Fragment();
        //此api可以主动添加Fragment到Activity中，因此会触发Fragment的onCreateView()
        SupportFragmentTestUtil.startFragment(fragment1);
        assertNotNull(fragment1.getView());
    }
}
