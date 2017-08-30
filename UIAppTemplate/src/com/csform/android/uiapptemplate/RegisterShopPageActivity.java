package com.csform.android.uiapptemplate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterShopPageActivity extends AppCompatActivity implements OnClickListener {

	public static final String LOGIN_PAGE_AND_LOADERS_CATEGORY = "com.csform.android.uiapptemplate.RegisterShopPageActivity";
	public static final String REGISTER_SHOP = "Register shop";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		getSupportActionBar().hide();
		setContentView(R.layout.activity_register_shop);
		TextView register;
		register = (TextView) findViewById(R.id.activity_register_shop_submit);

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
