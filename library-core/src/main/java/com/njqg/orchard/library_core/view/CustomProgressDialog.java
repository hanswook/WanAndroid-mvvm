package com.njqg.orchard.library_core.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

import com.njqg.orchard.library_core.R;


/**
 * Created by hans
 * date: 2017/11/23 17:17.
 * e-mail: hxxx1992@163.com
 */
public class CustomProgressDialog extends Dialog {
    public CustomProgressDialog(Context context) {
        super(context);
    }

    public CustomProgressDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected CustomProgressDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        //添加控件  执行帧动画
        ImageView imageView = (ImageView) findViewById(R.id.loadingImageView);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
        animationDrawable.start();
    }

    public void setMessage(String strMessage) {
        TextView tvMessage = (TextView) findViewById(R.id.tv_loadingmsg);

        if (tvMessage != null) {
            tvMessage.setText(strMessage);
        }
    }

}
