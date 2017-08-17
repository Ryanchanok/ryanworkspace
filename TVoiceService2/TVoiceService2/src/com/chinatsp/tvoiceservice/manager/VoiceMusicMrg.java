package com.chinatsp.tvoiceservice.manager;

import android.content.Context;

import com.chinatsp.tvoiceservice.VoiceService.VoiceActionCallBack;
import com.google.gson.Gson;
import com.incall.proxy.constant.VoiceConstantsDef;
/**
 * 数据类型包括：音乐misic
 * @author Administrator
 *
 */
public class VoiceMusicMrg extends IVoiceMrgInterface {

	public VoiceMusicMrg(Context mContext, VoiceActionCallBack callBack) {
		super(mContext, callBack);
		// TODO Auto-generated constructor stub
	}

	@Override
	String execute(String jsonObj) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		MusicData musicData = gson.fromJson(jsonObj, MusicData.class);
		if (musicData==null) {
			return buildResultStr(false, "json str is null");
		}
		mActionCallBack.onMusicNotify("", "", musicData.getSong(), musicData.getArtist(), musicData.getAlbum(), VoiceConstantsDef.MusicSource.AUX.ordinal(), VoiceConstantsDef.MusicGenre.CLASSICAL.ordinal());
		return buildResultStr(true, "json str is null");
	}

	public class MusicData {
		private String focus;
		private String rawText;
		private String song;
		private String artist;
		private String category;
		private String operation;
		private String album;
		private String source;
		
		public String getAlbum() {
			return album;
		}
		public void setAlbum(String album) {
			this.album = album;
		}
		public String getSource() {
			return source;
		}
		public void setSource(String source) {
			this.source = source;
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
		public String getSong() {
			return song;
		}
		public void setSong(String song) {
			this.song = song;
		}
		public String getArtist() {
			return artist;
		}
		public void setArtist(String artist) {
			this.artist = artist;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getOperation() {
			return operation;
		}
		public void setOperation(String operation) {
			this.operation = operation;
		}
		
	}
}
