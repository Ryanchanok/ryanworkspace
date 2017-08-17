package com.chinatsp.tvoiceservice.client;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.RemoteException;
import android.util.Log;

import com.iflytek.platform.PlatformClientListener;
import com.iflytek.platformservice.PlatformService;

/**
 * 该类为实现讯飞语音平台的监听类
 * 
 * @author Ryan.chen
 * 
 */
public class IFlyPlatformAdapterClient implements PlatformClientListener {
	private Context mContext;
	private PlatformClientListener mPlatformClientListener;

	public void setmFlyVoiceController(PlatformClientListener platformClientListener) {
		this.mPlatformClientListener = platformClientListener;
	}

	public IFlyPlatformAdapterClient(Context context) {
		super();
		this.mContext = context;
	}

	@Override
	public int changePhoneState(int arg0) {
		// TODO Auto-generated method stub
		return mPlatformClientListener.changePhoneState(arg0);
	}

	@Override
	public void onAbandonAudioFocus() {
		// TODO Auto-generated method stub
		mPlatformClientListener.onAbandonAudioFocus();
	}

	@Override
	public String onDoAction(String actionJson) {
		// TODO Auto-generated method stub
		return mPlatformClientListener.onDoAction(actionJson);
	}

	@Override
	public String onGetCarNumbersInfo() {
		// TODO Auto-generated method stub
		return mPlatformClientListener.onGetCarNumbersInfo();
	}

	@Override
	public String onGetLocation() {
		// TODO Auto-generated method stub
		return mPlatformClientListener.onGetLocation();
	}

	@Override
	public int onGetState(int arg0) {
		// TODO Auto-generated method stub
		return mPlatformClientListener.onGetState(arg0);
	}

	@Override
	public int onGetVrViewType() {
		// TODO Auto-generated method stub
		return mPlatformClientListener.onGetVrViewType();
	}

	@Override
	public void onManualInteractResult(String arg0, String arg1, String arg2) {
		// TODO Auto-generated method stub
		mPlatformClientListener.onManualInteractResult(arg0, arg1, arg2);
	}

	@Override
	public String onNLPResult(String arg0) {
		// TODO Auto-generated method stub
		return mPlatformClientListener.onNLPResult(arg0);
	}

	@Override
	public int onRequestAudioFocus(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return mPlatformClientListener.onRequestAudioFocus(arg0, arg1);
	}

	@Override
	public boolean onSearchPlayList(String arg0) {
		// TODO Auto-generated method stub
		return mPlatformClientListener.onSearchPlayList(arg0);
	}

	@Override
	public void onServiceUnbind() {
		// TODO Auto-generated method stub
		mPlatformClientListener.onServiceUnbind();
	}
}