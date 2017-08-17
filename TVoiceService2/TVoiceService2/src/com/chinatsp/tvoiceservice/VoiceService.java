package com.chinatsp.tvoiceservice;

import java.util.Arrays;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;

import com.chinatsp.tvoiceservice.client.IFlyCustomMvwClient;
import com.chinatsp.tvoiceservice.client.IFlyNaviClient;
import com.chinatsp.tvoiceservice.client.IFlyPlatformAdapterClient;
import com.chinatsp.tvoiceservice.manager.IFlyVoiceController;
import com.iflytek.adapter.custommvwservice.CustomMvwSession;
import com.iflytek.adapter.ttsservice.TtsServiceAgent;
import com.iflytek.navigationservice.NavigationHelp;
import com.iflytek.platformservice.PlatformHelp;
import com.incall.proxy.binder.callback.IVoiceCallBackInterface;
import com.incall.proxy.binder.service.IVoiceClientInterface;
import com.incall.proxy.binder.service.IVoiceHostInterface;

//import android.os.ServiceManager;

public class VoiceService extends Service {
	private static final String TAG = "VoiceService";

	private VoiceHostServiceImpl mBinder;

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		Log.d(TAG, "======== onBind ======== ");
		initService();
		return mBinder;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		Log.d(TAG, "======== onStartCommand ======== ");
		super.onCreate();
		initService();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Log.d(TAG, "======== onStartCommand ======== ");
		initService();
		return START_STICKY;
	}

	private void initService() {
		if (null == mBinder) {
			synchronized (VoiceService.class) {
				if (mBinder == null) {
					try {
						mBinder = new VoiceHostServiceImpl();
						mBinder.setVoiceClient(new VoiceClientInterfaceImpl());
						// ServiceManager.addService(ServiceNameManager.SYSTEM_VOICE_SERVICENAME,
						// mBinder);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private class VoiceClientInterfaceImpl extends IVoiceClientInterface.Stub {
		private RemoteCallbackList<IVoiceCallBackInterface> mRemoteCallbackList = new RemoteCallbackList<IVoiceCallBackInterface>();
		private IFlyVoiceController flyVoiceController;
		private TtsServiceAgent mTtsServiceAgent;
		private CustomMvwSession mvwSession;

		VoiceClientInterfaceImpl() {
			Log.d(TAG, "======== VoiceServiceImpl ======== ");
			// 启动语音助理
			// try {
			// Intent intent = new Intent();
			// intent.setComponent(new
			// ComponentName("com.iflytek.cutefly.speechclient",
			// "com.iflytek.autofly.SpeechClientService"));
			// /* 外界启动的包名，必填 */
			// intent.putExtra("fromservice", "com.chinatsp.tvoiceservice");
			// startService(intent);
			// } catch (Exception e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			// 创建集成控制类
			flyVoiceController = new IFlyVoiceController(VoiceService.this, actionCallBack);

			// 初始化语音平台适配
			IFlyPlatformAdapterClient iFlyPlatformAdapterClient = (IFlyPlatformAdapterClient) PlatformHelp
					.getInstance().getPlatformClient();
			iFlyPlatformAdapterClient.setmFlyVoiceController(flyVoiceController);
			// 初始化语音导航
			// IFlyNaviClient flyNaviClient = (IFlyNaviClient)
			// NavigationHelp.getInstance()
			// .getNaviClient();
			// flyNaviClient.setNaviClientListener(flyVoiceController);
			// 初始化语音播报
			// IFlyTtsClient flyTtsClient = new IFlyTtsClient();
			// flyTtsClient.setmITtsClientListener(flyVoiceController);
			// mTtsServiceAgent = TtsServiceAgent.getInstance();
			// mTtsServiceAgent
			// .initService(flyTtsClient, VoiceService.this,
			// AudioManager.STREAM_MUSIC);
			// 初始化语音会话
			// IFlyCustomMvwClient mCustomMvwClient = new IFlyCustomMvwClient();
			// mCustomMvwClient.setCustomMvwCallback(flyVoiceController);
			// mvwSession =
			// CustomMvwSession.getInstance(getApplicationContext(),
			// mCustomMvwClient);
			// mvwSession.initService();
			// mvwSession.startBackgroundMvw(Arrays.asList("小安"), true);

		}

		@Override
		public int closeManualInteract(String arg0, String arg1, String arg2)
				throws RemoteException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getEngineType() throws RemoteException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void pauseOtherSpeak() throws RemoteException {
			// TODO Auto-generated method stub

		}

		@Override
		public void pauseSpeak() throws RemoteException {
			// TODO Auto-generated method stub

		}

		@Override
		public void registerCallBack(IVoiceCallBackInterface arg0) throws RemoteException {
			// TODO Auto-generated method stub
			mRemoteCallbackList.register(arg0);
		}

		@Override
		public void requestAudioFocus(boolean arg0) throws RemoteException {
			// TODO Auto-generated method stub

		}

		@Override
		public void resumeOtherSpeak() throws RemoteException {
			// TODO Auto-generated method stub

		}

		@Override
		public void resumeSpeak() throws RemoteException {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean sendElfData(int arg0, String arg1) throws RemoteException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public int sendManualInteract(String arg0, String arg1, String arg2, boolean arg3)
				throws RemoteException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void setXFMode(int arg0) throws RemoteException {
			// TODO Auto-generated method stub

		}

		@Override
		public void speak(String arg0) throws RemoteException {
			// TODO Auto-generated method stub

		}

		@Override
		public void speakOther(String arg0) throws RemoteException {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean startSpeechClient(int arg0, String arg1) throws RemoteException {
			// TODO Auto-generated method stub
			String ACTION_FOR_IFLY_GETRESULT = "com.iflytek.getresult";
			Intent initIntent = new Intent();
			initIntent.setComponent(new ComponentName("com.iflytek.cutefly.speechclient",
					"com.iflytek.autofly.SpeechClientService"));
			initIntent.setAction(ACTION_FOR_IFLY_GETRESULT);
			initIntent.putExtra("ID", arg1);
			initIntent.putExtra("fromservice", arg1);
			startService(initIntent);
			return false;
		}

		@Override
		public void stopOtherSpeak() throws RemoteException {
			// TODO Auto-generated method stub

		}

		@Override
		public void stopSpeak() throws RemoteException {
			// TODO Auto-generated method stub

		}

		@Override
		public void unRegisterCallBack(IVoiceCallBackInterface arg0) throws RemoteException {
			// TODO Auto-generated method stub
			mRemoteCallbackList.unregister(arg0);
		}

		@Override
		public void uploadMusicData(int arg0, String[] arg1) throws RemoteException {
			// TODO Auto-generated method stub

		}

		public void onServiceDestroy() {
			mTtsServiceAgent.releaseService();
		}

		private VoiceActionCallBack actionCallBack = new VoiceActionCallBack() {

			@Override
			public void onTtsPlayNotify(boolean aIsEnd) {
				// TODO Auto-generated method stub
				int len = mRemoteCallbackList.beginBroadcast();
				for (int i = 0; i < len; i++) {
					try {
						mRemoteCallbackList.getBroadcastItem(i).onTtsPlayNotify(aIsEnd);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
				mRemoteCallbackList.finishBroadcast();
			}

			@Override
			public void onTtsInterrupted() {
				// TODO Auto-generated method stub
				int len = mRemoteCallbackList.beginBroadcast();
				for (int i = 0; i < len; i++) {
					try {
						mRemoteCallbackList.getBroadcastItem(i).onTtsInterrupted();
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
				mRemoteCallbackList.finishBroadcast();
			}

			@Override
			public void onRepeatNotify(int aRepeat) {
				// TODO Auto-generated method stub
				int len = mRemoteCallbackList.beginBroadcast();
				for (int i = 0; i < len; i++) {
					try {
						mRemoteCallbackList.getBroadcastItem(i).onRepeatNotify(aRepeat);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
				mRemoteCallbackList.finishBroadcast();
			}

			@Override
			public void onRadioNotify(int aFrequency, int band, String name, int radioType,
					String aCountry, String aProvince, String aCity) {
				// TODO Auto-generated method stub
				int len = mRemoteCallbackList.beginBroadcast();
				for (int i = 0; i < len; i++) {
					try {
						mRemoteCallbackList.getBroadcastItem(i).onRadioNotify(aFrequency, band,
								name, radioType, aCountry, aProvince, aCity);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
				mRemoteCallbackList.finishBroadcast();
			}

			@Override
			public void onNLPResult(String actionJson) {
				// TODO Auto-generated method stub
				int len = mRemoteCallbackList.beginBroadcast();
				for (int i = 0; i < len; i++) {
					try {
						mRemoteCallbackList.getBroadcastItem(i).onNLPResult(actionJson);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
				mRemoteCallbackList.finishBroadcast();
			}

			@Override
			public void onMusicNotify(String id, String forworld, String title, String artist,
					String album, int source, int aGenre) {
				// TODO Auto-generated method stub
				int len = mRemoteCallbackList.beginBroadcast();
				for (int i = 0; i < len; i++) {
					try {
						mRemoteCallbackList.getBroadcastItem(i).onMusicNotify(id, forworld, title,
								artist, album, source, aGenre);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
				mRemoteCallbackList.finishBroadcast();
			}

			@Override
			public void onManualInteractResult(String requestCode, String resultType, String cmdId) {
				// TODO Auto-generated method stub
				int len = mRemoteCallbackList.beginBroadcast();
				for (int i = 0; i < len; i++) {
					try {
						mRemoteCallbackList.getBroadcastItem(i).onManualInteractResult(requestCode,
								resultType, cmdId);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
				mRemoteCallbackList.finishBroadcast();
			}

			@Override
			public void onDoAction(String actionJson) {
				// TODO Auto-generated method stub
				int len = mRemoteCallbackList.beginBroadcast();
				for (int i = 0; i < len; i++) {
					try {
						mRemoteCallbackList.getBroadcastItem(i).onDoAction(actionJson);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
				mRemoteCallbackList.finishBroadcast();
			}

			@Override
			public void onCtrlNotify(int aCtrl) {
				// TODO Auto-generated method stub
				int len = mRemoteCallbackList.beginBroadcast();
				for (int i = 0; i < len; i++) {
					try {
						mRemoteCallbackList.getBroadcastItem(i).onCtrlNotify(aCtrl);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
				mRemoteCallbackList.finishBroadcast();
			}

			@Override
			public void onBtPhoneViewMsgNotify(int operation, int msgType) {
				// TODO Auto-generated method stub
				int len = mRemoteCallbackList.beginBroadcast();
				for (int i = 0; i < len; i++) {
					try {
						mRemoteCallbackList.getBroadcastItem(i).onBtPhoneViewMsgNotify(operation,
								msgType);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
				mRemoteCallbackList.finishBroadcast();
			}

			@Override
			public void onBtPhoneMsgNotify(String number, String message) {
				// TODO Auto-generated method stub
				int len = mRemoteCallbackList.beginBroadcast();
				for (int i = 0; i < len; i++) {
					try {
						mRemoteCallbackList.getBroadcastItem(i).onBtPhoneMsgNotify(number, message);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
				mRemoteCallbackList.finishBroadcast();
			}

			@Override
			public void onBtPhoneCallNotify(String number) {
				// TODO Auto-generated method stub
				int len = mRemoteCallbackList.beginBroadcast();
				for (int i = 0; i < len; i++) {
					try {
						mRemoteCallbackList.getBroadcastItem(i).onBtPhoneCallNotify(number);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
				mRemoteCallbackList.finishBroadcast();
			}

			@Override
			public void onAirTemperatureNotify(int aOperate, int aTemperature) {
				// TODO Auto-generated method stub
				int len = mRemoteCallbackList.beginBroadcast();
				for (int i = 0; i < len; i++) {
					try {
						mRemoteCallbackList.getBroadcastItem(i).onAirTemperatureNotify(aOperate,
								aTemperature);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
				mRemoteCallbackList.finishBroadcast();
			}

			@Override
			public void onAirSpeedNotify(int aSpeed) {
				// TODO Auto-generated method stub
				int len = mRemoteCallbackList.beginBroadcast();
				for (int i = 0; i < len; i++) {
					try {
						mRemoteCallbackList.getBroadcastItem(i).onAirSpeedNotify(aSpeed);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
				mRemoteCallbackList.finishBroadcast();
			}

			@Override
			public void onAirPowerNotify(int aPower) {
				// TODO Auto-generated method stub
				int len = mRemoteCallbackList.beginBroadcast();
				for (int i = 0; i < len; i++) {
					try {
						mRemoteCallbackList.getBroadcastItem(i).onAirPowerNotify(aPower);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
				mRemoteCallbackList.finishBroadcast();
			}

			@Override
			public void onAirModeNotify(int aMode) {
				// TODO Auto-generated method stub
				int len = mRemoteCallbackList.beginBroadcast();
				for (int i = 0; i < len; i++) {
					try {
						mRemoteCallbackList.getBroadcastItem(i).onAirModeNotify(aMode);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
				mRemoteCallbackList.finishBroadcast();
			}

			@Override
			public void onAirDirectionNotify(int aDirection) {
				// TODO Auto-generated method stub
				int len = mRemoteCallbackList.beginBroadcast();
				for (int i = 0; i < len; i++) {
					try {
						mRemoteCallbackList.getBroadcastItem(i).onAirDirectionNotify(aDirection);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
				mRemoteCallbackList.finishBroadcast();
			}
		};

	}

	public interface VoiceActionCallBack {
		void onManualInteractResult(final String requestCode, final String resultType,
				final String cmdId);

		void onMusicNotify(final String id, final String forworld, final String title,
				final String artist, final String album, final int source, final int aGenre);

		void onCtrlNotify(final int aCtrl);

		void onRepeatNotify(final int aRepeat);

		void onBtPhoneCallNotify(final String number);

		void onBtPhoneMsgNotify(final String number, final String message);

		void onRadioNotify(final int aFrequency, final int band, final String name,
				final int radioType, final String aCountry, final String aProvince,
				final String aCity);

		void onBtPhoneViewMsgNotify(final int operation, final int msgType);

		void onAirPowerNotify(final int aPower);

		void onAirModeNotify(final int aMode);

		void onAirTemperatureNotify(final int aOperate, final int aTemperature);

		void onAirSpeedNotify(final int aSpeed);

		void onAirDirectionNotify(final int aDirection);

		void onTtsPlayNotify(final boolean aIsEnd);

		void onTtsInterrupted();

		void onNLPResult(final String actionJson);

		void onDoAction(final String actionJson);
	}

	private class VoiceHostServiceImpl extends IVoiceHostInterface.Stub {
		private IVoiceClientInterface mIVoiceClientInterface;

		@Override
		public IVoiceClientInterface getVoiceClient() throws RemoteException {
			// TODO Auto-generated method stub
			return mIVoiceClientInterface;
		}

		@Override
		public void setVoiceClient(IVoiceClientInterface arg0) throws RemoteException {
			// TODO Auto-generated method stub
			mIVoiceClientInterface = arg0;
		}

	}

}
