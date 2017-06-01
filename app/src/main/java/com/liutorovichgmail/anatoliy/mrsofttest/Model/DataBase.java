package com.liutorovichgmail.anatoliy.mrsofttest.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import rx.Observable;


public class DataBase extends SQLiteOpenHelper implements Model {

    private static final String DATABASE_NAME = "DataBase";
    private static final String TABLE_EMPLOYEES = "employees";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_SURNAME = "surname";
    private static final String KEY_PROFESSION = "profession";
    private static final String KEY_AGE = "age";

    public DataBase (Context context) {
        super(context, DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ORDERS_TABLE = "CREATE TABLE " + TABLE_EMPLOYEES + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_SURNAME + " TEXT," + KEY_PROFESSION + " TEXT," +  KEY_AGE + " TEXT" +")";
        db.execSQL(CREATE_ORDERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEES);
        onCreate(db);
    }

    // длбавление данных в таблицу
    @Override
    public void addContact(String name, String surname, String profession, int age) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_NAME, name);
        cv.put(KEY_SURNAME, surname);
        cv.put(KEY_PROFESSION, profession);
        cv.put(KEY_AGE, age);

        db.insert(TABLE_EMPLOYEES,null, cv);
        db.close();
    }

    // вывод всех контактов
    @Override
    public Observable<Cursor> getAllContacts() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.query(TABLE_EMPLOYEES, null, null, null, null, null, null);
        Observable<Cursor> getAllcontacts = Observable.just(c);
        return getAllcontacts;
    }

    // сортировка
    @Override
    public Observable<Cursor> getSort(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.query(TABLE_EMPLOYEES, null, null, null, null, null, KEY_NAME);
        Observable<Cursor> getSortcontacts = Observable.just(c);
        return getSortcontacts;
    }

    // фильтрация
    @Override
    public Observable<Cursor> getFilter(CharSequence constraint) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from " + TABLE_EMPLOYEES + " where " +
                KEY_NAME + " like ?", new String[]{"%" + constraint + "%"});
        Observable<Cursor> getFiltercontacts = Observable.just(c);
        return getFiltercontacts;
    }

    // проверка на пустоту таблицы
    @Override
    public boolean checkNull() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.query(TABLE_EMPLOYEES, null, null, null, null, null, null);
        if (c.getCount() == 0){
            return true;
        }else {
            return false;
        }
    }
}
