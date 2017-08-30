package com.csform.android.uiapptemplate.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.csform.android.uiapptemplate.R;
import com.csform.android.uiapptemplate.model.DummyModel;
import com.csform.android.uiapptemplate.util.ImageUtil;

public class GoogleCardsSocialAdapter extends ArrayAdapter<DummyModel>
		implements OnClickListener {

	private LayoutInflater mInflater;

	public GoogleCardsSocialAdapter(Context context, List<DummyModel> items) {
		super(context, 0, items);
		mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public long getItemId(int position) {
		return getItem(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(
					R.layout.list_item_google_cards_social, parent, false);
			holder = new ViewHolder();
			holder.image = (ImageView) convertView
					.findViewById(R.id.list_item_google_cards_social_image);
			holder.profileImage = (ImageView) convertView
					.findViewById(R.id.list_item_google_cards_social_profile_image);
			holder.username = (TextView) convertView
					.findViewById(R.id.list_item_google_cards_social_name);
			holder.place = (TextView) convertView
					.findViewById(R.id.list_item_google_cards_social_place);
			holder.text = (TextView) convertView
					.findViewById(R.id.list_item_google_cards_social_text);
			holder.like = (TextView) convertView
					.findViewById(R.id.list_item_google_cards_social_like);
			holder.follow = (TextView) convertView
					.findViewById(R.id.list_item_google_cards_social_follow);
			holder.like.setOnClickListener(this);
			holder.follow.setOnClickListener(this);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		DummyModel item = getItem(position);
		ImageUtil.displayRoundImage(holder.profileImage, item.getImageURL(),
				null);
		ImageUtil.displayImage(holder.image, item.getImageURL(), null);
		holder.username.setText("@" + item.getText());
		holder.place.setText("from Oklahoma");
		holder.text.setText(R.string.lorem_ipsum_short);
		holder.like.setTag(position);
		holder.follow.setTag(position);

		return convertView;
	}

	private static class ViewHolder {
		public ImageView profileImage;
		public ImageView image;
		public TextView username;
		public TextView place;
		public TextView text;
		public TextView like;
		public TextView follow;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int possition = (Integer) v.getTag();
		switch (v.getId()) {
		case R.id.list_item_google_cards_social_like:
			// click on like button
			break;
		case R.id.list_item_google_cards_social_follow:
			// click on follow button
			break;
		}
	}
}
