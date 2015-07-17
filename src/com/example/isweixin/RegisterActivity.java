package com.example.isweixin;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import JavaBean.User;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends Activity{
	public static boolean PkUser_exits = false;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_register);
		
		final EditText m_EditText1 = (EditText)findViewById(R.id.editText1);
		final EditText m_EditText2 = (EditText)findViewById(R.id.editText2);
		final EditText m_EditText3 = (EditText)findViewById(R.id.editText3);
			
		
		Button btn1 = (Button)findViewById(R.id.button1);
		btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				if(m_EditText2.getText().toString().equals(m_EditText3.getText().toString())){
					//�������ݿ� �ж� ����û���Ϣ
				//	DisplayToast(""+PkUser_exits);
				//	PkUser(m_EditText1.getText().toString());	//�ж��û����Ƿ��Ѿ�����
				//	DisplayToast(""+PkUser_exits);
				//	if(!PkUser_exits){
						AddUser(m_EditText1.getText().toString(),m_EditText2.getText().toString());
				//	}else{
				//		DisplayToast("�û����Ѿ����ڣ�����������");
				//	}
					
					
					
				}
				else{
					DisplayToast("�����������벻һ�£�����������" + m_EditText1.getText().toString() + m_EditText2.getText().toString());
					
				}
				
				
				
			}
		});
		
	}
	protected void PkUser(final String username) {
		// TODO Auto-generated method stub
		PkUser_exits = false;
		BmobQuery<User> bmobQuery = new BmobQuery<User>();
		
		bmobQuery.addWhereEqualTo("username", username);
		bmobQuery.setLimit(10);
		
		bmobQuery.findObjects(this, new FindListener<User>() {
			
			@Override
			public void onSuccess(List<User> object) {
				// TODO Auto-generated method stub
				//�ж�������û����Ƿ��Ѿ����ڣ������ڣ���ѯ���ݿ⿴�Ƿ�����ͬ���û�������ˢ�µ�ǰ��ҳ��
				for(User user:object){
					if(user.getUsername().toString().equals(username)){
						PkUser_exits = true;
					}else{
						PkUser_exits = false;
					}
					DisplayToast(username+" "+user.getUsername()+" "+PkUser_exits);
				}
				
			}
			
			@Override
			public void onError(int arg0, String arg1) {
				// TODO Auto-generated method stub
				
			}
		});

	}
	public void AddUser(final String str_username,final String str_password){
		User user = new User();
		user.setUsername(str_username);
		user.setPassword(str_password);

		user.save(this,new SaveListener() {
			
			@Override
			public void onSuccess() {
				// TODO Auto-generated method stub
				DisplayToast("ע��ɹ����û�����"+str_username);
				Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
				startActivity(intent);	
			}
			
			@Override
			public void onFailure(int arg0, String arg1) {
				// TODO Auto-generated method stub
				DisplayToast("sorry,�û�����ʧ��,�������û����Ѵ���");
				Intent intent = new Intent(RegisterActivity.this,RegisterActivity.class);
				startActivity(intent);
			}
		});
		
	
	}
		
	
	public void DisplayToast(String str){
		Toast toast = Toast.makeText(this, str, Toast.LENGTH_LONG);
		toast.setGravity(Gravity.TOP, 0, 220);
		toast.show();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
