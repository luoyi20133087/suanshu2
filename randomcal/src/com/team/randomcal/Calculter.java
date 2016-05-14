package com.team.randomcal;

import java.util.*;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;


public class Calculter extends Activity{
	private TextView textView1;  //����
	private TextView textView2;  //������Ŀ��
	private TextView yun1;     //������1
	private TextView yun2;     //������2
	private TextView symbol;     //�����
	private TextView num;     //������
	
	private Button start;     //��ʼ��ť
	private Button check;     //�˶Դ�
	private Button next;     //��һ����
	private Button again;    //����һ��
	
	private EditText answer;   //��  
	private EditText shumu;   //��Ŀ
	
	private int value1;
	private int value2;
	private int result;  //���
	private int j=1;    //������Ŀ���
	private int rightnum=0;  //�ж���ȷ����Ŀ��
	private int errornum=0;  //�жϴ������Ŀ��
	
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.callayout);   //����������
		InitButton();    //��ʼ���ؼ�
		
		//��ʼ��ť�ĵ���¼�����
		start.setOnClickListener
		(
				new OnClickListener()
				{
					public void onClick(View v)
					{
						Toast toast;    //����
						//�ж�������ĿΪ�ջ���ʱ
						if(shumu.getText().toString().equals("")==true||Integer.parseInt(shumu.getText().toString())==0)
						{
							toast=Toast.makeText(getApplicationContext(), "��������Ŀ����", Toast.LENGTH_SHORT);
							toast.setGravity(Gravity.CENTER, 0, 0);  //Toast ������ʾ
							toast.show();	
						}
						else 
						{
							dotitle();   //������Ŀ
						}
					}
				}
		);
		
		//��鰴ť
		check.setOnClickListener
		(
				new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
						Toast toast;    //����
						//�ж������Ϊ��ʱ
						if(answer.getEditableText().toString().equals("")==true)
						{
							toast=Toast.makeText(getApplicationContext(), "�������", Toast.LENGTH_SHORT);
							toast.setGravity(Gravity.CENTER, 0, 0);  //Toast ������ʾ
							toast.show();	
						}
						else
						{
							value1=Integer.parseInt(yun1.getText().toString());
							value2=Integer.parseInt(yun2.getText().toString());
							
							//�ӷ��ж�
							if(symbol.getText().toString().equals("+")==true)
							{
								result=value1+value2;
								int number1=Integer.parseInt(answer.getText().toString());
								//���ж�
								if(result==number1)
								{
									toast=Toast.makeText(getApplicationContext(), "��ϲ�����ˣ�", Toast.LENGTH_SHORT);
									toast.setGravity(Gravity.CENTER, 0, 0);  //Toast ������ʾ
									toast.show();	
									rightnum++;
								}
								else
								{
									toast=Toast.makeText(getApplicationContext(), "��Ǹ�����ˣ�"+"\n"+"����"+result, Toast.LENGTH_SHORT);
									toast.setGravity(Gravity.CENTER, 0, 0);  //Toast ������ʾ
									toast.show();	
									errornum++;
								}
							}
							//�����ж�
							 if(symbol.getText().toString().equals("-")==true)
							{
								 result=value1-value2;
									int number1=Integer.parseInt(answer.getText().toString());
									//���ж�(Ϊ������������)
									if(result<0)
									{
										toast=Toast.makeText(getApplicationContext(), "��Ϊ���밴��һ��", Toast.LENGTH_SHORT);
										toast.setGravity(Gravity.CENTER, 0, 0);  //Toast ������ʾ
										toast.show();	
										j--;
									}
									else
								{
									if(result==number1)
									{
										toast=Toast.makeText(getApplicationContext(), "��ϲ�����ˣ�", Toast.LENGTH_SHORT);
										toast.setGravity(Gravity.CENTER, 0, 0);  //Toast ������ʾ
										toast.show();	
										rightnum++;
									}
									else
									{
										toast=Toast.makeText(getApplicationContext(), "��Ǹ�����ˣ�"+"\n"+"����"+result, Toast.LENGTH_SHORT);
										toast.setGravity(Gravity.CENTER, 0, 0);  //Toast ������ʾ
										toast.show();	
										errornum++;
									}
								}
							}
							 
							 //�˷��ж�
							//�ӷ��ж�
								if(symbol.getText().toString().equals("*")==true)
								{
									result=value1*value2;
									int number1=Integer.parseInt(answer.getText().toString());
									//���ж�
									if(result==number1)
									{
										toast=Toast.makeText(getApplicationContext(), "��ϲ�����ˣ�", Toast.LENGTH_SHORT);
										toast.setGravity(Gravity.CENTER, 0, 0);  //Toast ������ʾ
										toast.show();	
										rightnum++;
									}
									else
									{
										toast=Toast.makeText(getApplicationContext(), "��Ǹ�����ˣ�"+"\n"+"����"+result, Toast.LENGTH_SHORT);
										toast.setGravity(Gravity.CENTER, 0, 0);  //Toast ������ʾ
										toast.show();	
										errornum++;
									}
								}
							 //�����ж�
								//�ӷ��ж�
								if(symbol.getText().toString().equals("/")==true)
								{
									result=value1/value2;
									int number1=Integer.parseInt(answer.getText().toString());
									//���ж�
									if(result==number1)
									{
										toast=Toast.makeText(getApplicationContext(), "��ϲ�����ˣ�", Toast.LENGTH_SHORT);
										toast.setGravity(Gravity.CENTER, 0, 0);  //Toast ������ʾ
										toast.show();	
										rightnum++;
									}
									else
									{
										toast=Toast.makeText(getApplicationContext(), "��Ǹ�����ˣ�"+"\n"+"����"+result, Toast.LENGTH_SHORT);
										toast.setGravity(Gravity.CENTER, 0, 0);  //Toast ������ʾ
										toast.show();	
										errornum++;
									}
								}
						}
					}
				
				}
				);
		
		//��һ�����¼�����
		next.setOnClickListener
		(
				new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
						 Toast toast;
						 //�ж��Ƿ�д����Ŀ�Ĵ�
						 if(answer.getEditableText().toString().equals("")==true)
						 {
							 toast=Toast.makeText(getApplicationContext(), "������𰸣�", Toast.LENGTH_SHORT);
								toast.setGravity(Gravity.CENTER, 0, 0);  //Toast ������ʾ
								toast.show();
						 }
						 else
						 {
							 if(j==Integer.parseInt(shumu.getText().toString()))
							 {
								 toast=Toast.makeText(getApplicationContext(), "���Ѿ���ɱ��β��ԣ�"+"\n"+"�㹲���"+rightnum+"�� ���"+errornum+"��", Toast.LENGTH_SHORT);
									toast.setGravity(Gravity.CENTER, 0, 0);  //Toast ������ʾ
									toast.show();
							 }
							 else
							 {
								 yun1.setText("");
								 yun2.setText("");
								 symbol.setText("");
								 answer.setText("");  //��մ�
								 num.setText("");
								 j++;
								 dotitle();
								
							 }
						 }
					}
				}
		);
		
		//again��ť���¼�����
		again.setOnClickListener
		(
				new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Toast toast;
						
						toast=Toast.makeText(getApplicationContext(), "�뿪ʼ��Ĵ��⣡", Toast.LENGTH_SHORT);
						toast.setGravity(Gravity.CENTER, 0, 0);  //Toast ������ʾ
						toast.show();
						//���ԭ�е�ֵ
						shumu.setText("");
						yun1.setText("");
						 yun2.setText("");
						 symbol.setText("");
						 answer.setText("");  //��մ�
						 num.setText("");
						 rightnum=0;
						 errornum=0;
						 j=1;
					}
				}
		);
	}
	
	//��ʼ���ؼ�
	public void InitButton()
	{
		//�Ӳ����л�ȡ�ؼ�
		textView1=(TextView)findViewById(R.id.count_text1);
		textView2=(TextView)findViewById(R.id.count_text2);
		yun1=(TextView)findViewById(R.id.yun1);
		yun2=(TextView)findViewById(R.id.yun2);
		symbol=(TextView)findViewById(R.id.symbol);
		num=(TextView)findViewById(R.id.num);  //�ڼ���
		
		shumu=(EditText)findViewById(R.id.shumu);
		answer=(EditText)findViewById(R.id.answer);
		
		start=(Button)findViewById(R.id.start);
		next=(Button)findViewById(R.id.next);
		check=(Button)findViewById(R.id.check);
		again=(Button)findViewById(R.id.again);
		}
	
	//���Ӱ�ť�����������������˳�
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
	//���⺯��
	public void dotitle()
	{
		String a="";
		String b="";
		
		int k=0,p=30;  //0-30
		//����0-30�����������
		a=String.valueOf((int)(Math.random()*p+k));
		b=String.valueOf((int)(Math.random()*p+k));
		String []op={"+","-","*","/"};
		Random r=new Random(); //Ĭ�ϵ�ǰϵͳʱ��ĺ�������Ϊ������
		int d=r.nextInt(4);   //�����������Ϊ4(������)
		
		//�����жϣ���������Ϊ0 �������ɳ�����
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

