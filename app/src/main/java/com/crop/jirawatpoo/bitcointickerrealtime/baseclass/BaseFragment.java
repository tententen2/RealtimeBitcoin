package com.crop.jirawatpoo.bitcointickerrealtime.baseclass;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.support.v4.app.Fragment;

import com.crop.jirawatpoo.bitcointickerrealtime.utils.ProgressLoadingDialog;

/**
 * Created by jirawat.poo on 8/22/2017 AD.
 */

public class BaseFragment extends Fragment {
    private static final String TAG_LOADING_DIALOG = "loading_dialog";

    public void showLoadingDialog() {
        if (isScreenOn())
            ProgressLoadingDialog.create().show(getChildFragmentManager(), TAG_LOADING_DIALOG);
    }

    public boolean isLoadingDialogShowing() {
        return progressLoadingDialog() != null && isScreenOn() && progressLoadingDialog().isAdded();
    }

    public void dismissLoadingDialog() {
        if (isLoadingDialogShowing() && isScreenOn())
            progressLoadingDialog().dismiss();
    }

    private ProgressLoadingDialog progressLoadingDialog() {
        try {
            return (ProgressLoadingDialog) getChildFragmentManager().findFragmentByTag(TAG_LOADING_DIALOG);
        } catch (IllegalStateException e) {
            return null;
        }
    }

    private boolean isScreenOn() {
        PowerManager powerManager = (PowerManager) getActivity().getSystemService(Context.POWER_SERVICE);
        if (Build.VERSION.SDK_INT >= 20) {
            return powerManager.isInteractive();
        } else {
            return powerManager.isScreenOn();
        }
    }
}
