package com.liutorovichgmail.anatoliy.mrsofttest.View.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liutorovichgmail.anatoliy.mrsofttest.R;

/**
 * Created by ToLik on 30.05.2017.
 */


public class CursorAdapter extends CursorAdapterRecyclerView<CursorAdapter.ViewHolder> {

        public CursorAdapter(Context context, Cursor cursor){
            super(context,cursor);
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {

            TextView mName;
            TextView mProfession;
            TextView mAge;

            public ViewHolder(View view) {
                super(view);
                mName = (TextView) view.findViewById(R.id.tv_name);
                mProfession = (TextView) view.findViewById(R.id.tv_profession);
                mAge = (TextView) view.findViewById(R.id.tv_age);
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_rcview, parent, false);
            ViewHolder vh = new ViewHolder(itemView);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, Cursor cursor) {
            final String name = cursor.getString(cursor.getColumnIndex("name"));
            final String surname = cursor.getString(cursor.getColumnIndex("surname"));
            final String profession = cursor.getString(cursor.getColumnIndex("profession"));
            final int age = cursor.getInt(cursor.getColumnIndex("age"));

            viewHolder.mName.setText(name + " " + surname);
            viewHolder.mProfession.setText(profession);
            viewHolder.mAge.setText("Возраст: " + age);
        }
}

