/*
 * This source is part of the
 *      _____  ___   ____
 *  __ / / _ \/ _ | / __/___  _______ _
 * / // / , _/ __ |/ _/_/ _ \/ __/ _ `/
 * \___/_/|_/_/ |_/_/ (_)___/_/  \_, /
 *                              /___/
 * repository.
 *
 * Copyright (C) 2012 Benoit 'BoD' Lubek (BoD@JRAF.org)
 * Copyright (C) 2012 Intrications (intrications.com)
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kyleduo.switchbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.CompoundButton;
import org.jraf.android.backport.switchwidget.TwoStatePreference;

/**
 * A {@link Preference} that provides a two-state toggleable option.
 * <p>
 * This preference will store a boolean into the SharedPreferences.
 * 
 * @attr ref android.R.styleable#SwitchButtonPreference_asb_summaryOff
 * @attr ref android.R.styleable#SwitchButtonPreference_asb_summaryOn
 * @attr ref android.R.styleable#SwitchButtonPreference_asb_switchTextOff
 * @attr ref android.R.styleable#SwitchButtonPreference_asb_switchTextOn
 * @attr ref android.R.styleable#SwitchButtonPreference_asb_disableDependentsState
 */
public class SwitchButtonPreference extends TwoStatePreference {
	// SwitchButton text for on and off states
	private CharSequence mSwitchOn;
	private CharSequence mSwitchOff;
	private final Listener mListener = new Listener();

	private class Listener implements CompoundButton.OnCheckedChangeListener {
		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			if (!callChangeListener(isChecked)) {
				// Listener didn't like it, change it back.
				// CompoundButton will make sure we don't recurse.
				buttonView.setChecked(!isChecked);
				return;
			}

			SwitchButtonPreference.this.setChecked(isChecked);
		}
	}

	/**
	 * Construct a new SwitchButtonPreference with the given style options.
	 * 
	 * @param context
	 *            The Context that will style this preference
	 * @param attrs
	 *            Style attributes that differ from the default
	 * @param defStyle
	 *            Theme attribute defining the default style options
	 */
	public SwitchButtonPreference(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		TypedArray a = context.obtainStyledAttributes(attrs,
				R.styleable.SwitchButtonPreference, R.attr.asb_switchPreferenceStyle, 0);
		setSummaryOn(a.getString(R.styleable.SwitchButtonPreference_asb_summaryOn));
		setSummaryOff(a.getString(R.styleable.SwitchButtonPreference_asb_summaryOff));
		setSwitchTextOn(a.getString(R.styleable.SwitchButtonPreference_asb_switchTextOn));
		setSwitchTextOff(a
				.getString(R.styleable.SwitchButtonPreference_asb_switchTextOff));
		setDisableDependentsState(a.getBoolean(
				R.styleable.SwitchButtonPreference_asb_disableDependentsState, false));
		a.recycle();
	}

	/**
	 * Construct a new SwitchButtonPreference with the given style options.
	 * 
	 * @param context
	 *            The Context that will style this preference
	 * @param attrs
	 *            Style attributes that differ from the default
	 */
	public SwitchButtonPreference(Context context, AttributeSet attrs) {
		this(context, attrs, R.attr.asb_switchPreferenceStyle);
	}

	/**
	 * Construct a new SwitchButtonPreference with default style options.
	 * 
	 * @param context
	 *            The Context that will style this preference
	 */
	public SwitchButtonPreference(Context context) {
		super(context);
	}

	@Override
	protected void onBindView(View view) {
		super.onBindView(view);

		SwitchButton checkableView = (SwitchButton) view.findViewById(R.id.switchWidget);
		if (checkableView != null /* && checkableView instanceof Checkable */) {
			((Checkable) checkableView).setChecked(mChecked);

			// XXX Was on the Android source, but had to comment it out. --
			// Intrications
			// sendAccessibilityEvent(checkableView);

			// if (checkableView instanceof SwitchButton) {
				final SwitchButton switchView =/* (SwitchButton) */ checkableView;
				switchView.setTextOn(mSwitchOn);
				switchView.setTextOff(mSwitchOff);
				switchView.setOnCheckedChangeListener(mListener);
			// }
		}

		syncSummaryView(view);
	}

	/**
	 * Set the text displayed on the switch widget in the on state. This should
	 * be a very short string; one word if possible.
	 * 
	 * @param onText
	 *            Text to display in the on state
	 */
	public void setSwitchTextOn(CharSequence onText) {
		mSwitchOn = onText;
		notifyChanged();
	}

	/**
	 * Set the text displayed on the switch widget in the off state. This should
	 * be a very short string; one word if possible.
	 * 
	 * @param offText
	 *            Text to display in the off state
	 */
	public void setSwitchTextOff(CharSequence offText) {
		mSwitchOff = offText;
		notifyChanged();
	}

	/**
	 * Set the text displayed on the switch widget in the on state. This should
	 * be a very short string; one word if possible.
	 * 
	 * @param resId
	 *            The text as a string resource ID
	 */
	public void setSwitchTextOn(int resId) {
		setSwitchTextOn(getContext().getString(resId));
	}

	/**
	 * Set the text displayed on the switch widget in the off state. This should
	 * be a very short string; one word if possible.
	 * 
	 * @param resId
	 *            The text as a string resource ID
	 */
	public void setSwitchTextOff(int resId) {
		setSwitchTextOff(getContext().getString(resId));
	}

	/**
	 * @return The text that will be displayed on the switch widget in the on
	 *         state
	 */
	public CharSequence getSwitchTextOn() {
		return mSwitchOn;
	}

	/**
	 * @return The text that will be displayed on the switch widget in the off
	 *         state
	 */
	public CharSequence getSwitchTextOff() {
		return mSwitchOff;
	}
}
