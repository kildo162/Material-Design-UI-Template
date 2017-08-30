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
import android.widget.TextView;
import android.widget.Toast;

import com.csform.android.uiapptemplate.util.ImageUtil;
import com.csform.android.uiapptemplate.view.AnimatedExpandableListView;
import com.csform.android.uiapptemplate.view.AnimatedExpandableListView.AnimatedExpandableListAdapter;

public class ExpandableMediaListViewActivity extends AppCompatActivity {

	private AnimatedExpandableListView listView;
	private ExampleAdapter adapter;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.support.v7.app.ActionBarActivity#onCreate(android.os.Bundle)
	 */
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_expandable_list_view);

		List<GroupItem> items = new ArrayList<GroupItem>();
		items = fillData(items);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setTitle("Expandable media");

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
		String subtitle;
		List<ChildItem> items = new ArrayList<ChildItem>();
	}

	private static class ChildItem {
		String title;
		String imageUrl;
	}

	private static class ChildHolder {
		TextView title;
		TextView publish;
		ImageView image;
		TextView iconPlay;
	}

	private static class GroupHolder {
		TextView title;
		ImageView image;
		TextView subtitle;
		TextView iconLike;
		TextView iconFavorite;
		TextView iconShare;
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
		item.title = "Artist1";
		item.subtitle = "singer";
		item.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/15.jpg";
		ChildItem child;
		child = new ChildItem();
		child.title = "AlbumName1";
		child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/10.jpg";
		item.items.add(child);

		child = new ChildItem();
		child.title = "AlbumName2";
		child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/11.jpg";
		item.items.add(child);

		child = new ChildItem();
		child.title = "AlbumName3";
		child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/12.jpg";
		item.items.add(child);

		child = new ChildItem();
		child.title = "AlbumName4";
		child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/13.jpg";
		item.items.add(child);

		items.add(item);

		item = new GroupItem();
		item.title = "Artist2";
		item.subtitle = "drummer";
		item.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/2.jpg";
		child = new ChildItem();
		child.title = "AlbumName1";
		child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/14.jpg";
		item.items.add(child);

		child = new ChildItem();
		child.title = "AlbumName2";
		child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/15.jpg";
		item.items.add(child);

		child = new ChildItem();
		child.title = "AlbumName3";
		child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/14.jpg";
		item.items.add(child);

		child = new ChildItem();
		child.title = "AlbumName4";
		child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/13.jpg";
		item.items.add(child);

		child = new ChildItem();
		child.title = "AlbumName5";
		child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/12.jpg";
		item.items.add(child);

		child = new ChildItem();
		child.title = "AlbumName6";
		child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/11.jpg";
		item.items.add(child);

		items.add(item);

		item = new GroupItem();
		item.title = "Artist3";
		item.subtitle = "guitarist";
		item.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/3.jpg";
		child = new ChildItem();
		child.title = "AlbumName1";
		child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/11.jpg";
		item.items.add(child);

		child = new ChildItem();
		child.title = "AlbumName2";
		child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/12.jpg";
		item.items.add(child);

		child = new ChildItem();
		child.title = "AlbumName3";
		child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/13.jpg";
		item.items.add(child);

		child = new ChildItem();
		child.title = "AlbumName4";
		child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/14.jpg";
		item.items.add(child);

		child = new ChildItem();
		child.title = "AlbumName5";
		child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/15.jpg";
		item.items.add(child);

		items.add(item);

		item = new GroupItem();
		item.title = "Artist4";
		item.subtitle = "basso";
		item.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/4.jpg";
		child = new ChildItem();
		child.title = "AlbumName1";
		child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/0.jpg";
		item.items.add(child);

		child = new ChildItem();
		child.title = "AlbumName2";
		child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/1.jpg";
		item.items.add(child);

		child = new ChildItem();
		child.title = "AlbumName3";
		child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/2.jpg";
		item.items.add(child);

		child = new ChildItem();
		child.title = "AlbumName4";
		child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/3.jpg";
		item.items.add(child);

		items.add(item);

		item = new GroupItem();
		item.title = "Artist5";
		item.subtitle = "singer";
		item.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/5.jpg";
		child = new ChildItem();
		child.title = "AlbumName1";
		child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/14.jpg";
		item.items.add(child);

		child = new ChildItem();
		child.title = "AlbumName2";
		child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/15.jpg";
		item.items.add(child);

		child = new ChildItem();
		child.title = "AlbumName3";
		child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/6.jpg";
		item.items.add(child);

		child = new ChildItem();
		child.title = "AlbumName4";
		child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/7.jpg";
		item.items.add(child);

		items.add(item);

		return items;
	}

	private class ExampleAdapter extends AnimatedExpandableListAdapter implements OnClickListener {
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
						R.layout.list_item_expandable_media_child, parent,
						false);
				holder.title = (TextView) convertView
						.findViewById(R.id.list_item_expandable_media_child_name);
				holder.publish = (TextView) convertView
						.findViewById(R.id.list_item_expandable_media_child_publish);
				holder.iconPlay = (TextView) convertView
						.findViewById(R.id.list_item_expandable_media_child_icon_play);
				holder.image = (ImageView) convertView
						.findViewById(R.id.list_item_expandable_media_child_image);
				holder.iconPlay.setOnClickListener(this);
				convertView.setTag(holder);
			} else {
				holder = (ChildHolder) convertView.getTag();
			}

			holder.title.setText(item.title);
			ImageUtil.displayImage(holder.image,
					item.imageUrl, null);
			holder.iconPlay.setTag(childPosition);
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
						R.layout.list_item_expandable_media, parent, false);
				holder.image = (ImageView) convertView
						.findViewById(R.id.list_item_expandable_media_image);
				holder.title = (TextView) convertView
						.findViewById(R.id.list_item_expandable_media_title);
				holder.subtitle = (TextView) convertView
						.findViewById(R.id.list_item_expandable_media_subtitle);
				holder.iconLike = (TextView) convertView
						.findViewById(R.id.list_item_expandable_media_like);
				holder.iconFavorite = (TextView) convertView
						.findViewById(R.id.list_item_expandable_media_favorite);
				holder.iconShare = (TextView) convertView
						.findViewById(R.id.list_item_expandable_media_share);
				holder.iconLike.setOnClickListener(this);
				holder.iconFavorite.setOnClickListener(this);
				holder.iconShare.setOnClickListener(this);
				convertView.setTag(holder);
			} else {
				holder = (GroupHolder) convertView.getTag();
			}

			holder.title.setText(item.title);
			holder.subtitle.setText(item.subtitle.toUpperCase());
			ImageUtil.displayImage(holder.image,
					item.imageUrl, null);
			holder.iconLike.setTag(groupPosition);
			holder.iconFavorite.setTag(groupPosition);
			holder.iconShare.setTag(groupPosition);
			

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
			int possition = (Integer) v.getTag();
			switch (v.getId()) {
			case R.id.list_item_expandable_media_like:
				// click on explore button
				Toast.makeText(getApplicationContext(), "Like " + possition, Toast.LENGTH_SHORT).show();
				break;
			case R.id.list_item_expandable_media_favorite:
				// click on explore button
				Toast.makeText(getApplicationContext(), "Favorite " + possition, Toast.LENGTH_SHORT).show();
				break;
			case R.id.list_item_expandable_media_share:
				// click on explore button
				Toast.makeText(getApplicationContext(), "Share " + possition, Toast.LENGTH_SHORT).show();
				break;
			case R.id.list_item_expandable_media_child_icon_play:
				// click on explore button
				Toast.makeText(getApplicationContext(), "Play AlbumName " + possition, Toast.LENGTH_SHORT).show();
				break;
			}
		}
	}
}
