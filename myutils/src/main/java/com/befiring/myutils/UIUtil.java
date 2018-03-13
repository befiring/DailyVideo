package com.befiring.myutils;

import android.content.Context;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;

import java.util.List;

/**
 * Created by Wang Meng on 2017/10/27.
 */

public class UIUtil {
    private static Toast mToast;
    private static MaterialDialog progressDialog;

    public static void showShortToast(Context context, String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }

    public static void showLongToast(Context context, String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }

    public static void showSelectDialog(Context context, String title, List list, MaterialDialog.ListCallback callback) {
        new MaterialDialog.Builder(context)
                .title(title)
                .items(list)
                .itemsCallback(callback)
                .build()
                .show();
    }

    public static void showProgressDialog(Context context, String msg, boolean cancelable) {
        if (progressDialog == null) {
            progressDialog = new MaterialDialog.Builder(context)
                    .content(msg)
                    .progress(true, 0)
                    .cancelable(cancelable)
                    .build();
        } else {
            progressDialog.setContent(msg);
        }
        progressDialog.show();
    }

    public static void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }
}
