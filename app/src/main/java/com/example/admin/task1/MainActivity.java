package com.example.admin.task1;

//import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //FragmentLogin fragmentLogin;
    //FragmentWelcome fragmentWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentLogin fragmentLogin=new FragmentLogin();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.add(R.id.fragment_container,fragmentLogin);
        ft.commit();
       // fragmentLogin=new FragmentLogin();
        //fragmentWelcome=new FragmentWelcome();
        //FragmentTransaction fragmentTransaction1=getSupportFragmentManager().beginTransaction();
        //FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
        //fragmentTransaction1.replace(R.id.fragment2,fragmentWelcome,"Fragment");
        //fragmentTransaction1.commit();
    }
}
