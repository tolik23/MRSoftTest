package com.liutorovichgmail.anatoliy.mrsofttest.Model;

import android.database.Cursor;

import rx.Observable;


public interface Model {

    public void addContact(String name, String surname, String profession, int age);
    public Observable<Cursor> getAllContacts();
    public Observable<Cursor> getSort();
    public Observable<Cursor> getFilter(CharSequence constraint);
    public boolean checkNull();
}
