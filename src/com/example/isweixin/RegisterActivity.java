package com.example.isweixin;

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
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_login);
		
		EditText m_EditText1 = (EditText)findViewById(R.id.editText1);
		final EditText m_EditText2 = (EditText)findViewById(R.id.editText2);
		final EditText m_EditText3 = (EditText)findViewById(R.id.editText3);
		
		Button btn1 = (Button)findViewById(R.id.button1);
		btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				if(m_EditText2.toString().equals(m_EditText3.toString())){
					//连接数据库 判断 添加用户信息
					
					
					Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
					startActivity(intent);
				}
				else{
					DisplayToast("两次密码输入不一致，请重新输入");
					
				}
				
				
				
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
