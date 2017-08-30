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
import com.csform.android.uiapptemplate.WizardMediaActivity;
import com.csform.android.uiapptemplate.WizardShopActivity;
import com.csform.android.uiapptemplate.WizardSocialActivity;
import com.csform.android.uiapptemplate.WizardTravelActivity;
import com.csform.android.uiapptemplate.WizardUniversalActivity;
import com.csform.android.uiapptemplate.adapter.SubcategoryAdapter;

public class WizardFragment extends Fragment implements OnItemClickListener {

	public static final String WIZARD_TRAVEL = "Travel wizard";
	public static final String WIZARD_MEDIA = "Media wizard";
	public static final String WIZARD_SHOP = "Shop wizard";
	public static final String WIZARD_SOCIAL = "Social wizard";
	public static final String WIZARD_SHOPPING = "Shopping wizard";
	public static final String WIZARD_NEWS = "News wizard";
	public static final String WIZARD_UNIVERSAL = "Universal wizard";

	private ListView mListView;
	private List<String> mWizards;

	public static WizardFragment newInstance() {
		return new WizardFragment();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mWizards = new ArrayList<String>();
		mWizards.add(WIZARD_MEDIA);
		mWizards.add(WIZARD_SHOP);
		mWizards.add(WIZARD_SOCIAL);
		mWizards.add(WIZARD_TRAVEL);
		mWizards.add(WIZARD_UNIVERSAL);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_left_menus,
				container, false);

		mListView = (ListView) rootView.findViewById(R.id.list_view);
		mListView.setAdapter(new SubcategoryAdapter(getActivity(), mWizards));
		mListView.setOnItemClickListener(this);

		return rootView;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent;
		String leftMenu = mWizards.get(position);
		if (WIZARD_TRAVEL.equals(leftMenu)) {
			intent = new Intent(getActivity(), WizardTravelActivity.class);
		} else if (WIZARD_MEDIA.equals(leftMenu)) {
			intent = new Intent(getActivity(), WizardMediaActivity.class);
		} else if (WIZARD_SHOP.equals(leftMenu)) {
			intent = new Intent(getActivity(), WizardShopActivity.class);
		} else if (WIZARD_SOCIAL.equals(leftMenu)) {
			intent = new Intent(getActivity(), WizardSocialActivity.class);
		} else {
			intent = new Intent(getActivity(), WizardUniversalActivity.class);
		}
		startActivity(intent);
	}
}
