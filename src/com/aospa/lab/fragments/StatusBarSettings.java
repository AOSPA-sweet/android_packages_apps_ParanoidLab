package com.aospa.lab.fragments;

import com.android.internal.logging.nano.MetricsProto;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.UserHandle;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.UserHandle;
import android.content.ContentResolver;
import android.content.res.Resources;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import androidx.preference.PreferenceCategory;
import androidx.preference.Preference.OnPreferenceChangeListener;
import androidx.preference.PreferenceFragment;
import androidx.preference.SwitchPreference;
import android.provider.Settings;
import com.android.settings.R;

import java.util.Locale;
import android.text.TextUtils;
import android.view.View;

import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.Utils;
import android.util.Log;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

import com.aospa.support.preferences.SystemSettingMasterSwitchPreference;

public class StatusBarSettings extends SettingsPreferenceFragment
        implements Preference.OnPreferenceChangeListener {

private static final String KEY_NETWORK_TRAFFIC = "network_traffic_state";

private SystemSettingMasterSwitchPreference mNetworkTraffic;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        addPreferencesFromResource(R.xml.statusbar);
        PreferenceScreen prefSet = getPreferenceScreen();
        final ContentResolver resolver = getActivity().getContentResolver();

        mNetworkTraffic = (SystemSettingMasterSwitchPreference)
                findPreference(KEY_NETWORK_TRAFFIC);
        mNetworkTraffic.setChecked((Settings.System.getInt(getActivity().getContentResolver(),
                Settings.System.NETWORK_TRAFFIC_STATE, 0) == 1));
        mNetworkTraffic.setOnPreferenceChangeListener(this);

    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object objValue) {
    	if (preference == mNetworkTraffic) {
            boolean enabled = (boolean) objValue;
            Settings.System.putInt(getActivity().getContentResolver(),
                    Settings.System.NETWORK_TRAFFIC_STATE, enabled ? 1 : 0);
            return true;
	}
        return false;
    }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.AOSPA;
    }

}
