package com.example.isweixin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class AddFriendActivity extends Activity{
	private EditText et_username;
	private ListView m_ListView;
	//private List<User> users;
	List<Map<String, String>> ListItems;
	 BaseAdapter adapter;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addfriend);
		Bmob.initialize(this, "e0de3d3dc7ff4ff6a20070a1da7cad01");
		et_username = (EditText)findViewById(R.id.et_find_name);
		
		ListItems = new ArrayList<Map<String, String>>();
		adapter = new SimpleAdapter(this,
				ListItems,
				R.layout.listitemlayout,
				new String[] {"name"},
				new int[] {R.id.name});
		m_ListView = (ListView)findViewById(R.id.listView1);
		m_ListView.setAdapter(adapter);
		
		
		
		Button btn_search = (Button)findViewById(R.id.btn_search);
		btn_search.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.e("1", "1");
				if(!et_username.getText().toString().trim().contentEquals("")){
				//	Map<String, String> item = new HashMap<String, String>();
				//	item.put("name", et_username.getText().toString());
				//	item.put("password", "1111");
				//	adapter.notifyDataSetChanged();
					Log.e("2", "2");	
					Search(et_username.getText().toString());		
				}
			}
		});
		
	}

	
	public void Search(String name){
		Log.e("3", "3");	

		
		BmobQuery<User> bmobQuery = new BmobQuery<User>();
		bmobQuery.addWhereContains("username", name);
		//bmobQuery.addWhereEqualTo("username", name);
		bmobQuery.setLimit(50);
		ListItems.clear();
		bmobQuery.findObjects(this, new FindListener<User>() {
				
				@Override
				public void onSuccess(List<User> object) {
					// TODO Auto-generated method stub
					for(User user:object){
						DisplayToast(user.getUsername());
						
						Map<String, String> item = new HashMap<String, String>();
						item.put("name", user.getUsername());
					//	item.put("password", user.getPassword());
						ListItems.add(item);
					}
					adapter.notifyDataSetChanged();
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
