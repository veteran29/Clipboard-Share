package com.veteran29.clipboardshare;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class Share
	extends Activity
{
	public void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        Resources res = getResources();
        
        Log.i("Cliboard Share", "Sharing cliboard content!");
        
        Intent share = new Intent(android.content.Intent.ACTION_SEND);
        share.setType("text/plain");
        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        
        
        if ( !clipboard.hasPrimaryClip() )
        {
        	Toast.makeText(getApplicationContext(), R.string.error_string_empty, 
        			   Toast.LENGTH_LONG).show();
        }
        else
        {
        	share.putExtra(Intent.EXTRA_TEXT, clipboard.getPrimaryClip().getItemAt(0).getText() );
        	startActivity(Intent.createChooser(share, res.getText(R.string.share_title)) );
        }

        this.finish();
	}
}
