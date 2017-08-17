package com.chinatsp.tvoiceservice.manager;

import android.content.Context;

import com.chinatsp.tvoiceservice.VoiceService.VoiceActionCallBack;
import com.google.gson.Gson;
import com.incall.proxy.constant.VoiceConstantsDef;

/**
 * 数据类型包括:Radio
 * 
 * @author Administrator
 * 
 */
public class VoiceRadioMrg extends IVoiceMrgInterface {

	public VoiceRadioMrg(Context mContext, VoiceActionCallBack callBack) {
		super(mContext, callBack);
		// TODO Auto-generated constructor stub
	}

	@Override
	String execute(String jsonObj) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		RadioData radioData = gson.fromJson(jsonObj, RadioData.class);
		if (radioData == null) {
			buildResultStr(false, "json is null");
		}
		mActionCallBack.onRadioNotify(Integer.parseInt(radioData.getCode()),
				VoiceConstantsDef.RadioBand.FM.index, radioData.getName(),
				Integer.parseInt(radioData.getCategory()), "", radioData.getLocation(),
				radioData.getLocation());
		// do something
		return buildResultStr(true, "success");
	}

	public class RadioData {
		private String focus;
		private String rawText;
		private String name;
		private String waveband;
		private String code;
		private String category;
		private String location;

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

		public String getWaveband() {
			return waveband;
		}

		public void setWaveband(String waveband) {
			this.waveband = waveband;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

	}
}
