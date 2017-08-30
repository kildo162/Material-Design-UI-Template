package com.csform.android.uiapptemplate.adapter;

import java.util.ArrayList;
import java.util.Collections;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.csform.android.uiapptemplate.R;
import com.csform.android.uiapptemplate.model.DummyModel;
import com.csform.android.uiapptemplate.util.ImageUtil;
import com.nhaarman.listviewanimations.util.Swappable;

public class DragAndDropSocialAdapter extends BaseAdapter implements Swappable {

	private Context mContext;
	private LayoutInflater mInflater;
	private ArrayList<DummyModel> mDummyModelList;

	public DragAndDropSocialAdapter(Context context,
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
					R.layout.list_item_drag_and_drop_social, parent, false);
			holder = new ViewHolder();
			holder.image = (ImageView) convertView
					.findViewById(R.id.item_drag_and_drop_social_image);
			holder.text = (TextView) convertView
					.findViewById(R.id.item_drag_and_drop_social_name);
			holder.place = (TextView) convertView
					.findViewById(R.id.item_drag_and_drop_social_place);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		DummyModel dm = mDummyModelList.get(position);

		ImageUtil.displayRoundImage(holder.image, dm.getImageURL(), null);
		holder.text.setText(dm.getText());
		return convertView;
	}

	private static class ViewHolder {
		public ImageView image;
		public/* Roboto */TextView text;
		public/* Roboto */TextView subtext;
		public/* Fontello */TextView icon;
		public/* Roboto */TextView rating;
		public/* Roboto */TextView place;
	}
}
