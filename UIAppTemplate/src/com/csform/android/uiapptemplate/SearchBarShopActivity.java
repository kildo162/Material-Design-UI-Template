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

public class SearchBarShopActivity extends AppCompatActivity implements OnClickListener {

	public static final String TAG = "Shop Search Bar";

	private EditText mSearchField;
	private TextView mXMark;
	private View mMicrofon;
	private ListView mListView;
	private ArrayList<DummyModel> searchableArrayList;

	private TextView mShoes;
	private TextView mClothes;
	private TextView mMobile;
	private TextView mIT;
	private TextView mFoood;
	private TextView mFruits;
	private TextView mVegetable;
	private TextView mDrinks;
	private TextView mAlcohol;
	private TextView mBooks;
	
	private TextView mFilters;
	private TextView mArrow;
	private LinearLayout mFiltersLayout;
	private TextView mSearchButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE); // We hide Action
																// Bar
		getSupportActionBar().hide();
		setContentView(R.layout.activity_search_bar_shop);

		mShoes = (TextView) findViewById(R.id.activity_search_bar_shop_shoes);
		mClothes = (TextView) findViewById(R.id.activity_search_bar_shop_clothes);
		mMobile = (TextView) findViewById(R.id.activity_search_bar_shop_mobile);
		mIT = (TextView) findViewById(R.id.activity_search_bar_shop_it);
		mFoood = (TextView) findViewById(R.id.activity_search_bar_shop_food);
		mFruits = (TextView) findViewById(R.id.activity_search_bar_shop_fruits);
		mVegetable = (TextView) findViewById(R.id.activity_search_bar_shop_vegetable);
		mDrinks = (TextView) findViewById(R.id.activity_search_bar_shop_drinks);
		mAlcohol = (TextView) findViewById(R.id.activity_search_bar_shop_alcohol);
		mBooks = (TextView) findViewById(R.id.activity_search_bar_shop_books);
		
		mFilters = (TextView) findViewById(R.id.activity_search_bar_shop_filters);
		mArrow = (TextView) findViewById(R.id.activity_search_bar_shop_arrow);
		mSearchButton = (TextView) findViewById(R.id.search_button);
		mFiltersLayout = (LinearLayout) findViewById(R.id.activity_search_bar_shop_filters_layout);
		
		mFilters.setOnClickListener(this);

		mSearchButton.setOnClickListener(this);
		mShoes.setOnClickListener(this);
		mClothes.setOnClickListener(this);
		mMobile.setOnClickListener(this);
		mIT.setOnClickListener(this);
		mFoood.setOnClickListener(this);
		mFruits.setOnClickListener(this);
		mVegetable.setOnClickListener(this);
		mDrinks.setOnClickListener(this);
		mAlcohol.setOnClickListener(this);
		mBooks.setOnClickListener(this);
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
					mListView.setAdapter(new SearchAdapter(
							SearchBarShopActivity.this, searchedArray));
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
		case R.id.activity_search_bar_shop_shoes:
			if (mShoes.getText() == getString(R.string.material_icon_check_empty)) {
				mShoes.setText(getString(R.string.material_icon_check_full));
			} else {
				mShoes.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.activity_search_bar_shop_clothes:
			if (mClothes.getText() == getString(R.string.material_icon_check_empty)) {
				mClothes.setText(getString(R.string.material_icon_check_full));
			} else {
				mClothes.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.activity_search_bar_shop_mobile:
			if (mMobile.getText() == getString(R.string.material_icon_check_empty)) {
				mMobile.setText(getString(R.string.material_icon_check_full));
			} else {
				mMobile.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.activity_search_bar_shop_it:
			if (mIT.getText() == getString(R.string.material_icon_check_empty)) {
				mIT.setText(getString(R.string.material_icon_check_full));
			} else {
				mIT.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.activity_search_bar_shop_food:
			if (mFoood.getText() == getString(R.string.material_icon_check_empty)) {
				mFoood.setText(getString(R.string.material_icon_check_full));
			} else {
				mFoood.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.activity_search_bar_shop_fruits:
			if (mFruits.getText() == getString(R.string.material_icon_check_empty)) {
				mFruits.setText(getString(R.string.material_icon_check_full));
			} else {
				mFruits.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.activity_search_bar_shop_vegetable:
			if (mVegetable.getText() == getString(R.string.material_icon_check_empty)) {
				mVegetable
						.setText(getString(R.string.material_icon_check_full));
			} else {
				mVegetable
						.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.activity_search_bar_shop_drinks:
			if (mDrinks.getText() == getString(R.string.material_icon_check_empty)) {
				mDrinks.setText(getString(R.string.material_icon_check_full));
			} else {
				mDrinks.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.activity_search_bar_shop_alcohol:
			if (mAlcohol.getText() == getString(R.string.material_icon_check_empty)) {
				mAlcohol.setText(getString(R.string.material_icon_check_full));
			} else {
				mAlcohol.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.activity_search_bar_shop_books:
			if (mBooks.getText() == getString(R.string.material_icon_check_empty)) {
				mBooks.setText(getString(R.string.material_icon_check_full));
			} else {
				mBooks.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.activity_search_bar_shop_filters:
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
		case R.id.activity_search_bar_shop_arrow:
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
		case R.id.search_button:
			Toast.makeText(this, "SEARCH", Toast.LENGTH_SHORT);
			break;
		}
	}
}
