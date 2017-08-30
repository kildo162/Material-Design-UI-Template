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

public class MyStickyListHeadersSocialAdapter extends ArrayAdapter<String>
		implements StickyListHeadersAdapter, OnClickListener {

	private final Context mContext;
	private LayoutInflater mInflater;
	private ArrayList<DummyModel> mDummyModelList;

	public MyStickyListHeadersSocialAdapter(final Context context, ArrayList<DummyModel> dummyModelList) {
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
					R.layout.list_item_sticky_header_social, parent, false);
			holder = new ViewHolder();
			holder.image = (ImageView) convertView
					.findViewById(R.id.list_item_sticky_header_social_image);
			holder.name = (TextView) convertView
					.findViewById(R.id.list_item_sticky_header_social_name);
			holder.likeIcon = (TextView) convertView
					.findViewById(R.id.list_item_sticky_header_social_icon_like);
			holder.bookmarkIcon = (TextView) convertView
					.findViewById(R.id.list_item_sticky_header_social_icon_bookmark);
			holder.shareIcon = (TextView) convertView
					.findViewById(R.id.list_item_sticky_header_social_icon_share);
			holder.text = (TextView) convertView
					.findViewById(R.id.list_item_sticky_header_social_text);
			holder.image.setOnClickListener(this);
			holder.name.setOnClickListener(this);
			holder.likeIcon.setOnClickListener(this);
			holder.bookmarkIcon.setOnClickListener(this);
			holder.shareIcon.setOnClickListener(this);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		// TODO Change image URL
		ImageUtil.displayRoundImage(holder.image,
				mDummyModelList.get(position % 5).getImageURL(), null);
		
		holder.name.setText("John Smith " + position);
		holder.text.setText(R.string.lorem_ipsum_long);
		holder.image.setTag(position);
		holder.name.setTag(position);
		holder.likeIcon.setTag(position);
		holder.shareIcon.setTag(position);
		holder.bookmarkIcon.setTag(position);
		return convertView;
	}

	private static class ViewHolder {
		public ImageView image;
		public/* Roboto */TextView name;
		public/* Material */TextView likeIcon;
		public/* Material */TextView bookmarkIcon;
		public/* Material */TextView shareIcon;
		public/* Roboto */TextView text;
	}

	private static class HeaderViewHolder {
		public/* Roboto */TextView day;
		public/* Roboto */TextView date;
	}

	@Override
	public View getHeaderView(final int position, final View convertView,
			final ViewGroup parent) {
		View view = convertView;
		final HeaderViewHolder holder;
		if (view == null) {
			view = LayoutInflater.from(mContext).inflate(
					R.layout.list_header_social, parent, false);
			holder = new HeaderViewHolder();
			holder.day = (TextView) view
					.findViewById(R.id.list_header_social_day);
			holder.date = (TextView) view
					.findViewById(R.id.list_header_social_date);
			view.setTag(holder);
		} else {
			holder = (HeaderViewHolder) view.getTag();
		}

		holder.day.setText("Yesterday");
		holder.date.setText("14.6.2015.");
		// holder.name.setText("Header " + getHeaderId(position));

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
		case R.id.list_item_sticky_header_social_image:
			Toast.makeText(mContext, "User image: " + position,
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.list_item_sticky_header_social_icon_like:
			Toast.makeText(mContext, "Like icon: " + position,
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.list_item_sticky_header_social_icon_bookmark:
			Toast.makeText(mContext, "Bookmark icon: " + position,
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.list_item_sticky_header_social_icon_share:
			Toast.makeText(mContext, "Share icon: " + position,
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.list_item_sticky_header_social_name:
			Toast.makeText(mContext, "Username: " + position,
					Toast.LENGTH_SHORT).show();
			break;
		}
	}
}