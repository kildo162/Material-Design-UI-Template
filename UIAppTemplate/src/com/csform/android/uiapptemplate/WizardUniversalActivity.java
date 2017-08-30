package com.csform.android.uiapptemplate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.csform.android.uiapptemplate.fragment.WizardUniversalFragment;

public class WizardUniversalActivity extends AppCompatActivity {

	private MyPagerAdapter adapter;
	private ViewPager pager;
	private TextView previousButton;
	private TextView nextButton;
	private TextView navigator;
	private int currentItem;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wizard_universal);

		currentItem = 0;

		pager = (ViewPager) findViewById(R.id.activity_wizard_universal_pager);
		previousButton = (TextView) findViewById(R.id.activity_wizard_universal_previous);
		nextButton = (TextView) findViewById(R.id.activity_wizard_universal_next);
		navigator = (TextView) findViewById(R.id.activity_wizard_universal_possition);

		adapter = new MyPagerAdapter(getSupportFragmentManager());
		pager.setAdapter(adapter);
		pager.setCurrentItem(currentItem);

		setNavigator();

		pager.addOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int position) {
				// TODO Auto-generated method stub
				setNavigator();
			}
		});

		previousButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/*if (pager.getCurrentItem() != 0) {
					pager.setCurrentItem(pager.getCurrentItem() - 1);
				}
				setNavigator();*/
				Toast.makeText(WizardUniversalActivity.this, "Skip",
						Toast.LENGTH_SHORT).show();
			}
		});

		nextButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (pager.getCurrentItem() != (pager.getAdapter().getCount() - 1)) {
					pager.setCurrentItem(pager.getCurrentItem() + 1);
				} else {
					Toast.makeText(WizardUniversalActivity.this, "Finish",
							Toast.LENGTH_SHORT).show();
				}
				setNavigator();
			}
		});

	}

	public void setNavigator() {
		String navigation = "";
		for (int i = 0; i < adapter.getCount(); i++) {
			if (i == pager.getCurrentItem()) {
				navigation += getString(R.string.material_icon_point_full)
						+ "  ";
			} else {
				navigation += getString(R.string.material_icon_point_empty)
						+ "  ";
			}
		}
		navigator.setText(navigation);
	}

	public void setCurrentSlidePosition(int position) {
		this.currentItem = position;
	}

	public int getCurrentSlidePosition() {
		return this.currentItem;
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

		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return null;
		}

		@Override
		public int getCount() {
			return 3;
		}

		@Override
		public Fragment getItem(int position) {
			if (position == 0) {
				return WizardUniversalFragment.newInstance(position);
			} else if (position == 1) {
				return WizardUniversalFragment.newInstance(position);
			} else {
				return WizardUniversalFragment.newInstance(position);
			}
		}
	}
}