package com.csform.android.uiapptemplate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.csform.android.uiapptemplate.adapter.SwipeToDissmissShopAdapter;
import com.csform.android.uiapptemplate.util.DummyContent;
import com.csform.android.uiapptemplate.view.pzv.PullToZoomListViewEx;

public class ParallaxShopActivity extends AppCompatActivity implements
		OnClickListener {

	public static final String TAG = "Parallax shop";

	ImageView iv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_parallax_shop);

		TextView iconLike = (TextView) findViewById(R.id.header_parallax_shop_like);
		TextView iconFavorite = (TextView) findViewById(R.id.header_parallax_shop_favorite);
		TextView iconShare = (TextView) findViewById(R.id.header_parallax_shop_share);
		TextView discount = (TextView) findViewById(R.id.header_parallax_shop_discount);
		TextView percent = (TextView) findViewById(R.id.header_parallax_shop_percent);

		iconLike.setOnClickListener(this);
		iconFavorite.setOnClickListener(this);
		iconShare.setOnClickListener(this);

		// iv = (ImageView) findViewById(R.id.header_parallax_);
		PullToZoomListViewEx listView = (PullToZoomListViewEx) findViewById(R.id.paralax_shop_list_view);
		listView.setShowDividers(0);
		listView.setAdapter(new SwipeToDissmissShopAdapter(this, DummyContent
				.getDummyModelDragAndDropShopList()));

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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {
		case R.id.header_parallax_shop_like:
			// click on explore button
			Toast.makeText(this, "Like", Toast.LENGTH_SHORT).show();
			break;
		case R.id.header_parallax_shop_favorite:
			// click on explore button
			Toast.makeText(this, "Favorite", Toast.LENGTH_SHORT).show();
			break;
		case R.id.header_parallax_shop_share:
			// click on explore button
			Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
			break;
		}
	}
}
