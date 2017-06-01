package com.liutorovichgmail.anatoliy.mrsofttest.View;

import android.database.SQLException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.liutorovichgmail.anatoliy.mrsofttest.DI.App;
import com.liutorovichgmail.anatoliy.mrsofttest.DI.MainActivityPresenterComponent;
import com.liutorovichgmail.anatoliy.mrsofttest.Model.DataBaseFilling;
import com.liutorovichgmail.anatoliy.mrsofttest.Presenter.MainActivityPresenter;
import com.liutorovichgmail.anatoliy.mrsofttest.R;

import javax.inject.Inject;


public class MainActivityFragment extends Fragment {
    ImageButton mButtonSort;
    EditText mEtSearch;
    private MainActivityPresenter mPresenter;
    private static final String TAG = MainActivityFragment.class.getSimpleName();

    @Inject
    MainActivityPresenter presenter;

    public static MainActivityFragment createInstance(FragmentManager fragmentManager) {
        MainActivityFragment myFragment = (MainActivityFragment) fragmentManager.findFragmentByTag(MainActivityFragment.TAG);

        if (myFragment == null) {

            myFragment = new MainActivityFragment();
        }
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final DataBaseFilling dataBaseFilling = new DataBaseFilling(getContext());
        dataBaseFilling.addAllContact();

        View view = inflater.inflate(R.layout.fragment_main_activity, container, false);

        mButtonSort = (ImageButton) view.findViewById(R.id.btn_sort);
        mEtSearch = (EditText) view.findViewById(R.id.edit_text_search);

        MainActivityPresenterComponent component = App.component(this);
        component.inject(this);
        component.presenter();

        // сортировка при нажатии кнопки
        mPresenter = new MainActivityPresenter(getContext(), view);
        mPresenter.fillRecyclerView();

        mButtonSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.sortContacts();
            }
        });

        try {
            // установка слушателя изменения текста
            mEtSearch.addTextChangedListener(new TextWatcher() {

                public void afterTextChanged(Editable s) { }

                public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
                // при изменении текста выполняем фильтрацию
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (s == null || s.length() == 0) {
                        mPresenter.fillRecyclerView();
                    }
                    else {
                        mPresenter.filterContacts(s);
                    }
                }
            });
        }
        catch (SQLException ex){}

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
