package com.csform.android.uiapptemplate.adapter;

import java.util.ArrayList;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.csform.android.uiapptemplate.R;
import com.csform.android.uiapptemplate.model.DummyModel;
import com.csform.android.uiapptemplate.util.ImageUtil;
import com.nhaarman.listviewanimations.ArrayAdapter;

public class MyStickyListHeadersMediaAdapter extends ArrayAdapter<String>
		implements StickyListHeadersAdapter, OnClickListener {

	private final Context mContext;
	private LayoutInflater mInflater;
	private ArrayList<DummyModel> mDummyModelList;

	public MyStickyListHeadersMediaAdapter(final Context context,
			ArrayList<DummyModel> dummyModelList) {
		mContext = context;
		mDummyModelList = dummyModelList;
		mInflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		for (int i = 0; i < 100; i++) {
			add("Row number " + i);
		}
	}

	@Override
	public long getItemId(final int position) {
		return getItem(position).hashCode();
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(
					R.layout.list_item_sticky_header_media, parent, false);
			holder = new ViewHolder();
			holder.image = (ImageView) convertView
					.findViewById(R.id.list_item_sticky_header_media_image);
			holder.albumName = (TextView) convertView
					.findViewById(R.id.list_item_sticky_header_media_album_name);
			holder.artistName = (TextView) convertView
					.findViewById(R.id.list_item_sticky_header_media_artist_name);
			holder.time = (TextView) convertView
					.findViewById(R.id.list_item_sticky_header_media_time);
			holder.iconPlay = (TextView) convertView
					.findViewById(R.id.list_item_sticky_header_media_icon_play);
			holder.iconPlay.setOnClickListener(this);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		// TODO Change image URL
		ImageUtil.displayImage(holder.image,
				mDummyModelList.get(position % 5).getImageURL(), null);

		holder.iconPlay.setTag(position);

		return convertView;
	}

	private static class ViewHolder {
		public ImageView image;
		public/* Roboto */TextView albumName;
		public/* Roboto */TextView artistName;
		public/* Roboto */TextView time;
		public/* Material */TextView iconPlay;
	}

	private static class HeaderViewHolder {
		public/* Roboto */TextView header;
		public/* Material */TextView icon;
	}

	@Override
	public View getHeaderView(final int position, final View convertView,
			final ViewGroup parent) {
		View view = convertView;
		final HeaderViewHolder holder;
		if (view == null) {
			view = LayoutInflater.from(mContext).inflate(
					R.layout.list_header_media, parent, false);
			holder = new HeaderViewHolder();
			holder.header = (TextView) view
					.findViewById(R.id.list_header_media_header);
			holder.icon = (TextView) view
					.findViewById(R.id.list_header_media_icon);
			holder.icon.setOnClickListener(this);

			view.setTag(holder);
		} else {
			holder = (HeaderViewHolder) view.getTag();
		}

		holder.icon.setTag(position);
		holder.header.setText("Jazz " + (getHeaderId(position) + 1));

		return view;
	}

	@Override
	public long getHeaderId(final int position) {
		return position / 5;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int position = (Integer) v.getTag();
		switch (v.getId()) {
		case R.id.list_header_media_icon:
			Toast.makeText(mContext, "Header icon: " + (getHeaderId(position) + 1),
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.list_item_sticky_header_media_icon_play:
			Toast.makeText(mContext, "Play song: " + position,
					Toast.LENGTH_SHORT).show();
			break;
		}
	}
}