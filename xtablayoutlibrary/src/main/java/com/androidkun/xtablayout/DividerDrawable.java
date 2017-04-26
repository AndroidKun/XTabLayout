package com.androidkun.xtablayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/**
 * Created by Kun on 2017/4/26.
 * GitHub: https://github.com/AndroidKun
 * CSDN: http://blog.csdn.net/a1533588867
 * Description:分割线
 */

public class DividerDrawable extends Drawable{

    private Paint paint;
    private RectF rectF;
    private int color = Color.BLACK;

    private int height =0;
    private int width;

    public final static int TOP = 0;
    public final static int CENTER = 1;
    public final static int BOTTOM = 2;
    private int gravity = CENTER;

    public DividerDrawable(Context context){
        width = dip2px(context,2);
        paint = new Paint();
        paint.setColor(color);
        paint.setAntiAlias(true);
    }

    public void setColor(int color){
        paint.setColor(color);
    }

    public void setGravity(int gravity) {
        if(gravity!=TOP && gravity != CENTER && gravity != BOTTOM){
            throw new IllegalArgumentException("Gravity must be one of 0(DividerDrawable.TOP)、" +
                    "1(DividerDrawable.CENTER) and 2(DividerDrawable.BOTTOM)");
        }
        this.gravity = gravity;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawColor(Color.TRANSPARENT);
        if(height==0 || height>=rectF.bottom) {
            canvas.drawRect(rectF, paint);
        }else{
            int margin = (int) ((rectF.bottom - height)/2);
            switch (gravity){
                case TOP:
                    canvas.drawRect(rectF.left,rectF.top,rectF.right,rectF.bottom-margin*2,paint);
                    break;
                case CENTER:
                    canvas.drawRect(rectF.left,rectF.top+margin,rectF.right,rectF.bottom-margin,paint);
                    break;
                case BOTTOM:
                    canvas.drawRect(rectF.left,rectF.top+margin*2,rectF.right,rectF.bottom,paint);
                    break;
            }
        }
    }

    @Override
    public void setBounds(int left, int top, int right, int bottom)
    {
        super.setBounds(left, top, right, bottom);
        rectF = new RectF(left, top, right, bottom);
    }


    public void setDividerSize(int width,int height) {
        this.width = width;
        this.height = height;
        invalidateSelf();
    }

    @Override
    public int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }


    @Override
    public int getIntrinsicWidth() {
        return width;
    }

    @Override
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    public int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
