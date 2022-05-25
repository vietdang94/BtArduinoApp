package ru.astar.btarduinoapp1;

import android.os.Bundle;
import android.preference.PreferenceFragment;

public class PrefFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.main_settings);
    }
}
