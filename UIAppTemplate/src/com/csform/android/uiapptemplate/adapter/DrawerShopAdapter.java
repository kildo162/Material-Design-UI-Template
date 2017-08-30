package com.csform.android.uiapptemplate.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.csform.android.uiapptemplate.R;
import com.csform.android.uiapptemplate.model.DummyModel;
import com.csform.android.uiapptemplate.util.DummyContent;

public class DrawerShopAdapter extends BaseAdapter {
	
	private Context mContext;
	private List<DummyModel> mDrawerItems;
	private LayoutInflater mInflater;

	public DrawerShopAdapter(Context context) {
		mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mDrawerItems = DummyContent.getDrawerShopDummyList();
		mContext = context;
	}

	@Override
	public int getCount() {
		return mDrawerItems.size();
	}

	@Override
	public Object getItem(int position) {
		return mDrawerItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return mDrawerItems.get(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(
					R.layout.list_view_item_navigation_drawer_shop, parent,
					false);
			holder = new ViewHolder();
			holder.icon = (TextView) convertView
					.findViewById(R.id.list_item_navigation_drawer_shop_icon);
			holder.title = (TextView) convertView.findViewById(R.id.list_item_navigation_drawer_shop_title);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		DummyModel item = mDrawerItems.get(position);
		holder.icon.setText(mContext.getString(item.getIconRes()));
		holder.title.setText(item.getText());

		return convertView;
	}

	private static class ViewHolder {
		public TextView icon;
		public/* Roboto */TextView title;
	}
}
