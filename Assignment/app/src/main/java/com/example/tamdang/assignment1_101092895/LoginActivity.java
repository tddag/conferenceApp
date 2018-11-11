package com.example.tamdang.assignment1_101092895;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private UserDBHelper usrHelper;
    EditText txtUser, txtPass;
    Button btnLogin, viewSignup;

    private SharedPreferenceConfig preferenceConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        preferenceConfig = new SharedPreferenceConfig((getApplicationContext()));

        usrHelper = new UserDBHelper(this);
        db = usrHelper.getWritableDatabase();

        txtUser = findViewById(R.id.edtUser);
        txtPass = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        viewSignup = findViewById(R.id.btnSignup);

        if (preferenceConfig.readLoginStatus()) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = txtUser.getText().toString();
                String password = txtPass.getText().toString();
                User usr = usrHelper.getUser(db, username);

                 if (username.equals("") || password.equals("")) {
                     Toast.makeText(getApplicationContext(), "Field are empty", Toast.LENGTH_SHORT);
                 } else {
                     if (username.equals(usr.getUser_name()) && password.equals(usr.getPassword())) {
                         Intent i = new Intent(v.getContext(), MainActivity.class);
                         startActivity(i);
                         preferenceConfig.writeLoginStatus(true);
                         preferenceConfig.writeLoginUser(username);
                     }
                     else {
                         TextView txtError = findViewById(R.id.txtError);
                         txtError.setText("Either Username or Password is incorrect!");
                         txtUser.setText("");
                         txtPass.setText("");
                     }
                 }


            }
        });

    }




}
