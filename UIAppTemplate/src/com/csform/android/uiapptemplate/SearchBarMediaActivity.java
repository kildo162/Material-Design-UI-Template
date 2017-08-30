package com.csform.android.uiapptemplate;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.csform.android.uiapptemplate.adapter.SearchAdapter;
import com.csform.android.uiapptemplate.model.DummyModel;
import com.csform.android.uiapptemplate.util.DummyContent;

public class SearchBarMediaActivity extends AppCompatActivity implements OnClickListener {

	public static final String TAG = "Media Search Bar";

	private EditText mSearchField;
	private TextView mXMark;
	private View mMicrofon;
	private ListView mListView;
	private ArrayList<DummyModel> searchableArrayList;

	private TextView mSong;
	private TextView mAlbum;
	private TextView mArtist;
	private TextView mGenre;
	
	private TextView mArrow;
	private LinearLayout mFiltersLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE); // We hide Action
																// Bar
		getSupportActionBar().hide();
		setContentView(R.layout.activity_search_bar_media);

		mSong = (TextView) findViewById(R.id.activity_search_bar_media_song);
		mAlbum = (TextView) findViewById(R.id.activity_search_bar_media_album);
		mArtist= (TextView) findViewById(R.id.activity_search_bar_media_artist);
		mGenre = (TextView) findViewById(R.id.activity_search_bar_media_genre);

		mArrow = (TextView) findViewById(R.id.activity_search_bar_media_arrow);
		mFiltersLayout = (LinearLayout) findViewById(R.id.activity_search_bar_media_filters_layout);
		

		mSong.setOnClickListener(this);
		mAlbum.setOnClickListener(this);
		mArtist.setOnClickListener(this);
		mGenre.setOnClickListener(this);
		mArrow.setOnClickListener(this);

		mSearchField = (EditText) findViewById(R.id.search_field);
		mXMark = (TextView) findViewById(R.id.search_x);
		mMicrofon = findViewById(R.id.search_microfon);
		mListView = (ListView) findViewById(R.id.list_view);

		searchableArrayList = DummyContent.getDummyModelList();

		mXMark.setOnClickListener(this);
		mMicrofon.setOnClickListener(this);

		mSearchField.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			@SuppressLint("DefaultLocale")
			@Override
			public void afterTextChanged(Editable editable) {
				String searchText = editable.toString().trim();
				ArrayList<String> searchedArray = new ArrayList<String>();
				for (DummyModel dm : searchableArrayList) {
					if (dm.getText().toLowerCase()
							.contains(searchText.toLowerCase())) {
						searchedArray.add(dm.getText());
					}
				}
				if (searchText.isEmpty()) {
					mListView.setAdapter(null);
					mXMark.setText(R.string.fontello_x_mark);
				} else {
					mListView.setAdapter(new SearchAdapter(SearchBarMediaActivity.this,
							searchedArray));
					mXMark.setText(R.string.fontello_x_mark_masked);
				}
			}
		});
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.search_x:
			mSearchField.setText(null);
			break;
		case R.id.search_microfon:
			Toast.makeText(this, "Implement voice search", Toast.LENGTH_LONG)
					.show();
			break;
		case R.id.activity_search_bar_media_song:
			if (mSong.getText() == getString(R.string.material_icon_check_empty)) {
				mSong.setText(getString(R.string.material_icon_checked_full));
			} else {
				mSong.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.activity_search_bar_media_album:
			if (mAlbum.getText() == getString(R.string.material_icon_check_empty)) {
				mAlbum.setText(getString(R.string.material_icon_checked_full));
			} else {
				mAlbum.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.activity_search_bar_media_artist:
			if (mArtist.getText() == getString(R.string.material_icon_check_empty)) {
				mArtist.setText(getString(R.string.material_icon_checked_full));
			} else {
				mArtist.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.activity_search_bar_media_genre:
			if (mGenre.getText() == getString(R.string.material_icon_check_empty)) {
				mGenre.setText(getString(R.string.material_icon_checked_full));
			} else {
				mGenre.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.activity_search_bar_media_arrow:
			if(mFiltersLayout.getVisibility() == View.VISIBLE) {
				mFiltersLayout.setVisibility(View.GONE);
			} else {
				mFiltersLayout.setVisibility(View.VISIBLE);
			}
			if (mArrow.getText() == getString(R.string.material_icon_chevron_up)) {
				mArrow.setText(getString(R.string.material_icon_chevron_down));
			} else {
				mArrow.setText(getString(R.string.material_icon_chevron_up));
			}
			break;
		}
	}
}
