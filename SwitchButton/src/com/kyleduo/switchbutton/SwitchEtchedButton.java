package com.kyleduo.switchbutton;

import android.content.Context;
import android.util.AttributeSet;

/**
 * SwitchEtchedButton widget
 * 
 * @version 1.2
 * @author kyleduo
 * @since 2014-09-24
 */

public class SwitchEtchedButton extends SwitchButton {
	public SwitchEtchedButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public SwitchEtchedButton(Context context, AttributeSet attrs) {
		this(context, attrs, R.style.SwitchEtchedButtonStyle);
	}

	public SwitchEtchedButton(Context context) {
		this(context, null);
	}
}
