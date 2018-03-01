package com.hans.wanandroid.customizeview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.hans.wanandroid.R;
import com.njqg.orchard.library_core.utils.LogUtils;

/**
 * Created by hans
 * date: 2018/2/28 18:12.
 * e-mail: hxxx1992@163.com
 */

public class PointView extends View {

    private int defaultColor=Color.BLUE;

    public PointView(Context context) {
        this(context, null);
    }

    public PointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //第二个参数就是我们在styles.xml文件中的<declare-styleable>标签
        //即属性集合的标签，在R文件中名称为R.styleable+name
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.PointView);
        //第一个参数为属性集合里面的属性，R文件名称：R.styleable+属性集合名称+下划线+属性名称
        //第二个参数为，如果没有设置这个属性，则设置的默认的值
        defaultColor = a.getColor(R.styleable.PointView_p_color, Color.BLUE);
        //最后记得将TypedArray对象回收
        LogUtils.e(defaultColor+"+defaultColor");
        a.recycle();

    }



    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        int circle=getMeasuredHeight()/2;
        int centerX=getLeft()+circle;
        int centerY=getTop()+circle;
        Paint p=new Paint();
        p.setColor(defaultColor);
        canvas.drawCircle(centerX,centerY,circle,p);

    }
}
