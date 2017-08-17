package com.chinatsp.tvoiceservice.manager;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.text.TextUtils;

import com.chinatsp.tvoiceservice.VoiceService.VoiceActionCallBack;

public abstract class IVoiceMrgInterface {
	protected Context mContext;
	protected VoiceActionCallBack mActionCallBack;

	public IVoiceMrgInterface(Context mContext, VoiceActionCallBack callBack) {
		super();
		this.mContext = mContext;
		mActionCallBack = callBack;
	}

	abstract String execute(String jsonObj);

	/**
	 * 创建讯飞语音json信息返回
	 * 
	 * @param success
	 * @param msg
	 * @return
	 */
	public String buildResultStr(boolean success, String msg) {
		JSONObject resultJson = new JSONObject();
		String status = success ? "success" : "fail";
		try {
			resultJson.put("status", status);
			if (!TextUtils.isEmpty(msg)) {
				resultJson.put("message", msg);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultJson.toString();
	}

	/**
	 * 当execute时发生异常通知上层UI
	 */
	protected void onError() {

	}

	/**
	 * 当execute时未支持此功能并通知上层UI
	 */
	protected void onNotSupport() {

	}
}
