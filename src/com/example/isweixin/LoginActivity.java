package com.example.isweixin;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.GetListener;
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

public class LoginActivity extends Activity{
	EditText m_EditText1;
	EditText m_EditText2;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Bmob.initialize(this, "e0de3d3dc7ff4ff6a20070a1da7cad01");
		
		setContentView(R.layout.activity_login);
		
		m_EditText1 = (EditText)findViewById(R.id.editText1);
		m_EditText2 = (EditText)findViewById(R.id.editText2);
		
		Button btn1 = (Button)findViewById(R.id.button1);
		btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String str_name = m_EditText1.getText().toString();
				String str_password = m_EditText2.getText().toString();
				
			//	DisplayToast(str_name+"!!"+str_password);
				
				Search(str_name,str_password);
				
			}
		});
		
		Button btn2 = (Button)findViewById(R.id.button2);
		btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
				startActivity(intent);
			}
		});
		
		TextView m_TextView = (TextView)findViewById(R.id.textView3);
		m_TextView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
				startActivity(intent);
				finish();
			}
		});
		
	}
	
	public void Search(String name,final String password){
		BmobQuery<User> bmobQuery = new BmobQuery<User>();
		
		bmobQuery.addWhereEqualTo("username", name);
		bmobQuery.setLimit(50);
		
		bmobQuery.findObjects(this, new FindListener<User>() {
			
			@Override
			public void onSuccess(List<User> object) {
				// TODO Auto-generated method stub
				for(User user:object){
					if(user.getPassword().toString().equals(password)){
						Intent intent = new Intent(LoginActivity.this,MainActivity.class);
						PublicData.username = m_EditText1.getText().toString();
						
						startActivity(intent);
					//	finish();
					//	DisplayToast(user.getPassword()+user.getUsername());
					}
				}
				
			}
			
			@Override
			public void onError(int arg0, String arg1) {
				// TODO Auto-generated method stub
				DisplayToast("fail!");
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
