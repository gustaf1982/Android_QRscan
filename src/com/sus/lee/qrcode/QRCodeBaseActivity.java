package com.sus.lee.qrcode;

import com.sus.lee.qr_scanner.R;

import android.app.Activity;
import android.view.KeyEvent;
/**
 * 
 * @author wanghuan
 * Base Activity
 */
public class QRCodeBaseActivity extends Activity{

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if(event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_BACK){
			this.finish();
			overridePendingTransition(R.anim.exit_side_in, R.anim.exit_side_out);
		}
		return super.onKeyDown(keyCode, event);
	}
}
