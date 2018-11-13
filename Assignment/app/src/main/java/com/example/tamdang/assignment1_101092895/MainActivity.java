package com.example.tamdang.assignment1_101092895;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SQLiteDatabase db;
    private UserDBHelper usrHelper;
    private SharedPreferenceConfig preferenceConfig;
    private CardView general_schedule_card, personal_schedule_card, speakers_card, maps_card,
            attendees_card, sponsors_card;
    private TextView txtUser, txtLogout, txtSurvey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferenceConfig = new SharedPreferenceConfig((getApplicationContext()));

        // Defining CardView
        general_schedule_card = findViewById(R.id.general_schedule_card);
        personal_schedule_card = findViewById(R.id.personal_schedule_card);
        speakers_card = findViewById(R.id.speakers_card);
        maps_card = findViewById(R.id.maps_card);
        attendees_card = findViewById(R.id.attendees_card);
        sponsors_card = findViewById(R.id.sponsors_card);

        // Defining TextView
        txtLogout = findViewById(R.id.txtLogout);
        txtUser = findViewById(R.id.txtUser);
        txtSurvey = findViewById(R.id.txtSurvey);

        txtUser.setText(preferenceConfig.readLoginUser());

        // Set Click Listener to these Cards
        general_schedule_card.setOnClickListener(this);
        personal_schedule_card.setOnClickListener(this);
        speakers_card.setOnClickListener(this);
        maps_card.setOnClickListener(this);
        attendees_card.setOnClickListener(this);
        sponsors_card.setOnClickListener(this);
        txtLogout.setOnClickListener(this);
        txtSurvey.setOnClickListener(this);
        }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.general_schedule_card:
                i = new Intent(this, GeneralScheduleActivity.class);
                startActivity(i);
                break;
            case R.id.personal_schedule_card:
                i = new Intent(this, PersonalScheduleActivity.class);
                startActivity(i);
                break;
            case R.id.speakers_card:
                i = new Intent(this, SpeakersActivity.class);
                startActivity(i);
                break;
            case R.id.maps_card:
                i = new Intent(this, MapsActivity.class);
                startActivity(i);
                break;
            case R.id.attendees_card:
                i = new Intent(this, AttendeesActivity.class);
                startActivity(i);
                break;
            case R.id.sponsors_card:
                i = new Intent(this, SponsorsActivity.class);
                startActivity(i);
                break;
            case R.id.txtLogout:
                i = new Intent(this, LoginActivity.class);
                preferenceConfig.writeLoginStatus(false);
                startActivity(i);
                finish();
                break;
            case R.id.txtSurvey:
                i = new Intent(this, SurveyActivity.class);
                startActivity(i);
                break;


        }
    }
}
