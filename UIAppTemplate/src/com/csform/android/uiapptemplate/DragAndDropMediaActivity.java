package com.csform.android.uiapptemplate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Toast;

import com.csform.android.uiapptemplate.adapter.DragAndDropMediaAdapter;
import com.csform.android.uiapptemplate.util.DummyContent;
import com.nhaarman.listviewanimations.itemmanipulation.DynamicListView;
import com.nhaarman.listviewanimations.itemmanipulation.dragdrop.TouchViewDraggableManager;

public class DragAndDropMediaActivity extends AppCompatActivity {

	public static final String LIST_VIEW_OPTION = "com.csform.android.uiapptemplate.DragAndDropMediaActivity";

	private DynamicListView mDynamicListView;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drag_and_drop_media);
		
		mDynamicListView = (DynamicListView) findViewById(R.id.activity_list_view_drag_and_drop_dynamic_listview);
		mDynamicListView.setDividerHeight(0);

		setUpDragAndDrop();
		Toast.makeText(this, "Long press an item to start dragging",
				Toast.LENGTH_SHORT).show();

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setTitle("Drag and Drop Media");
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void setUpDragAndDrop() {
		final DragAndDropMediaAdapter adapter = new DragAndDropMediaAdapter(
				this, DummyContent.getDummyModelDragAndDropTravelList());
		mDynamicListView.setAdapter(adapter);
		mDynamicListView.enableDragAndDrop();
		TouchViewDraggableManager tvdm = new TouchViewDraggableManager(
				R.id.icon);
		mDynamicListView.setDraggableManager(tvdm);
		mDynamicListView
				.setOnItemLongClickListener(new OnItemLongClickListener() {

					@Override
					public boolean onItemLongClick(AdapterView<?> parent,
							View view, int position, long id) {
						mDynamicListView.startDragging(position);
						return true;
					}
				});
	}
}
