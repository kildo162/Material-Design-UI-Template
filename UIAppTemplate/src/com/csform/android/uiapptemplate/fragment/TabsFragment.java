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

import com.csform.android.uiapptemplate.R;
import com.csform.android.uiapptemplate.TabMediaActivity;
import com.csform.android.uiapptemplate.TabShopActivity;
import com.csform.android.uiapptemplate.TabSocialActivity;
import com.csform.android.uiapptemplate.TabTravelActivity;
import com.csform.android.uiapptemplate.TabUniversalActivity;
import com.csform.android.uiapptemplate.adapter.SubcategoryAdapter;

public class TabsFragment extends Fragment implements OnItemClickListener {

	public static final String TABS_TRAVEL = "Travel tabs";
	public static final String TABS_MEDIA = "Media tabs";
	public static final String TABS_SHOP = "Shop tabs";
	public static final String TABS_SOCIAL = "Social tabs";
	public static final String TABS_NEWS = "News tabs";
	public static final String TABS_UNIVERSAL = "Universal tabs";

	private ListView mListView;
	private List<String> mTabs;

	public static TabsFragment newInstance() {
		return new TabsFragment();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mTabs = new ArrayList<String>();
		mTabs.add(TABS_MEDIA);
		mTabs.add(TABS_SHOP);
		mTabs.add(TABS_SOCIAL);
		mTabs.add(TABS_TRAVEL);
		mTabs.add(TABS_UNIVERSAL);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_left_menus,
				container, false);

		mListView = (ListView) rootView.findViewById(R.id.list_view);
		mListView.setAdapter(new SubcategoryAdapter(getActivity(), mTabs));
		mListView.setOnItemClickListener(this);

		return rootView;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent;
		String leftMenu = mTabs.get(position);
		if(TABS_MEDIA.equals(leftMenu)){
			intent = new Intent(getActivity(), TabMediaActivity.class);
		} else if (TABS_SHOP.equals(leftMenu)) {
			intent = new Intent(getActivity(), TabShopActivity.class);
		} else if (TABS_SOCIAL.equals(leftMenu)) {
			intent = new Intent(getActivity(), TabSocialActivity.class);
		} else if (TABS_TRAVEL.equals(leftMenu)) {
			intent = new Intent(getActivity(), TabTravelActivity.class);
		} else{
			intent = new Intent(getActivity(), TabUniversalActivity.class);
		}
		startActivity(intent);
	}
}
