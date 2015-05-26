package com.example.controlcarbyblueth;

import com.widget.hotspot.WifiMn;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class StartActivity extends Activity {
	Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_start);

	}

	// 跳转到蓝牙设置界面
	public void goBlu(View view) {
		intent = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
		startActivityForResult(intent, 1);
	}

	// 跳转到Wifi设置界面
	public void goWifi(View view) {
		intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
		
		startActivityForResult(intent, 2);
		
		
	}

	// 跳转到GPRS设置界面
	public void goGprs(View view) {
		intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
		startActivityForResult(intent, 3);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		if (requestCode == 1) {
			Intent intent = new Intent(StartActivity.this, Bluetooth.class);
			startActivity(intent);
		}

		if (requestCode == 2) {
			//Intent intent = new Intent(StartActivity.this, WifiActivity.class);
			Intent intent = new Intent(StartActivity.this, WifiActivity.class);
			System.out.println("运行了到了1");
			startActivity(intent);
			System.out.println("运行了到了2");
		}

		if (requestCode == 3) {
			Intent intent = new Intent(StartActivity.this, chatActivity.class);
			startActivity(intent);
		}
	}

}
