package com.sus.lee.qrcode;

import com.sus.lee.qr_scanner.R;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ScannerResultActivity extends QRCodeBaseActivity implements OnClickListener{
	
	private ImageView result_image;
	private TextView result_text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scanner_result);		
		result_text = (TextView)findViewById(R.id.scanner_result_text);
		try{
			if((Bitmap)getIntent().getExtras().getParcelable("image")!=null){
				result_image.setImageBitmap((Bitmap)getIntent().getExtras().getParcelable("image"));
			}
		}catch (Exception e) {
			// TODO: handle exception
		}	
		
		result_text.setText(getIntent().getExtras().getString("text"));
		
		findViewById(R.id.scanner_result_click_tel).setOnClickListener(this);
		findViewById(R.id.scanner_result_click_web).setOnClickListener(this);
		findViewById(R.id.scanner_result_click_search).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.scanner_result_click_tel:
			try{
				Intent intent_tel = new Intent(Intent.ACTION_DIAL, Uri.parse("tel://"+result_text.getText()));    
				startActivity(intent_tel);
			}catch(Exception e){
			    Toast.makeText(ScannerResultActivity.this, "Can not connect this phonenumber", Toast.LENGTH_LONG).show();
			}
			break;
		case R.id.scanner_result_click_web:
			try{
				Intent intent_web= new Intent();        
				intent_web.setAction("android.intent.action.VIEW");    
			    Uri content_url = Uri.parse(result_text.getText().toString());   
			    intent_web.setData(content_url);  
			    startActivity(intent_web);
		    }catch(Exception e){
		    	Toast.makeText(ScannerResultActivity.this, "Can not connect this site", Toast.LENGTH_LONG).show();
		    }
			break;
		case R.id.scanner_result_click_search:
			try{
				Intent intent_web= new Intent();        
				intent_web.setAction("android.intent.action.VIEW");    
				String url = "http://www.baidu.com/s?wd=" + Uri.encode(result_text.getText().toString());
			    Uri content_url = Uri.parse(url);   
			    intent_web.setData(content_url);  
			    startActivity(intent_web);
		    }catch(Exception e){
		    	Toast.makeText(ScannerResultActivity.this, "Can not find this server", Toast.LENGTH_LONG).show();
		    }
			break;

		default:
			break;
		}
	}
}
