package com.example.tamdang.assignment1_101092895;

import android.provider.BaseColumns;

public class SpeakerContract {
    private SpeakerContract(){}

    public static class PresenterEntry implements BaseColumns {

        public static final String TABLE_NAME = "presenter";
        public static final String _ID = "ID";
        public static final String FIRST_NAME = "first_name";
        public static final String LAST_NAME = "last_name";
        public static final String AFFILIATION = "affiliation";
        public static final String EMAIL = "email";
        public static final String BIO = "bio";
    }

    public static final String SQL_CREATE_PRESENTER =
            "CREATE TABLE "+PresenterEntry.TABLE_NAME+" ("+
                    PresenterEntry._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    PresenterEntry.FIRST_NAME+" TEXT, " +
                    PresenterEntry.LAST_NAME+" TEXT, " +
                    PresenterEntry.AFFILIATION+" TEXT, " +
                    PresenterEntry.EMAIL+" TEXT, " +
                    PresenterEntry.BIO+" TEXT)";

    public static final String SQL_DROP_PRESENTER =
            "DROP TABLE IF EXISTS "+PresenterEntry.TABLE_NAME;

}
