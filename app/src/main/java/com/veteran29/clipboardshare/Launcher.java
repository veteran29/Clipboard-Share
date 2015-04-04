package com.veteran29.clipboardshare;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

/**
 * Created by filip2 on 04.04.15.
 */
public class Launcher extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Intent i = new Intent("com.veteran29.clipboardshare.Main");
        i.setClass(getApplicationContext(), Main.class);
        startActivity(i);

        ComponentName componentToDisable =
                new ComponentName("com.veteran29.clipboardshare",
                        "com.veteran29.clipboardshare.Launcher");

        getPackageManager().setComponentEnabledSetting(
                componentToDisable,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
        this.finish();
    }
}
