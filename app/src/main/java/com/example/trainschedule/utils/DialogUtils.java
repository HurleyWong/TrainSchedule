package com.example.trainschedule.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.util.Log;

public class DialogUtils {

    private static final String TAG = "DialogUtils";


    /**
     * 警告 Dialog
     *
     * @param activity
     * @param title       标题
     * @param content     内容
     * @param positiveBtn 确定按钮
     */
    public static void showAlertDialog(Activity activity,
                                       String title,
                                       String content,
                                       String positiveBtn) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        // 设置 Dialog 标题
        builder.setTitle(title);
        // 设置 Dialog 内容
        builder.setMessage(content);
        // 设置按钮
        builder.setPositiveButton(positiveBtn, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // 按钮点击事件
                // onBackPressed();
            }
        });

        // 创建 Dialog 对象，并实例化
        AlertDialog alertDialog = builder.create();
        if (alertDialog != null && !alertDialog.isShowing()) {
            alertDialog.show();
        }
    }

    // 隐藏 Dialog
    public static void dismissDialog(Dialog dialog) {
        if (dialog != null && dialog.isShowing()) {
            Activity ownerActivity = dialog.getOwnerActivity();
            if (ownerActivity != null && !ownerActivity.isFinishing()) {
                try {
                    dialog.dismiss();
                } catch (Exception e) {
                    Log.e(TAG, "error dismiss dialog" + e.getMessage());
                }
            }
        }
    }
}
















