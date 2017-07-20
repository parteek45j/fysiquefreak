package com.android.parteek.fysquefreak;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {

    Dbhelper dbhelper;
    SQLiteDatabase sqLiteDatabase;


    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {

        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        String table=uri.getLastPathSegment();
        long l=sqLiteDatabase.insert(table,null,values);
        Uri dummy=Uri.parse("fysque/"+l);
        return dummy;
    }

    @Override
    public boolean onCreate() {
        dbhelper=new Dbhelper(getContext(),Util.DbName,null,Util.DbVersion);
        sqLiteDatabase=dbhelper.getWritableDatabase();
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        String table=uri.getLastPathSegment();
        Cursor c=sqLiteDatabase.query(table,projection,null,null,null,null,null);
        return c;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    class Dbhelper extends SQLiteOpenHelper{

        public Dbhelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
            super(context, name, factory, version);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL(Util.CreateTab);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
