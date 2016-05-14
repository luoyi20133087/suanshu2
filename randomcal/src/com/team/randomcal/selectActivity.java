package com.team.randomcal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.*;
import android.widget.Button;

public class selectActivity extends Activity {

	private Button simplebtn,adbtn,rabtn,diffbtn;
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_layout);
		
		SysApplication.getInstance().addActivity(this); 
		InitButton();  //初始化按钮
		
		//入门按钮事件
		simplebtn.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//向下一个传递参数
				String data="easy";
				Intent intent=new Intent();
				intent.setClass(selectActivity.this, countActivity.class);
				intent.putExtra("info", data);
				startActivity(intent);
			}
		}
				);
		
		//进阶按钮
		adbtn.setOnClickListener(new OnClickListener()
				{
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						//向下一个传递参数
						String data="advance";
						Intent intent=new Intent();
						intent.setClass(selectActivity.this, countActivity.class);
						intent.putExtra("info", data);
						startActivity(intent);
					}
				}
						);
		
		//提升按钮
		rabtn.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//向下一个传递参数
				String data="raise";
				Intent intent=new Intent();
				intent.setClass(selectActivity.this, countActivity.class);
				intent.putExtra("info", data);
				startActivity(intent);
			}
		}
				);
		
		//困难按钮
		diffbtn.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//向下一个传递参数
				String data="difficult";
				Intent intent=new Intent();
				intent.setClass(selectActivity.this, countActivity.class);
				intent.putExtra("info", data);
				startActivity(intent);
			}
		}
				);
	}
	
	//初始化按钮
	public void InitButton()
	{
		simplebtn=(Button)findViewById(R.id.easy);
		adbtn=(Button)findViewById(R.id.advance);
		rabtn=(Button)findViewById(R.id.raise1);
		diffbtn=(Button)findViewById(R.id.different);
	}
}
