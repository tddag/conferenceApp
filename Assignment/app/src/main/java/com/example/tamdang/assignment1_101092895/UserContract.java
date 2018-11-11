package com.example.tamdang.assignment1_101092895;

import android.provider.BaseColumns;

public class UserContract {
    private UserContract() {

    }

    public static class UserEntity implements BaseColumns {
        public static final String TABLE_NAME = "USER";
        public static final String COL_NAME_USERNAME = "USERNAME";
        public static final String COL_NAME_PASSWORD = "PASSWORD";
        public static final String COL_TYPE_USERNAME = "TEXT";
        public static final String COL_TYPE_PASSWORD = "TEXT";
    }

    public static final String SQL_CREATE_USERS =
            "CREATE TABLE " + UserEntity.TABLE_NAME + " (" +
                    UserEntity.COL_NAME_USERNAME + " " + UserEntity.COL_TYPE_USERNAME + " PRIMARY KEY, " +
                    UserEntity.COL_NAME_PASSWORD + " " + UserEntity.COL_TYPE_PASSWORD + ")";

    public static final String SQL_DROP_USERS =
            "DROP TABLE IF EXISTS " + UserEntity.TABLE_NAME;
}
