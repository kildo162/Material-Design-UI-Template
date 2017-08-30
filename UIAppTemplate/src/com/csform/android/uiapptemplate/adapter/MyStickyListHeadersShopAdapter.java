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

public class MyStickyListHeadersShopAdapter extends ArrayAdapter<String>
		implements StickyListHeadersAdapter, OnClickListener {

	private final Context mContext;
	private LayoutInflater mInflater;
	private ArrayList<DummyModel> mDummyModelList;

	public MyStickyListHeadersShopAdapter(final Context context,
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
					R.layout.list_item_sticky_header_shop, parent, false);
			holder = new ViewHolder();
			holder.image = (ImageView) convertView
					.findViewById(R.id.list_item_sticky_header_shop_image);
			holder.image1 = (ImageView) convertView
					.findViewById(R.id.list_item_sticky_header_shop_image1);
			holder.image2 = (ImageView) convertView
					.findViewById(R.id.list_item_sticky_header_shop_image2);
			holder.image3 = (ImageView) convertView
					.findViewById(R.id.list_item_sticky_header_shop_image3);
			holder.image4 = (ImageView) convertView
					.findViewById(R.id.list_item_sticky_header_shop_image4);
			holder.productName = (TextView) convertView
					.findViewById(R.id.list_item_sticky_header_shop_product_name);
			holder.shipping = (TextView) convertView
					.findViewById(R.id.list_item_sticky_header_shop_shipping);
			holder.oldPrice = (TextView) convertView
					.findViewById(R.id.list_item_sticky_header_shop_old_price);
			holder.price = (TextView) convertView
					.findViewById(R.id.list_item_sticky_header_shop_price);
			holder.buttonBuy = (TextView) convertView
					.findViewById(R.id.list_item_sticky_header_shop_button);
			holder.buttonBuy.setOnClickListener(this);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		// TODO Change image URL
		ImageUtil.displayImage(holder.image,
				mDummyModelList.get(position % 3).getImageURL(), null);
		ImageUtil.displayImage(holder.image1,
				mDummyModelList.get((position % 3) + 1).getImageURL(), null);
		ImageUtil.displayImage(holder.image2,
				mDummyModelList.get((position % 3) + 2).getImageURL(), null);
		ImageUtil.displayImage(holder.image3,
				mDummyModelList.get((position % 3) + 3).getImageURL(), null);
		ImageUtil.displayImage(holder.image4,
				mDummyModelList.get((position % 3)).getImageURL(), null);

		holder.buttonBuy.setTag(position);

		return convertView;
	}

	private static class ViewHolder {
		public ImageView image;
		public ImageView image1;
		public ImageView image2;
		public ImageView image3;
		public ImageView image4;
		public/* Roboto */TextView productName;
		public/* Roboto */TextView shipping;
		public/* Roboto */TextView oldPrice;
		public/* Roboto */TextView price;
		public/* Roboto */TextView buttonBuy;
	}

	private static class HeaderViewHolder {
		public/* Roboto */TextView header;
	}

	@Override
	public View getHeaderView(final int position, final View convertView,
			final ViewGroup parent) {
		View view = convertView;
		final HeaderViewHolder holder;
		if (view == null) {
			view = LayoutInflater.from(mContext).inflate(
					R.layout.list_header_shop, parent, false);
			holder = new HeaderViewHolder();
			holder.header = (TextView) view
					.findViewById(R.id.list_header_media_header);

			view.setTag(holder);
		} else {
			holder = (HeaderViewHolder) view.getTag();
		}

		holder.header.setText("Wardrobe " + (getHeaderId(position) + 1));

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
		case R.id.list_item_sticky_header_shop_button:
			Toast.makeText(mContext, "Buy: " + position,
					Toast.LENGTH_SHORT).show();
			break;
		}
	}
}