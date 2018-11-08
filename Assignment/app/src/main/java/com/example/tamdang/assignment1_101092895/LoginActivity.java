package com.example.tamdang.assignment1_101092895;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin = findViewById(R.id.btnLogin);

        Button viewSignup = findViewById(R.id.btnSignup);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtUser = findViewById(R.id.edtUser);
                EditText txtPass = findViewById(R.id.edtPassword);
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
