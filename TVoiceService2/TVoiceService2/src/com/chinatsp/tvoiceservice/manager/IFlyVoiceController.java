package com.chinatsp.tvoiceservice.manager;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.RemoteException;
import android.util.Log;

import com.chinatsp.tvoiceservice.VoiceService.VoiceActionCallBack;
import com.iflytek.adapter.custommvwservice.ICustomMvwCallback;
import com.iflytek.adapter.ttsservice.ITtsClientListener;
import com.iflytek.navi.NaviClientListener;
import com.iflytek.platform.PlatformClientListener;
import com.iflytek.platform.type.PlatformCode;
import com.iflytek.platformservice.PlatformHelp;
import com.iflytek.platformservice.PlatformService;
import com.incall.proxy.can.CanManager.MIC;

/**
 * 此类为科大讯飞SDK集成控制类，主要包括语音助理,语音播报，导航控制等
 * 
 * @author chenxudong
 * 
 */
public class IFlyVoiceController implements PlatformClientListener, NaviClientListener,
		ITtsClientListener, ICustomMvwCallback {

	private Context mContext;
	private VoiceActionCallBack mVActionCallBack;
	public static final String TAG = "IFlyVoiceController";
	public static final String VOICE_ACTION_MRG = "voice_action_mrg";
	public static final String VOICE_MUSIC_MRG = "music";
	public static final String VOICE_RADIO_MRG = "radio";
	public static final String VOICE_NAVIGATION_MRG = "voice_navigation_mrg";
	public static final String VOICE_MISC_MRG = "voice_misc_mrg";
	public static final String VOICE_AC_MRG = "airControl";
	public static final String VOICE_INFO_DETAIL_MRG = "voice_info_detail_mrg";
	public static final String VOICE_DEFAULT_MRG = "voice_default_mrg";
	private HashMap<String, IVoiceMrgInterface> mCommandMap;
	private AudioManager audioManager = null;

	public IFlyVoiceController(Context context, VoiceActionCallBack mVActionCallBack) {
		super();
		this.mContext = context.getApplicationContext();
		this.mVActionCallBack = mVActionCallBack;
		initActionsMrg();
	}
	public VoiceActionCallBack getVActionCallBack(){
		return mVActionCallBack;
	}

	private void initActionsMrg() {
		// TODO Auto-generated method stub
		if (mCommandMap == null) {
			mCommandMap = new HashMap<String, IVoiceMrgInterface>();
			mCommandMap.put(VOICE_ACTION_MRG, new VoiceActionMrg(mContext, this));
			mCommandMap.put(VOICE_MUSIC_MRG, new VoiceMusicMrg(mContext, this));
			mCommandMap.put(VOICE_RADIO_MRG, new VoiceRadioMrg(mContext, this));
			mCommandMap.put(VOICE_MISC_MRG, new VoiceMiscMrg(mContext, this));
			mCommandMap.put(VOICE_AC_MRG, new VoiceACMrg(mContext, this));
			mCommandMap.put(VOICE_AC_MRG, new VoiceCmdMrg(mContext, this));
			mCommandMap.put(VOICE_INFO_DETAIL_MRG, new VoiceInfoDetialMrg(mContext,
					this));
			mCommandMap.put(VOICE_NAVIGATION_MRG,
					new VoiceNavigationMrg(mContext, this));
			mCommandMap.put(VOICE_DEFAULT_MRG, new VoiceDefaultMrg(mContext, this));
		}
		if (audioManager == null) {
			audioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
		}
	}

	/* interface of ITtsClientListener */
	@Override
	public void onPlayBegin() {
		// TODO Auto-generated method stub
		Log.d(TAG, "onPlayBegin ======");
	}

	@Override
	public void onPlayCompleted() {
		// TODO Auto-generated method stub
		Log.d(TAG, "onPlayCompleted ======");
	}

	@Override
	public void onPlayInterrupted() {
		// TODO Auto-generated method stub
		Log.d(TAG, "onPlayInterrupted ======");
	}

	@Override
	public void onProgressReturn(int arg0, int arg1) {
		// TODO Auto-generated method stub
		Log.d(TAG, "onProgressReturn ======");
	}

	@Override
	public void onTtsInited(boolean arg0, int arg1) {
		// TODO Auto-generated method stub
		Log.d(TAG, "onTtsInited ======");
	}

	@Override
	public boolean generalNavigate(String arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		Log.d(TAG, "generalNavigate ======");
		return false;
	}

	@Override
	public String getLocation() {
		// TODO Auto-generated method stub
		Log.d(TAG, "getLocation ======");
		return null;
	}

	@Override
	public boolean navigate(String arg0, int arg1, String arg2) {
		// TODO Auto-generated method stub
		Log.d(TAG, "navigate ======");
		return false;
	}

	@Override
	public void onGetMapShareState(int arg0) {
		// TODO Auto-generated method stub
		Log.d(TAG, "onGetMapShareState ======");
	}

	// interface of NaviClientListener
	@Override
	public boolean searchPoi(String arg0, int arg1) {
		// TODO Auto-generated method stub
		Log.d(TAG, "searchPoi ======");
		return false;
	}

	@Override
	public boolean searchPoiAlongRoute(String arg0, int arg1) {
		// TODO Auto-generated method stub
		Log.d(TAG, "searchPoiAlongRoute ======");
		return false;
	}

	@Override
	public boolean searchPoiFavorite(int arg0, int arg1) {
		// TODO Auto-generated method stub
		Log.d(TAG, "searchPoiFavorite ======");
		return false;
	}

	@Override
	public boolean searchPoiNearby(String arg0, int arg1) {
		// TODO Auto-generated method stub
		Log.d(TAG, "searchPoiNearby ======");
		return false;
	}

	@Override
	public boolean setAvoidPlace(String arg0) {
		// TODO Auto-generated method stub
		Log.d(TAG, "setAvoidPlace ======");
		return false;
	}

	@Override
	public boolean setPassPlace(String arg0) {
		// TODO Auto-generated method stub
		Log.d(TAG, "setPassPlace ======");
		return false;
	}

	@Override
	public boolean settingOption(String arg0) {
		// TODO Auto-generated method stub
		Log.d(TAG, "settingOption ======");
		return false;
	}

	@Override
	public boolean shareByMap(String arg0) {
		// TODO Auto-generated method stub
		Log.d(TAG, "shareByMap ======");
		return false;
	}

	@Override
	public boolean showLocation() {
		// TODO Auto-generated method stub
		Log.d(TAG, "showLocation ======");
		return false;
	}

	@Override
	public boolean showOnMap(String arg0) {
		// TODO Auto-generated method stub
		Log.d(TAG, "showOnMap ======");
		return false;
	}

	@Override
	public boolean showTraffic(String arg0) {
		// TODO Auto-generated method stub
		Log.d(TAG, "showTraffic ======");
		return false;
	}

	@Override
	public int changePhoneState(int arg0) {
		// TODO Auto-generated method stub
		Log.d(TAG, "changePhoneState ======");
		return 0;
	}

	@Override
	public void onAbandonAudioFocus() {
		// TODO Auto-generated method stub
		Log.d(TAG, "onAbandonAudioFocus ======");
		audioManager.abandonAudioFocus(afChangeListener);
		sendAuidoCtrol(false);
	}

	@Override
	public String onGetCarNumbersInfo() {
		// TODO Auto-generated method stub
		Log.d(TAG, "onGetCarNumbersInfo ======");
		return null;
	}

	@Override
	public String onGetLocation() {
		// TODO Auto-generated method stub
		Log.d(TAG, "onGetLocation ======");
		String location = "{'name':'锟狡达拷讯锟斤拷锟斤拷息锟狡硷拷锟缴凤拷锟斤拷锟睫癸拷司','address':'锟斤拷山路616','city':'锟较凤拷锟斤拷','longitude':'117.143269','latitude':'31.834399'}";
		return location;
	}

	// interface of PlatformClientListener
	@Override
	public int onGetState(int arg0) {
		// TODO Auto-generated method stub
		Log.d(TAG, "onGetState ======");
		if (arg0 == PlatformCode.STATE_BLUETOOTH_PHONE) {
			return PlatformCode.STATE_OK;
		} else if (arg0 == PlatformCode.STATE_SENDSMS) {
			return PlatformCode.STATE_OK;
		} else {
			return PlatformCode.FAILED;
		}
	}

	@Override
	public int onGetVrViewType() {
		// TODO Auto-generated method stub
		Log.d(TAG, "onGetVrViewType ======");
		return 0;
	}

	@Override
	public void onManualInteractResult(String arg0, String arg1, String arg2) {
		// TODO Auto-generated method stub
		Log.d(TAG, "onManualInteractResult ======");
	}

	@Override
	public int onRequestAudioFocus(int arg0, int arg1) {
		// TODO Auto-generated method stub
		Log.d(TAG, "onRequestAudioFocus ======");
		int audioFocusResult = audioManager.requestAudioFocus(afChangeListener, arg0, arg1);
		if (audioFocusResult == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
			sendAuidoCtrol(true);
		}
		return audioFocusResult;
	}

	OnAudioFocusChangeListener afChangeListener = new OnAudioFocusChangeListener() {
		public void onAudioFocusChange(int focusChange) {
			AudioFocusChange(focusChange);
		}
	};

	private void sendAuidoCtrol(boolean isStart) {
		Intent intent = new Intent();
		if (isStart) {
			intent.setAction("com.iflytek.startoperation");
		} else {
			intent.setAction("com.iflytek.endoperation");
		}
		mContext.sendBroadcast(intent);
	}

	@Override
	public boolean onSearchPlayList(String arg0) {
		// TODO Auto-generated method stub
		Log.d(TAG, "onSearchPlayList ======" + arg0);
		try {
			JSONObject jsonObject = new JSONObject(arg0);
			if (mCommandMap.get(jsonObject.getString("focus")) != null) {
				String success = mCommandMap.get(jsonObject.getString("focus")).execute(arg0);
				return success.equals("true") ? true : false;
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void onServiceUnbind() {
		// TODO Auto-generated method stub
		Log.d(TAG, "onServiceUnbind ======");
	}

	@Override
	public String onDoAction(String arg0) {
		// TODO Auto-generated method stub
		Log.d(TAG, "onDoAction ======" + arg0);
		return mCommandMap.get(VOICE_ACTION_MRG).execute(arg0);
	}

	@Override
	public String onNLPResult(String arg0) {
		// TODO Auto-generated method stub
		Log.d(TAG, "onNLPResult ======" + arg0);
		try {
			JSONObject jsonObject = new JSONObject(arg0);
			if (mCommandMap.get(jsonObject.getString("focus")) != null) {
				return mCommandMap.get(jsonObject.getString("focus")).execute(arg0);
			} else {
				if ("app".equals(jsonObject.getString("focus"))
						|| "conControl".equals(jsonObject.getString("focus"))
						|| "vehicleInfo".equals(jsonObject.getString("focus"))) {
					return mCommandMap.get(VOICE_MISC_MRG).execute(arg0);
				}
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mCommandMap.get(VOICE_DEFAULT_MRG).buildResultStr(false, "no Json");
	}

	/* interface of ICustomMvwCallback */
	@Override
	public void initCallback(boolean arg0, int arg1) {
		// TODO Auto-generated method stub
		Log.d(TAG, "initCallback ======");
	}

	@Override
	public void initMvwCallback(boolean arg0, int arg1) {
		// TODO Auto-generated method stub
		Log.d(TAG, "initMvwCallback ======");
	}

	@Override
	public void onWakeupResult(int arg0, int arg1) {
		// TODO Auto-generated method stub
		Log.d(TAG, "onWakeupResult ======");
	}

	/* open call the interface of PlatformService.platformCallback */
	/**
	 * 主动通知音频焦点改变 若客户采用AudioFocus的机制，请在AudioFocus的音频焦点改变事件里面，调用此方法。
	 * 
	 * @param focusChange
	 */
	public void AudioFocusChange(int focusChange) {
		if (PlatformService.platformCallback == null) {
			Log.d(TAG, "PlatformService.platformCallback == null");
			return;
		}
		try {
			PlatformService.platformCallback.audioFocusChange(focusChange);
		} catch (RemoteException e) {
			Log.d(TAG, "platformCallback audioFocusChange error:" + e.getMessage());
		}
	}

	/**
	 * 系统返回语音助理请求的结果（音乐广播等）
	 * 
	 * @param type
	 * @param result
	 */
	public void onSearchPlayListResult(int type, java.lang.String result) {
		if (PlatformService.platformCallback == null) {
			Log.d(TAG, "PlatformService.platformCallback == null");
			return;
		}
		try {
			PlatformService.platformCallback.onSearchPlayListResult(type, result);
		} catch (RemoteException e) {
			Log.d(TAG, "platformCallback get music error:" + e.getMessage());
		}

	}

	/**
	 * 主动通知语音助理当前的电话状态
	 * 
	 * @param state
	 * @param inComingNumber
	 */
	public void phoneStateChange(int state, String inComingNumber) {
		if (PlatformService.platformCallback == null) {
			Log.d(TAG, "PlatformService.platformCallback == null");
			return;
		}
		JSONObject actionJson = new JSONObject();

		try {
			actionJson.put("state", state);
			actionJson.put("number", inComingNumber);
			PlatformService.platformCallback.phoneCallStateChange(actionJson.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 系统主动通知当前状态，告诉语音助理执行相应的动作
	 * 
	 * @param stateChange
	 */
	public void systemStateChange(int stateChange) {
		if (PlatformService.platformCallback == null) {
			Log.e(TAG, "PlatformService.platformCallback == null");
			return;
		}
		try {
			PlatformService.platformCallback.systemStateChange(stateChange);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 上传自定义的热词,给语音助理发送自定义数据，用于增强语音理解效果
	 * 
	 * @param dataType
	 * @param customData
	 */
	public void uploadCustomData(int dataType, java.lang.String[] customData) {
		if (PlatformService.platformCallback == null) {
			Log.e(TAG, "PlatformService.platformCallback == null");
			return;
		}
		try {
			PlatformService.platformCallback.uploadCustomData(dataType, customData);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
