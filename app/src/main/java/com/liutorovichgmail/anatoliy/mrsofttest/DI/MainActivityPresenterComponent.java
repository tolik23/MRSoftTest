package com.liutorovichgmail.anatoliy.mrsofttest.DI;

import com.liutorovichgmail.anatoliy.mrsofttest.Presenter.Presenter;
import com.liutorovichgmail.anatoliy.mrsofttest.View.MainActivityFragment;

import javax.inject.Singleton;

import dagger.Component;

    @Singleton
    @Component(
            modules = {MainActivityPresenterModule.class}

    )
    public interface MainActivityPresenterComponent {
        void inject(MainActivityFragment mainFragment);
        Presenter presenter();
    }