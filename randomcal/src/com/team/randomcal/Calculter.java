package com.team.randomcal;

import java.util.*;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;


public class Calculter extends Activity{
	private TextView textView1;  //标题
	private TextView textView2;  //输入题目数
	private TextView yun1;     //运算数1
	private TextView yun2;     //运算数2
	private TextView symbol;     //运算符
	private TextView num;     //出题数
	
	private Button start;     //开始按钮
	private Button check;     //核对答案
	private Button next;     //下一道题
	private Button again;    //再来一次
	
	private EditText answer;   //答案  
	private EditText shumu;   //数目
	
	private int value1;
	private int value2;
	private int result;  //结果
	private int j=1;    //设置题目序号
	private int rightnum=0;  //判断正确的题目数
	private int errornum=0;  //判断错误的题目数
	
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.callayout);   //进入出题界面
		InitButton();    //初始化控件
		
		//开始按钮的点击事件监听
		start.setOnClickListener
		(
				new OnClickListener()
				{
					public void onClick(View v)
					{
						Toast toast;    //提醒
						//判断输入题目为空或零时
						if(shumu.getText().toString().equals("")==true||Integer.parseInt(shumu.getText().toString())==0)
						{
							toast=Toast.makeText(getApplicationContext(), "请输入题目数量", Toast.LENGTH_SHORT);
							toast.setGravity(Gravity.CENTER, 0, 0);  //Toast 居中显示
							toast.show();	
						}
						else 
						{
							dotitle();   //生成题目
						}
					}
				}
		);
		
		//检查按钮
		check.setOnClickListener
		(
				new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
						Toast toast;    //提醒
						//判断输入答案为空时
						if(answer.getEditableText().toString().equals("")==true)
						{
							toast=Toast.makeText(getApplicationContext(), "请输入答案", Toast.LENGTH_SHORT);
							toast.setGravity(Gravity.CENTER, 0, 0);  //Toast 居中显示
							toast.show();	
						}
						else
						{
							value1=Integer.parseInt(yun1.getText().toString());
							value2=Integer.parseInt(yun2.getText().toString());
							
							//加法判断
							if(symbol.getText().toString().equals("+")==true)
							{
								result=value1+value2;
								int number1=Integer.parseInt(answer.getText().toString());
								//答案判断
								if(result==number1)
								{
									toast=Toast.makeText(getApplicationContext(), "恭喜你答对了！", Toast.LENGTH_SHORT);
									toast.setGravity(Gravity.CENTER, 0, 0);  //Toast 居中显示
									toast.show();	
									rightnum++;
								}
								else
								{
									toast=Toast.makeText(getApplicationContext(), "抱歉你答错了！"+"\n"+"答案是"+result, Toast.LENGTH_SHORT);
									toast.setGravity(Gravity.CENTER, 0, 0);  //Toast 居中显示
									toast.show();	
									errornum++;
								}
							}
							//减法判断
							 if(symbol.getText().toString().equals("-")==true)
							{
								 result=value1-value2;
									int number1=Integer.parseInt(answer.getText().toString());
									//答案判断(为负数重新生成)
									if(result<0)
									{
										toast=Toast.makeText(getApplicationContext(), "答案为负请按下一题", Toast.LENGTH_SHORT);
										toast.setGravity(Gravity.CENTER, 0, 0);  //Toast 居中显示
										toast.show();	
										j--;
									}
									else
								{
									if(result==number1)
									{
										toast=Toast.makeText(getApplicationContext(), "恭喜你答对了！", Toast.LENGTH_SHORT);
										toast.setGravity(Gravity.CENTER, 0, 0);  //Toast 居中显示
										toast.show();	
										rightnum++;
									}
									else
									{
										toast=Toast.makeText(getApplicationContext(), "抱歉你答错了！"+"\n"+"答案是"+result, Toast.LENGTH_SHORT);
										toast.setGravity(Gravity.CENTER, 0, 0);  //Toast 居中显示
										toast.show();	
										errornum++;
									}
								}
							}
							 
							 //乘法判断
							//加法判断
								if(symbol.getText().toString().equals("*")==true)
								{
									result=value1*value2;
									int number1=Integer.parseInt(answer.getText().toString());
									//答案判断
									if(result==number1)
									{
										toast=Toast.makeText(getApplicationContext(), "恭喜你答对了！", Toast.LENGTH_SHORT);
										toast.setGravity(Gravity.CENTER, 0, 0);  //Toast 居中显示
										toast.show();	
										rightnum++;
									}
									else
									{
										toast=Toast.makeText(getApplicationContext(), "抱歉你答错了！"+"\n"+"答案是"+result, Toast.LENGTH_SHORT);
										toast.setGravity(Gravity.CENTER, 0, 0);  //Toast 居中显示
										toast.show();	
										errornum++;
									}
								}
							 //除法判断
								//加法判断
								if(symbol.getText().toString().equals("/")==true)
								{
									result=value1/value2;
									int number1=Integer.parseInt(answer.getText().toString());
									//答案判断
									if(result==number1)
									{
										toast=Toast.makeText(getApplicationContext(), "恭喜你答对了！", Toast.LENGTH_SHORT);
										toast.setGravity(Gravity.CENTER, 0, 0);  //Toast 居中显示
										toast.show();	
										rightnum++;
									}
									else
									{
										toast=Toast.makeText(getApplicationContext(), "抱歉你答错了！"+"\n"+"答案是"+result, Toast.LENGTH_SHORT);
										toast.setGravity(Gravity.CENTER, 0, 0);  //Toast 居中显示
										toast.show();	
										errornum++;
									}
								}
						}
					}
				
				}
				);
		
		//下一题点击事件监听
		next.setOnClickListener
		(
				new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
						 Toast toast;
						 //判断是否写出题目的答案
						 if(answer.getEditableText().toString().equals("")==true)
						 {
							 toast=Toast.makeText(getApplicationContext(), "请输入答案！", Toast.LENGTH_SHORT);
								toast.setGravity(Gravity.CENTER, 0, 0);  //Toast 居中显示
								toast.show();
						 }
						 else
						 {
							 if(j==Integer.parseInt(shumu.getText().toString()))
							 {
								 toast=Toast.makeText(getApplicationContext(), "您已经完成本次测试！"+"\n"+"你共答对"+rightnum+"题 答错"+errornum+"题", Toast.LENGTH_SHORT);
									toast.setGravity(Gravity.CENTER, 0, 0);  //Toast 居中显示
									toast.show();
							 }
							 else
							 {
								 yun1.setText("");
								 yun2.setText("");
								 symbol.setText("");
								 answer.setText("");  //清空答案
								 num.setText("");
								 j++;
								 dotitle();
								
							 }
						 }
					}
				}
		);
		
		//again按钮的事件监听
		again.setOnClickListener
		(
				new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Toast toast;
						
						toast=Toast.makeText(getApplicationContext(), "请开始你的答题！", Toast.LENGTH_SHORT);
						toast.setGravity(Gravity.CENTER, 0, 0);  //Toast 居中显示
						toast.show();
						//清空原有的值
						shumu.setText("");
						yun1.setText("");
						 yun2.setText("");
						 symbol.setText("");
						 answer.setText("");  //清空答案
						 num.setText("");
						 rightnum=0;
						 errornum=0;
						 j=1;
					}
				}
		);
	}
	
	//初始化控件
	public void InitButton()
	{
		//从布局中获取控件
		textView1=(TextView)findViewById(R.id.count_text1);
		textView2=(TextView)findViewById(R.id.count_text2);
		yun1=(TextView)findViewById(R.id.yun1);
		yun2=(TextView)findViewById(R.id.yun2);
		symbol=(TextView)findViewById(R.id.symbol);
		num=(TextView)findViewById(R.id.num);  //第几题
		
		shumu=(EditText)findViewById(R.id.shumu);
		answer=(EditText)findViewById(R.id.answer);
		
		start=(Button)findViewById(R.id.start);
		next=(Button)findViewById(R.id.next);
		check=(Button)findViewById(R.id.check);
		again=(Button)findViewById(R.id.again);
		}
	
	//增加按钮监听否则程序会意外退出
	public void buttonListener(Button button,final int id)
	{
		button.setOnClickListener
		(
				new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						yun1.setText("");
						yun2.setText("");
						symbol.setText("");
						num.setText("");
						answer.setText("");
					}
				}
				);
	}
	//出题函数
	public void dotitle()
	{
		String a="";
		String b="";
		
		int k=0,p=30;  //0-30
		//生成0-30的两个随机数
		a=String.valueOf((int)(Math.random()*p+k));
		b=String.valueOf((int)(Math.random()*p+k));
		String []op={"+","-","*","/"};
		Random r=new Random(); //默认当前系统时间的毫秒数作为种子数
		int d=r.nextInt(4);   //随机数的上限为4(不包括)
		
		//加入判断（除法除数为0 重新生成除数）
		while(b=="0")
		{
			b=String.valueOf((int)(Math.random()*p+k));
		}
		
		yun1.setText(a);
		yun2.setText(b);
		symbol.setText(op[d]);
		num.setText(String.valueOf(j));
	}
	
}

