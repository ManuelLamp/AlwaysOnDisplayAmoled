package com.tomer.alwayson.activities;

import android.os.Bundle;

import com.heinrichreimersoftware.androidissuereporter.IssueReporterActivity;
import com.heinrichreimersoftware.androidissuereporter.model.github.ExtraInfo;
import com.heinrichreimersoftware.androidissuereporter.model.github.GithubTarget;
import com.tomer.alwayson.helpers.Prefs;
import com.tomer.alwayson.SecretConstants;


public class ReporterActivity extends IssueReporterActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setGuestEmailRequired(true);
    }

    @Override
    public GithubTarget getTarget() {
        return new GithubTarget("rosenpin", "AlwaysOnDisplayAmoled");
    }

    @Override
    public String getGuestToken() {
        return SecretConstants.getPropertyValue(this, "github-key");
    }

    @Override
    public void onSaveExtraInfo(ExtraInfo extraInfo) {
        Prefs prefs = new Prefs(this);
        String[][] preferences = prefs.toArray();
        for (String[] preference : preferences) {
            extraInfo.put(preference[0], preference[1]);
        }
    }
}
