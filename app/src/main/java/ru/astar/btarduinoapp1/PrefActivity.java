package ru.astar.btarduinoapp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PrefActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pref);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new PrefFragment())
                .commit();
    }
}
