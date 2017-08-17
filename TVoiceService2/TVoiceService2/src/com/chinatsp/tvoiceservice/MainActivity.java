package com.chinatsp.tvoiceservice;

import android.os.Bundle;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startService(new Intent(this, VoiceService.class));
		TextView show = (TextView) findViewById(R.id.show);
		show.setText(getPackageName());
		findViewById(R.id.start).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				try {
		    		Intent intent = new Intent();
		        	intent.setComponent(new ComponentName("com.iflytek.cutefly.speechclient",
		                    "com.iflytek.autofly.SpeechClientService"));
		        	 /*外界启动的包名，必填*/
		            intent.putExtra("fromservice","com.chinatsp.tvoiceservice");
		        	startService(intent);
		        } catch (Exception e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		stopService(new Intent(this, VoiceService.class));
	}
}
