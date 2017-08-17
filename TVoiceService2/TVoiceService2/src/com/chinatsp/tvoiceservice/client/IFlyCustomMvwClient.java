package com.chinatsp.tvoiceservice.client;

import com.iflytek.adapter.custommvwservice.ICustomMvwCallback;

public class IFlyCustomMvwClient implements ICustomMvwCallback {
	private ICustomMvwCallback iCustomMvwCallback;

	public void setCustomMvwCallback(ICustomMvwCallback iCustomMvwCallback) {
		this.iCustomMvwCallback = iCustomMvwCallback;
	}

	@Override
	public void initCallback(boolean arg0, int arg1) {
		// TODO Auto-generated method stub
		iCustomMvwCallback.initCallback(arg0, arg1);
	}

	@Override
	public void initMvwCallback(boolean arg0, int arg1) {
		// TODO Auto-generated method stub
		iCustomMvwCallback.initMvwCallback(arg0, arg1);
	}

	@Override
	public void onWakeupResult(int arg0, int arg1) {
		// TODO Auto-generated method stub
		iCustomMvwCallback.onWakeupResult(arg0, arg1);
	}

}
