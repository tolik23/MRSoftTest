package com.liutorovichgmail.anatoliy.mrsofttest.DI;

import android.content.Context;
import android.view.View;

import com.liutorovichgmail.anatoliy.mrsofttest.Presenter.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;


@Module
public class MainActivityPresenterModule {

    @Provides
    public MainActivityPresenter providePresrnter(Context context, View v){
        MainActivityPresenter presenter = new MainActivityPresenter(context, v);
        presenter.fillRecyclerView();
        return presenter;
    }
}
