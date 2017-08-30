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

import com.csform.android.uiapptemplate.DialogMediaActivity;
import com.csform.android.uiapptemplate.DialogShopActivity;
import com.csform.android.uiapptemplate.DialogSocialActivity;
import com.csform.android.uiapptemplate.DialogTravelActivity;
import com.csform.android.uiapptemplate.DialogUniversalInfoActivity;
import com.csform.android.uiapptemplate.DialogUniversalWarningActivity;
import com.csform.android.uiapptemplate.R;
import com.csform.android.uiapptemplate.adapter.SubcategoryAdapter;

public class DialogFragment extends Fragment implements OnItemClickListener {

	public static final String DIALOG_TRAVEL = "Travel dialog";
	public static final String DIALOG_MEDIA = "Media dialog";
	public static final String DIALOG_SHOP = "Shop dialog";
	public static final String DIALOG_SOCIAL = "Social dialog";
	public static final String DIALOG_SHOPPING = "Shopping dialog";
	public static final String DIALOG_NEWS = "News dialog";
	public static final String DIALOG_UNIVERSAL_INFO = "Universal info dialog";
	public static final String DIALOG_UNIVERSAL_WARNING = "Universal warning dialog";

	private ListView mListView;
	private List<String> mDialogs;

	public static DialogFragment newInstance() {
		return new DialogFragment();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mDialogs = new ArrayList<String>();
		mDialogs.add(DIALOG_MEDIA);
		mDialogs.add(DIALOG_SHOP);
		mDialogs.add(DIALOG_SOCIAL);
		mDialogs.add(DIALOG_TRAVEL);
		mDialogs.add(DIALOG_UNIVERSAL_INFO);
		mDialogs.add(DIALOG_UNIVERSAL_WARNING);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_left_menus,
				container, false);

		mListView = (ListView) rootView.findViewById(R.id.list_view);
		mListView.setAdapter(new SubcategoryAdapter(getActivity(), mDialogs));
		mListView.setOnItemClickListener(this);

		return rootView;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent;
		String leftMenu = mDialogs.get(position);
		if (DIALOG_TRAVEL.equals(leftMenu)) {
			intent = new Intent(getActivity(), DialogTravelActivity.class);
		} else if (DIALOG_MEDIA.equals(leftMenu)) {
			intent = new Intent(getActivity(), DialogMediaActivity.class);
		} else if (DIALOG_SHOP.equals(leftMenu)) {
			intent = new Intent(getActivity(), DialogShopActivity.class);
		} else if (DIALOG_SOCIAL.equals(leftMenu)) {
			intent = new Intent(getActivity(), DialogSocialActivity.class);
		} else if (DIALOG_UNIVERSAL_WARNING.equals(leftMenu)) {
			intent = new Intent(getActivity(), DialogUniversalWarningActivity.class);
		} else {
			intent = new Intent(getActivity(), DialogUniversalInfoActivity.class);
		}
		startActivity(intent);
	}
}
