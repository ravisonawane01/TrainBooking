package com.example.ravi.helper;

import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.example.ravi.R;

public class CommonBindingUtils {

    @BindingAdapter({"layout_marginTop"})
    public static void setLayoutMarginTop(View self, int margin) {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) self.getLayoutParams();
        layoutParams.topMargin = (int) (getRelativeHeightInPX(self, margin)/**self.getContext().getResources().getDisplayMetrics().density*/);
        self.setLayoutParams(layoutParams);
    }

    @BindingAdapter({"layout_marginBottom"})
    public static void setLayoutMarginBottom(View self, int margin) {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) self.getLayoutParams();
        layoutParams.bottomMargin = (int) (getRelativeHeightInPX(self, margin)/**self.getContext().getResources().getDisplayMetrics().density*/);
        self.setLayoutParams(layoutParams);
    }

    @BindingAdapter({"layout_marginStart"})
    public static void setLayoutMarginLeft(View self, int margin) {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) self.getLayoutParams();
        layoutParams.leftMargin = (int) (getRelativeWidthInPX(self, margin)/**self.getContext().getResources().getDisplayMetrics().density*/);
        self.setLayoutParams(layoutParams);
    }

    @BindingAdapter({"layout_marginEnd"})
    public static void setLayoutMarginRight(View self, int margin) {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) self.getLayoutParams();
        layoutParams.rightMargin = (int) (getRelativeWidthInPX(self, margin)/**self.getContext().getResources().getDisplayMetrics().density*/);
        self.setLayoutParams(layoutParams);
    }

    @BindingAdapter({"layout_margin"})
    public static void setLayoutMargin(View self, int margin) {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) self.getLayoutParams();
        layoutParams.rightMargin = (int) (getRelativeWidthInPX(self, margin)/**self.getContext().getResources().getDisplayMetrics().density*/);
        layoutParams.leftMargin = (int) (getRelativeWidthInPX(self, margin)/**self.getContext().getResources().getDisplayMetrics().density*/);
        layoutParams.topMargin = (int) (getRelativeWidthInPX(self, margin)/**self.getContext().getResources().getDisplayMetrics().density*/);
        layoutParams.bottomMargin = (int) (getRelativeWidthInPX(self, margin)/**self.getContext().getResources().getDisplayMetrics().density*/);
        self.setLayoutParams(layoutParams);
    }

    @BindingAdapter({"layout_height"})
    public static void setLayoutHeight(View self, int height) {
        ViewGroup.LayoutParams layoutParams = self.getLayoutParams();
        layoutParams.height = (int) (getRelativeHeightInPX(self, height)/**self.getContext().getResources().getDisplayMetrics().density*/);
        self.setLayoutParams(layoutParams);
    }

    @BindingAdapter({"layout_width"})
    public static void setLayoutWidth(View self, int width) {
        ViewGroup.LayoutParams layoutParams = self.getLayoutParams();
        layoutParams.width = (int) (getRelativeWidthInPX(self, width)/**self.getContext().getResources().getDisplayMetrics().density*/);
        self.setLayoutParams(layoutParams);
    }

    @BindingAdapter({"textSize"})
    public static void setTextSize(View self, int size) {
        //size = LandingScreenPhoneActivity.isTablet(self.getContext())?size+8:size;
        ((TextView) self).setTextSize(TypedValue.COMPLEX_UNIT_PX, (size + self.getContext().getResources().getInteger(R.integer.font_scale)) * self.getContext().getResources().getDisplayMetrics().density);
    }

    /*@BindingAdapter({"textSizeSpinner"})
    public static void setTextSizeSpinner(View self, int size) {
        ((AppCompatSpinner) self).setTextSize(TypedValue.COMPLEX_UNIT_PX, (size) * self.getContext().getResources().getDisplayMetrics().density);
    }*/

    @BindingAdapter({"edit_textSize"})
    public static void setEditTextSize(View self, int size) {
        // size = LandingScreenPhoneActivity.isTablet(self.getContext())?size+8:size;
        ((EditText) self).setTextSize(TypedValue.COMPLEX_UNIT_PX, (size) * self.getContext().getResources().getDisplayMetrics().density);
    }

    private static int getRelativeHeightInPX(View view, int px) {
        return (int) (px * view.getContext().getResources().getDisplayMetrics().density);
    }

    private static int getRelativeWidthInPX(View view, int px) {
        return (int) (px * view.getContext().getResources().getDisplayMetrics().density);
    }
}