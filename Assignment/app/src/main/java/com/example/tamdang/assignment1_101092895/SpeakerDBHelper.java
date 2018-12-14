package com.example.tamdang.assignment1_101092895;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SpeakerDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "presenter.db";

    public SpeakerDBHelper(Context context) {
        super(context, DATABASE_NAME,   null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SpeakerContract.SQL_CREATE_PRESENTER);
        addPresenter(db, new Speaker("John", "Doe", "Software Engineer - Google Inc.", "johndoe@gmail.com", "Canadian, Enthusiasm in Programming"));
        addPresenter(db, new Speaker("Elon", "Musk", "Founder - Tesla Inc.", "elonmusk@gmail.com", "AI, Machine Learning, Technology Entrepreneurship"));
        addPresenter(db, new Speaker("Bill", "Gates", "Founder - Microsoft Inc.", "billgates@gmail.com", "Billionaire, Windows OS Founder"));
        addPresenter(db, new Speaker("Jeff", "Bezos", "Founder - Amazon Inc.", "jeffbezos@gmail.com", "E-commerce empire, Amazon Cloud Services "));
        addPresenter(db, new Speaker("Mark", "Zuckerberg", "Founder - Facebook Inc.", "markzuckerberg@gmail.com", "Facebook Social Network, The youngest billionaire"));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SpeakerContract.SQL_DROP_PRESENTER);
        onCreate(db);
    }

    public long addPresenter(SQLiteDatabase db, Speaker speaker){
        ContentValues values = new ContentValues();
        values.put(SpeakerContract.PresenterEntry.FIRST_NAME, speaker.getFirstname());
        values.put(SpeakerContract.PresenterEntry.LAST_NAME, speaker.getLastname());
        values.put(SpeakerContract.PresenterEntry.AFFILIATION, speaker.getAffiliation());
        values.put(SpeakerContract.PresenterEntry.EMAIL, speaker.getEmail());
        values.put(SpeakerContract.PresenterEntry.BIO, speaker.getBio());

        return db.insert(SpeakerContract.PresenterEntry.TABLE_NAME, null, values);
    }

    public Speaker getPresenter(SQLiteDatabase db, long presenterId){

        String[] projection = {
                SpeakerContract.PresenterEntry._ID,
                SpeakerContract.PresenterEntry.FIRST_NAME,
                SpeakerContract.PresenterEntry.LAST_NAME,
                SpeakerContract.PresenterEntry.AFFILIATION,
                SpeakerContract.PresenterEntry.EMAIL,
                SpeakerContract.PresenterEntry.BIO,
        };

        String selection = SpeakerContract.PresenterEntry._ID+"= ? ";
        String[] selectionArgs = {Long.toString(presenterId)};


        Cursor cursor = db.query(
                SpeakerContract.PresenterEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        if(cursor.moveToFirst()){

            long id = cursor.getLong(cursor.getColumnIndexOrThrow(SpeakerContract.PresenterEntry._ID));
            String fname = cursor.getString(
                    cursor.getColumnIndexOrThrow(SpeakerContract.PresenterEntry.FIRST_NAME));
            String lname = cursor.getString(
                    cursor.getColumnIndexOrThrow(SpeakerContract.PresenterEntry.LAST_NAME));
            String affiliation = cursor.getString(
                    cursor.getColumnIndexOrThrow(SpeakerContract.PresenterEntry.AFFILIATION));
            String email = cursor.getString(
                    cursor.getColumnIndexOrThrow(SpeakerContract.PresenterEntry.EMAIL));
            String bio = cursor.getString(
                    cursor.getColumnIndexOrThrow(SpeakerContract.PresenterEntry.BIO));

            Speaker speaker = new Speaker(id, fname, lname, affiliation, email, bio);
            return speaker;

        }

        cursor.close();
        return null;
    }
}
