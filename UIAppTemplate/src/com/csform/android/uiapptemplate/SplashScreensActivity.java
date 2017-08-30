package com.csform.android.uiapptemplate;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.csform.android.uiapptemplate.font.MaterialDesignIconsTextView;
import com.csform.android.uiapptemplate.view.kbv.KenBurnsView;

public class SplashScreensActivity extends AppCompatActivity {

	public static final String SPLASH_SCREEN_OPTION = "com.csform.android.uiapptemplate.SplashScreensActivity";
	public static final String SPLASH_SCREEN_OPTION_1 = "Fade in + Ken Burns";
	public static final String SPLASH_SCREEN_OPTION_2 = "Down + Ken Burns";
	public static final String SPLASH_SCREEN_OPTION_3 = "Down + fade in + Ken Burns";
	
	private KenBurnsView mKenBurns;
	private MaterialDesignIconsTextView mLogo;
	private TextView welcomeText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE); //Removing ActionBar
		getSupportActionBar().hide();
		setContentView(R.layout.activity_splash_screen);
		
		mKenBurns = (KenBurnsView) findViewById(R.id.ken_burns_images);
		mLogo = (MaterialDesignIconsTextView) findViewById(R.id.logo);
		welcomeText = (TextView) findViewById(R.id.welcome_text);
		
		String category = SPLASH_SCREEN_OPTION_1;
		Bundle extras = getIntent().getExtras();
		if (extras != null && extras.containsKey(SPLASH_SCREEN_OPTION)) {
			category = extras.getString(SPLASH_SCREEN_OPTION, SPLASH_SCREEN_OPTION_1);
		}
		setAnimation(category);
	}
	
	/** Animation depends on category.
	 * */
	private void setAnimation(String category) {
		if (category.equals(SPLASH_SCREEN_OPTION_1)) {
			mKenBurns.setImageResource(R.drawable.background_media);
			animation1();
		} else if (category.equals(SPLASH_SCREEN_OPTION_2)) {
			mLogo.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.main_color_500));
			mKenBurns.setImageResource(R.drawable.background_shop);
			animation2();
		} else if (category.equals(SPLASH_SCREEN_OPTION_3)) {
			mKenBurns.setImageResource(R.drawable.splash_screen_option_three);
			animation2();
			animation3();
		}
	}

	private void animation1() {
		ObjectAnimator scaleXAnimation = ObjectAnimator.ofFloat(mLogo, "scaleX", 5.0F, 1.0F);
		scaleXAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
		scaleXAnimation.setDuration(1200);
		ObjectAnimator scaleYAnimation = ObjectAnimator.ofFloat(mLogo, "scaleY", 5.0F, 1.0F);
		scaleYAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
		scaleYAnimation.setDuration(1200);
		ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(mLogo, "alpha", 0.0F, 1.0F);
		alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
		alphaAnimation.setDuration(1200);
		AnimatorSet animatorSet = new AnimatorSet();
		animatorSet.play(scaleXAnimation).with(scaleYAnimation).with(alphaAnimation);
		animatorSet.setStartDelay(500);
		animatorSet.start();
	}
	
	private void animation2() {
		mLogo.setAlpha(1.0F);
		Animation anim = AnimationUtils.loadAnimation(this, R.anim.translate_top_to_center);
		mLogo.startAnimation(anim);
	}
	
	private void animation3() {
		ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(welcomeText, "alpha", 0.0F, 1.0F);
		alphaAnimation.setStartDelay(1700);
		alphaAnimation.setDuration(500);
		alphaAnimation.start();
	}
}
