package com.example.learnsqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "learning_sqlite2";
	private static final String DICTIONARY_TABLE_NAME = "test1";
	private static final String KEY_WORD = "id";
	private static final String KEY_DEFINITION = "name";

	private static final String DICTIONARY_TABLE_CREATE = "CREATE TABLE "
			+ DICTIONARY_TABLE_NAME + " (" + KEY_WORD + " TEXT, "
			+ KEY_DEFINITION + " TEXT);";
	private static final String TAG = "MySQLiteHelper";

	public MySQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.d(TAG,"create db");
		db.execSQL(DICTIONARY_TABLE_CREATE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	public boolean isTableExistent(String table) {
		boolean re=false;
		SQLiteDatabase db = this.getReadableDatabase();
		Log.d(TAG, "got the db");
		Cursor cr = showAllTables(db);
		if (cr.moveToFirst()) {
			do {
				String tName=cr.getString(cr.getColumnIndexOrThrow("name"));
				Log.d(TAG, tName);
				
				if(tName.equals(table)){
					re=true;
				}

			} while (cr.moveToNext());
		}
		else{
			Log.d(TAG,"Empty cursor");
		}
		cr.close();
		return re;
	}

	public Cursor showAllTables(SQLiteDatabase db) {
		String mySql = " SELECT name FROM sqlite_master "
				+ " WHERE type='table'             "
				+ "  ";
		return db.rawQuery(mySql, null);
	}

}
