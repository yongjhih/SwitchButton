package com.kyleduo.switchbutton;

import android.content.Context;
import android.util.AttributeSet;

/**
 * SwitchMaterialButton widget
 * 
 * @version 1.2
 * @author kyleduo
 * @since 2014-09-24
 */

public class SwitchMaterialButton extends SwitchButton {
	public SwitchMaterialButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public SwitchMaterialButton(Context context, AttributeSet attrs) {
		this(context, attrs, R.style.SwitchMaterialButtonStyle);
	}

	public SwitchMaterialButton(Context context) {
		this(context, null);
	}
}
