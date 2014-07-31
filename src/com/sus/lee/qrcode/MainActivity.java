package com.sus.lee.qrcode;


import com.sus.lee.qr_scanner.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	Button scanbtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		scanbtn = (Button)findViewById(R.id.scan_qr);
		scanbtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent openCameraIntent = new Intent(MainActivity.this,CaptureActivity.class);
				startActivity(openCameraIntent);
			}
		});
	}

}
