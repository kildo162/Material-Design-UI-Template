package com.csform.android.uiapptemplate.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.csform.android.uiapptemplate.R;

public class WizardMediaFragment extends Fragment {

	private static final String ARG_POSITION = "position";

	private int position;
	private TextView icon;
	private TextView title;
	private TextView text;

	public static WizardMediaFragment newInstance(int position) {
		WizardMediaFragment f = new WizardMediaFragment();
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
		View rootView = inflater.inflate(R.layout.fragment_wizard_media,
				container, false);
		icon = (TextView) rootView.findViewById(R.id.fragment_wizard_media_icon);
		title = (TextView) rootView.findViewById(R.id.fragment_wizard_media_title);
		text = (TextView) rootView.findViewById(R.id.fragment_wizard_media_text);
		
		if (position == 0) {
			icon.setText(R.string.material_icon_star_outline);
			title.setText("Fragment Example 1");
			text.setText("Text for Fragment Example 1 " + getString(R.string.lorem_ipsum_short));
		} else if (position == 1) {
			icon.setText(R.string.material_icon_star_half);
			title.setText("Fragment Example 2");
			text.setText("Text for Fragment Example 2 " + getString(R.string.lorem_ipsum_short));
		} else {
			icon.setText(R.string.material_icon_star);
			title.setText("Fragment Example 3");
			text.setText("Text for Fragment Example 3 " + getString(R.string.lorem_ipsum_short));
		}

		ViewCompat.setElevation(rootView, 50);
		return rootView;
	}

}