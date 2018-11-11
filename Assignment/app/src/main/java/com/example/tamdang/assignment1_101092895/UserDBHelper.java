package com.example.tamdang.assignment1_101092895;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "user.db";

    public UserDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserContract.SQL_CREATE_USERS);
        insertUser(db, new User("admin", "P@ssword"));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(UserContract.SQL_DROP_USERS);
        onCreate(db);
    }

    // Inserting user in database
    public long insertUser(SQLiteDatabase db, User user) {
        ContentValues values = new ContentValues();
        values.put(UserContract.UserEntity.COL_NAME_USERNAME, user.getUser_name());
        values.put(UserContract.UserEntity.COL_NAME_PASSWORD, user.getPassword());
        return db.insert(UserContract.UserEntity.TABLE_NAME, null, values);
    }

    public User getUser (SQLiteDatabase db, String username) {
        String [] projection = {
                UserContract.UserEntity.COL_NAME_USERNAME,
                UserContract.UserEntity.COL_NAME_PASSWORD
        };

        String selection = UserContract.UserEntity.COL_NAME_USERNAME + "= ? ";
        String[] selectionArgs = {username};

        Cursor cursor = db.query(
                UserContract.UserEntity.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        if (cursor.moveToFirst()) {
            String usr = cursor.getString(
                    cursor.getColumnIndexOrThrow(UserContract.UserEntity.COL_NAME_USERNAME));
            String password = cursor.getString(
                    cursor.getColumnIndexOrThrow(UserContract.UserEntity.COL_NAME_PASSWORD));

            User user = new User(usr, password);
            return user;
        }
        cursor. close();
        return null;

    }


}
