package com.example.admin.task1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLogin extends Fragment {

    String username;
    EditText username1,password1;
    TextView textView1;
    String email;
    String emailPattern;
    public FragmentLogin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_layout, container, false);
        username1=(EditText) view.findViewById(R.id.username_et);
        password1=(EditText) view.findViewById(R.id.password_et);
        textView1=(TextView)view.findViewById(R.id.alert);
        email= username1.getText().toString().trim();
        emailPattern= "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        username1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(email.matches(emailPattern)){
                    username1.setError("Invalid email");
                }
            }
        });

        final Button bt1=(Button) view.findViewById(R.id.button_submit);
        bt1.setOnClickListener(new View.OnClickListener() {
            FragmentManager fm=getFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            FragmentWelcome fragmentWelcome=new FragmentWelcome();

            @Override
            public void onClick(View v) {
                if(username1.getText().toString().equals("") && password1.getText().toString().equals("")){
                    textView1.setText("enter user name and password");
                }
                else if(username1.getText().toString().equals("student@vnurture.com") && password1.getText().toString().equals("student@123")){
                    username=username1.getText().toString();

                    //android.support.v4.app.FragmentTransaction fragmentTransaction= getFragmentManager().beginTransaction();


                    Bundle bundle=new Bundle();
                    bundle.putString("username_et",username);
                    fragmentWelcome.setArguments(bundle);
                    ft.replace(R.id.fragment_container,fragmentWelcome);
                    ft.commit();
                }
                else
                {
                    textView1.setText("Invalid user name and password");
                }

            }
        });
        return view;

    }

}
