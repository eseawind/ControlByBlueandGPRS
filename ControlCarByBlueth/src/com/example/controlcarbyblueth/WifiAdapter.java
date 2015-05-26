package com.example.controlcarbyblueth;

import java.util.List;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class WifiAdapter extends BaseAdapter {

	private LayoutInflater mInflater;
	private Context mContext;
	private List<ScanResult> list;

	public WifiAdapter(Context context, List<ScanResult> list) {
		mInflater = LayoutInflater.from(context);
		this.mContext = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = null;
		view = mInflater.inflate(R.layout.item, null);
		ScanResult scanResult = list.get(position);
		TextView textView = (TextView) view.findViewById(R.id.textView);
		textView.setText(scanResult.SSID);
		TextView signalStrenth = (TextView) view
				.findViewById(R.id.signal_strenth);
		signalStrenth.setText(String.valueOf(Math.abs(scanResult.level)));
		ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
		// 判断信号强度，显示对应的指示图标

		if (Math.abs(scanResult.level) > 100) {
			imageView.setBackgroundResource(R.drawable.one);
		} else if (Math.abs(scanResult.level) > 80) {
			imageView.setBackgroundResource(R.drawable.two);
		} else if (Math.abs(scanResult.level) > 70) {
			imageView.setBackgroundResource(R.drawable.three);
		} else if (Math.abs(scanResult.level) > 60) {
			imageView.setBackgroundResource(R.drawable.four);
		} else if (Math.abs(scanResult.level) > 50) {
			imageView.setBackgroundResource(R.drawable.five);
		} else {
			imageView.setBackgroundResource(R.drawable.six);
		}
		return view;

	}
}