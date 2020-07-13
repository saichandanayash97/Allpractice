package com.example.asifkhan.customlistview.activities;
import com.example.asifkhan.customlistview.R;
import android.content.SharedPreferences;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.app.Activity;
import android.net.Uri;
public class LoginActivity extends AppCompatActivity {
    private Button button;
    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button =(Button) findViewById(R.id.button1);
        button1 =(Button)findViewById(R.id.button2);
        button2 =(Button)findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextPage();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextPage2();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextPage();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextPage1();
            }
        });
        SharedPreferences prefs = getSharedPreferences("demopref",
                Context.MODE_WORLD_READABLE);
        SharedPreferences.Editor editor = prefs.edit();
        /*String strShareValue;
        editor.putString("demostring", strShareValue);*/
        editor.commit();
            
    }
    /*redirect to APk and redirect to web app if APK is not found*/
    public void openNextPage1(){
        String packageName = "com.example.hello";
        Intent intent = getPackageManager().getLaunchIntentForPackage(packageName);
        if(intent != null) {
            startActivity(intent);
        }
        else{
            Intent browserIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://angular.io/"));
            startActivity(browserIntent);
        }
    }
    /*Refresh function*/
    public void openNextPage(){
        Intent intent = new Intent(this,Activity.class);
        startActivity(intent);
    }
    /*Redirection to webpage*/
    public void openNextPage2(){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://angular.io/"));
        startActivity(browserIntent);
    }
}