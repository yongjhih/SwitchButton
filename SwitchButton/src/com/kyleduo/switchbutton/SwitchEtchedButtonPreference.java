package com.kyleduo.switchbutton;

import android.content.Context;
import android.preference.CheckBoxPreference;
import android.util.AttributeSet;

public class SwitchEtchedButtonPreference extends CheckBoxPreference {

    public SwitchEtchedButtonPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public SwitchEtchedButtonPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public SwitchEtchedButtonPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SwitchEtchedButtonPreference(Context context) {
        super(context);
        init();
    }

    protected void init() {
        setWidgetLayoutResource(R.layout.preference_switch_etched_button_layout);
    }
}
