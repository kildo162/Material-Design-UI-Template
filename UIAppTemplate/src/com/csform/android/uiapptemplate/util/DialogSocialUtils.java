package com.csform.android.uiapptemplate.util;

import android.app.Dialog;
import android.graphics.Typeface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.csform.android.uiapptemplate.DialogSocialActivity;
import com.csform.android.uiapptemplate.R;

public class DialogSocialUtils {

	private DialogSocialActivity mDialogSocialActivity;
	private Dialog mDialog;

	private TextView mDialogFreeFreeButton;
	private TextView mDialogFreePremiumButton;
	private TextView mDialogFreeOKButton;
	private TextView mDialogFreeCancelButton;
	private TextView mDialogFreeUsername;
	private TextView mDialogFreePassword;
	private EditText mDialogFreeEditUsername;
	private EditText mDialogFreeEditPassword;
	private LinearLayout mDialogFreeLayout;

	private TextView mDialogPremiumFreeButton;
	private TextView mDialogPremiumPremiumButton;
	private TextView mDialogPremiumOKButton;
	private TextView mDialogPremiumCancelButton;
	private TextView mDialogPremiumUsername;
	private TextView mDialogPremiumPassword;
	private EditText mDialogPremiumEditUsername;
	private EditText mDialogPremiumEditPassword;
	private LinearLayout mDialogPremiumLayout;

	public DialogSocialUtils(DialogSocialActivity mDialogSocialActivity) {
		this.mDialogSocialActivity = mDialogSocialActivity;
	}

	public void showDialog() {
		if (mDialog == null) {
			mDialog = new Dialog(mDialogSocialActivity, R.style.CustomDialogTheme);
		}
		mDialog.setContentView(R.layout.dialog_social);
		mDialog.show();

		mDialogFreeLayout = (LinearLayout) mDialog.findViewById(R.id.dialog_social_layout);
		mDialogFreeFreeButton = (TextView) mDialog.findViewById(R.id.dialog_social_free);
		mDialogFreePremiumButton = (TextView) mDialog.findViewById(R.id.dialog_social_premium);
		mDialogFreeOKButton = (TextView) mDialog.findViewById(R.id.dialog_social_ok);
		mDialogFreeCancelButton = (TextView) mDialog.findViewById(R.id.dialog_social_cancel);
		mDialogFreeUsername = (TextView) mDialog.findViewById(R.id.dialog_social_username);
		mDialogFreePassword = (TextView) mDialog.findViewById(R.id.dialog_social_password);
		mDialogFreeEditUsername = (EditText) mDialog.findViewById(R.id.dialog_social_edit_username);
		mDialogFreeEditPassword = (EditText) mDialog.findViewById(R.id.dialog_social_edit_password);
		
		Typeface sRobotoThin = Typeface.createFromAsset(mDialogSocialActivity.getAssets(),
				"fonts/Roboto-Light.ttf");
		mDialogFreeEditUsername.setTypeface(sRobotoThin);
		mDialogFreeEditPassword.setTypeface(sRobotoThin);
		
		initDialogFreeButtons();
	}

	public void showPremiumDialog() {
		if (mDialog == null) {
			mDialog = new Dialog(mDialogSocialActivity, R.style.CustomDialogTheme);
		}
		mDialog.setContentView(R.layout.dialog_social_premium);
		mDialog.show();

		mDialogPremiumLayout = (LinearLayout) mDialog.findViewById(R.id.dialog_social_premium_layout);
		mDialogPremiumFreeButton = (TextView) mDialog.findViewById(R.id.dialog_social_premium_free);
		mDialogPremiumPremiumButton = (TextView) mDialog.findViewById(R.id.dialog_social_premium_premium);
		mDialogPremiumOKButton = (TextView) mDialog.findViewById(R.id.dialog_social_premium_ok);
		mDialogPremiumCancelButton = (TextView) mDialog.findViewById(R.id.dialog_social_premium_cancel);
		mDialogPremiumUsername = (TextView) mDialog.findViewById(R.id.dialog_social_premium_username);
		mDialogPremiumPassword = (TextView) mDialog.findViewById(R.id.dialog_social_premium_password);
		mDialogPremiumEditUsername = (EditText) mDialog.findViewById(R.id.dialog_social_premium_edit_username);
		mDialogPremiumEditPassword = (EditText) mDialog.findViewById(R.id.dialog_social_premium_edit_password);
		
		Typeface sRobotoThin = Typeface.createFromAsset(mDialogSocialActivity.getAssets(),
				"fonts/Roboto-Light.ttf");
		mDialogPremiumEditUsername.setTypeface(sRobotoThin);
		mDialogPremiumEditPassword.setTypeface(sRobotoThin);
		
		initDialogPremiumButtons();
	}

	private void initDialogFreeButtons() {
		mDialogFreePremiumButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				showPremiumDialog();
			}
		});

		mDialogFreeOKButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				dismissDialog();
			}
		});

		mDialogFreeCancelButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				dismissDialog();
			}
		});
		
	}

	private void initDialogPremiumButtons() {
		mDialogPremiumFreeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				showDialog();
			}
		});

		mDialogPremiumOKButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				dismissDialog();
			}
		});

		mDialogPremiumCancelButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				dismissDialog();
			}
		});
	}
	
	public void dismissDialog() {
		mDialog.dismiss();
	}
}
