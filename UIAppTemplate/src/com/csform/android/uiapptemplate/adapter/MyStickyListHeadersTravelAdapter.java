package com.csform.android.uiapptemplate.adapter;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.csform.android.uiapptemplate.R;
import com.csform.android.uiapptemplate.util.ImageUtil;
import com.nhaarman.listviewanimations.ArrayAdapter;

public class MyStickyListHeadersTravelAdapter extends ArrayAdapter<String>
		implements StickyListHeadersAdapter {

	private final Context mContext;
	private LayoutInflater mInflater;

	public MyStickyListHeadersTravelAdapter(final Context context) {
		mContext = context;
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
					R.layout.list_item_sticky_header_travel, parent, false);
			holder = new ViewHolder();
			holder.image = (ImageView) convertView
					.findViewById(R.id.list_item_sticky_header_travel_image);
			holder.name = (TextView) convertView
					.findViewById(R.id.list_item_sticky_header_travel_name);
			holder.nameIcon = (TextView) convertView
					.findViewById(R.id.list_item_sticky_header_travel_name_icon);
			holder.walk = (TextView) convertView
					.findViewById(R.id.list_item_sticky_header_travel_walk);
			holder.walkIcon = (TextView) convertView
					.findViewById(R.id.list_item_sticky_header_travel_walk_icon);
			holder.price = (TextView) convertView
					.findViewById(R.id.list_item_sticky_header_travel_price);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		// TODO Change image URL
		ImageUtil.displayImage(holder.image,
				"http://pengaja.com/uiapptemplate/newphotos/listviews/stickylistheaders/travel/0.jpg", null);
		holder.name.setText("Hotel Palace " + position);
		holder.price.setText("112$");
		return convertView;
	}

	private static class ViewHolder {
		public ImageView image;
		public/* Roboto */TextView name;
		public/* Roboto */TextView walk;
		public/* Material */TextView nameIcon;
		public/* Material */TextView walkIcon;
		public/* Roboto */TextView price;
	}

	private static class HeaderViewHolder {
		public/* Roboto */TextView name;
		public/* Material */TextView icon;
	}

	@Override
	public View getHeaderView(final int position, final View convertView,
			final ViewGroup parent) {
		View view = convertView;
		final HeaderViewHolder holder;
		if (view == null) {
			view = LayoutInflater.from(mContext).inflate(
					R.layout.list_header_travel, parent, false);
			holder = new HeaderViewHolder();
			holder.name = (TextView) view
					.findViewById(R.id.list_header_travel_name);
			holder.icon = (TextView) view
					.findViewById(R.id.list_header_travel_icon);
			view.setTag(holder);
		} else {
			holder = (HeaderViewHolder) view.getTag();
		}

		holder.name.setText("HOTELS " + getHeaderId(position));
		holder.icon.setText(R.string.material_icon_hotels);

		return view;
	}

	@Override
	public long getHeaderId(final int position) {
		return position / 10 + 1;
	}
}