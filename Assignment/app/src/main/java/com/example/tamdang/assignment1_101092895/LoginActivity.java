package com.example.tamdang.assignment1_101092895;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText txtUser, txtPass;
    Button btnLogin, viewSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this, "Login.db", null, 1);
        txtUser = findViewById(R.id.edtUser);
        txtPass = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        viewSignup = findViewById(R.id.btnSignup);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 if (txtUser.equals("") || txtPass.equals("")) {
                     Toast.makeText(getApplicationContext(), "Field are empty", Toast.LENGTH_SHORT);
                 }

                if (txtUser.getText().toString().equals("admin") && txtPass.getText().toString().equals("P@ssword")) {
                    Intent i = new Intent(v.getContext(), MainActivity.class);
                    startActivity(i);
                }
                else {
                    TextView txtError = findViewById(R.id.txtError);
                    txtError.setText("Either Username or Password is incorrect!");
                }
            }
        });

    }




}
