package com.team.randomcal;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class countActivity extends Activity implements OnClickListener{

	//定义按钮
	private TextView counttext1,counttext2;
	private Button ResultBtn;
	private Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13;
	private int result=0;
	private String op_fen;
	private int sum_title = 0, true_title = 0, flase_title = 0;//判断题目正确数
	private String []op_fu={"+","-","x","÷"};
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.countlayout);
		SysApplication.getInstance().addActivity(this); 
		InitButton();  //初始化按钮
		//注册按钮监听
		b0.setOnClickListener(this);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		b5.setOnClickListener(this);
		b6.setOnClickListener(this);
		b7.setOnClickListener(this);
		b8.setOnClickListener(this);
		b9.setOnClickListener(this);
		b10.setOnClickListener(this);
		b11.setOnClickListener(this);
		b12.setOnClickListener(this);
		b13.setOnClickListener(this);
		
		//获得传递性息
		Intent intent=getIntent();
		final String info=intent.getStringExtra("info");
		
		//出题
		if(info.equals("easy"))
		{
			dotitle1();  
		}
		else if(info.equals("advance"))
		{
			dotitle2();  
		}
		else if(info.equals("raise"))
		{
			dotitle3(); 
		}
		else
		{
			dotitle4(); 
		}
		//结果判断
		ResultBtn.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub			
				Toast toast;
				if(op_fen .equals(counttext2.getText().toString()))
				{
					true_title++;
					sum_title++;
					//带图片的toast
					toast=Toast.makeText(countActivity.this, "恭喜你答对了！", Toast.LENGTH_SHORT);
					toast.setGravity(Gravity.CENTER, 0, 0);// 中间显示
					LinearLayout toastLayout = (LinearLayout) toast.getView();
					ImageView imageView = new ImageView(getApplicationContext());
					imageView.setImageResource(R.drawable.xiao);
					toastLayout.addView(imageView, 0);// 0 图片在文字的上方
					toast.show();
					
				}
				else
				{
					flase_title++;
					sum_title++;
					toast=Toast.makeText(countActivity.this, "答错了！答案是："+op_fen, Toast.LENGTH_SHORT);
					toast.setGravity(Gravity.CENTER, 0, 0);// 中间显示
					LinearLayout toastLayout = (LinearLayout) toast.getView();
					ImageView imageView = new ImageView(getApplicationContext());
					imageView.setImageResource(R.drawable.ku);
					toastLayout.addView(imageView, 0);// 0 图片在文字的上方
					toast.show();
				}
				//清空
				counttext2.setText(""); 
				//再次出题
				if(info.equals("easy"))
				{
					dotitle1();  
				}
				else if(info.equals("advance"))
				{
					dotitle2();  
				}
				else if(info.equals("raise"))
				{
					dotitle3(); 
				}
				else
				{
					Random r=new Random(); 
					int j=r.nextInt(2);   
					if(j==0)
					dotitle3(); 
					else
						dotitle4(); 
				}
			}
			
		}
				);
	}
	
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.count,menu);
		return true;
	}
	//响应菜单事件
	public boolean onOptionsItemSelected(MenuItem item)
	{
		Toast toast;
		switch(item.getItemId())
		{
		
		case R.id.count_item1:
			toast=Toast.makeText(this, "暂无可用信息", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);// 中间显示
			toast.show();
			break;
		case R.id.count_item2:
			toast=Toast.makeText(this, "您答对"+true_title+"道题,答错"+flase_title+"道题,正确率"+Rate()+"%", Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);// 中间显示
			toast.show();
			break;
		default:
			toast=Toast.makeText(this, "下次再接再厉", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);// 中间显示
			toast.show();
			finish();    //退出本次活动和back键一样
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	//计算正确率
	public double Rate()
	{
		return Math.round(((double)true_title/sum_title)*100);
	}
			
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) 
		{
		case R.id.b0:
			counttext2.append("0");
			break;
		case R.id.b1:
			counttext2.append("1");
			break;
		case R.id.b2:
			counttext2.append("2");
			break;
		case R.id.b3:
			counttext2.append("3");
			break;
		case R.id.b4:
			counttext2.append("4");
			break;
		case R.id.b5:
			counttext2.append("5");
			break;
		case R.id.b6:
			counttext2.append("6");
			break;
		case R.id.b7:
			counttext2.append("7");
			break;
		case R.id.b8:
			counttext2.append("8");
			break;
		case R.id.b9:
			counttext2.append("9");
			break;
		case R.id.b10:
			counttext2.setText("");  //清除
			break;
		case R.id.b11:
			counttext2.append(".");  
			break;
		case R.id.b12:
			counttext2.append("-");   //负号
			break;
		case R.id.b13:
			counttext2.append("/");   //分号
			break;
			
		}
	}
	//初始化控件
	public void InitButton()
	{
		counttext1=(TextView)findViewById(R.id.count_text1);
		counttext2=(TextView)findViewById(R.id.count_text2);
		ResultBtn=(Button)findViewById(R.id.b15);
		b0=(Button)findViewById(R.id.b0);
		b1=(Button)findViewById(R.id.b1);
		b2=(Button)findViewById(R.id.b2);
		b3=(Button)findViewById(R.id.b3);
		b4=(Button)findViewById(R.id.b4);
		b5=(Button)findViewById(R.id.b5);   //5
		b6=(Button)findViewById(R.id.b6);
		b7=(Button)findViewById(R.id.b7);
		b8=(Button)findViewById(R.id.b8);
		b9=(Button)findViewById(R.id.b9);
		b10=(Button)findViewById(R.id.b10);
		b11=(Button)findViewById(R.id.b11);
		b12=(Button)findViewById(R.id.b12);
		b13=(Button)findViewById(R.id.b13);
	}
	//出题
	public void dotitle1()     //只做加减
	{
		int num1=0;
		int num2=0;
		//String op_yun;    //保存表达式
		Random r=new Random(); //默认当前系统时间的毫秒数作为种子数
		int sign=r.nextInt(4);   //符号随机数的上限为4(不包括)
		
		num1=(int)(1+Math.random()*30);   //0-30随机数
		num2=(int)(1+Math.random()*30);
		
		if(sign % 2 == 0){
			//加法
			counttext1.setText(num1+"+"+num2);
			result = num1+num2;
			op_fen=String.valueOf(result);
		}else{
			//减法
			counttext1.setText(num1+"-"+num2);
			result = num1-num2;
			op_fen=String.valueOf(result);
		}
		
	}
	
	public void dotitle2()   //加减乘除
	{
		int num1=0;
		int num2=0;
		//String op_yun;    //保存表达式
		num1=(int)(1+Math.random()*30);   //0-30随机数
		num2=(int)(1+Math.random()*30);
		
		int g=0;   //公约数
		Random r=new Random(); //默认当前系统时间的毫秒数作为种子数
		int sign=r.nextInt(4);   //符号随机数的上限为4(不包括)
		if(sign == 0){
			//加法
			counttext1.setText(num1+"+"+num2);
			result = num1+num2;
			op_fen=String.valueOf(result);
			
		}else if(sign == 1){
			//减法
			counttext1.setText(num1+"-"+num2);
			result = num1-num2;
			op_fen=String.valueOf(result);
		}
		else if(sign == 2){
			//乘法
			counttext1.setText(num1+"x"+num2);
			result = num1*num2;
			op_fen=String.valueOf(result);
		}
		else{
			//除法
			counttext1.setText(num1+"÷"+num2);
			
			//除不尽 化为分数
			if((num1%num2)!=0)
			{
				g=div_cl(num1, num2);
				fen_cl(num1,num2,g);
			}
			else
			{
				result = num1/num2;
				op_fen=String.valueOf(result);
			}
		}
	}

	public void dotitle3()   //分数加减实现
	{
		int z_num1=0;    //第一个数分子
		z_num1=(int)(1+Math.random()*30);   //0-30随机数
		int m_num1=0;   //第一个数分母
		m_num1=(int)(1+Math.random()*30);   //0-30随机数
		int z_num2=0;    //第二个数分子
		z_num2=(int)(1+Math.random()*30);
		int m_num2=0;    //第二个数分母
		m_num2=(int)(1+Math.random()*30);
		
		Random r=new Random(); //默认当前系统时间的毫秒数作为种子数
		int sign=r.nextInt(4);   //符号随机数的上限为4(不包括)
		int sum_z=0;
		int sum_m=0;
		int g=0;  //公约数
		if(sign == 0){  //分数加法
			
			counttext1.setText(z_num1+"/"+m_num1+"+"+z_num2+"/"+m_num2);
			sum_z=z_num1*m_num2+z_num2*m_num1;  
			sum_m=m_num1*m_num2;
			//求分子分母最大公约数
			g=div_cl(sum_z,sum_m);
			//化简为最简真分数
			fen_cl(sum_z,sum_m,g);
		}
		else if(sign == 1)   //减法
		{
			counttext1.setText(z_num1+"/"+m_num1+"-"+z_num2+"/"+m_num2);
			
			sum_z=(z_num1*m_num2)-(z_num2*m_num1);
			while(sum_z<0)
			{
				//重新生成
				z_num1=(int)(1+Math.random()*30);   //0-30随机数
				m_num1=(int)(1+Math.random()*30);   //0-30随机数
				z_num2=(int)(1+Math.random()*30);
				m_num2=(int)(1+Math.random()*30);
				sum_z=(z_num1*m_num2)-(z_num2*m_num1);
			}
			sum_m=m_num1*m_num2;
			g=div_cl(sum_z, sum_m);
			fen_cl(sum_z, sum_m, g);
		}
		else if(sign == 2)  //乘法
		{
			counttext1.setText(z_num1+"/"+m_num1+"x"+z_num2+"/"+m_num2);
			sum_z=z_num1*z_num2;
			sum_m=m_num2*m_num1;
			g=div_cl(sum_z, sum_m);
			fen_cl(sum_z, sum_m, g);
		}
		else   //除法
		{
			counttext1.setText(z_num1+"/"+m_num1+"÷"+z_num2+"/"+m_num2);
			
			sum_z=z_num1*m_num2;
			sum_m=z_num2*m_num1;
			g=div_cl(sum_z, sum_m);
			fen_cl(sum_z, sum_m, g);
		}
	}
	
	//求公约数
	public int div_cl(int x,int y)
	{
		int t;
		while(y!=0)
		{
			t=x%y;
			x=y;
			y=t;
		}
		return x;
		
	}
	
	//分数表示
	public void fen_cl(int a,int b,int g)
	{
		String s_z,s_m;
		if(g==1)
		{
			if(a!=b)
			{
				s_z=String.valueOf(a);
				s_m=String.valueOf(b);
				op_fen=s_z+"/"+s_m;   //表达式
			}
			else
			{
				s_z=String.valueOf(1); 
				op_fen=s_z;
			}
		}
		else
		{
			int x=a/g;
			int y=b/g;
			if(y==1)
			{
				s_z=String.valueOf(x);
				op_fen=s_z;
			}
			else
			{
				s_z=String.valueOf(x);
				s_m=String.valueOf(y);
				op_fen=s_z+"/"+s_m;   //表达式
			}
		}
		
	}
	
	public void  dotitle4()
	{
		//产生括号的计算式(三个数)
		int num1=0;
		int num2=0;
		int num3=0;
		int ch=0;  //情况选择
		
		//String op_yun;    //保存表达式
		num1=(int)(1+Math.random()*30);   //0-30随机数
		num2=(int)(1+Math.random()*30);
		num3=(int)(1+Math.random()*30);
		int g=0;   //公约数
		Random r=new Random(); //默认当前系统时间的毫秒数作为种子数
		int sign1=r.nextInt(4);   //符号随机数的上限为4(不包括)	
		ch=r.nextInt(2);    //判断是否有括号
		int sign2=r.nextInt(4);
		if(ch==1)
		{
			counttext1.setText("("+num1+OP(sign1)+num2+")"+OP(sign2)+num3);
			if(OP(sign1)!="÷")
			{
				if(OP(sign2)!="÷")
				{
					result=yunsuan1((yunsuan1(num1,num2,sign1)),num3,sign2);
					op_fen=String.valueOf(result);
				}
				else
				{
					int x=yunsuan1(num1,num2,sign1);
					g=div_cl(x,num3);
					fen_cl(x,num3,g);
				}
			}
			else
			{
				//看成两个分数的运算
				g=div_cl(num1,num2);
				yunsuan2(num1,num2,num3,1,sign2,g);
			}
		}
		else
		{
			counttext1.setText(num1+OP(sign1)+"("+num2+OP(sign2)+num3+")");
			
			if(OP(sign2)!="÷")
			{
				if(OP(sign1)!="÷")
				{
					result=yunsuan1(num1,(yunsuan1(num2,num3,sign2)),sign1);
					op_fen=String.valueOf(result);
				}
				else
				{
					int x=yunsuan1(num2,num3,sign1);
					g=div_cl(num1,x);
					fen_cl(num1,x,g);
				}
			}
			else
			{
				//看成两个分数的运算
				g=div_cl(num2,num3);
				yunsuan2(num1,1,num2,num3,sign1,g);
			}
		}
		
	}
		public String OP(int k)
		{
			return op_fu[k];
		}
		//运算
		public void yunsuan2(int z_num1,int m_num1,int z_num2,int m_num2,int sign ,int g)
		{
			int sum_z=0;
			int sum_m=0;
			if(sign == 0){  //分数加法
				sum_z=z_num1*m_num2+z_num2*m_num1;  
				sum_m=m_num1*m_num2;
				//求分子分母最大公约数
				g=div_cl(sum_z,sum_m);
				//化简为最简真分数
				fen_cl(sum_z,sum_m,g);
			}
			else if(sign == 1)   //减法
			{
				
				sum_z=(z_num1*m_num2)-(z_num2*m_num1);
				while(sum_z<0)
				{
					//重新生成
					z_num1=(int)(1+Math.random()*30);   //0-30随机数
					m_num1=(int)(1+Math.random()*30);   //0-30随机数
					z_num2=(int)(1+Math.random()*30);
					m_num2=(int)(1+Math.random()*30);
					sum_z=(z_num1*m_num2)-(z_num2*m_num1);
				}
				sum_m=m_num1*m_num2;
				g=div_cl(sum_z, sum_m);
				fen_cl(sum_z, sum_m, g);
			}
			else if(sign == 2)  //乘法
			{
				sum_z=z_num1*z_num2;
				sum_m=m_num2*m_num1;
				g=div_cl(sum_z, sum_m);
				fen_cl(sum_z, sum_m, g);
			}
			else   //除法
			{
				sum_z=z_num1*m_num2;
				sum_m=z_num2*m_num1;
				g=div_cl(sum_z, sum_m);
				fen_cl(sum_z, sum_m, g);
			}
		}
		
		public int yunsuan1(int num1,int num2,int sign)
		{
			if(sign == 0){
				//加法
				return num1+num2;
				
			}else if(sign == 1){
				//减法
				return num1*num2;
			}
			else if(sign == 2){
				//乘法
				return num1*num2;
			}
			else{
				//除法
				if(num1%num2==0)
					return num1/num2;
				else
				{
					return 0xffff;
				}
			}
		}
}
