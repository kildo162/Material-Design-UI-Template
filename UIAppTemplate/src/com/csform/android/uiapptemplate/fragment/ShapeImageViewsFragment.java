package com.csform.android.uiapptemplate.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.csform.android.uiapptemplate.R;
import com.csform.android.uiapptemplate.util.ImageUtil;

public class ShapeImageViewsFragment extends Fragment {

	public static ShapeImageViewsFragment newInstance() {
		return new ShapeImageViewsFragment();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_shape_image_views, container, false);
		// universal
		ImageUtil.displayImage((ImageView) rootView.findViewById(R.id.a), "http://pengaja.com/uiapptemplate/newphotos/shapeimageview.jpg", null);
		ImageUtil.displayImage((ImageView) rootView.findViewById(R.id.b), "http://pengaja.com/uiapptemplate/newphotos/shapeimageview.jpg", null);
		ImageUtil.displayImage((ImageView) rootView.findViewById(R.id.c), "http://pengaja.com/uiapptemplate/newphotos/shapeimageview.jpg", null);
		ImageUtil.displayImage((ImageView) rootView.findViewById(R.id.d), "http://pengaja.com/uiapptemplate/newphotos/shapeimageview.jpg", null);
		ImageUtil.displayImage((ImageView) rootView.findViewById(R.id.e), "http://pengaja.com/uiapptemplate/newphotos/shapeimageview.jpg", null);
		ImageUtil.displayImage((ImageView) rootView.findViewById(R.id.f), "http://pengaja.com/uiapptemplate/newphotos/shapeimageview.jpg", null);
		ImageUtil.displayImage((ImageView) rootView.findViewById(R.id.g), "http://pengaja.com/uiapptemplate/newphotos/shapeimageview.jpg", null);
		ImageUtil.displayImage((ImageView) rootView.findViewById(R.id.h), "http://pengaja.com/uiapptemplate/newphotos/shapeimageview.jpg", null);
		
		// media
		ImageUtil.displayImage((ImageView) rootView.findViewById(R.id.baloon), "http://pengaja.com/uiapptemplate/newphotos/shapeimageview.jpg", null);
		ImageUtil.displayImage((ImageView) rootView.findViewById(R.id.pig), "http://pengaja.com/uiapptemplate/newphotos/shapeimageview.jpg", null);
		ImageUtil.displayImage((ImageView) rootView.findViewById(R.id.play), "http://pengaja.com/uiapptemplate/newphotos/shapeimageview.jpg", null);
		ImageUtil.displayImage((ImageView) rootView.findViewById(R.id.rewind), "http://pengaja.com/uiapptemplate/newphotos/shapeimageview.jpg", null);
		ImageUtil.displayImage((ImageView) rootView.findViewById(R.id.soundcloud), "http://pengaja.com/uiapptemplate/newphotos/shapeimageview.jpg", null);
		ImageUtil.displayImage((ImageView) rootView.findViewById(R.id.speaker), "http://pengaja.com/uiapptemplate/newphotos/shapeimageview.jpg", null);

		// shop
		ImageUtil.displayImage((ImageView) rootView.findViewById(R.id.bag), "http://pengaja.com/uiapptemplate/newphotos/shapeimageview.jpg", null);
		ImageUtil.displayImage((ImageView) rootView.findViewById(R.id.basket), "http://pengaja.com/uiapptemplate/newphotos/shapeimageview.jpg", null);
		ImageUtil.displayImage((ImageView) rootView.findViewById(R.id.cart), "http://pengaja.com/uiapptemplate/newphotos/shapeimageview.jpg", null);
		ImageUtil.displayImage((ImageView) rootView.findViewById(R.id.cupshop), "http://pengaja.com/uiapptemplate/newphotos/shapeimageview.jpg", null);
		ImageUtil.displayImage((ImageView) rootView.findViewById(R.id.dollar), "http://pengaja.com/uiapptemplate/newphotos/shapeimageview.jpg", null);
		ImageUtil.displayImage((ImageView) rootView.findViewById(R.id.heksagonal), "http://pengaja.com/uiapptemplate/newphotos/shapeimageview.jpg", null);

		// social
		ImageUtil.displayImage((ImageView) rootView.findViewById(R.id.camera), "http://pengaja.com/uiapptemplate/newphotos/shapeimageview.jpg", null);
		ImageUtil.displayImage((ImageView) rootView.findViewById(R.id.heart), "http://pengaja.com/uiapptemplate/newphotos/shapeimageview.jpg", null);
		ImageUtil.displayImage((ImageView) rootView.findViewById(R.id.like), "http://pengaja.com/uiapptemplate/newphotos/shapeimageview.jpg", null);
		ImageUtil.displayImage((ImageView) rootView.findViewById(R.id.shit), "http://pengaja.com/uiapptemplate/newphotos/shapeimageview.jpg", null);
		ImageUtil.displayImage((ImageView) rootView.findViewById(R.id.speach_cloud), "http://pengaja.com/uiapptemplate/newphotos/shapeimageview.jpg", null);
		ImageUtil.displayImage((ImageView) rootView.findViewById(R.id.star), "http://pengaja.com/uiapptemplate/newphotos/shapeimageview.jpg", null);

		// travel
		ImageUtil.displayImage((ImageView) rootView.findViewById(R.id.cloud), "http://pengaja.com/uiapptemplate/newphotos/shapeimageview.jpg", null);
		ImageUtil.displayImage((ImageView) rootView.findViewById(R.id.cup), "http://pengaja.com/uiapptemplate/newphotos/shapeimageview.jpg", null);
		ImageUtil.displayImage((ImageView) rootView.findViewById(R.id.house), "http://pengaja.com/uiapptemplate/newphotos/shapeimageview.jpg", null);
		ImageUtil.displayImage((ImageView) rootView.findViewById(R.id.pin), "http://pengaja.com/uiapptemplate/newphotos/shapeimageview.jpg", null);
		ImageUtil.displayImage((ImageView) rootView.findViewById(R.id.suitcase), "http://pengaja.com/uiapptemplate/newphotos/shapeimageview.jpg", null);
		ImageUtil.displayImage((ImageView) rootView.findViewById(R.id.truck), "http://pengaja.com/uiapptemplate/newphotos/shapeimageview.jpg", null);
		
		return rootView;
	}
}
