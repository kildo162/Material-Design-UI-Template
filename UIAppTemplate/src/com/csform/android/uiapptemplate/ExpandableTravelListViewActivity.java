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
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.TextView;

import com.csform.android.uiapptemplate.view.AnimatedExpandableListView;
import com.csform.android.uiapptemplate.view.AnimatedExpandableListView.AnimatedExpandableListAdapter;

public class ExpandableTravelListViewActivity extends AppCompatActivity {

	private AnimatedExpandableListView listView;
	private ExampleAdapter adapter;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_expandable_list_view_travel);

		List<GroupItem> items = new ArrayList<GroupItem>();
		items = fillData(items);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setTitle("Expandable travel");

		adapter = new ExampleAdapter(this);
		adapter.setData(items);

		listView = (AnimatedExpandableListView) findViewById(R.id.activity_expandable_travel_list_view);
		View headerView = getLayoutInflater().inflate(
				R.layout.header_expandable_list_view_travel, listView, false);
		listView.addHeaderView(headerView);
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
		// Log.v("width", width + "");
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
		int icon;
		List<ChildItem> items = new ArrayList<ChildItem>();
	}

	private static class ChildItem {
		String title;
	}

	private static class ChildHolder {
		TextView title;
	}

	private static class GroupHolder {
		TextView title;
		TextView icon;
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
		item.title = "Where to go";
		item.icon = R.string.material_icon_go;
		ChildItem child;
		child = new ChildItem();
		child.title = "Monuments";
		item.items.add(child);

		child = new ChildItem();
		child.title = "Sightseeing";
		item.items.add(child);

		child = new ChildItem();
		child.title = "Historical";
		item.items.add(child);

		child = new ChildItem();
		child.title = "Sport";
		item.items.add(child);

		items.add(item);

		item = new GroupItem();
		item.title = "Where to sleep";
		item.icon = R.string.material_icon_sleep;
		child = new ChildItem();
		child.title = "Hotels";
		item.items.add(child);

		child = new ChildItem();
		child.title = "Hostels";
		item.items.add(child);

		child = new ChildItem();
		child.title = "Motels";
		item.items.add(child);

		child = new ChildItem();
		child.title = "Rooms";
		item.items.add(child);

		items.add(item);

		item = new GroupItem();
		item.title = "Where to eat";
		item.icon = R.string.material_icon_eat;
		child = new ChildItem();
		child.title = "Fast Food";
		item.items.add(child);

		child = new ChildItem();
		child.title = "Restorants";
		item.items.add(child);

		child = new ChildItem();
		child.title = "Pubs";
		item.items.add(child);

		child = new ChildItem();
		child.title = "Hotels";
		item.items.add(child);

		items.add(item);

		item = new GroupItem();
		item.title = "Where to drink";
		item.icon = R.string.material_icon_drink;
		child = new ChildItem();
		child.title = "Caffes";
		item.items.add(child);

		child = new ChildItem();
		child.title = "Bars";
		item.items.add(child);

		child = new ChildItem();
		child.title = "Pubs";
		item.items.add(child);

		child = new ChildItem();
		child.title = "Clubs";
		item.items.add(child);

		items.add(item);

		return items;
	}

	private class ExampleAdapter extends AnimatedExpandableListAdapter {
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
				convertView = inflater.inflate(
						R.layout.list_item_expandable_travel_child, parent,
						false);
				holder.title = (TextView) convertView
						.findViewById(R.id.textTitle);
				convertView.setTag(holder);
			} else {
				holder = (ChildHolder) convertView.getTag();
			}

			holder.title.setText(item.title);

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
						R.layout.list_item_expandable_travel, parent, false);
				holder.title = (TextView) convertView
						.findViewById(R.id.list_item_expandable_travel_textTitle);
				holder.icon = (TextView) convertView
						.findViewById(R.id.list_item_expandable_travel_icon);
				convertView.setTag(holder);
			} else {
				holder = (GroupHolder) convertView.getTag();
			}

			holder.title.setText(item.title);
			holder.icon.setText(item.icon);
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
	}
}
