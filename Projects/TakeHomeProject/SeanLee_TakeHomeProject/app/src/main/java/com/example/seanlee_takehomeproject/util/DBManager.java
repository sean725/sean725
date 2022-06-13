package com.example.seanlee_takehomeproject.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBManager extends SQLiteOpenHelper {

    private static final String DB_FILE_NAME = "jefit_takehome_project.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_NAME = "likes";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_BIZ_ID = "biz_id";

    private static final String CREATE_TABLE_STATEMENT = "CREATE TABLE IF NOT EXISTS " +
                                                        TABLE_NAME + " (" +
                                                        COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                                                        COLUMN_BIZ_ID + " STRING" + ")";

    private SQLiteDatabase mDB = null;
    private static DBManager mSingleInstance = null;

    public static DBManager getInstance(Context _context){
        if(mSingleInstance == null) { mSingleInstance = new DBManager(_context); }
        return mSingleInstance;
    }

    private DBManager(@Nullable Context _context){
        super(_context, DB_FILE_NAME, null, DB_VERSION);
        mDB = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_STATEMENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) { }

    public static final int LIKE_ON = 1;
    public static final int LIKE_OFF = 0;

    public int handleLikeBtn(String _id){
        if(isLiked(_id)){ // has data in the db
            deleteLike(_id);
            return LIKE_OFF;
        }else{
            createLike(_id);
            return LIKE_ON;
        }
    }

    public void createLike(String _id){
        // create new biz id in DB
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_BIZ_ID, escapeQuotes(_id));

        mDB.insert(TABLE_NAME, null, cv);
    }

    // remove like from DB
    public void deleteLike(String _id){
        mDB.delete(TABLE_NAME, "biz_id = ?", new String[]{escapeQuotes(_id)});
    }

    public boolean isLiked(String _id){
        Cursor c = mDB.rawQuery("SELECT * FROM likes WHERE biz_id=?", new String[]{escapeQuotes(_id)});
        return c.getCount() > 0;
    }

    private String escapeQuotes(String _id){
        return android.database.DatabaseUtils.sqlEscapeString(_id);
    }
}
