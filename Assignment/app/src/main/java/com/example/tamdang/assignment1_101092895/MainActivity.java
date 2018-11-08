package com.example.tamdang.assignment1_101092895;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView general_schedule_card, personal_schedule_card, speakers_card, maps_card,
            attendees_card, sponsors_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Defining CardView
        general_schedule_card = findViewById(R.id.general_schedule_card);
        personal_schedule_card = findViewById(R.id.personal_schedule_card);
        speakers_card = findViewById(R.id.speakers_card);
        maps_card = findViewById(R.id.maps_card);
        attendees_card = findViewById(R.id.attendees_card);
        sponsors_card = findViewById(R.id.sponsors_card);

        // Set Click Listener to these Cards
        general_schedule_card.setOnClickListener(this);
        personal_schedule_card.setOnClickListener(this);
        speakers_card.setOnClickListener(this);
        maps_card.setOnClickListener(this);
        attendees_card.setOnClickListener(this);
        sponsors_card.setOnClickListener(this);

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

        }
    }
}
