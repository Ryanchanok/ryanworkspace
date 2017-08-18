package com.chinatsp.tvoiceservice.manager;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.google.gson.Gson;
import com.incall.proxy.media.scan.CoagentMediaScanManager;

/**
 * 数据类型包括：音乐misic
 *
 * @author Administrator
 */
public class VoiceMusicMrg extends IVoiceMrgInterface {


    public VoiceMusicMrg(Context mContext, IFlyVoiceController flyVoicecontroller) {
        super(mContext, flyVoicecontroller);
    }

    @Override
    String execute(String jsonObj) {
        // TODO Auto-generated method stub
        Gson gson = new Gson();
        MusicData musicData = gson.fromJson(jsonObj, MusicData.class);
        if (musicData == null) {
            return buildResultStr(false, "未能搜索到结果");
        }
        Log.d(TAG, "Musicdata ===" + musicData.toString());
//        iFlyVoiceController.getVActionCallBack().onMusicNotify("", "", musicData.getSong(), musicData.getArtist(), musicData.getAlbum(), VoiceConstantsDef.MusicSource.AUX.ordinal(), VoiceConstantsDef.MusicGenre.CLASSICAL.ordinal());

        Cursor cursor = CoagentMediaScanManager.getMediaScanManager(mContext).getCursorByID3(musicData.getSong(), musicData.getArtist(), musicData.getAlbum());
        if (cursor == null) {
            Log.d(TAG, "cursor is null");
            return buildResultStr(false, "未能搜索到结果");
        }
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            String song = cursor.getString(cursor.getColumnIndex("title"));
            String artist = cursor.getString(cursor.getColumnIndex("artist"));
            String album = cursor.getString(cursor.getColumnIndex("album"));
//            this.duration = songListCursor.getLong(songListCursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
//            this.first_year = songListCursor.getInt(songListCursor.getColumnIndex(MediaStore.Audio.Media.YEAR));

            Log.d(TAG, "music size = " + cursor.getCount() + "===song ===" + song + "==artist ==" + artist + "==album==" + album);
        }


//        iFlyVoiceController.onSearchPlayListResult(0, formJsonForResult());
        return buildResultStr(true, "");
    }

    public String formJsonForResult() {
        String result = "{\"focus\":\"music\",\"status\":\"success\",\"result\":[{\"song\":\"忘情水\",\"artist\":\"刘德华\"},"
                + "{\"song\":\"恭喜发财\",\"artist\":\"刘德华\"},"
                + "{\"song\":\"billie jean\",\"artist\":\"迈克杰克逊\",\"category\":\"摇滚\"},"
                + "{\"song\":\"beat it\",\"artist\":\"迈克杰克逊\",\"category\":\"摇滚\"},"
                + "{\"song\":\"we are the world\",\"artist\":\"迈克杰克逊\",\"category\":\"摇滚\"},"
                + "{\"song\":\"beat it\",\"artist\":\"迈克杰克逊\",\"category\":\"摇滚\"},"
                + "{\"song\":\"双节棍\",\"artist\":\"周杰伦\",\"album\":\"Jay\"},"
                + "{\"song\":\"青花瓷\",\"artist\":\"周杰伦\"},"
                + "{\"song\":\"斗牛\",\"artist\":\"周杰伦\"},"
                + "{\"song\":\"七里香\",\"artist\":\"周杰伦\"}" + "]}";
        return result;
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

        @Override
        public String toString() {
            return "MusicData{" +
                    "focus='" + focus + '\'' +
                    ", rawText='" + rawText + '\'' +
                    ", song='" + song + '\'' +
                    ", artist='" + artist + '\'' +
                    ", category='" + category + '\'' +
                    ", operation='" + operation + '\'' +
                    ", album='" + album + '\'' +
                    ", source='" + source + '\'' +
                    '}';
        }
    }
}
