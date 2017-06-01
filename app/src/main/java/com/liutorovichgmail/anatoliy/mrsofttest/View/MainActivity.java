package com.liutorovichgmail.anatoliy.mrsofttest.View;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.liutorovichgmail.anatoliy.mrsofttest.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showFragment(MainActivityFragment.createInstance(getSupportFragmentManager()), false, false);
    }

    public void showFragment(Fragment fragment, boolean addToBackStack, boolean clearToBackStak) {
        /// очистить BackStak
        if (clearToBackStak) {
            while (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                getSupportFragmentManager().popBackStackImmediate();
            }
        }

        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.conteiner, fragment);


        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
}
