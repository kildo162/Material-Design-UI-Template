package com.csform.android.uiapptemplate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterPageActivity extends AppCompatActivity implements OnClickListener {

	public static final String LOGIN_PAGE_AND_LOADERS_CATEGORY = "com.csform.android.uiapptemplate.RegisterPageActivity";
	public static final String REGISTER_TRAVEL = "Register travel";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		getSupportActionBar().hide();
		setContentView(R.layout.activity_register);
		TextView register;
		register = (TextView) findViewById(R.id.register);

		register.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v instanceof TextView) {
			TextView tv = (TextView) v;
			Toast.makeText(this, tv.getText(), Toast.LENGTH_SHORT).show();
		}
	}
}
