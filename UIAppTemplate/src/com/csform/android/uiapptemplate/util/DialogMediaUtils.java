package com.csform.android.uiapptemplate.util;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.csform.android.uiapptemplate.DialogMediaActivity;
import com.csform.android.uiapptemplate.R;

public class DialogMediaUtils {

	private DialogMediaActivity mDialogMediaActivity;
	private Dialog mDialog;

	private EditText mDialogComment;
	private TextView mOKButton;
	private TextView mCancelButton;
	private ImageView mDialogImage;
	private TextView mName;
	private EditText mComment;
	private RatingBar mRatingBar;

	public DialogMediaUtils(DialogMediaActivity mDialogMediaActivity) {
		this.mDialogMediaActivity = mDialogMediaActivity;
	}

	public void showDialog() {
		if (mDialog == null) {
			mDialog = new Dialog(mDialogMediaActivity,
					R.style.CustomDialogTheme);
		}
		mDialog.setContentView(R.layout.dialog_media);
		mDialog.show();
		
		mOKButton = (TextView) mDialog.findViewById(R.id.dialog_media_ok);
		mCancelButton = (TextView) mDialog.findViewById(R.id.dialog_media_cancel);
		mName = (TextView) mDialog.findViewById(R.id.dialog_media_ok);
		mComment = (EditText) mDialog.findViewById(R.id.dialog_media_comment);
		mDialogImage = (ImageView) mDialog.findViewById(R.id.dialog_media_image);
		mRatingBar = (RatingBar) mDialog.findViewById(R.id.dialog_media_ratingBar);
		mDialogComment = (EditText) mDialog.findViewById(R.id.dialog_media_comment);
		
		ImageUtil.displayRoundImage(mDialogImage, "http://pengaja.com/uiapptemplate/newphotos/profileimages/0.jpg", null);
		
		mRatingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener(){

	        @Override
	        public void onRatingChanged(RatingBar ratingBar, float rating,
	                boolean fromUser) {
	            // TODO Auto-generated method stub
	                Toast.makeText(mDialogMediaActivity, Float.toString(rating),Toast.LENGTH_SHORT).show();
	        }
	    });
		
		initDialogButtons();
	}

	private void initDialogButtons() {

		mOKButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Toast.makeText(mDialogMediaActivity, "Rate: " + Float.toString(mRatingBar.getRating()) + " with comment: " + mDialogComment.getText(),Toast.LENGTH_SHORT).show();
			}
		});

		mCancelButton.setOnClickListener(new OnClickListener() {

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
