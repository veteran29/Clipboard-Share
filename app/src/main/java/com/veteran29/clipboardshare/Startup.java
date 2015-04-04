package com.veteran29.clipboardshare;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class Startup 
	extends BroadcastReceiver
{
	@Override
	public void onReceive(Context context, Intent intent) 
	{
		if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED))
		{	
	        Intent i = new Intent("com.veteran29.clipboardshare.Main");
	        i.setClass(context, Main.class);
	        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

	        context.startActivity(i);
	    }
	}
}
