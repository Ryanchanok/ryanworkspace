package com.chinatsp.tvoiceservice.manager;

import android.content.Context;

import com.chinatsp.tvoiceservice.VoiceService.VoiceActionCallBack;
import com.google.gson.Gson;

/*
 * 可操作数据类型包括：应用app,车身控制conControl,车辆信息vehicleInfo
 */
public class VoiceMiscMrg extends IVoiceMrgInterface {

	public VoiceMiscMrg(Context mContext, IFlyVoiceController callBack) {
		super(mContext, callBack);
		// TODO Auto-generated constructor stub
	}

	@Override
	String execute(String jsonObj) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		MiscData miscData = gson.fromJson(jsonObj, MiscData.class);
		if (miscData == null) {
			return buildResultStr(false, "json is null");
		}
		// do something
		if ("app".equals(miscData.getFocus())) {

		} else if ("carControl".equals(miscData.getFocus())) {

		} else if ("vehicleInfo".equals(miscData.getFocus())) {

		} else {
			return buildResultStr(false, "json parse error");
		}
		return buildResultStr(true, "");
	}

	public class MiscData {
		private String focus;
		private String rawText;
		private String name;
		private String operation;

		public String getFocus() {
			return focus;
		}

		public void setFocus(String focus) {
			this.focus = focus;
		}

		public String getRawText() {
			return rawText;
		}

		public void setRawText(String rawText) {
			this.rawText = rawText;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getOperation() {
			return operation;
		}

		public void setOperation(String operation) {
			this.operation = operation;
		}

	}
}
