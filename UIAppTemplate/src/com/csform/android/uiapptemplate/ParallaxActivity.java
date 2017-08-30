package com.csform.android.uiapptemplate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.csform.android.uiapptemplate.adapter.DefaultAdapter;
import com.csform.android.uiapptemplate.util.DummyContent;
import com.csform.android.uiapptemplate.view.pzv.PullToZoomListViewEx;

public class ParallaxActivity extends AppCompatActivity {
	
	public static final String TAG = "Parallax";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_parallax);
		
		PullToZoomListViewEx listView = (PullToZoomListViewEx) findViewById(R.id.list_view);
		//listView.setZoomEnabled(true);
		//listView.setParallax(true);
		//listView.showHeadView();
		listView.setAdapter(new DefaultAdapter(this, DummyContent.getDummyModelList(), false));
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
