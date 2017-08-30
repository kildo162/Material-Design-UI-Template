/*
 * Copyright (C) 2013 Andreas Stuetz <andreas.stuetz@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.csform.android.uiapptemplate;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.Toast;

import com.csform.android.uiapptemplate.fragment.TabMediaFragment;
import com.csform.android.uiapptemplate.fragment.TabShopFragment;
import com.csform.android.uiapptemplate.fragment.TabSocialFragment;
import com.csform.android.uiapptemplate.fragment.TabTravelFragment;
import com.csform.android.uiapptemplate.fragment.TabUniversalFragment;
import com.csform.android.uiapptemplate.util.ImageUtil;
import com.csform.android.uiapptemplate.view.PagerSlidingTabStrip;

public class TabTravelActivity extends AppCompatActivity {

	private MyPagerAdapter adapter;
	private PagerSlidingTabStrip tabs;
	private ViewPager pager;
	private ImageView image;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab_travel);

		tabs = (PagerSlidingTabStrip) findViewById(R.id.activity_tab_travel_tabs);
		pager = (ViewPager) findViewById(R.id.activity_tab_travel_pager);
		image = (ImageView) findViewById(R.id.activity_tab_travel_image);
		ImageUtil.displayImage(image, "http://pengaja.com/uiapptemplate/newphotos/listviews/swipetodissmiss/travel/1.jpg", null);
		
		adapter = new MyPagerAdapter(getSupportFragmentManager());
		pager.setAdapter(adapter);
		tabs.setViewPager(pager);
		final int pageMargin = (int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 4, getResources()
						.getDisplayMetrics());
		pager.setPageMargin(pageMargin);
		pager.setCurrentItem(3);

		tabs.setOnTabReselectedListener(new PagerSlidingTabStrip.OnTabReselectedListener() {
			@Override
			public void onTabReselected(int position) {
				Toast.makeText(TabTravelActivity.this,
						"Tab reselected: " + position, Toast.LENGTH_SHORT)
						.show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
	}

	public class MyPagerAdapter extends FragmentPagerAdapter {

		private final ArrayList<String> tabNames = new ArrayList<String>() {
			{
				add("Media");
				add("Shop");
				add("Social");
				add("Travel");
				add("Universal");
			}
		};

		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return tabNames.get(position);
		}

		@Override
		public int getCount() {
			return tabNames.size();
		}

		@Override
		public Fragment getItem(int position) {
			if (position == 0) {
				return TabMediaFragment.newInstance(position);
			} else if (position == 1) {
				return TabShopFragment.newInstance(position);
			} else if (position == 2) {
				return TabSocialFragment.newInstance(position);
			} else if (position == 3) {
				return TabTravelFragment.newInstance(position);
			} else {
				return TabUniversalFragment.newInstance(position);
			}
		}
	}
}