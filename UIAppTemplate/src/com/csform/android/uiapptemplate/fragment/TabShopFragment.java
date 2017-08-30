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

package com.csform.android.uiapptemplate.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.csform.android.uiapptemplate.R;
import com.csform.android.uiapptemplate.util.ImageUtil;

public class TabShopFragment extends Fragment implements OnClickListener {

	private static final String ARG_POSITION = "position";

	private TextView mLike;
	private TextView mFavorite;
	private TextView mShare;

	private int position;

	public static TabShopFragment newInstance(int position) {
		TabShopFragment f = new TabShopFragment();
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
		View rootView = inflater.inflate(R.layout.fragment_tab_shop, container,
				false);
		ImageView image = (ImageView) rootView
				.findViewById(R.id.fragment_shop_image);
		mLike = (TextView) rootView
				.findViewById(R.id.fragment_tab_shop_like);
		mFavorite = (TextView) rootView
				.findViewById(R.id.fragment_tab_shop_favorite);
		mShare = (TextView) rootView
				.findViewById(R.id.fragment_tab_shop_share);
		ViewCompat.setElevation(rootView, 50);
		ImageUtil.displayImage(image,
				"http://pengaja.com/uiapptemplate/newphotos/shop/0.jpg", null);
		
		mLike.setOnClickListener(this);
		mFavorite.setOnClickListener(this);
		mShare.setOnClickListener(this);
		return rootView;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.fragment_tab_shop_like:
			Toast.makeText(getActivity(), "Like shop", Toast.LENGTH_SHORT).show();
			break;
		case R.id.fragment_tab_shop_favorite:
			Toast.makeText(getActivity(), "Favorite shop", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.fragment_tab_shop_share:
			Toast.makeText(getActivity(), "Share shop", Toast.LENGTH_SHORT).show();
			break;
		}
	}
}