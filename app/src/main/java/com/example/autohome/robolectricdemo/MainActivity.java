package com.example.autohome.robolectricdemo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Button login,toast;
    private CheckBox checkbox1, checkbox2;
    private TextView textview;
    private ImageView imageView;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        toast.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"提示一下",Toast.LENGTH_LONG).show();
            }
        });
        textview.setText("onCreate");
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("确定要退出吗?");
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                MainActivity.this.finish();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
    public boolean onKeyDown(int keyCode,KeyEvent event){
        if(keyCode==KeyEvent.KEYCODE_BACK&& event.getRepeatCount()==0){
            dialog();
        }
        return false;
    }

    @Override
    public void onStop() {
        super.onStop();
        textview.setText("onStop");
    }
    private void initView() {
        login=(Button)findViewById(R.id.login);
        imageView=(ImageView)findViewById(R.id.image);
        textview=(TextView)findViewById(R.id.textview);
        checkbox1=(CheckBox)findViewById(R.id.checkbox1);
        checkbox2=(CheckBox)findViewById(R.id.checkbox2);
        toast=(Button)findViewById(R.id.toast);
    }

    @Override
    protected void onResume() {
        super.onResume();
        textview.setText("onResume");
    }
    @Override
    protected void onStart(){
        super.onStart();
        textview.setText("onStart");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        textview.setText("onDestroy");
    }
}
