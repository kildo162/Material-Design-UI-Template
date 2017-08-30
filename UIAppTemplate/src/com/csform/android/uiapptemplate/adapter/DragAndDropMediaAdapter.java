package com.csform.android.uiapptemplate.adapter;

import java.util.ArrayList;
import java.util.Collections;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.csform.android.uiapptemplate.R;
import com.csform.android.uiapptemplate.model.DummyModel;
import com.nhaarman.listviewanimations.util.Swappable;

public class DragAndDropMediaAdapter extends BaseAdapter implements Swappable, OnClickListener {

	private Context mContext;
	private LayoutInflater mInflater;
	private ArrayList<DummyModel> mDummyModelList;

	public DragAndDropMediaAdapter(Context context,
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
					R.layout.list_item_drag_and_drop_media, parent, false);
			holder = new ViewHolder();
			holder.songName = (TextView) convertView
					.findViewById(R.id.list_item_drag_and_drop_media_songname);
			holder.iconDrag = (TextView) convertView
					.findViewById(R.id.icon);
			holder.iconPlay = (TextView) convertView
					.findViewById(R.id.list_item_drag_and_drop_media_icon_play);
			holder.username = (TextView) convertView
					.findViewById(R.id.list_item_drag_and_drop_media_username);
			holder.iconPlay.setOnClickListener(this);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.iconPlay.setTag(position);
	//	DummyModel dm = mDummyModelList.get(position);

		return convertView;
	}

	private static class ViewHolder {
		public/* Roboto */TextView songName;
		public/* Material */TextView iconDrag;
		public/* Material */TextView iconPlay;
		public/* Roboto */TextView username;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int possition = (Integer) v.getTag();
		switch (v.getId()) {
		case R.id.list_item_drag_and_drop_media_icon_play:
			// click on explore button
			Toast.makeText(mContext, "Play " + possition, Toast.LENGTH_SHORT).show();
			break;
		}
	}
}
