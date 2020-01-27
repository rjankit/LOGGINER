package com.npdevs.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user);
		Button btnLogout=findViewById(R.id.logout);
		btnLogout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				clearTable();
				saveTable();
				finish();
			}
		});
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
		editor.putString("User","no");
		editor.apply();
	}
}
