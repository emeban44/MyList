package com.example.mylist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button login = (Button) findViewById(R.id.loginButton);
        Button register = (Button) findViewById(R.id.button2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences userData = getSharedPreferences("EMERALD", Context.MODE_PRIVATE);
                TextView username = (TextView) findViewById(R.id.usernameText);
                TextView password = (TextView) findViewById(R.id.passwordText);
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if (userData.contains(user+pass)){
                Intent intent = new Intent(getApplicationContext(), NavigationActivity.class);
                intent.putExtra("username",user);
                startActivity(intent);
            }else if(user.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Username is blank!", Toast.LENGTH_LONG).show();
                }else if(pass.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Password is blank!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Username and Password are incorrect!", Toast.LENGTH_LONG).show();
                }
        }});

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }
    public void onPause() {
        super.onPause();
        this.finish();
    }
    public void onStop() {
        super.onStop();
        finish();
    }
}
