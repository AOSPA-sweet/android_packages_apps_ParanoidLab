package com.radiant.extras.fragments;

import com.android.internal.logging.nano.MetricsProto;

import android.os.Bundle;
import com.android.settings.R;

import com.android.settings.SettingsPreferenceFragment;

public class NotificationSettings extends SettingsPreferenceFragment {

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        addPreferencesFromResource(R.xml.radiant_extras_notifications);
    }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.Radiant;
    }
}
