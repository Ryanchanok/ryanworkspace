package com.chinatsp.tvoiceservice;

import com.chinatsp.tvoiceservice.client.IFlyNaviClient;
import com.chinatsp.tvoiceservice.client.IFlyPlatformAdapterClient;
import com.iflytek.navigationservice.NavigationHelp;
import com.iflytek.platformservice.PlatformHelp;

import android.app.Application;
import android.content.Intent;

public class VoiceApplication extends Application{
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		PlatformHelp.getInstance().setPlatformClient(new IFlyPlatformAdapterClient(this));
		NavigationHelp.getInstance().setNaviClient(new IFlyNaviClient());
	}

}
