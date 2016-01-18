package com.raizada.ankush.microfinance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener {

    Button bLogin;
    EditText etUsername, etPassword;
    TextView tvregisterLink;
    com.example.yogeshdarji.loginregister.UserLocalStore userLocalStore;

    //Login Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText)findViewById(R.id.etUsername);
        etPassword = (EditText)findViewById(R.id.etPassword);
        bLogin = (Button)findViewById(R.id.bLogin);
        tvregisterLink = (TextView)findViewById(R.id.tvRegisterLink);


        bLogin.setOnClickListener(this);
        tvregisterLink.setOnClickListener(this);
        userLocalStore = new com.raizada.ankush.microfinance.loginregister.UserLocalStore(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.bLogin:

                //User user;
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

               // userLocalStore.storeUserData(user);
               // userLocalStore.setUserLoggedIn(true);

                com.example.yogeshdarji.loginregister.User user = new com.example.yogeshdarji.loginregister.User(username, password);

                authenticate(user);

                break;

            case R.id.tvRegisterLink:
        startActivity(new Intent(this, com.example.yogeshdarji.loginregister.Register.class));

                break;
        }
    }


    public void authenticate(com.example.yogeshdarji.loginregister.User user)
    {
       // ServerRequests serverRequest = new ServerRequests(this);
      //  serverRequest.fetchUserDataAsyncTask(user, new GetUserCallback()
      {

        }
    }
}
