package com.csform.android.uiapptemplate.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.csform.android.uiapptemplate.R;
import com.csform.android.uiapptemplate.util.ImageUtil;

public class CheckAndRadioBoxesFragment extends Fragment implements
		OnClickListener {

	private TextView mediaCheck1;
	private TextView mediaCheck2;
	private TextView mediaCheck3;

	private TextView shopCheck1;
	private TextView shopCheck2;
	private TextView shopCheck3;
	private TextView shopCheck4;
	private TextView shopCheck5;
	private TextView shopCheck6;

	private TextView socialCheck1;
	private TextView socialCheck2;
	private TextView socialCheck3;
	private ImageView socialImage1;
	private ImageView socialImage2;
	private ImageView socialImage3;

	private TextView travelCheck1;
	private TextView travelCheck2;
	private TextView travelCheck3;

	public static CheckAndRadioBoxesFragment newInstance() {
		return new CheckAndRadioBoxesFragment();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(
				R.layout.fragment_check_and_radio_boxes, container, false);

		mediaCheck1 = (TextView) rootView
				.findViewById(R.id.fragment_check_boxes_media_check1);
		mediaCheck2 = (TextView) rootView
				.findViewById(R.id.fragment_check_boxes_media_check2);
		mediaCheck3 = (TextView) rootView
				.findViewById(R.id.fragment_check_boxes_media_check3);

		shopCheck1 = (TextView) rootView
				.findViewById(R.id.fragment_check_boxes_shop_check1);
		shopCheck2 = (TextView) rootView
				.findViewById(R.id.fragment_check_boxes_shop_check2);
		shopCheck3 = (TextView) rootView
				.findViewById(R.id.fragment_check_boxes_shop_check3);
		shopCheck4 = (TextView) rootView
				.findViewById(R.id.fragment_check_boxes_shop_check4);
		shopCheck5 = (TextView) rootView
				.findViewById(R.id.fragment_check_boxes_shop_check5);
		shopCheck6 = (TextView) rootView
				.findViewById(R.id.fragment_check_boxes_shop_check6);

		socialCheck1 = (TextView) rootView
				.findViewById(R.id.fragment_check_boxes_social_check1);
		socialCheck2 = (TextView) rootView
				.findViewById(R.id.fragment_check_boxes_social_check2);
		socialCheck3 = (TextView) rootView
				.findViewById(R.id.fragment_check_boxes_social_check3);
		socialImage1 = (ImageView) rootView
				.findViewById(R.id.fragment_check_boxes_social_image1);
		socialImage2 = (ImageView) rootView
				.findViewById(R.id.fragment_check_boxes_social_image2);
		socialImage3 = (ImageView) rootView
				.findViewById(R.id.fragment_check_boxes_social_image3);
		

		travelCheck1 = (TextView) rootView
				.findViewById(R.id.fragment_check_boxes_travel_check1);
		travelCheck2 = (TextView) rootView
				.findViewById(R.id.fragment_check_boxes_travel_check2);
		travelCheck3 = (TextView) rootView
				.findViewById(R.id.fragment_check_boxes_travel_check3);

		mediaCheck1.setOnClickListener(this);
		mediaCheck2.setOnClickListener(this);
		mediaCheck3.setOnClickListener(this);

		shopCheck1.setOnClickListener(this);
		shopCheck2.setOnClickListener(this);
		shopCheck3.setOnClickListener(this);
		shopCheck4.setOnClickListener(this);
		shopCheck5.setOnClickListener(this);
		shopCheck6.setOnClickListener(this);

		socialCheck1.setOnClickListener(this);
		socialCheck2.setOnClickListener(this);
		socialCheck3.setOnClickListener(this);
		
		travelCheck1.setOnClickListener(this);
		travelCheck2.setOnClickListener(this);
		travelCheck3.setOnClickListener(this);
		
		ImageUtil.displayRoundImage(socialImage1, "http://pengaja.com/uiapptemplate/newphotos/profileimages/1.jpg", null);
		ImageUtil.displayRoundImage(socialImage2, "http://pengaja.com/uiapptemplate/newphotos/profileimages/2.jpg", null);
		ImageUtil.displayRoundImage(socialImage3, "http://pengaja.com/uiapptemplate/newphotos/profileimages/3.jpg", null);

		return rootView;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.fragment_check_boxes_media_check1:
			// click on explore button
			if (mediaCheck1.getText() == getString(R.string.material_icon_check_empty)) {
				mediaCheck1
						.setText(getString(R.string.material_icon_checked_full));
			} else {
				mediaCheck1
						.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.fragment_check_boxes_media_check2:
			// click on explore button
			if (mediaCheck2.getText() == getString(R.string.material_icon_check_empty)) {
				mediaCheck2
						.setText(getString(R.string.material_icon_checked_full));
			} else {
				mediaCheck2
						.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.fragment_check_boxes_media_check3:
			// click on explore button
			if (mediaCheck3.getText() == getString(R.string.material_icon_check_empty)) {
				mediaCheck3
						.setText(getString(R.string.material_icon_checked_full));
			} else {
				mediaCheck3
						.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.fragment_check_boxes_shop_check1:
			// click on explore button
			if (shopCheck1.getText() == getString(R.string.material_icon_check_empty)) {
				shopCheck1
						.setText(getString(R.string.material_icon_check_full));
			} else {
				shopCheck1
						.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.fragment_check_boxes_shop_check2:
			// click on explore button
			if (shopCheck2.getText() == getString(R.string.material_icon_check_empty)) {
				shopCheck2
						.setText(getString(R.string.material_icon_check_full));
			} else {
				shopCheck2
						.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.fragment_check_boxes_shop_check3:
			// click on explore button
			if (shopCheck3.getText() == getString(R.string.material_icon_check_empty)) {
				shopCheck3
						.setText(getString(R.string.material_icon_check_full));
			} else {
				shopCheck3
						.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.fragment_check_boxes_shop_check4:
			// click on explore button
			if (shopCheck4.getText() == getString(R.string.material_icon_check_empty)) {
				shopCheck4
						.setText(getString(R.string.material_icon_check_full));
			} else {
				shopCheck4
						.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.fragment_check_boxes_shop_check5:
			// click on explore button
			if (shopCheck5.getText() == getString(R.string.material_icon_check_empty)) {
				shopCheck5
						.setText(getString(R.string.material_icon_check_full));
			} else {
				shopCheck5
						.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.fragment_check_boxes_shop_check6:
			// click on explore button
			if (shopCheck6.getText() == getString(R.string.material_icon_check_empty)) {
				shopCheck6
						.setText(getString(R.string.material_icon_check_full));
			} else {
				shopCheck6
						.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.fragment_check_boxes_social_check1:
			// click on explore button
			if (socialCheck1.getText() == getString(R.string.material_icon_check_empty)) {
				socialCheck1
						.setText(getString(R.string.material_icon_check_full));
			} else {
				socialCheck1
						.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.fragment_check_boxes_social_check2:
			// click on explore button
			if (socialCheck2.getText() == getString(R.string.material_icon_check_empty)) {
				socialCheck2
						.setText(getString(R.string.material_icon_check_full));
			} else {
				socialCheck2
						.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.fragment_check_boxes_social_check3:
			// click on explore button
			if (socialCheck3.getText() == getString(R.string.material_icon_check_empty)) {
				socialCheck3
						.setText(getString(R.string.material_icon_check_full));
			} else {
				socialCheck3
						.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.fragment_check_boxes_travel_check1:
			// click on explore button
			if (travelCheck1.getText() == getString(R.string.material_icon_box_full)) {
				travelCheck1
						.setText(getString(R.string.material_icon_checked_full));
			} else {
				travelCheck1
						.setText(getString(R.string.material_icon_box_full));
			}
			break;
		case R.id.fragment_check_boxes_travel_check2:
			// click on explore button
			if (travelCheck2.getText() == getString(R.string.material_icon_box_full)) {
				travelCheck2
						.setText(getString(R.string.material_icon_checked_full));
			} else {
				travelCheck2
						.setText(getString(R.string.material_icon_box_full));
			}
			break;
		case R.id.fragment_check_boxes_travel_check3:
			// click on explore button
			if (travelCheck3.getText() == getString(R.string.material_icon_box_full)) {
				travelCheck3
						.setText(getString(R.string.material_icon_checked_full));
			} else {
				travelCheck3
						.setText(getString(R.string.material_icon_box_full));
			}
			break;
		}
	}
}
