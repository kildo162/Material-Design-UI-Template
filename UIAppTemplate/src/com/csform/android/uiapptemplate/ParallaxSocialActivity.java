package com.csform.android.uiapptemplate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

import com.csform.android.uiapptemplate.adapter.ParallaxSocialAdapter;
import com.csform.android.uiapptemplate.util.DummyContent;
import com.csform.android.uiapptemplate.view.pzv.PullToZoomListViewEx;

public class ParallaxSocialActivity extends AppCompatActivity {

	public static final String TAG = "Parallax social";

	ImageView iv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_parallax_social);

		iv = (ImageView) findViewById(R.id.header_parallax_social_new_image);

		iv.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(ParallaxSocialActivity.this, "Photo of user",
						Toast.LENGTH_SHORT).show();
			}
		});

		PullToZoomListViewEx listView = (PullToZoomListViewEx) findViewById(R.id.paralax_social_list_view);
		listView.setShowDividers(0);
		listView.setAdapter(new ParallaxSocialAdapter(this, DummyContent
				.getDummyModelListSocial(), false));

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setTitle("Parallax social");
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
