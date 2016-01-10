package ru.diitcenter.myapplication2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by marat on 19.12.15.
 */
public class MyDataBase {

    public static final String TABLE_CONTACTS = "table_contacts";
    public static final String TABLE_NEWS = "table_news";

    private static final String table_type = "CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS + " ("
            + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "name text,"
            + "phone text,"
            + "age int);";

    private static final String table_news = "CREATE TABLE IF NOT EXISTS " + TABLE_NEWS + " ("
            + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "name text,"
            + "date text,"
            + "image text,"
            + "desc text);";

    private SQLiteDatabase db;

    public MyDataBase(Context context){
        db = new SqliteOpenHelper(context).getWritableDatabase();
    }

    public void insert(People item){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", item.name);
        contentValues.put("phone", item.phone);
        contentValues.put("age", item.age);
        db.insert(TABLE_CONTACTS, null, contentValues);
    }

    public void insertNews(News item){
        /*ContentValues contentValues = new ContentValues();
        contentValues.put("name", item.name);
        contentValues.put("date", item.date);
        contentValues.put("image", item.image);
        contentValues.put("desc", item.desc);
        db.insert(TABLE_NEWS, null, contentValues);*/
    }

    public Cursor queryFromContacts(){
        Cursor cursor = db.query(TABLE_CONTACTS, null,null,null,null,null,null);
        return cursor;
    }

    public Cursor queryFromNews(){
        Cursor cursor = db.query(TABLE_NEWS, null,null,null,null,null,null);
        return cursor;
    }

    public static class SqliteOpenHelper extends SQLiteOpenHelper {

        public SqliteOpenHelper(Context context) {
            super(context, "myDb", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(table_type);
            db.execSQL(table_news);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
