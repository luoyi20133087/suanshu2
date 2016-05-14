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
		InitButton();  //��ʼ����ť
		
		//���Ű�ť�¼�
		simplebtn.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//����һ�����ݲ���
				String data="easy";
				Intent intent=new Intent();
				intent.setClass(selectActivity.this, countActivity.class);
				intent.putExtra("info", data);
				startActivity(intent);
			}
		}
				);
		
		//���װ�ť
		adbtn.setOnClickListener(new OnClickListener()
				{
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						//����һ�����ݲ���
						String data="advance";
						Intent intent=new Intent();
						intent.setClass(selectActivity.this, countActivity.class);
						intent.putExtra("info", data);
						startActivity(intent);
					}
				}
						);
		
		//������ť
		rabtn.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//����һ�����ݲ���
				String data="raise";
				Intent intent=new Intent();
				intent.setClass(selectActivity.this, countActivity.class);
				intent.putExtra("info", data);
				startActivity(intent);
			}
		}
				);
		
		//���Ѱ�ť
		diffbtn.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//����һ�����ݲ���
				String data="difficult";
				Intent intent=new Intent();
				intent.setClass(selectActivity.this, countActivity.class);
				intent.putExtra("info", data);
				startActivity(intent);
			}
		}
				);
	}
	
	//��ʼ����ť
	public void InitButton()
	{
		simplebtn=(Button)findViewById(R.id.easy);
		adbtn=(Button)findViewById(R.id.advance);
		rabtn=(Button)findViewById(R.id.raise1);
		diffbtn=(Button)findViewById(R.id.different);
	}
}
