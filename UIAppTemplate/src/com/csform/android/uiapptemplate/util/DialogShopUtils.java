package com.csform.android.uiapptemplate.util;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.csform.android.uiapptemplate.DialogShopActivity;
import com.csform.android.uiapptemplate.R;

public class DialogShopUtils implements OnClickListener {

	private DialogShopActivity mDialogShopActivity;
	private Dialog mDialog;

	private TextView mOKButton;
	private TextView mCheck1;
	private TextView mCheck2;
	private TextView mCheck3;
	private TextView mCheck4;

	public DialogShopUtils(DialogShopActivity mDialogShopActivity) {
		this.mDialogShopActivity = mDialogShopActivity;
	}

	public void showDialog() {
		if (mDialog == null) {
			mDialog = new Dialog(mDialogShopActivity, R.style.CustomDialogTheme);
		}
		mDialog.setContentView(R.layout.dialog_shop);
		mDialog.show();

		mCheck1 = (TextView) mDialog.findViewById(R.id.dialog_shop_check1);
		mCheck2 = (TextView) mDialog.findViewById(R.id.dialog_shop_check2);
		mCheck3 = (TextView) mDialog.findViewById(R.id.dialog_shop_check3);
		mCheck4 = (TextView) mDialog.findViewById(R.id.dialog_shop_check4);
		mOKButton = (TextView) mDialog.findViewById(R.id.dialog_shop_ok);
		
		mCheck1.setOnClickListener(this);
		mCheck2.setOnClickListener(this);
		mCheck3.setOnClickListener(this);
		mCheck4.setOnClickListener(this);

		initDialogButtons();
	}

	private void initDialogButtons() {

		mOKButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				mDialog.dismiss();
			}
		});
	}

	public void dismissDialog() {
		mDialog.dismiss();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.dialog_shop_check1:
			// click on explore button
			if (mCheck1.getText() == mDialogShopActivity.getString(R.string.material_icon_check_empty)) {
				mCheck1
						.setText(mDialogShopActivity.getString(R.string.material_icon_checked_full));
			} else {
				mCheck1
						.setText(mDialogShopActivity.getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.dialog_shop_check2:
			// click on explore button
			if (mCheck2.getText() == mDialogShopActivity.getString(R.string.material_icon_check_empty)) {
				mCheck2
						.setText(mDialogShopActivity.getString(R.string.material_icon_checked_full));
			} else {
				mCheck2
						.setText(mDialogShopActivity.getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.dialog_shop_check3:
			// click on explore button
			if (mCheck3.getText() == mDialogShopActivity.getString(R.string.material_icon_check_empty)) {
				mCheck3
						.setText(mDialogShopActivity.getString(R.string.material_icon_checked_full));
			} else {
				mCheck3
						.setText(mDialogShopActivity.getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.dialog_shop_check4:
			// click on explore button
			if (mCheck4.getText() == mDialogShopActivity.getString(R.string.material_icon_check_empty)) {
				mCheck4
						.setText(mDialogShopActivity.getString(R.string.material_icon_checked_full));
			} else {
				mCheck4
						.setText(mDialogShopActivity.getString(R.string.material_icon_check_empty));
			}
			break;
		}
	}
}
