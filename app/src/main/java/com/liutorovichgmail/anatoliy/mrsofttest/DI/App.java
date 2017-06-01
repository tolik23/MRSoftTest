package com.liutorovichgmail.anatoliy.mrsofttest.DI;

import android.app.Application;
import android.content.Context;

import com.liutorovichgmail.anatoliy.mrsofttest.View.MainActivityFragment;

public class App extends Application {

    MainActivityPresenterComponent component;

    public static MainActivityPresenterComponent component(MainActivityFragment context){
        return ((App) context.getApplicationContext()).component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = MainActivityPresenterComponent
                .builder()
                .daggerTestImageModelModule(new MainActivityPresenterModule())
                .build();
    }

}
