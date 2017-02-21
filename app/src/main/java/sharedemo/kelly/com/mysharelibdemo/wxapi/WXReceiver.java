package sharedemo.kelly.com.mysharelibdemo.wxapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.idealsee.share.platform.WeixinShareApi;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

public class WXReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		final IWXAPI api = WXAPIFactory.createWXAPI(context, null);
		// 将该app注册到微信
		api.registerApp(WeixinShareApi.WEIXIN_APP_ID);
	}
}
