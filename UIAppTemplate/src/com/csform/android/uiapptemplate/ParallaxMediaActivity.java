package com.csform.android.uiapptemplate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.csform.android.uiapptemplate.adapter.SwipeToDissmissMediaAdapter;
import com.csform.android.uiapptemplate.util.DummyContent;
import com.csform.android.uiapptemplate.view.pzv.PullToZoomListViewEx;

public class ParallaxMediaActivity extends AppCompatActivity implements
		OnClickListener {

	public static final String TAG = "Parallax media";

	ImageView iv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_parallax_media);

		TextView iconLike = (TextView) findViewById(R.id.header_parallax_media_like);
		TextView iconFavorite = (TextView) findViewById(R.id.header_parallax_media_favorite);
		TextView iconShare = (TextView) findViewById(R.id.header_parallax_media_share);
		TextView iconPrevious = (TextView) findViewById(R.id.header_parallax_media_previous);
		TextView iconPlay = (TextView) findViewById(R.id.header_parallax_media_play);
		TextView iconNext = (TextView) findViewById(R.id.header_parallax_media_next);
		TextView songName = (TextView) findViewById(R.id.header_parallax_media_song_name);
		TextView artistName = (TextView) findViewById(R.id.header_parallax_media_artist_name);

		iconLike.setOnClickListener(this);
		iconFavorite.setOnClickListener(this);
		iconShare.setOnClickListener(this);
		iconPrevious.setOnClickListener(this);
		iconPlay.setOnClickListener(this);
		iconNext.setOnClickListener(this);

		// iv = (ImageView) findViewById(R.id.header_parallax_);
		PullToZoomListViewEx listView = (PullToZoomListViewEx) findViewById(R.id.paralax_media_list_view);
		listView.setShowDividers(0);
		listView.setAdapter(new SwipeToDissmissMediaAdapter(this, DummyContent
				.getDummyModelList()));

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
		case R.id.header_parallax_media_like:
			// click on explore button
			Toast.makeText(this, "Like", Toast.LENGTH_SHORT).show();
			break;
		case R.id.header_parallax_media_favorite:
			// click on explore button
			Toast.makeText(this, "Favorite", Toast.LENGTH_SHORT).show();
			break;
		case R.id.header_parallax_media_share:
			// click on explore button
			Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
			break;
		case R.id.header_parallax_media_previous:
			// click on explore button
			Toast.makeText(this, "Previous", Toast.LENGTH_SHORT).show();
			break;
		case R.id.header_parallax_media_play:
			// click on explore button
			Toast.makeText(this, "Play ", Toast.LENGTH_SHORT).show();
			break;
		case R.id.header_parallax_media_next:
			// click on explore button
			Toast.makeText(this, "Next", Toast.LENGTH_SHORT).show();
			break;
		}
	}
}
