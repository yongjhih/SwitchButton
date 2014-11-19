package com.kyleduo.switchbutton;

import android.content.Context;
import android.util.AttributeSet;

public class SwitchMaterialButtonPreference extends SwitchButtonPreference {

    public SwitchMaterialButtonPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SwitchMaterialButtonPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public SwitchMaterialButtonPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SwitchMaterialButtonPreference(Context context) {
        super(context);
    }

    @Override
    protected void init() {
        setWidgetLayoutResource(R.layout.preference_switch_material_button_layout);
    }
}
