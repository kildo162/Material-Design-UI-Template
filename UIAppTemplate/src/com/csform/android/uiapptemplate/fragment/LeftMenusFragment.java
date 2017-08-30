package com.csform.android.uiapptemplate.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.csform.android.uiapptemplate.LeftMenusActivity;
import com.csform.android.uiapptemplate.LeftMenusMediaActivity;
import com.csform.android.uiapptemplate.LeftMenusShopActivity;
import com.csform.android.uiapptemplate.LeftMenusSocialActivity;
import com.csform.android.uiapptemplate.LeftMenusTravelActivity;
import com.csform.android.uiapptemplate.R;
import com.csform.android.uiapptemplate.adapter.SubcategoryAdapter;

public class LeftMenusFragment extends Fragment implements OnItemClickListener {

	private ListView mListView;
	private List<String> mLeftMenus;

	public static LeftMenusFragment newInstance() {
		return new LeftMenusFragment();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mLeftMenus = new ArrayList<String>();
		mLeftMenus.add(LeftMenusActivity.LEFT_MENU_TRAVEL);
		mLeftMenus.add(LeftMenusActivity.LEFT_MENU_MEDIA);
		mLeftMenus.add(LeftMenusActivity.LEFT_MENU_SHOP);
		mLeftMenus.add(LeftMenusActivity.LEFT_MENU_SOCIAL);
		mLeftMenus.add(LeftMenusActivity.LEFT_MENU_OPTION_1);
		mLeftMenus.add(LeftMenusActivity.LEFT_MENU_OPTION_2);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_left_menus,
				container, false);

		mListView = (ListView) rootView.findViewById(R.id.list_view);
		mListView.setAdapter(new SubcategoryAdapter(getActivity(), mLeftMenus));
		mListView.setOnItemClickListener(this);

		return rootView;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent;
		String leftMenu = mLeftMenus.get(position);
		if (LeftMenusActivity.LEFT_MENU_TRAVEL.equals(leftMenu)) {
			intent = new Intent(getActivity(), LeftMenusTravelActivity.class);
		} else if (LeftMenusActivity.LEFT_MENU_MEDIA.equals(leftMenu)) {
			intent = new Intent(getActivity(), LeftMenusMediaActivity.class);
		} else if (LeftMenusActivity.LEFT_MENU_SHOP.equals(leftMenu)) {
			intent = new Intent(getActivity(), LeftMenusShopActivity.class);
		} else if (LeftMenusActivity.LEFT_MENU_SOCIAL.equals(leftMenu)) {
			intent = new Intent(getActivity(), LeftMenusSocialActivity.class);
		} else {
			intent = new Intent(getActivity(), LeftMenusActivity.class);
		}
		intent.putExtra(LeftMenusActivity.LEFT_MENU_OPTION, leftMenu);
		startActivity(intent);
	}
}
