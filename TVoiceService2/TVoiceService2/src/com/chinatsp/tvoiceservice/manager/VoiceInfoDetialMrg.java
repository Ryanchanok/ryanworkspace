package com.chinatsp.tvoiceservice.manager;

import android.content.Context;

import com.chinatsp.tvoiceservice.VoiceService.VoiceActionCallBack;
import com.google.gson.Gson;

/*
 * 可操作数据类型包括：天气weather,机票查询flight，火车票查询train，新闻news,空气质量pm25
 */
public class VoiceInfoDetialMrg extends IVoiceMrgInterface {

	public VoiceInfoDetialMrg(Context mContext, VoiceActionCallBack callBack) {
		super(mContext, callBack);
		// TODO Auto-generated constructor stub
	}

	@Override
	String execute(String jsonObj) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		InfoDetialData infoDetialData = gson.fromJson(jsonObj, InfoDetialData.class);
		if (infoDetialData == null) {
			buildResultStr(false, "json is null");
		}
		// do something
		if ("weather".equals(infoDetialData.getFocus())) {

		} else if ("flight".equals(infoDetialData.getFocus())) {

		} else if ("train".equals(infoDetialData.getFocus())) {

		} else if ("news".equals(infoDetialData.getFocus())) {

		} else if ("pm25".equals(infoDetialData.getFocus())) {

		}else {
			return buildResultStr(false, "json parse error");
		}
		return buildResultStr(true, "success");
	}

	public class InfoDetialData {
		private String focus;
		private String rawText;
		private String category;
		private String code;
		private LocationBean location;
		private String operation;
		private DatetimeBean datetime;
		private StartLocBean startLoc;
		private EndLocBean endLoc;
		private StartDateBean startDate;

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

		public LocationBean getLocation() {
			return location;
		}

		public void setLocation(LocationBean location) {
			this.location = location;
		}

		public String getOperation() {
			return operation;
		}

		public void setOperation(String operation) {
			this.operation = operation;
		}

		public DatetimeBean getDatetime() {
			return datetime;
		}

		public void setDatetime(DatetimeBean datetime) {
			this.datetime = datetime;
		}

		public StartLocBean getStartLoc() {
			return startLoc;
		}

		public void setStartLoc(StartLocBean startLoc) {
			this.startLoc = startLoc;
		}

		public EndLocBean getEndLoc() {
			return endLoc;
		}

		public void setEndLoc(EndLocBean endLoc) {
			this.endLoc = endLoc;
		}

		public StartDateBean getStartDate() {
			return startDate;
		}

		public void setStartDate(StartDateBean startDate) {
			this.startDate = startDate;
		}

		public class LocationBean {
			/**
			 * cityAddr : 合 肥 city : 合 肥 市 type : LOC_BASIC
			 */

			private String cityAddr;
			private String city;
			private String type;

			public String getCityAddr() {
				return cityAddr;
			}

			public void setCityAddr(String cityAddr) {
				this.cityAddr = cityAddr;
			}

			public String getCity() {
				return city;
			}

			public void setCity(String city) {
				this.city = city;
			}

			public String getType() {
				return type;
			}

			public void setType(String type) {
				this.type = type;
			}
		}

		public class DatetimeBean {
			/**
			 * date : 2016-04-05 type : DT_BASIC dateOrig : 今天
			 */

			private String date;
			private String type;
			private String dateOrig;

			public String getDate() {
				return date;
			}

			public void setDate(String date) {
				this.date = date;
			}

			public String getType() {
				return type;
			}

			public void setType(String type) {
				this.type = type;
			}

			public String getDateOrig() {
				return dateOrig;
			}

			public void setDateOrig(String dateOrig) {
				this.dateOrig = dateOrig;
			}
		}

		public class StartLocBean {
			/**
			 * cityAddr : 合 肥 city : 合 肥 市 type : LOC_BASIC
			 */

			private String cityAddr;
			private String city;
			private String type;

			public String getCityAddr() {
				return cityAddr;
			}

			public void setCityAddr(String cityAddr) {
				this.cityAddr = cityAddr;
			}

			public String getCity() {
				return city;
			}

			public void setCity(String city) {
				this.city = city;
			}

			public String getType() {
				return type;
			}

			public void setType(String type) {
				this.type = type;
			}
		}

		public class EndLocBean {
			/**
			 * cityAddr : 上 海 city : 上海市 type : LOC_BASIC
			 */

			private String cityAddr;
			private String city;
			private String type;

			public String getCityAddr() {
				return cityAddr;
			}

			public void setCityAddr(String cityAddr) {
				this.cityAddr = cityAddr;
			}

			public String getCity() {
				return city;
			}

			public void setCity(String city) {
				this.city = city;
			}

			public String getType() {
				return type;
			}

			public void setType(String type) {
				this.type = type;
			}
		}

		public class StartDateBean {
			/**
			 * timeOrig : 下 午 dateOrig : 明 天 time : 12:00:00 date : 2014-09-03
			 * endDate : 2014-09-03 endTime : 18:00:00 type : DT_INTERVAL
			 */

			private String timeOrig;
			private String dateOrig;
			private String time;
			private String date;
			private String endDate;
			private String endTime;
			private String type;

			public String getTimeOrig() {
				return timeOrig;
			}

			public void setTimeOrig(String timeOrig) {
				this.timeOrig = timeOrig;
			}

			public String getDateOrig() {
				return dateOrig;
			}

			public void setDateOrig(String dateOrig) {
				this.dateOrig = dateOrig;
			}

			public String getTime() {
				return time;
			}

			public void setTime(String time) {
				this.time = time;
			}

			public String getDate() {
				return date;
			}

			public void setDate(String date) {
				this.date = date;
			}

			public String getEndDate() {
				return endDate;
			}

			public void setEndDate(String endDate) {
				this.endDate = endDate;
			}

			public String getEndTime() {
				return endTime;
			}

			public void setEndTime(String endTime) {
				this.endTime = endTime;
			}

			public String getType() {
				return type;
			}

			public void setType(String type) {
				this.type = type;
			}
		}
	}
}
