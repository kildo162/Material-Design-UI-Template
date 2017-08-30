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

import com.csform.android.uiapptemplate.adapter.SwipeToDissmissShopAdapter;
import com.csform.android.uiapptemplate.util.DummyContent;
import com.nhaarman.listviewanimations.itemmanipulation.DynamicListView;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.OnDismissCallback;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.undo.SimpleSwipeUndoAdapter;

public class SwipToDissmissShopActivity extends AppCompatActivity implements
		OnClickListener {

	private DynamicListView mDynamicListView;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_swip_to_dissmiss_shop);

		TextView price = (TextView) findViewById(R.id.activity_swip_to_dissmiss_shop_price);
		TextView orderNumber = (TextView) findViewById(R.id.activity_swip_to_dissmiss_shop_order_number);
		TextView proceed = (TextView) findViewById(R.id.activity_swip_to_dissmiss_shop_proceed);
		
		proceed.setOnClickListener(this);

		mDynamicListView = (DynamicListView) findViewById(R.id.activity_swip_to_dissmiss_shop_dynamic_listview);

		setUpSwipeToDissmiss();

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setTitle("Swipe to Dissmiss Shop");
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
		final SwipeToDissmissShopAdapter adapter = new SwipeToDissmissShopAdapter(
				this, DummyContent.getDummyModelDragAndDropShopList());
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
		case R.id.activity_swip_to_dissmiss_shop_proceed:
			// click on explore button
			Toast.makeText(this, "Proceed...", Toast.LENGTH_SHORT).show();
			break;
		}
	}
}
