package com.chinatsp.tvoiceservice.client;

import com.iflytek.navi.NaviClientListener;

public class IFlyNaviClient implements NaviClientListener {
	private NaviClientListener mNaviClientListener;

	public void setNaviClientListener(NaviClientListener naviClientListener) {
		this.mNaviClientListener = naviClientListener;
	}

	@Override
	public boolean generalNavigate(String arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return mNaviClientListener.generalNavigate(arg0, arg1, arg2);
	}

	@Override
	public String getLocation() {
		// TODO Auto-generated method stub
		return mNaviClientListener.getLocation();
	}

	@Override
	public boolean navigate(String arg0, int arg1, String arg2) {
		// TODO Auto-generated method stub
		return mNaviClientListener.navigate(arg0, arg1, arg2);
	}

	@Override
	public void onGetMapShareState(int arg0) {
		// TODO Auto-generated method stub
		mNaviClientListener.onGetMapShareState(arg0);
	}

	@Override
	public boolean searchPoi(String arg0, int arg1) {
		// TODO Auto-generated method stub
		return mNaviClientListener.searchPoi(arg0, arg1);
	}

	@Override
	public boolean searchPoiAlongRoute(String arg0, int arg1) {
		// TODO Auto-generated method stub
		return mNaviClientListener.searchPoiAlongRoute(arg0, arg1);
	}

	@Override
	public boolean searchPoiFavorite(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return mNaviClientListener.searchPoiFavorite(arg0, arg1);
	}

	@Override
	public boolean searchPoiNearby(String arg0, int arg1) {
		// TODO Auto-generated method stub
		return mNaviClientListener.searchPoiNearby(arg0, arg1);
	}

	@Override
	public boolean setAvoidPlace(String arg0) {
		// TODO Auto-generated method stub
		return mNaviClientListener.setAvoidPlace(arg0);
	}

	@Override
	public boolean setPassPlace(String arg0) {
		// TODO Auto-generated method stub
		return mNaviClientListener.setPassPlace(arg0);
	}

	@Override
	public boolean settingOption(String arg0) {
		// TODO Auto-generated method stub
		return mNaviClientListener.settingOption(arg0);
	}

	@Override
	public boolean shareByMap(String arg0) {
		// TODO Auto-generated method stub
		return mNaviClientListener.shareByMap(arg0);
	}

	@Override
	public boolean showLocation() {
		// TODO Auto-generated method stub
		return mNaviClientListener.showLocation();
	}

	@Override
	public boolean showOnMap(String arg0) {
		// TODO Auto-generated method stub
		return mNaviClientListener.showOnMap(arg0);
	}

	@Override
	public boolean showTraffic(String arg0) {
		// TODO Auto-generated method stub
		return mNaviClientListener.showTraffic(arg0);
	}

}
