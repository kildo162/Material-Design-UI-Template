package com.csform.android.uiapptemplate;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.csform.android.uiapptemplate.util.ImageUtil;
import com.csform.android.uiapptemplate.view.AnimatedExpandableListView;
import com.csform.android.uiapptemplate.view.AnimatedExpandableListView.AnimatedExpandableListAdapter;

public class ExpandableShopListViewActivity extends AppCompatActivity {

	private AnimatedExpandableListView listView;
	private ExampleAdapter adapter;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_expandable_list_view_shop);

		List<GroupItem> items = new ArrayList<GroupItem>();
		items = fillData(items);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setTitle("Expandable shop");

		adapter = new ExampleAdapter(this);
		adapter.setData(items);

		listView = (AnimatedExpandableListView) findViewById(R.id.list_view);
		listView.setDividerHeight(0);
		listView.setAdapter(adapter);

		// In order to show animations, we need to use a custom click handler
		// for our ExpandableListView.
		listView.setOnGroupClickListener(new OnGroupClickListener() {

			@Override
			public boolean onGroupClick(ExpandableListView parent, View v,
					int groupPosition, long id) {
				// We call collapseGroupWithAnimation(int) and
				// expandGroupWithAnimation(int) to animate group
				// expansion/collapse.
				if (listView.isGroupExpanded(groupPosition)) {
					listView.collapseGroupWithAnimation(groupPosition);
				} else {
					listView.expandGroupWithAnimation(groupPosition);
				}
				return true;
			}

		});

		// Set indicator (arrow) to the right
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int width = size.x;
		Resources r = getResources();
		int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
				50, r.getDisplayMetrics());
		if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
			listView.setIndicatorBounds(width - px, width);
		} else {
			listView.setIndicatorBoundsRelative(width - px, width);
		}

	}

	private static class GroupItem {
		String title;
		String imageUrl;
		List<ChildItem> items = new ArrayList<ChildItem>();
	}

	private static class ChildItem {
		String title;
	}

	private static class ChildHolder {
		TextView title;
		LinearLayout layout;
	//	TextView icon;
	}

	private static class GroupHolder {
		TextView title;
		ImageView image;
		TextView button;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private List<GroupItem> fillData(List<GroupItem> items) {
		GroupItem item = new GroupItem();
		item.title = "Product1";
		item.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/shop/1.jpg";
		ChildItem child;
		child = new ChildItem();
		child.title = "Pay with paypal";
		item.items.add(child);

		child = new ChildItem();
		child.title = "Pay with Visa card";
		item.items.add(child);

		child = new ChildItem();
		child.title = "Pay with maestero card";
		item.items.add(child);

		items.add(item);

		item = new GroupItem();
		item.title = "Product2";
		item.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/shop/2.jpg";
		child = new ChildItem();
		child.title = "Pay with paypal";
		item.items.add(child);

		child = new ChildItem();
		child.title = "Pay with Visa card";
		item.items.add(child);

		child = new ChildItem();
		child.title = "Pay with maestero card";
		item.items.add(child);

		items.add(item);

		item = new GroupItem();
		item.title = "Product3";
		item.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/shop/3.jpg";
		child = new ChildItem();
		child.title = "Pay with paypal";
		item.items.add(child);

		child = new ChildItem();
		child.title = "Pay with Visa card";
		item.items.add(child);

		child = new ChildItem();
		child.title = "Pay with maestero card";
		item.items.add(child);

		items.add(item);

		item = new GroupItem();
		item.title = "Product4";
		item.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/shop/4.jpg";
		child = new ChildItem();
		child.title = "Pay with paypal";
		item.items.add(child);

		child = new ChildItem();
		child.title = "Pay with Visa card";
		item.items.add(child);

		child = new ChildItem();
		child.title = "Pay with maestero card";
		item.items.add(child);

		items.add(item);

		return items;
	}

	private class ExampleAdapter extends AnimatedExpandableListAdapter
			implements OnClickListener {
		private LayoutInflater inflater;

		private List<GroupItem> items;

		public ExampleAdapter(Context context) {
			inflater = LayoutInflater.from(context);
		}

		public void setData(List<GroupItem> items) {
			this.items = items;
		}

		@Override
		public ChildItem getChild(int groupPosition, int childPosition) {
			return items.get(groupPosition).items.get(childPosition);
		}

		@Override
		public long getChildId(int groupPosition, int childPosition) {
			return childPosition;
		}

		@Override
		public View getRealChildView(int groupPosition, int childPosition,
				boolean isLastChild, View convertView, ViewGroup parent) {
			ChildHolder holder;
			ChildItem item = getChild(groupPosition, childPosition);
			if (convertView == null) {
				holder = new ChildHolder();
				convertView = inflater
						.inflate(R.layout.list_item_expandable_shop_child,
								parent, false);
				holder.title = (TextView) convertView
						.findViewById(R.id.list_item_expandable_shop_child_title);
				holder.layout = (LinearLayout) convertView
						.findViewById(R.id.list_item_expandable_shop_child_layout);
				holder.layout.setOnClickListener(this);
	//			holder.icon = (TextView) convertView
	//					.findViewById(R.id.list_item_expandable_shop_child_icon);
	//			holder.icon.setOnClickListener(this);
				convertView.setTag(holder);
			} else {
				holder = (ChildHolder) convertView.getTag();
			}
	//		holder.icon.setTag(childPosition);
			holder.layout.setTag(childPosition);
			holder.title.setText(item.title.toUpperCase());

			return convertView;
		}

		@Override
		public int getRealChildrenCount(int groupPosition) {
			return items.get(groupPosition).items.size();
		}

		@Override
		public GroupItem getGroup(int groupPosition) {
			return items.get(groupPosition);
		}

		@Override
		public int getGroupCount() {
			return items.size();
		}

		@Override
		public long getGroupId(int groupPosition) {
			return groupPosition;
		}

		@Override
		public View getGroupView(int groupPosition, boolean isExpanded,
				View convertView, ViewGroup parent) {
			GroupHolder holder;
			GroupItem item = getGroup(groupPosition);
			if (convertView == null) {
				holder = new GroupHolder();
				convertView = inflater.inflate(
						R.layout.list_item_expandable_shop, parent, false);
				holder.title = (TextView) convertView
						.findViewById(R.id.list_item_expandable_shop_title);
				holder.button = (TextView) convertView
						.findViewById(R.id.list_item_expandable_shop_button);
				holder.image = (ImageView) convertView
						.findViewById(R.id.list_item_expandable_shop_image);
				holder.button.setOnClickListener(this);
				convertView.setTag(holder);
			} else {
				holder = (GroupHolder) convertView.getTag();
			}
			holder.button.setTag(groupPosition);
			ImageUtil.displayImage(holder.image, item.imageUrl, null);
			holder.title.setText(item.title);

			return convertView;
		}

		@Override
		public boolean hasStableIds() {
			return true;
		}

		@Override
		public boolean isChildSelectable(int arg0, int arg1) {
			return true;
		}

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

			int position = (Integer) v.getTag();
			switch (v.getId()) {
			case R.id.list_item_expandable_shop_button:
				// click on explore button
				Toast.makeText(getApplicationContext(), "BUY " + position,
						Toast.LENGTH_SHORT).show();
				break;
			case R.id.list_item_expandable_shop_child_layout:
				// click on explore button
				Toast.makeText(getApplicationContext(),
						"Pay option:  " + position, Toast.LENGTH_SHORT).show();
				break;
			}
		}
	}
}
