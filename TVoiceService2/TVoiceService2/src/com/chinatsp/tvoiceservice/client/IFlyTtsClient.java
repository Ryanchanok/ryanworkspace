package com.chinatsp.tvoiceservice.client;

import com.iflytek.adapter.ttsservice.ITtsClientListener;

public class IFlyTtsClient implements ITtsClientListener {
	private ITtsClientListener mITtsClientListener;

	public void setmITtsClientListener(ITtsClientListener ittsclientlistener) {
		this.mITtsClientListener = ittsclientlistener;
	}

	@Override
	public void onPlayBegin() {
		// TODO Auto-generated method stub
		mITtsClientListener.onPlayBegin();
	}

	@Override
	public void onPlayCompleted() {
		// TODO Auto-generated method stub
		mITtsClientListener.onPlayCompleted();
	}

	@Override
	public void onPlayInterrupted() {
		// TODO Auto-generated method stub
		mITtsClientListener.onPlayInterrupted();
	}

	@Override
	public void onProgressReturn(int arg0, int arg1) {
		// TODO Auto-generated method stub
		mITtsClientListener.onProgressReturn(arg0, arg1);
	}

	@Override
	public void onTtsInited(boolean arg0, int arg1) {
		// TODO Auto-generated method stub
		mITtsClientListener.onTtsInited(arg0, arg1);
	}

}
