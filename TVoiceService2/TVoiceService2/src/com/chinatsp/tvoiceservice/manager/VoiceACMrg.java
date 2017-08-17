package com.chinatsp.tvoiceservice.manager;

import android.content.Context;

import com.chinatsp.tvoiceservice.R;
import com.chinatsp.tvoiceservice.VoiceService.VoiceActionCallBack;
import com.google.gson.Gson;
import com.incall.proxy.constant.VoiceConstantsDef;

/**
 * 数据类型包括：空调控制airControl
 * 
 * @author Administrator
 * 
 */
public class VoiceACMrg extends IVoiceMrgInterface {

	public VoiceACMrg(Context mContext, VoiceActionCallBack callBack) {
		super(mContext, callBack);
		// TODO Auto-generated constructor stub
	}

	@Override
	String execute(String jsonObj) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		AcControlData acControlData = gson.fromJson(jsonObj, AcControlData.class);
		if (acControlData == null) {
			buildResultStr(false, "json is null");
		}
		if (acControlData.getOperation().equals("OPEN")) {
			mActionCallBack.onAirPowerNotify(VoiceConstantsDef.AirPower.ON.index);
		} else if (acControlData.getOperation().equals("CLOSE")) {
			mActionCallBack.onAirPowerNotify(VoiceConstantsDef.AirPower.OFF.index);
		} else if (acControlData.getOperation().equals("SET")) {
			if ("制冷".equals(acControlData.getMode())) {
				mActionCallBack.onAirModeNotify(VoiceConstantsDef.AirMode.WIND_PEOPLE.index);
			} else if ("制热".equals(acControlData.getMode())) {
				mActionCallBack.onAirModeNotify(VoiceConstantsDef.AirMode.HEATING.index);
			} else {
				// do something
				if ("+".equals(acControlData.getFan_speed())) {
					mActionCallBack.onAirModeNotify(VoiceConstantsDef.AirMode.HEATING.index);
				} else if ("自动风".equals(acControlData.getFan_speed())) {
					mActionCallBack.onAirModeNotify(VoiceConstantsDef.AirMode.HEATING.index);
				} else {

				}
			}
		} else {
			buildResultStr(false, "can not parse the json");
		}
		return buildResultStr(true, "success");
	}

	public class AcControlData {
		private String focus;
		private String rawText;
		private String operation;
		private String device;
		private String mode;
		private String fan_speed;
		private String airflow_direction;
		private TemperatureBean temperature;

		public String getAirflow_direction() {
			return airflow_direction;
		}

		public void setAirflow_direction(String airflow_direction) {
			this.airflow_direction = airflow_direction;
		}

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

		public String getOperation() {
			return operation;
		}

		public void setOperation(String operation) {
			this.operation = operation;
		}

		public String getDevice() {
			return device;
		}

		public void setDevice(String device) {
			this.device = device;
		}

		public String getMode() {
			return mode;
		}

		public void setMode(String mode) {
			this.mode = mode;
		}

		public String getFan_speed() {
			return fan_speed;
		}

		public void setFan_speed(String fan_speed) {
			this.fan_speed = fan_speed;
		}

		public TemperatureBean getTemperature() {
			return temperature;
		}

		public void setTemperature(TemperatureBean temperature) {
			this.temperature = temperature;
		}

		public class TemperatureBean {
			/**
			 * direct : + type : SPOT offset : 10 ref : CUR
			 */

			private String direct;
			private String type;
			private String offset;
			private String ref;

			public String getDirect() {
				return direct;
			}

			public void setDirect(String direct) {
				this.direct = direct;
			}

			public String getType() {
				return type;
			}

			public void setType(String type) {
				this.type = type;
			}

			public String getOffset() {
				return offset;
			}

			public void setOffset(String offset) {
				this.offset = offset;
			}

			public String getRef() {
				return ref;
			}

			public void setRef(String ref) {
				this.ref = ref;
			}
		}

	}
}
