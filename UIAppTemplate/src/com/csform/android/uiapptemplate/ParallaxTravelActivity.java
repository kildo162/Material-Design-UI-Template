package com.csform.android.uiapptemplate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;

import com.csform.android.uiapptemplate.adapter.ParallaxTravelAdapter;
import com.csform.android.uiapptemplate.util.DummyContent;
import com.csform.android.uiapptemplate.view.pzv.PullToZoomListViewEx;

public class ParallaxTravelActivity extends AppCompatActivity {

	public static final String TAG = "Parallax travel";

	ImageView iv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_parallax_travel);

		iv = (ImageView) findViewById(R.id.header_parallax_travel_image);

		PullToZoomListViewEx listView = (PullToZoomListViewEx) findViewById(R.id.paralax_travel_list_view);
		listView.setShowDividers(0);
		listView.setAdapter(new ParallaxTravelAdapter(this, DummyContent
				.getDummyModelListTravel(), false));

		getSupportActionBar().hide();
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
