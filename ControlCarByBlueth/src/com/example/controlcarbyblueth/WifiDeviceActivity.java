package com.example.controlcarbyblueth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class WifiDeviceActivity extends Activity {

	private List<String> mDatas = new ArrayList<String>(Arrays.asList("Hello",
			"World", "Welcome"));
	private WifiAdapter mAdapter;

	private WifiManager wifiManager;

	private List<ScanResult> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wifi_device);

		init();
	}

	public void init() {
		wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
		list = wifiManager.getScanResults();
		ListView listView = (ListView) findViewById(R.id.list_wifi);
		
		if (list == null) {
			Toast.makeText(this, "wifi鏈墦寮�紒", Toast.LENGTH_LONG).show();
		} else {
			openWifi();
			listView.setAdapter(new WifiAdapter(this, list));
		}
	}

	// 鎵撳紑wifi
	private void openWifi() {
		if (!wifiManager.isWifiEnabled()) {
			wifiManager.setWifiEnabled(true);
		}
	}

}
