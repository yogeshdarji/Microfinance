package com.raizada.ankush.microfinance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button bLogout;
    EditText etName,etAge,etSSN,etEmail,etUsername;
    com.example.yogeshdarji.loginregister.UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etName = (EditText)findViewById(R.id.etName);
        etAge = (EditText)findViewById(R.id.etAge);
        etSSN = (EditText)findViewById(R.id.etSSN);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etUsername = (EditText)findViewById(R.id.etUsername);

        bLogout = (Button)findViewById(R.id.bLogout);

        bLogout.setOnClickListener(this);

        userLocalStore = new com.example.yogeshdarji.loginregister.UserLocalStore(this);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        if(authenticate()==true)
        {
            displayUserDetails();
        }

        else
        {
            startActivity(new Intent(MainActivity.this, com.example.yogeshdarji.loginregister.Login.class));
        }

    }

    public boolean authenticate()
    {
        return userLocalStore.getUserLoggedIn();
    }

    private void displayUserDetails()
    {
        com.example.yogeshdarji.loginregister.User user = userLocalStore.getLoggedInUser();
        etUsername.setText(user.username);
        etName.setText(user.name);
        etAge.setText(user.age + "");
    }



    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bLogout:
                userLocalStore.clearUserData();
                userLocalStore.setUserLoggedIn(false);
                startActivity(new Intent(this, com.example.yogeshdarji.loginregister.Login.class));
                break;
        }
    }
}
