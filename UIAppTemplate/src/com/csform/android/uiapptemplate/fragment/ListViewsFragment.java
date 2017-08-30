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

import com.csform.android.uiapptemplate.CategoriesListViewActivity;
import com.csform.android.uiapptemplate.R;
import com.csform.android.uiapptemplate.adapter.SubcategoryAdapter;

public class ListViewsFragment extends Fragment implements OnItemClickListener {

	private ListView mListView;
	private List<String> mListViews;

	public static ListViewsFragment newInstance() {
		return new ListViewsFragment();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mListViews = new ArrayList<String>();
		mListViews.add(CategoriesListViewActivity.LIST_VIEW_OPTION_EXPANDABLE);
		mListViews
				.add(CategoriesListViewActivity.LIST_VIEW_OPTION_DRAG_AND_DROP);
		mListViews
				.add(CategoriesListViewActivity.LIST_VIEW_OPTION_SWIPE_TO_DISSMISS);
		mListViews
				.add(CategoriesListViewActivity.LIST_VIEW_OPTION_APPEARANCE_ANIMIATIONS);
		mListViews
				.add(CategoriesListViewActivity.LIST_VIEW_OPTION_STICKI_LIST_HEADERS);
		mListViews
				.add(CategoriesListViewActivity.LIST_VIEW_OPTION_GOOGLE_CARDS);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_list_views,
				container, false);

		mListView = (ListView) rootView.findViewById(R.id.list_view);
		mListView.setAdapter(new SubcategoryAdapter(getActivity(), mListViews));
		mListView.setOnItemClickListener(this);

		return rootView;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent = new Intent(getActivity(),
				CategoriesListViewActivity.class);

		if (position == 5) {
			intent.putExtra(
					CategoriesListViewActivity.LIST_VIEW_CATEGORY_GOOGLE_CARDS,
					mListViews.get(position));
		} else if (position == 4) {
			intent.putExtra(
					CategoriesListViewActivity.LIST_VIEW_CATEGORY_STICKY_HEADER,
					mListViews.get(position));
		} else if (position == 0) {
			intent.putExtra(
					CategoriesListViewActivity.LIST_VIEW_CATEGORY_EXPANDABLES,
					mListViews.get(position));
		} else if (position == 1) {
			intent.putExtra(
					CategoriesListViewActivity.LIST_VIEW_CATEGORY_DRAG_AND_DROP,
					mListViews.get(position));
		} else if (position == 2) {
			intent.putExtra(
					CategoriesListViewActivity.LIST_VIEW_CATEGORY_SWIPE_TO_DISSMISS,
					mListViews.get(position));
		} else if (position == 3) {
			intent.putExtra(
					CategoriesListViewActivity.LIST_VIEW_CATEGORY_APPEARANCE_ANIMATIONS,
					mListViews.get(position));
		} else {
		}
		startActivity(intent);
	}
}
