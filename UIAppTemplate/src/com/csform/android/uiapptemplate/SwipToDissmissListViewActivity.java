package com.csform.android.uiapptemplate;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.csform.android.uiapptemplate.adapter.DefaultAdapter;
import com.csform.android.uiapptemplate.adapter.SwipeToDissmissTravelAndSocialAdapter;
import com.csform.android.uiapptemplate.util.DummyContent;
import com.nhaarman.listviewanimations.itemmanipulation.DynamicListView;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.OnDismissCallback;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.undo.SimpleSwipeUndoAdapter;

public class SwipToDissmissListViewActivity extends AppCompatActivity {

	public static final String SWIPE_TO_DISSMISS_TRAVEL = "travel";
	public static final String SWIPE_TO_DISSMISS_SOCIAL = "social";

	private DynamicListView mDynamicListView;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_views);

		mDynamicListView = (DynamicListView) findViewById(R.id.dynamic_listview);
		String category = SWIPE_TO_DISSMISS_TRAVEL;
		Bundle extras = getIntent().getExtras();
		if (extras != null
				&& extras
						.containsKey(CategoriesListViewActivity.LIST_VIEW_OPTION_SWIPE_TO_DISSMISS)) {
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
				category = extras
						.getString(
								CategoriesListViewActivity.LIST_VIEW_OPTION_SWIPE_TO_DISSMISS,
								SWIPE_TO_DISSMISS_TRAVEL);
			} else {
				category = extras
						.getString(CategoriesListViewActivity.LIST_VIEW_OPTION_SWIPE_TO_DISSMISS);
			}
		}

		if (category.equals(SWIPE_TO_DISSMISS_TRAVEL)) {
			setUpSwipeToDissmissTravel();
		} else if (category.equals(SWIPE_TO_DISSMISS_SOCIAL)) {
			mDynamicListView
					.setBackgroundResource(R.drawable.drag_and_drop_background_image);
			setUpSwipeToDissmissSocial();
		} else {
			setUpSwipeToDissmiss();
		}
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
		final DefaultAdapter adapter = new DefaultAdapter(this,
				DummyContent.getDummyModelList(), false);
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

	private void setUpSwipeToDissmissTravel() {
		final SwipeToDissmissTravelAndSocialAdapter adapter = new SwipeToDissmissTravelAndSocialAdapter(
				this, DummyContent.getDummyModelSwipeToDissmissTravelList(),
				SwipToDissmissListViewActivity.SWIPE_TO_DISSMISS_TRAVEL);
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

	private void setUpSwipeToDissmissSocial() {
		final SwipeToDissmissTravelAndSocialAdapter adapter = new SwipeToDissmissTravelAndSocialAdapter(
				this, DummyContent.getDummyModelSwipeToDissmissSocialList(),
				SwipToDissmissListViewActivity.SWIPE_TO_DISSMISS_SOCIAL);
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
}
