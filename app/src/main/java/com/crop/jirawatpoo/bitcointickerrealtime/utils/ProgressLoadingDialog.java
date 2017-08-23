package com.crop.jirawatpoo.bitcointickerrealtime.utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.crop.jirawatpoo.bitcointickerrealtime.R;

/**
 * Created by jirawat.poo on 8/22/2017 AD.
 */

public class ProgressLoadingDialog extends DialogFragment {

    public static ProgressLoadingDialog create() {
        return new ProgressLoadingDialog();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().setCanceledOnTouchOutside(false);
        return inflater.inflate(R.layout.view_dialog_loading, container, false);
    }
}
