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

	//���尴ť
	private TextView counttext1,counttext2;
	private Button ResultBtn;
	private Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13;
	private int result=0;
	private String op_fen;
	private int sum_title = 0, true_title = 0, flase_title = 0;//�ж���Ŀ��ȷ��
	private String []op_fu={"+","-","x","��"};
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.countlayout);
		SysApplication.getInstance().addActivity(this); 
		InitButton();  //��ʼ����ť
		//ע�ᰴť����
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
		
		//��ô�����Ϣ
		Intent intent=getIntent();
		final String info=intent.getStringExtra("info");
		
		//����
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
		//����ж�
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
					//��ͼƬ��toast
					toast=Toast.makeText(countActivity.this, "��ϲ�����ˣ�", Toast.LENGTH_SHORT);
					toast.setGravity(Gravity.CENTER, 0, 0);// �м���ʾ
					LinearLayout toastLayout = (LinearLayout) toast.getView();
					ImageView imageView = new ImageView(getApplicationContext());
					imageView.setImageResource(R.drawable.xiao);
					toastLayout.addView(imageView, 0);// 0 ͼƬ�����ֵ��Ϸ�
					toast.show();
					
				}
				else
				{
					flase_title++;
					sum_title++;
					toast=Toast.makeText(countActivity.this, "����ˣ����ǣ�"+op_fen, Toast.LENGTH_SHORT);
					toast.setGravity(Gravity.CENTER, 0, 0);// �м���ʾ
					LinearLayout toastLayout = (LinearLayout) toast.getView();
					ImageView imageView = new ImageView(getApplicationContext());
					imageView.setImageResource(R.drawable.ku);
					toastLayout.addView(imageView, 0);// 0 ͼƬ�����ֵ��Ϸ�
					toast.show();
				}
				//���
				counttext2.setText(""); 
				//�ٴγ���
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
	//��Ӧ�˵��¼�
	public boolean onOptionsItemSelected(MenuItem item)
	{
		Toast toast;
		switch(item.getItemId())
		{
		
		case R.id.count_item1:
			toast=Toast.makeText(this, "���޿�����Ϣ", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);// �м���ʾ
			toast.show();
			break;
		case R.id.count_item2:
			toast=Toast.makeText(this, "�����"+true_title+"����,���"+flase_title+"����,��ȷ��"+Rate()+"%", Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);// �м���ʾ
			toast.show();
			break;
		default:
			toast=Toast.makeText(this, "�´��ٽ�����", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);// �м���ʾ
			toast.show();
			finish();    //�˳����λ��back��һ��
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	//������ȷ��
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
			counttext2.setText("");  //���
			break;
		case R.id.b11:
			counttext2.append(".");  
			break;
		case R.id.b12:
			counttext2.append("-");   //����
			break;
		case R.id.b13:
			counttext2.append("/");   //�ֺ�
			break;
			
		}
	}
	//��ʼ���ؼ�
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
	//����
	public void dotitle1()     //ֻ���Ӽ�
	{
		int num1=0;
		int num2=0;
		//String op_yun;    //������ʽ
		Random r=new Random(); //Ĭ�ϵ�ǰϵͳʱ��ĺ�������Ϊ������
		int sign=r.nextInt(4);   //���������������Ϊ4(������)
		
		num1=(int)(1+Math.random()*30);   //0-30�����
		num2=(int)(1+Math.random()*30);
		
		if(sign % 2 == 0){
			//�ӷ�
			counttext1.setText(num1+"+"+num2);
			result = num1+num2;
			op_fen=String.valueOf(result);
		}else{
			//����
			counttext1.setText(num1+"-"+num2);
			result = num1-num2;
			op_fen=String.valueOf(result);
		}
		
	}
	
	public void dotitle2()   //�Ӽ��˳�
	{
		int num1=0;
		int num2=0;
		//String op_yun;    //������ʽ
		num1=(int)(1+Math.random()*30);   //0-30�����
		num2=(int)(1+Math.random()*30);
		
		int g=0;   //��Լ��
		Random r=new Random(); //Ĭ�ϵ�ǰϵͳʱ��ĺ�������Ϊ������
		int sign=r.nextInt(4);   //���������������Ϊ4(������)
		if(sign == 0){
			//�ӷ�
			counttext1.setText(num1+"+"+num2);
			result = num1+num2;
			op_fen=String.valueOf(result);
			
		}else if(sign == 1){
			//����
			counttext1.setText(num1+"-"+num2);
			result = num1-num2;
			op_fen=String.valueOf(result);
		}
		else if(sign == 2){
			//�˷�
			counttext1.setText(num1+"x"+num2);
			result = num1*num2;
			op_fen=String.valueOf(result);
		}
		else{
			//����
			counttext1.setText(num1+"��"+num2);
			
			//������ ��Ϊ����
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

	public void dotitle3()   //�����Ӽ�ʵ��
	{
		int z_num1=0;    //��һ��������
		z_num1=(int)(1+Math.random()*30);   //0-30�����
		int m_num1=0;   //��һ������ĸ
		m_num1=(int)(1+Math.random()*30);   //0-30�����
		int z_num2=0;    //�ڶ���������
		z_num2=(int)(1+Math.random()*30);
		int m_num2=0;    //�ڶ�������ĸ
		m_num2=(int)(1+Math.random()*30);
		
		Random r=new Random(); //Ĭ�ϵ�ǰϵͳʱ��ĺ�������Ϊ������
		int sign=r.nextInt(4);   //���������������Ϊ4(������)
		int sum_z=0;
		int sum_m=0;
		int g=0;  //��Լ��
		if(sign == 0){  //�����ӷ�
			
			counttext1.setText(z_num1+"/"+m_num1+"+"+z_num2+"/"+m_num2);
			sum_z=z_num1*m_num2+z_num2*m_num1;  
			sum_m=m_num1*m_num2;
			//����ӷ�ĸ���Լ��
			g=div_cl(sum_z,sum_m);
			//����Ϊ��������
			fen_cl(sum_z,sum_m,g);
		}
		else if(sign == 1)   //����
		{
			counttext1.setText(z_num1+"/"+m_num1+"-"+z_num2+"/"+m_num2);
			
			sum_z=(z_num1*m_num2)-(z_num2*m_num1);
			while(sum_z<0)
			{
				//��������
				z_num1=(int)(1+Math.random()*30);   //0-30�����
				m_num1=(int)(1+Math.random()*30);   //0-30�����
				z_num2=(int)(1+Math.random()*30);
				m_num2=(int)(1+Math.random()*30);
				sum_z=(z_num1*m_num2)-(z_num2*m_num1);
			}
			sum_m=m_num1*m_num2;
			g=div_cl(sum_z, sum_m);
			fen_cl(sum_z, sum_m, g);
		}
		else if(sign == 2)  //�˷�
		{
			counttext1.setText(z_num1+"/"+m_num1+"x"+z_num2+"/"+m_num2);
			sum_z=z_num1*z_num2;
			sum_m=m_num2*m_num1;
			g=div_cl(sum_z, sum_m);
			fen_cl(sum_z, sum_m, g);
		}
		else   //����
		{
			counttext1.setText(z_num1+"/"+m_num1+"��"+z_num2+"/"+m_num2);
			
			sum_z=z_num1*m_num2;
			sum_m=z_num2*m_num1;
			g=div_cl(sum_z, sum_m);
			fen_cl(sum_z, sum_m, g);
		}
	}
	
	//��Լ��
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
	
	//������ʾ
	public void fen_cl(int a,int b,int g)
	{
		String s_z,s_m;
		if(g==1)
		{
			if(a!=b)
			{
				s_z=String.valueOf(a);
				s_m=String.valueOf(b);
				op_fen=s_z+"/"+s_m;   //���ʽ
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
				op_fen=s_z+"/"+s_m;   //���ʽ
			}
		}
		
	}
	
	public void  dotitle4()
	{
		//�������ŵļ���ʽ(������)
		int num1=0;
		int num2=0;
		int num3=0;
		int ch=0;  //���ѡ��
		
		//String op_yun;    //������ʽ
		num1=(int)(1+Math.random()*30);   //0-30�����
		num2=(int)(1+Math.random()*30);
		num3=(int)(1+Math.random()*30);
		int g=0;   //��Լ��
		Random r=new Random(); //Ĭ�ϵ�ǰϵͳʱ��ĺ�������Ϊ������
		int sign1=r.nextInt(4);   //���������������Ϊ4(������)	
		ch=r.nextInt(2);    //�ж��Ƿ�������
		int sign2=r.nextInt(4);
		if(ch==1)
		{
			counttext1.setText("("+num1+OP(sign1)+num2+")"+OP(sign2)+num3);
			if(OP(sign1)!="��")
			{
				if(OP(sign2)!="��")
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
				//������������������
				g=div_cl(num1,num2);
				yunsuan2(num1,num2,num3,1,sign2,g);
			}
		}
		else
		{
			counttext1.setText(num1+OP(sign1)+"("+num2+OP(sign2)+num3+")");
			
			if(OP(sign2)!="��")
			{
				if(OP(sign1)!="��")
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
				//������������������
				g=div_cl(num2,num3);
				yunsuan2(num1,1,num2,num3,sign1,g);
			}
		}
		
	}
		public String OP(int k)
		{
			return op_fu[k];
		}
		//����
		public void yunsuan2(int z_num1,int m_num1,int z_num2,int m_num2,int sign ,int g)
		{
			int sum_z=0;
			int sum_m=0;
			if(sign == 0){  //�����ӷ�
				sum_z=z_num1*m_num2+z_num2*m_num1;  
				sum_m=m_num1*m_num2;
				//����ӷ�ĸ���Լ��
				g=div_cl(sum_z,sum_m);
				//����Ϊ��������
				fen_cl(sum_z,sum_m,g);
			}
			else if(sign == 1)   //����
			{
				
				sum_z=(z_num1*m_num2)-(z_num2*m_num1);
				while(sum_z<0)
				{
					//��������
					z_num1=(int)(1+Math.random()*30);   //0-30�����
					m_num1=(int)(1+Math.random()*30);   //0-30�����
					z_num2=(int)(1+Math.random()*30);
					m_num2=(int)(1+Math.random()*30);
					sum_z=(z_num1*m_num2)-(z_num2*m_num1);
				}
				sum_m=m_num1*m_num2;
				g=div_cl(sum_z, sum_m);
				fen_cl(sum_z, sum_m, g);
			}
			else if(sign == 2)  //�˷�
			{
				sum_z=z_num1*z_num2;
				sum_m=m_num2*m_num1;
				g=div_cl(sum_z, sum_m);
				fen_cl(sum_z, sum_m, g);
			}
			else   //����
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
				//�ӷ�
				return num1+num2;
				
			}else if(sign == 1){
				//����
				return num1*num2;
			}
			else if(sign == 2){
				//�˷�
				return num1*num2;
			}
			else{
				//����
				if(num1%num2==0)
					return num1/num2;
				else
				{
					return 0xffff;
				}
			}
		}
}
