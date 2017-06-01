package com.liutorovichgmail.anatoliy.mrsofttest.Presenter;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.liutorovichgmail.anatoliy.mrsofttest.Model.DataBase;
import com.liutorovichgmail.anatoliy.mrsofttest.R;
import com.liutorovichgmail.anatoliy.mrsofttest.View.Adapters.CursorAdapter;

import rx.Observer;
import rx.Subscription;

public class MainActivityPresenter implements Presenter {

    private CursorAdapter adapter;
    RecyclerView recyclerView;
    View mView;
    DataBase db;
    Context mContext;

    public MainActivityPresenter(Context context, View v){
        mContext = context;
        mView = v;
    }

    @Override
    public void fillRecyclerView() {

        db= new DataBase(mContext);

        Subscription subscription = db.getAllContacts()
                .subscribe(new Observer<Cursor>() {

                    @Override
                    public void onCompleted() {}
                    @Override
                    public void onError(Throwable e) {}

                    @Override
                    public void onNext(Cursor c) {
                        recyclerView = (RecyclerView) mView.findViewById(R.id.rcview);
                        recyclerView.setHasFixedSize(true);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext);
                        recyclerView.setLayoutManager(layoutManager);
                        adapter = new CursorAdapter(mContext, c);
                        recyclerView.setAdapter(adapter);
                    }
                });
    }

    @Override
    public void sortContacts() {

        db= new DataBase(mContext);

        Subscription subscription = db.getSort()
                .subscribe(new Observer<Cursor>() {

                    @Override
                    public void onCompleted() {}
                    @Override
                    public void onError(Throwable e) {}

                    @Override
                    public void onNext(Cursor c) {
                        adapter.swapCursor(c);
                    }

                });
    }

    @Override
    public void filterContacts(final CharSequence s) {
        db= new DataBase(mContext);

        Subscription subscription = db.getFilter(s)
                .subscribe(new Observer<Cursor>() {

                    @Override
                    public void onCompleted() {}
                    @Override
                    public void onError(Throwable e) {}

                    @Override
                    public void onNext(Cursor c) {
                            adapter.swapCursor(c);
                    }

                });
    }


}
