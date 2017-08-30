package com.csform.android.uiapptemplate.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.csform.android.uiapptemplate.R;

public class TabSocialFragment extends Fragment implements OnClickListener {

	private static final String ARG_POSITION = "position";

	private TextView mLike;
	private TextView mFavorite;
	private TextView mShare;

	private int position;

	public static TabSocialFragment newInstance(int position) {
		TabSocialFragment f = new TabSocialFragment();
		Bundle b = new Bundle();
		b.putInt(ARG_POSITION, position);
		f.setArguments(b);
		return f;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		position = getArguments().getInt(ARG_POSITION);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_tab_social,
				container, false);
		mLike = (TextView) rootView
				.findViewById(R.id.fragment_tab_social_like);
		mFavorite = (TextView) rootView
				.findViewById(R.id.fragment_tab_social_favorite);
		mShare = (TextView) rootView
				.findViewById(R.id.fragment_tab_social_share);
		
		mLike.setOnClickListener(this);
		mFavorite.setOnClickListener(this);
		mShare.setOnClickListener(this);
		ViewCompat.setElevation(rootView, 50);
		return rootView;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.fragment_tab_social_like:
			Toast.makeText(getActivity(), "Like social", Toast.LENGTH_SHORT).show();
			break;
		case R.id.fragment_tab_social_favorite:
			Toast.makeText(getActivity(), "Favorite social", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.fragment_tab_social_share:
			Toast.makeText(getActivity(), "Share social", Toast.LENGTH_SHORT).show();
			break;
		}
	}
}