package com.team.randomcal;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class homeactivity extends Activity {

	private Button startbtn,aboutbtn,exitbtn;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_footbar_layout);
		
		SysApplication.getInstance().addActivity(this); 
		InitButton();  //初始化按钮
		
		//开始游戏
		startbtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(homeactivity.this, selectActivity.class);
				startActivity(intent);
			}
		});
		
		//关于信息
		
		//退出游戏
		exitbtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				//退出整个应用程序
				SysApplication.getInstance().exit();
			}
		});
	}
	
	public void InitButton()
	{
		startbtn=(Button)findViewById(R.id.start_app);
		aboutbtn=(Button)findViewById(R.id.about_game);
		exitbtn=(Button)findViewById(R.id.exit_app);
		
	}
}
