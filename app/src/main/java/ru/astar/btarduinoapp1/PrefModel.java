package ru.astar.btarduinoapp1;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PrefModel implements SharedPreferences.OnSharedPreferenceChangeListener {

    public static final String KEY_DELAY_TIMER = "key_delay_timer";
    public static final String KEY_POINTS_COUNT = "key_points_count";
    public static final String KEY_GRAPH_TEMP = "key_graph_temp";
    public static final String KEY_GRAPH_RAND = "key_graph_rand";
    public static final String KEY_LAST_CONNECT_DEVICE = "key_last_connect_device";

    private int     delayTimer;
    private int     pointsCount;
    private boolean graphTemp;
    private boolean graphRand;
    private boolean lastConnectDevice;

    private SharedPreferences preferences;

    public PrefModel(Context context) {
        this.delayTimer        = 1000;
        this.pointsCount       = 40;
        this.graphTemp         = true;
        this.graphRand         = false;
        this.lastConnectDevice = false;

        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        preferences.registerOnSharedPreferenceChangeListener(this);
    }

    public int getDelayTimer() {
        return delayTimer;
    }

    public void setDelayTimer(int delayTimer) {
        this.delayTimer = delayTimer;
    }

    public int getPointsCount() {
        return pointsCount;
    }

    public void setPointsCount(int pointsCount) {
        this.pointsCount = pointsCount;
    }

    public boolean isGraphTemp() {
        return graphTemp;
    }

    public void setGraphTemp(boolean graphTemp) {
        this.graphTemp = graphTemp;
    }

    public boolean isGraphRand() {
        return graphRand;
    }

    public void setGraphRand(boolean graphRand) {
        this.graphRand = graphRand;
    }

    public boolean isLastConnectDevice() {
        return lastConnectDevice;
    }

    public void setLastConnectDevice(boolean lastConnectDevice) {
        this.lastConnectDevice = lastConnectDevice;
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences preferences, String key) {
        switch (key) {
            case KEY_DELAY_TIMER:
                int delayTimer = Integer.parseInt(preferences.getString(key, "1000"));
                setDelayTimer(delayTimer);
                break;
            case KEY_POINTS_COUNT:
                int pointCount = Integer.parseInt(preferences.getString(key, "1000"));
                setPointsCount(pointCount);
                break;
            case KEY_GRAPH_TEMP:
                setGraphTemp(preferences.getBoolean(key, true));
                break;
            case KEY_GRAPH_RAND:
                setGraphRand(preferences.getBoolean(key, false));
                break;
            case KEY_LAST_CONNECT_DEVICE:
                setLastConnectDevice(preferences.getBoolean(key, false));
                break;
        }
    }
}
