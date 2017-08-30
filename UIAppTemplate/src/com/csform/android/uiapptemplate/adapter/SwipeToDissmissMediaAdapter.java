package com.csform.android.uiapptemplate.adapter;

import java.util.ArrayList;
import java.util.Collections;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.csform.android.uiapptemplate.R;
import com.csform.android.uiapptemplate.model.DummyModel;
import com.csform.android.uiapptemplate.util.ImageUtil;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.OnDismissCallback;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.undo.UndoAdapter;
import com.nhaarman.listviewanimations.util.Swappable;

public class SwipeToDissmissMediaAdapter extends BaseAdapter implements
		Swappable, UndoAdapter, OnDismissCallback, OnClickListener {

	private Context mContext;
	private LayoutInflater mInflater;
	private ArrayList<DummyModel> mDummyModelList;

	public SwipeToDissmissMediaAdapter(Context context,
			ArrayList<DummyModel> dummyModelList) {
		mContext = context;
		mInflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mDummyModelList = dummyModelList;
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
			convertView = mInflater.inflate(
					R.layout.list_item_swipe_to_dissmiss_media, parent, false);
			holder = new ViewHolder();
			holder.image = (ImageView) convertView
					.findViewById(R.id.list_item_swipe_to_dissmiss_media_image);
			holder.songName = (TextView) convertView
					.findViewById(R.id.list_item_swipe_to_dissmiss_media_song_name);
			holder.artistName = (TextView) convertView
					.findViewById(R.id.list_item_swipe_to_dissmiss_media_artist_name);
			holder.time = (TextView) convertView
					.findViewById(R.id.list_item_swipe_to_dissmiss_media_time);
			holder.icon = (TextView) convertView
					.findViewById(R.id.list_item_swipe_to_dissmiss_media_icon_play);
			holder.icon.setOnClickListener(this);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.icon.setTag(position);
		
		DummyModel dm = mDummyModelList.get(position);

		ImageUtil.displayImage(holder.image, dm.getImageURL(), null);
		
		
		return convertView;
	}

	private static class ViewHolder {
		public ImageView image;
		public/* Roboto */TextView songName;
		public/* Roboto */TextView artistName;
		public/* Roboto */TextView time;
		public/* Material */TextView icon;
	}

	@Override
	@NonNull
	public View getUndoClickView(@NonNull View view) {
		return view.findViewById(R.id.undo_button_media);
	}

	@Override
	@NonNull
	public View getUndoView(final int position, final View convertView,
			@NonNull final ViewGroup parent) {
		View view = convertView;
		if (view == null) {
			view = LayoutInflater.from(mContext).inflate(
					R.layout.list_item_undo_media, parent, false);
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int position = (int)v.getTag();
		Toast.makeText(mContext, "Play " + position + ". song", Toast.LENGTH_SHORT).show();
	}
}
