package com.csform.android.uiapptemplate.util;

import java.util.ArrayList;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.csform.android.uiapptemplate.DialogTravelActivity;
import com.csform.android.uiapptemplate.R;
import com.csform.android.uiapptemplate.model.DummyModel;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

public class DialogTravelUtils {

	private DialogTravelActivity mDialogTravelActivity;
	private Dialog mDialog;
	
	private ImageView mImage;
	private ArrayList<DummyModel> mDummyModelList; 
	private int currentImage;
	private TextView mPrevious;
	private TextView mNext;
	private TextView mOK;
	private ProgressBar mBar;
	
	private SimpleImageLoadingListener listener = new SimpleImageLoadingListener() {

		@Override
		public void onLoadingFailed(String imageUri, View view,
				FailReason failReason) {
			mBar.setVisibility(View.GONE);
		}

		@Override
		public void onLoadingComplete(String imageUri, View view,
				Bitmap loadedImage) {
			mBar.setVisibility(View.GONE);
		}
	};
	
	public DialogTravelUtils(DialogTravelActivity mDialogTravelActivity) {
		this.mDialogTravelActivity = mDialogTravelActivity;
		this.mDummyModelList = DummyContent.getDummyModelDragAndDropTravelList();
		this.currentImage = 0;
	}

	public void showDialog() {
		if (mDialog == null) {
			mDialog = new Dialog(mDialogTravelActivity,
					R.style.CustomDialogTheme);
		}
		mDialog.setContentView(R.layout.dialog_travel);
		mDialog.show();
		
		mImage = (ImageView) mDialog.findViewById(R.id.dialog_travel_image);
		mPrevious = (TextView) mDialog.findViewById(R.id.dialog_travel_left);
		mNext = (TextView) mDialog.findViewById(R.id.dialog_travel_right);
		mOK = (TextView) mDialog.findViewById(R.id.dialog_travel_ok);
		mBar = (ProgressBar) mDialog.findViewById(R.id.dialog_travel_imageProgressBar);
		
		displayCurrentImage(currentImage);
		
		initDialogButtons();
	}
	
	private void displayCurrentImage(int position) {
		ImageUtil.displayImage(mImage, mDummyModelList.get(position).getImageURL(), listener);
	}
	
	private void initDialogButtons() {

		mPrevious.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				if(currentImage > 0){
					displayCurrentImage(--currentImage);
				}
			}
		});

		mNext.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				if(currentImage < mDummyModelList.size()-1) {
					displayCurrentImage(++currentImage);
				}
			}
		});

		mOK.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				mDialog.dismiss();
			}
		});
	}

	public void dismissDialog() {
		mDialog.dismiss();
	}
}
