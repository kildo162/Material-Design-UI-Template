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

public class DragAndDropShopAdapter extends BaseAdapter implements Swappable {

	private Context mContext;
	private LayoutInflater mInflater;
	private ArrayList<DummyModel> mDummyModelList;

	public DragAndDropShopAdapter(Context context,
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
					R.layout.list_item_drag_and_drop_shop, parent, false);
			holder = new ViewHolder();
			holder.image = (ImageView) convertView
					.findViewById(R.id.list_item_drag_and_drop_shop_image);
			holder.productName = (TextView) convertView
					.findViewById(R.id.list_item_drag_and_drop_shop_product_name);
			holder.oldPrice = (TextView) convertView
					.findViewById(R.id.list_item_drag_and_drop_shop_old_price);
			holder.price = (TextView) convertView
					.findViewById(R.id.list_item_drag_and_drop_shop_price);
			holder.sellerName = (TextView) convertView
					.findViewById(R.id.list_item_drag_and_drop_shop_seller_name);
			holder.shipping = (TextView) convertView
					.findViewById(R.id.list_item_drag_and_drop_shop_shipping);
			holder.icon = (TextView) convertView
					.findViewById(R.id.list_item_drag_and_drop_shop_icon);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		DummyModel dm = mDummyModelList.get(position);
		
		ImageUtil.displayImage(holder.image, dm.getImageURL(), null);
		
		holder.productName.setText(dm.getText());
		
		return convertView;
	}

	private static class ViewHolder {
		public ImageView image;
		public/* Roboto */TextView productName;
		public/* Roboto */TextView oldPrice;
		public/* Roboto */TextView price;
		public/* Roboto */TextView sellerName;
		public/* Roboto */TextView shipping;
		public/* Material */TextView icon;
	}
}
