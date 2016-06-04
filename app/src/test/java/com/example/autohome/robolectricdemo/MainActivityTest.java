package com.example.autohome.robolectricdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.v4.view.KeyEventCompat;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import junit.framework.Assert;
import junit.framework.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowAlertDialog;
import org.robolectric.shadows.ShadowToast;
import org.robolectric.util.ActivityController;

import java_cup.Main;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Jack on 2016-06-04.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class,sdk=17)
public class MainActivityTest {
    private MainActivity mainActivity=Robolectric.setupActivity(MainActivity.class);
    /*
    protected MainActivityTest() {
        initView(mainActivity);
    }

    private void initView(Activity activity) {
        activity.findViewById(R.id.checkbox1);
        activity.findViewById(R.id.checkbox2);
    }
    */

    @Test
    public void testLoginBtn(){  //通过Intent判断activity跳转是否正确
        //MainActivity mainActivity=Robolectric.setupActivity(MainActivity.class);
        mainActivity.findViewById(R.id.login).performClick();

        Intent expectedIntent=new Intent(mainActivity,LoginActivity.class);
        ShadowActivity shadowActivity= Shadows.shadowOf(mainActivity);
        Intent actualIntent=shadowActivity.getNextStartedActivity();
        assertEquals(expectedIntent,actualIntent);
    }
    @Test
    public void testLifecycle(){  //测试Activity的生命周期内的函数
        ActivityController<MainActivity> controller=Robolectric.buildActivity(MainActivity.class).create();
        Activity activity=controller.get();
        TextView textView=(TextView)activity.findViewById(R.id.textview);
        assertEquals("onCreate",textView.getText().toString());

        controller.start();
        assertEquals("onStart",textView.getText().toString());
        controller.resume();
        assertEquals("onResume",textView.getText().toString());
        controller.destroy();
        assertEquals("onDestroy",textView.getText().toString());
    }
    @Test
    public void testViewState(){  //测试UI控件状态
        CheckBox checkbox1=(CheckBox)mainActivity.findViewById(R.id.checkbox1);
        CheckBox checkbox2=(CheckBox)mainActivity.findViewById(R.id.checkbox2);
        Button login=(Button)mainActivity.findViewById(R.id.login);
        assertTrue(login.isEnabled());

        checkbox1.setChecked(false);
        checkbox2.setChecked(true);
        checkbox1.performClick();
        checkbox2.performClick();

        assertTrue(checkbox1.isChecked());
        assertTrue(!checkbox2.isChecked());
    }
    @Test
    public void testDialog(){  //操作物理键盘 返回键触发
        mainActivity.finish();//KeyEvent.KEYCODE_BACK
        AlertDialog latestAlertDialog= ShadowAlertDialog.getLatestAlertDialog();
        assertNotNull(latestAlertDialog);
    }
    @Test
    public void testToast(){
        Button toast=(Button)mainActivity.findViewById(R.id.toast);
        toast.performClick();
        assertEquals(ShadowToast.getTextOfLatestToast(),"提示一下");
    }
}
