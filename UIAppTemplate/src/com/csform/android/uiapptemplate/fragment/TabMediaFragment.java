package com.csform.android.uiapptemplate.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.csform.android.uiapptemplate.R;
import com.csform.android.uiapptemplate.util.ImageUtil;

public class TabMediaFragment extends Fragment implements OnClickListener {

	private static final String ARG_POSITION = "position";

	private TextView mLike;
	private TextView mFavorite;
	private TextView mShare;

	private int position;

	public static TabMediaFragment newInstance(int position) {
		TabMediaFragment f = new TabMediaFragment();
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
		View rootView = inflater.inflate(R.layout.fragment_tab_media,
				container, false);
		ImageView image = (ImageView) rootView
				.findViewById(R.id.fragment_tab_media_image);
		mLike = (TextView) rootView
				.findViewById(R.id.fragment_tab_media_like);
		mFavorite = (TextView) rootView
				.findViewById(R.id.fragment_tab_media_favorite);
		mShare = (TextView) rootView
				.findViewById(R.id.fragment_tab_media_share);
		ViewCompat.setElevation(rootView, 50);
		ImageUtil
				.displayImage(
						image,
						"http://pengaja.com/uiapptemplate/newphotos/profileimages/0.jpg",
						null);

		mLike.setOnClickListener(this);
		mFavorite.setOnClickListener(this);
		mShare.setOnClickListener(this);
		return rootView;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.fragment_tab_media_like:
			Toast.makeText(getActivity(), "Like media", Toast.LENGTH_SHORT).show();
			break;
		case R.id.fragment_tab_media_favorite:
			Toast.makeText(getActivity(), "Favorite media", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.fragment_tab_media_share:
			Toast.makeText(getActivity(), "Share media", Toast.LENGTH_SHORT).show();
			break;
		}
	}
}