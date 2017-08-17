package com.chinatsp.tvoiceservice.manager;

import android.content.Context;

import com.chinatsp.tvoiceservice.VoiceService.VoiceActionCallBack;
import com.google.gson.Gson;

/**
 * 数据类型包括：命令词cmd,股票stock
 * @author Administrator
 *
 */
public class VoiceNavigationMrg extends IVoiceMrgInterface {

	public VoiceNavigationMrg(Context mContext, VoiceActionCallBack callBack) {
		super(mContext, callBack);
		// TODO Auto-generated constructor stub
	}

	@Override
	String execute(String jsonObj) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		CmdData cmdData = gson.fromJson(jsonObj, CmdData.class);
		if (cmdData == null) {
			buildResultStr(false, "json is null");
		}
		// do something
		if ("音量控制".equals(cmdData.category)) {

		} else if ("播放模式".equals(cmdData.category)) {

		} else if ("曲目控制".equals(cmdData.category)) {

		} else if ("屏幕控制".equals(cmdData.category)) {
 
		} else if ("收音机控制".equals(cmdData.category)) {

		} else {
			return buildResultStr(false, "json parse error");
		}
		return buildResultStr(true, "success");
	}

	public class CmdData {
		private String focus;
		private String rawText;
		private String name;
		private String category;
		private String code;

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

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}
		
	}
}
