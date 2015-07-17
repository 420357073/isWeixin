package com.example.isweixin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ChatActivity extends Activity{
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_chat);
		
		Intent intent = getIntent();
		String contact_id = intent.getStringExtra(MainActivity.EXTRA_ID); 
		String contact_name = intent.getStringExtra(MainActivity.EXTRA_NAME); 
		
		Toast.makeText(this, "id:"+contact_id+",name:"+contact_name, Toast.LENGTH_LONG).show();
		
		TextView friendName = (TextView)findViewById(R.id.friendName);
		friendName.setText(contact_name);
		ImageView goBack = (ImageView)findViewById(R.id.goBack);
		goBack.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ChatActivity.this, MainActivity.class);
				startActivity(intent);
			}
			
		});
		
		Button btn_send = (Button)findViewById(R.id.btn_chat_send);
		btn_send.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Toast.makeText(ChatActivity.this, "sending", Toast.LENGTH_SHORT).show();
			}
			
		});
		
		
	}

}
