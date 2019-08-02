package com.example.ravi.base;


import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.ravi.DashboardActivity;
import com.google.android.material.snackbar.Snackbar;

/**
 * Created by Ravi on 21-01-2018.
 */
public abstract class BaseContainerFragment extends Fragment {

    private static final String TAG = BaseContainerFragment.class.getSimpleName();
    private DashboardActivity mActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof DashboardActivity) {
            this.mActivity = (DashboardActivity) context;
        }
    }

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }

    /**
     * If class is non-abstract make all protected method to public
     *
     * @return mActivity
     */
    protected DashboardActivity getBaseActivity() {
        return mActivity;
    }

    /*public Context getContext() {
        return getActivity();
    }*/

    protected void hideKeyboard() {
        if (mActivity != null) {
            InputMethodManager inputManager = (InputMethodManager) mActivity
                    .getSystemService(Context.INPUT_METHOD_SERVICE);

            View currentFocusedView = mActivity.getCurrentFocus();
            if (currentFocusedView != null) {
                inputManager.hideSoftInputFromWindow(currentFocusedView.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }

    protected void showShortToast(String message) {
        Toast.makeText(getBaseActivity(), message, Toast.LENGTH_SHORT).show();
    }

    protected void showLongToast(String message) {
        Toast.makeText(getBaseActivity(), message, Toast.LENGTH_LONG).show();
    }

    protected void showSnack(View view, String msg) {
        snack(view, msg, null);
    }

    private void snack(View view, String msg, final Runnable runnable) {
        Snackbar
                .make(view, msg, Snackbar.LENGTH_LONG)
                .setAction("Ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (runnable != null) {
                            runnable.run();
                        }
                    }
                })
                .show();
    }

   /* protected interface Callback {

        void onFragmentAttached();

        void onFragmentDetached(String tag);
    }*/

}