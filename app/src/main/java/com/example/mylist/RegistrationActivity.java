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

import java.util.ArrayList;
import java.util.List;

public class RegistrationActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);



        Button register = (Button) findViewById(R.id.registerButton);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final SharedPreferences userData = getSharedPreferences("EMERALD", Context.MODE_PRIVATE);
                final SharedPreferences.Editor myEditor = userData.edit();
                TextView newUsername = findViewById(R.id.newUsername);
                TextView newPassword = findViewById(R.id.newPassword);
                String newuser = newUsername.getText().toString();
                String newpass = newPassword.getText().toString();

                if (newuser.length()<6){
                    Toast.makeText(getApplicationContext(), "Username must be at least 6 characters long", Toast.LENGTH_LONG).show();
                }else if (newpass.length()<8){
                    Toast.makeText(getApplicationContext(),"Password must be at least 8 characters long", Toast.LENGTH_LONG).show();
                }else if(userData.contains(newuser)) {
                    Toast.makeText(getApplicationContext(),"Username already exist, try another one!", Toast.LENGTH_LONG).show();
                }else if(!userData.contains(newuser)){
                    myEditor.putString(newuser+newpass,newuser+newpass);
                    myEditor.putString(newuser,newuser);
                    myEditor.apply();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("username", newuser);
                    startActivity(intent);
                }
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