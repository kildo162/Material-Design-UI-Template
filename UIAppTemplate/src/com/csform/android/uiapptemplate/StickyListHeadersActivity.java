/*
 * Copyright 2014 Niek Haarman
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.csform.android.uiapptemplate;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.csform.android.uiapptemplate.adapter.MyStickyListHeadersAdapter;
import com.csform.android.uiapptemplate.adapter.MyStickyListHeadersMediaAdapter;
import com.csform.android.uiapptemplate.adapter.MyStickyListHeadersShopAdapter;
import com.csform.android.uiapptemplate.adapter.MyStickyListHeadersSocialAdapter;
import com.csform.android.uiapptemplate.adapter.MyStickyListHeadersTravelAdapter;
import com.csform.android.uiapptemplate.util.DummyContent;
import com.nhaarman.listviewanimations.appearance.StickyListHeadersAdapterDecorator;
import com.nhaarman.listviewanimations.appearance.simple.AlphaInAnimationAdapter;
import com.nhaarman.listviewanimations.util.StickyListHeadersListViewWrapper;

public class StickyListHeadersActivity extends AppCompatActivity {

	public static final String STICKY_LIST_HEADERS_TRAVEL = "sticky.list.headers.travel";
	public static final String STICKY_LIST_HEADERS_SOCIAL = "sticky.list.headers.social";
	public static final String STICKY_LIST_HEADERS_MEDIA = "sticky.list.headers.media";
	public static final String STICKY_LIST_HEADERS_SHOP = "sticky.list.headers.shop";
	public static final String STICKY_LIST_HEADERS_UNIVERSAL = "sticky.list.headers.universal";

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stickylistheaders);
		String category = "";
		Bundle extras = getIntent().getExtras();
		if (extras != null
				&& extras
						.containsKey(CategoriesListViewActivity.LIST_VIEW_OPTION_STICKI_LIST_HEADERS)) {
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
				category = extras
						.getString(
								CategoriesListViewActivity.LIST_VIEW_OPTION_STICKI_LIST_HEADERS,
								STICKY_LIST_HEADERS_UNIVERSAL);
			} else {
				category = extras
						.getString(CategoriesListViewActivity.LIST_VIEW_OPTION_STICKI_LIST_HEADERS);
			}
		}
		StickyListHeadersListView listView = (StickyListHeadersListView) findViewById(R.id.activity_stickylistheaders_listview);
		listView.setFitsSystemWindows(true);

		AlphaInAnimationAdapter animationAdapter;
		if (category.equals(STICKY_LIST_HEADERS_TRAVEL)) {
			MyStickyListHeadersTravelAdapter adapterTravel = new MyStickyListHeadersTravelAdapter(
					this);
			animationAdapter = new AlphaInAnimationAdapter(adapterTravel);
		} else if (category.equals(STICKY_LIST_HEADERS_SOCIAL)) {
			MyStickyListHeadersSocialAdapter adapterSocial = new MyStickyListHeadersSocialAdapter(
					this, DummyContent.getDummyModelList());
			animationAdapter = new AlphaInAnimationAdapter(adapterSocial);
		} else if (category.equals(STICKY_LIST_HEADERS_MEDIA)) {
			listView.setBackgroundResource(R.drawable.background_media);
			MyStickyListHeadersMediaAdapter adapterSocial = new MyStickyListHeadersMediaAdapter(
					this, DummyContent.getDummyModelList());
			animationAdapter = new AlphaInAnimationAdapter(adapterSocial);
		} else if (category.equals(STICKY_LIST_HEADERS_SHOP)) {
			listView.setBackgroundResource(R.drawable.background_shop);
			MyStickyListHeadersShopAdapter adapterSocial = new MyStickyListHeadersShopAdapter(
					this, DummyContent.getDummyModelDragAndDropShopList());
			animationAdapter = new AlphaInAnimationAdapter(adapterSocial);
		} else {
			MyStickyListHeadersAdapter adapter = new MyStickyListHeadersAdapter(
					this);
			animationAdapter = new AlphaInAnimationAdapter(adapter);
		}

		StickyListHeadersAdapterDecorator stickyListHeadersAdapterDecorator = new StickyListHeadersAdapterDecorator(
				animationAdapter);
		stickyListHeadersAdapterDecorator
				.setListViewWrapper(new StickyListHeadersListViewWrapper(
						listView));
		assert animationAdapter.getViewAnimator() != null;
		animationAdapter.getViewAnimator().setInitialDelayMillis(500);
		assert stickyListHeadersAdapterDecorator.getViewAnimator() != null;
		stickyListHeadersAdapterDecorator.getViewAnimator()
				.setInitialDelayMillis(500);
		listView.setAdapter(stickyListHeadersAdapterDecorator);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setTitle("Sticky list headers");
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}