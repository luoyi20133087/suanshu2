package com.team.randomcal;



import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//去掉标题栏
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//全屏
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		       WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		WebView runWebView=null;
		runWebView = (WebView) findViewById(R.id.runWebView);
		runWebView.loadDataWithBaseURL(null,"<HTML><body bgcolor='#f3f3f3'><div align=center><IMG src='file:///android_asset/+-.gif'/></div></body></html>", "text/html", "UTF-8",null);
		
		SysApplication.getInstance().addActivity(this); 
		//延时换屏
		final Intent intent=new Intent();
		Timer timer=new Timer();
		TimerTask task = new TimerTask() {
			   @Override
			   public void run() {
			  intent.setClass(MainActivity.this, homeactivity.class);
				startActivity(intent);
			   }
			  };
			  timer.schedule(task, 7000);   //延时7秒
	}

	
	

      
	

}
