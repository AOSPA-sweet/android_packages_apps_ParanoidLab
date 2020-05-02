package com.extra.settings.fragments;

import com.android.internal.logging.nano.MetricsProto;

import android.os.Bundle;
import com.android.settings.R;

import com.android.settings.SettingsPreferenceFragment;

public class NotificationSettings extends SettingsPreferenceFragment {

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        addPreferencesFromResource(R.xml.extra_settings_notifications);
    }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.EXTRA_SETTINGS;
    }
}
