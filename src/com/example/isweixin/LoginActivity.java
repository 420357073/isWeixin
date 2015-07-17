package com.example.isweixin;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
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
import android.widget.Toast;

public class LoginActivity extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Bmob.initialize(this, "e0de3d3dc7ff4ff6a20070a1da7cad01");
		
		setContentView(R.layout.activity_login);
		
		final EditText m_EditText1 = (EditText)findViewById(R.id.editText1);
		final EditText m_EditText2 = (EditText)findViewById(R.id.editText2);
		
		Button btn1 = (Button)findViewById(R.id.button1);

		
			
		//查询数据库 是否存在次用户，密码是否正确
		
		if(true) // 用户存在，密码正确 登录
		{
			Intent intent = new Intent(LoginActivity.this,MainActivity.class);
			startActivity(intent);
		}else   //提示错误信息
		{
			
		}
		
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
