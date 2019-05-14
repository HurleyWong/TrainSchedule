package com.example.trainschedule.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/08/15
 * </pre>
 */

public class TextUtils {

    /**
     * 监听清除
     *
     * @param editText
     * @param imageView
     */
    public static void addClearListener(final EditText editText, final ImageView imageView) {
        //监听EditText的输入内容
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //如果输入后的输入内容长度大于0，则显示clear图标
                if (s.length() > 0) {
                    imageView.setVisibility(View.VISIBLE);
                } else {
                    imageView.setVisibility(View.INVISIBLE);
                }
            }
        });

        //clear图标的点击事件
        imageView.setOnClickListener(v -> editText.setText(""));
    }
}
