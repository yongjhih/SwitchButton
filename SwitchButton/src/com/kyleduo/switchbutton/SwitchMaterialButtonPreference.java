package com.kyleduo.switchbutton;

import android.content.Context;
import android.preference.CheckBoxPreference;
import android.util.AttributeSet;

public class SwitchMaterialButtonPreference extends CheckBoxPreference {

    public SwitchMaterialButtonPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public SwitchMaterialButtonPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public SwitchMaterialButtonPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SwitchMaterialButtonPreference(Context context) {
        super(context);
        init();
    }

    protected void init() {
        setWidgetLayoutResource(R.layout.preference_switch_material_button_layout);
    }
}
