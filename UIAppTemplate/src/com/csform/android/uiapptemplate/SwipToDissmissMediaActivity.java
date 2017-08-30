package com.csform.android.uiapptemplate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.csform.android.uiapptemplate.adapter.SwipeToDissmissMediaAdapter;
import com.csform.android.uiapptemplate.util.DummyContent;
import com.nhaarman.listviewanimations.itemmanipulation.DynamicListView;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.OnDismissCallback;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.undo.SimpleSwipeUndoAdapter;

public class SwipToDissmissMediaActivity extends AppCompatActivity implements
		OnClickListener {

	private DynamicListView mDynamicListView;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_swip_to_dissmiss_media);

		TextView play = (TextView) findViewById(R.id.activity_swip_to_dissmiss_media_play);
		TextView like = (TextView) findViewById(R.id.activity_swip_to_dissmiss_media_like);
		TextView favorite = (TextView) findViewById(R.id.activity_swip_to_dissmiss_media_favorite);
		TextView share = (TextView) findViewById(R.id.activity_swip_to_dissmiss_media_share);
		TextView time = (TextView) findViewById(R.id.activity_swip_to_dissmiss_media_time);
		TextView playlistName = (TextView) findViewById(R.id.activity_swip_to_dissmiss_media_playlist);
		TextView songs = (TextView) findViewById(R.id.activity_swip_to_dissmiss_media_songs);

		play.setOnClickListener(this);
		like.setOnClickListener(this);
		favorite.setOnClickListener(this);
		share.setOnClickListener(this);

		mDynamicListView = (DynamicListView) findViewById(R.id.activity_swip_to_dissmiss_media_dynamic_listview);

		setUpSwipeToDissmiss();

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setTitle("Swipe to Dissmiss");
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void setUpSwipeToDissmiss() {
		final SwipeToDissmissMediaAdapter adapter = new SwipeToDissmissMediaAdapter(
				this, DummyContent.getDummyModelList());
		SimpleSwipeUndoAdapter swipeUndoAdapter = new SimpleSwipeUndoAdapter(
				adapter, this, new OnDismissCallback() {
					@Override
					public void onDismiss(@NonNull final ViewGroup listView,
							@NonNull final int[] reverseSortedPositions) {
						for (int position : reverseSortedPositions) {
							adapter.remove(position);
						}
					}
				});
		swipeUndoAdapter.setAbsListView(mDynamicListView);
		mDynamicListView.setAdapter(swipeUndoAdapter);
		mDynamicListView.enableSimpleSwipeUndo();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.activity_swip_to_dissmiss_media_play:
			// click on explore button
			Toast.makeText(this, "Play playlist", Toast.LENGTH_SHORT).show();
			break;
		case R.id.activity_swip_to_dissmiss_media_like:
			// click on explore button
			Toast.makeText(this, "Like", Toast.LENGTH_SHORT).show();
			break;
		case R.id.activity_swip_to_dissmiss_media_favorite:
			// click on explore button
			Toast.makeText(this, "Favorite", Toast.LENGTH_SHORT).show();
			break;
		case R.id.activity_swip_to_dissmiss_media_share:
			// click on explore button
			Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
			break;
		}
	}
}
