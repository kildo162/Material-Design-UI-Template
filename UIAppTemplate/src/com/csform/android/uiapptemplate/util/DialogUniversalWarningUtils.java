package com.csform.android.uiapptemplate.util;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.csform.android.uiapptemplate.DialogUniversalWarningActivity;
import com.csform.android.uiapptemplate.R;

public class DialogUniversalWarningUtils {

	private DialogUniversalWarningActivity mDialogUniversalWarningActivity;
	private Dialog mDialog;

	private TextView mDialogText;
	private TextView mDialogOKButton;
	private TextView mDialogCancelButton;

	public DialogUniversalWarningUtils(
			DialogUniversalWarningActivity mDialogUniversalWarningActivity) {
		this.mDialogUniversalWarningActivity = mDialogUniversalWarningActivity;
	}

	public void showDialog() {
		if (mDialog == null) {
			mDialog = new Dialog(mDialogUniversalWarningActivity,
					R.style.CustomDialogTheme);
		}
		mDialog.setContentView(R.layout.dialog_universal_warning);
		mDialog.setCancelable(true);
		mDialog.show();

		mDialogText = (TextView) mDialog
				.findViewById(R.id.dialog_universal_warning_text);
		mDialogOKButton = (TextView) mDialog
				.findViewById(R.id.dialog_universal_warning_ok);
		mDialogCancelButton = (TextView) mDialog
				.findViewById(R.id.dialog_universal_warning_cancel);

		initDialogButtons();
	}

	private void initDialogButtons() {

		mDialogOKButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				mDialog.dismiss();
			}
		});

		mDialogCancelButton.setOnClickListener(new OnClickListener() {

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
