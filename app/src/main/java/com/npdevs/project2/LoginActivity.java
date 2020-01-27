package com.npdevs.project2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

	private TextInputLayout textInputLayout1,textInputLayout2;
	private Button login,signup;
	private EditText editMob,editPass;
	private String loggedIn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		textInputLayout1=findViewById(R.id.name_text_input1);
		textInputLayout2=findViewById(R.id.name_text_input2);
		editMob=findViewById(R.id.mobNumber);
		loadPreferences();
		if(!loggedIn.equals("no")) {
			Intent i=new Intent(getApplicationContext(),UserActivity.class);
			startActivity(i);
			finish();
		}
		editPass=findViewById(R.id.password);
		login=findViewById(R.id.login);
		login.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String mob=editMob.getText().toString(),pass=editPass.getText().toString();
				if(mob.equals("8004344462") && pass.equals("123456")) {

					clearTable();
					saveTable();
					Intent i=new Intent(getApplicationContext(),UserActivity.class);
					startActivity(i);
					finish();
				}
			}
		});
	}
	private void loadPreferences()
	{
		SharedPreferences sharedPreferences=getSharedPreferences("tablesave",MODE_PRIVATE);
		loggedIn=sharedPreferences.getString("User","");
		if(loggedIn.isEmpty())
			loggedIn="no";
	}
	private void clearTable()
	{
		for(int day=1;day<=5;day++) {
			SharedPreferences preferences = getSharedPreferences("tablesave", Context.MODE_PRIVATE);
			SharedPreferences.Editor editor = preferences.edit();
			editor.clear();
			editor.commit();
		}
	}
	private void saveTable()
	{
		SharedPreferences sharedPreferences=getSharedPreferences("tablesave",MODE_PRIVATE);
		SharedPreferences.Editor editor=sharedPreferences.edit();
		editor.putString("User","yes");
		editor.apply();
	}
}
