package com.csform.android.uiapptemplate.adapter;

import java.util.ArrayList;
import java.util.Collections;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.csform.android.uiapptemplate.R;
import com.csform.android.uiapptemplate.SwipToDissmissListViewActivity;
import com.csform.android.uiapptemplate.model.DummyModel;
import com.csform.android.uiapptemplate.util.ImageUtil;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.OnDismissCallback;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.undo.UndoAdapter;
import com.nhaarman.listviewanimations.util.Swappable;

public class SwipeToDissmissTravelAndSocialAdapter extends BaseAdapter
		implements Swappable, UndoAdapter, OnDismissCallback {

	private Context mContext;
	private LayoutInflater mInflater;
	private ArrayList<DummyModel> mDummyModelList;
	private String category;

	public SwipeToDissmissTravelAndSocialAdapter(Context context,
			ArrayList<DummyModel> dummyModelList, String cat) {
		mContext = context;
		mInflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mDummyModelList = dummyModelList;
		category = cat;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public int getCount() {
		return mDummyModelList.size();
	}

	@Override
	public Object getItem(int position) {
		return mDummyModelList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return mDummyModelList.get(position).getId();
	}

	@Override
	public void swapItems(int positionOne, int positionTwo) {
		Collections.swap(mDummyModelList, positionOne, positionTwo);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		if (convertView == null) {
			if (category
					.equals(SwipToDissmissListViewActivity.SWIPE_TO_DISSMISS_TRAVEL)) {
				convertView = mInflater.inflate(
						R.layout.list_item_swipe_to_dissmiss_travel, parent,
						false);
				holder = new ViewHolder();
				holder.image = (ImageView) convertView
						.findViewById(R.id.item_swip_to_dissmiss_travel_image);
				holder.travelHeader = (TextView) convertView
						.findViewById(R.id.item_swip_to_dissmiss_travel_header);
				holder.travelSubheader = (TextView) convertView
						.findViewById(R.id.item_swip_to_dissmiss_travel_subheader);
			} else {
				convertView = mInflater.inflate(
						R.layout.list_item_swipe_to_dissmiss_social, parent,
						false);
				holder = new ViewHolder();
				holder.image = (ImageView) convertView
						.findViewById(R.id.swipe_to_dissmiss_lv_social_image);
				holder.name = (TextView) convertView
						.findViewById(R.id.swipe_to_dissmiss_lv_social_name);
				holder.text = (TextView) convertView
						.findViewById(R.id.swipe_to_dissmiss_lv_social_text);
			}
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		if (category
				.equals(SwipToDissmissListViewActivity.SWIPE_TO_DISSMISS_TRAVEL)) {

			DummyModel dm = mDummyModelList.get(position);

			ImageUtil.displayImage(holder.image, dm.getImageURL(), null);
			holder.travelHeader.setText(dm.getText());
			// holder.travelHeader.setText(dm.getText());
			return convertView;
		} else {
			DummyModel dm = mDummyModelList.get(position);

			ImageUtil.displayRoundImage(holder.image, dm.getImageURL(), null);
			holder.name.setText(dm.getText());
			return convertView;
		}
	}

	private static class ViewHolder {
		public ImageView image;
		public/* Roboto */TextView text;
		public/* Roboto */TextView name;
		public/* Roboto */TextView travelHeader;
		public/* Roboto */TextView travelSubheader;
		public/* Fontello */TextView icon;
	}

	@Override
	@NonNull
	public View getUndoClickView(@NonNull View view) {
		if (category
				.equals(SwipToDissmissListViewActivity.SWIPE_TO_DISSMISS_TRAVEL)) {
			return view.findViewById(R.id.undo_button_travel);
		} else if (category
				.equals(SwipToDissmissListViewActivity.SWIPE_TO_DISSMISS_SOCIAL))
			return view.findViewById(R.id.undo_button_social);
		else {
			return view.findViewById(R.id.undo_button);
		}
	}

	@Override
	@NonNull
	public View getUndoView(final int position, final View convertView,
			@NonNull final ViewGroup parent) {
		View view = convertView;
		if (view == null) {
			if (category
					.equals(SwipToDissmissListViewActivity.SWIPE_TO_DISSMISS_TRAVEL)) {
				view = LayoutInflater.from(mContext).inflate(
						R.layout.list_item_undo_view_travel, parent, false);
			} else if (category
					.equals(SwipToDissmissListViewActivity.SWIPE_TO_DISSMISS_SOCIAL)) {
				view = LayoutInflater.from(mContext).inflate(
						R.layout.list_item_undo_view_social, parent, false);
			}

			else {
				view = LayoutInflater.from(mContext).inflate(
						R.layout.list_item_undo_view, parent, false);
			}
		}
		return view;
	}

	@Override
	public void onDismiss(@NonNull final ViewGroup listView,
			@NonNull final int[] reverseSortedPositions) {
		for (int position : reverseSortedPositions) {
			remove(position);
		}
	}

	public void remove(int position) {
		mDummyModelList.remove(position);
	}
}
