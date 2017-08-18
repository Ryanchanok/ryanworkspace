package com.chinatsp.tvoiceservice.manager;

import android.content.Context;
import android.util.Log;

import com.chinatsp.tvoiceservice.VoiceService.VoiceActionCallBack;
import com.google.gson.Gson;

/**
 * 数据类型包括：执行操作Action
 * 
 * @author Administrator
 * 
 */
public class VoiceActionMrg extends IVoiceMrgInterface {
	private int currentMicType = -1;

	public VoiceActionMrg(Context mContext, IFlyVoiceController flyVoicecontroller) {
		super(mContext, flyVoicecontroller);
	}


	@Override
	String execute(String jsonObj) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		Action action = gson.fromJson(jsonObj, Action.class);
		if (action == null) {
			buildResultStr(false, "json is null");
		}
		if (action.getAction().equals("call")) {
			iFlyVoiceController.getVActionCallBack().onBtPhoneCallNotify(action.getParam1());
		} else if (action.getAction().equals("sendsms")) {
			iFlyVoiceController.getVActionCallBack().onBtPhoneMsgNotify(action.getParam1(), action.getParam2());
		} else if ("startwakerecord".equals(action.getAction())) {
			changeDinoseMode(1);
		} else if ("startspeechrecord".equals(action.getAction())) {
			changeDinoseMode(0);
		} else {
			return buildResultStr(false, "抱歉，不能为您处理");
		}
		return buildResultStr(true, "");
	}

	private void changeDinoseMode(int type) {
		// TODO Auto-generated method stub

//		com.iflytek.autofly.audioservice.util.AudioManager mAudioManager = com.iflytek.autofly.audioservice.util.AudioManager
//				.registerListener(mContext, null);
//		if (type == 0) {
//			if (currentMicType != 0) {
//				mAudioManager.setMicMode(AudioServiceCons.MicMode.NOISE_REDUCTION);
//			}
//			currentMicType = 0;
//
//		} else {
//			if (currentMicType != 1) {
//				mAudioManager.setMicMode(AudioServiceCons.MicMode.WAKEUP);
//			}
//			currentMicType = 1;
//
//		}
	}

	public class Action {
		private String action;
		private String param1;
		private String param2;

		public String getAction() {
			return action;
		}

		public void setAction(String action) {
			this.action = action;
		}

		public String getParam1() {
			return param1;
		}

		public void setParam1(String param1) {
			this.param1 = param1;
		}

		public String getParam2() {
			return param2;
		}

		public void setParam2(String param2) {
			this.param2 = param2;
		}

	}
}
