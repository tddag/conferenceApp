package com.example.tamdang.assignment1_101092895;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SpeakerProfile extends AppCompatActivity {
    private SQLiteDatabase db;
    private SpeakerDBHelper myDB;

    ImageView imageView;
    TextView fnameTxtView, lnameTxtView, affiliationTxtView, emailTxtView, bioTxtView;

    public String TAG = "Main";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaker_profile);

        myDB = new SpeakerDBHelper(this);
        db = myDB.getWritableDatabase();

        Intent i = getIntent();
        Bundle bd = i.getExtras();
        long id = Long.parseLong((String) bd.get("ID"));
        Speaker speaker = myDB.getPresenter(db, id);

        imageView =  findViewById(R.id.profileImg);
        fnameTxtView =  findViewById(R.id.fnameTxtView);
        lnameTxtView =  findViewById(R.id.lnameTxtView);
        affiliationTxtView =  findViewById(R.id.affiliationTxtView);
        emailTxtView =  findViewById(R.id.emailTxtView);
        bioTxtView =  findViewById(R.id.bioTxtView);

        fnameTxtView.setText(speaker.getFirstname());
        lnameTxtView.setText(speaker.getLastname());
        affiliationTxtView.setText(speaker.getAffiliation());
        emailTxtView.setText(speaker.getEmail());
        bioTxtView.setText(speaker.getBio());

    }
    @Override
    protected void onDestroy() {
        myDB.close();
        super.onDestroy();

    }

}

