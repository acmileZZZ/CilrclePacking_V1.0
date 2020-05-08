package com.example.suanfa1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class huahua extends View {
    public static float c,k,zj,nyy,k_rest,c_rest;

    public static int width,height;
    public  static int sizex,sizey,sizex_o,sizey_o;
    public huahua(Context context) {
        super(context);

    }
public  void setwide(int w,float a,float b,float c,float d)
{
    width=w;
    this.c=a;
    this.k=b;
    this.zj=c;
    this.nyy=d;
}
    public huahua(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    float wdiv,hdiv,dd;
    @Override
    protected void onDraw(Canvas canvas) {

        process_packing t = new process_packing(c, k, zj, nyy);

        Paint paint = new Paint();
        t.dofunc();

        sizex = t.xx.size();
        sizey = t.yy.size();
        float[] xx = new float[sizex];
        float[] yy = new float[sizey];

        sizex_o = t.xx_o.size();
        sizey_o = t.yy_o.size();
        float[] xx_o = new float[sizex_o];
        float[] yy_o = new float[sizey_o];
        wdiv = (float) ((canvas.getWidth() - zj / 2) / this.k);
        hdiv = (float) (0.5 * (canvas.getHeight() - zj / 2) / this.c);
        dd = (wdiv < hdiv) ? wdiv : hdiv;

        int x_changbian=0,y_changbian=0;
        int zuidax_o = 0, zuiday_o = 0;//画边

        for (int j = 1; j < sizex_o; j++) {
            if (t.xx_o.get(j) > t.xx_o.get(zuidax_o)) { zuidax_o = j; }
        }
        for (int j = 1; j < sizey_o; j++) {
            if (t.yy_o.get(j) > t.yy_o.get(zuiday_o)) { zuiday_o = j; }
        }
        int zuidax=0,zuiday=0;//画边

        for (int j = 1; j < sizex; j++) {
            if (t.xx.get(j) > t.xx.get(zuidax)) { zuidax = j; }
        }
        for (int j = 1; j < sizey; j++) {
            if (t.yy.get(j) > t.yy.get(zuiday)) { zuiday = j; }
        }
        if (t.xx_o.get(zuidax_o) >= t.yy_o.get(zuiday_o))
        {
            k_rest=Math.abs((this.k-t.zhijing()/2-t.yy_o.get(zuiday_o))/(t.zhijing()/2+t.yy_o.get(zuiday_o)));//短边剩下的
            c_rest=Math.abs((this.c-t.zhijing()/2-t.xx_o.get(zuidax_o))/(t.zhijing()/2+t.xx_o.get(zuidax_o)));//长边剩下的,X为长边
            if((t.xx.get(zuidax)) >= t.yy.get(zuiday))
            {
                x_changbian=1;

            }
            else {
                x_changbian=2;

            }
        }else{
            k_rest=Math.abs((this.c-t.zhijing()/2-t.yy_o.get(zuiday_o))/(t.zhijing()/2+t.yy_o.get(zuiday_o)));//长边剩下的，Y为长边
            c_rest=Math.abs((this.k-t.zhijing()/2-t.xx_o.get(zuidax_o))/(t.zhijing()/2+t.xx_o.get(zuidax_o)));//短边剩下的
            if((t.xx.get(zuidax)) <= t.yy.get(zuiday))
            {
                y_changbian=3;

            }
            else {
                y_changbian=4;

            }

        }


    if(t.flagsame==false) {
        if (dd == wdiv)
        {
            for (int i = 0; i < sizex; i += 1) {
                xx[i] = dd * t.xx.get(i);
            }
            for (int i = 0; i < sizey; i += 1) {
                yy[i] = dd * t.yy.get(i);
            }
            for (int i = 0; i < sizex_o; i += 1) {
                xx_o[i] = dd * t.xx_o.get(i);
            }
            for (int i = 0; i < sizey_o; i += 1) {
                yy_o[i] = dd * t.yy_o.get(i);
            }
            paint.setStyle(Paint.Style.STROKE);

            paint.setColor(Color.GREEN);
            for (int i = 0; i < sizex; i++) {
                canvas.drawCircle(xx[i], yy[i], (t.zhijing() / 2) * dd, paint);
            }
            paint.setStrokeWidth(1);
            paint.setColor(Color.BLACK);

        }

        else
            {
                for (int i = 0; i < sizex; i += 1) { xx[i] = dd * t.xx.get(i); }
                for (int i = 0; i < sizey; i += 1) { yy[i] = dd * t.yy.get(i); }

                for (int i = 0; i < sizex_o; i += 1) { xx_o[i] = dd * t.xx_o.get(i); }
                for (int i = 0; i < sizey_o; i += 1) { yy_o[i] = dd * t.yy_o.get(i); }

                paint.setStyle(Paint.Style.STROKE);
                float distance;
                distance = (canvas.getWidth() - xx[sizex - 1] - zj * dd / 2) / 2;
                for (int i = 0; i < sizex_o; i += 1) { xx_o[i] += distance; }
                for (int i = 0; i < sizex; i += 1) { xx[i] += distance; }

                paint.setColor(Color.RED);
                for (int i = 0; i < sizex; i++) { canvas.drawCircle(xx[i], yy[i], (t.zhijing() / 2) * dd, paint); }


                paint.setStrokeWidth(1);
                paint.setColor(Color.BLACK);

                int flag=x_changbian+y_changbian;
                switch (flag){
                    case (1):
                        canvas.drawRect(xx[0]-(t.zhijing()/2)*dd,yy[0]-(t.zhijing()/2)*dd+1,c*dd+distance,k*dd,paint);break;
                    case (2):
                        canvas.drawRect(xx[0]-(t.zhijing()/2)*dd,yy[0]-(t.zhijing()/2)*dd+1,k*dd+distance,c*dd,paint);break;
                    case (3):
                        canvas.drawRect(xx[0]-(t.zhijing()/2)*dd,yy[0]-(t.zhijing()/2)*dd+1,k*dd+distance,c*dd,paint);break;
                    case (4):
                        canvas.drawRect(xx[0]-(t.zhijing()/2)*dd,yy[0]-(t.zhijing()/2)*dd+1,c*dd+distance,k*dd,paint);break;
                }

            }


    }
    else {
        if (dd == wdiv)
        {

            for (int i = 0; i < sizex_o; i += 1) {
                xx_o[i] = dd * t.xx_o.get(i);
            }
            for (int i = 0; i < sizey_o; i += 1) {
                yy_o[i] = dd * t.yy_o.get(i);
            }
            paint.setColor(Color.DKGRAY);
            paint.setStyle(Paint.Style.STROKE);
            float distance;
            distance =(float) (0.75*((canvas.getWidth() - xx_o[sizex_o - 1] - zj * dd / 2) / 2));
            for (int i = 0; i < sizex_o; i += 1) {
                xx_o[i] += distance;
            }
            for (int i = 0; i < sizex; i += 1) {
                xx[i] += distance;
            }
            for (int i = 0; i < sizex_o; i++) {
                canvas.drawCircle(xx_o[i], yy_o[i], (t.zhijing() / 2) * dd, paint);
            }
            paint.setStrokeWidth(1);
            paint.setColor(Color.BLACK);

            paint.setStrokeWidth(1);
            paint.setColor(Color.BLACK);
            int flag=x_changbian+y_changbian;
            switch (flag){
                case (1):
                    canvas.drawRect(xx[0]-(t.zhijing()/2)*dd,yy[0]-(t.zhijing()/2)*dd+1,c*dd+distance,k*dd,paint);break;
                case (2):
                    canvas.drawRect(xx[0]-(t.zhijing()/2)*dd,yy[0]-(t.zhijing()/2)*dd+1,k*dd+distance,c*dd,paint);break;
                case (3):
                    canvas.drawRect(xx[0]-(t.zhijing()/2)*dd,yy[0]-(t.zhijing()/2)*dd+1,k*dd+distance,c*dd,paint);break;
                case (4):
                    canvas.drawRect(xx[0]-(t.zhijing()/2)*dd,yy[0]-(t.zhijing()/2)*dd+1,c*dd+distance,k*dd,paint);break;
            }

        }
        else {
            float distance;
            for (int i = 0; i < sizex_o; i += 1) {
                xx_o[i] = dd * t.xx_o.get(i);
            }
            for (int i = 0; i < sizey_o; i += 1) {
                yy_o[i] = dd * t.yy_o.get(i);
            }
            paint.setColor(Color.BLUE);
            paint.setStyle(Paint.Style.STROKE);
            distance = (canvas.getWidth() - xx_o[sizex_o - 1] - zj * dd / 2) / 2;
            for (int i = 0; i < sizex_o; i += 1) {
                xx_o[i] += distance;
            }

            for (int i = 0; i < sizex_o; i++) {
                canvas.drawCircle(xx_o[i], yy_o[i], (t.zhijing() / 2) * dd, paint);
            }
            paint.setStrokeWidth(1);
            paint.setColor(Color.BLACK);
            int flag=x_changbian+y_changbian;
            switch (flag){
                case (1):
                    canvas.drawRect(xx_o[0]-(t.zhijing()/2)*dd,yy_o[0]-(t.zhijing()/2)*dd+1,c*dd+distance,k*dd,paint);break;
                case (2):
                    canvas.drawRect(xx_o[0]-(t.zhijing()/2)*dd,yy_o[0]-(t.zhijing()/2)*dd+1,k*dd+distance,c*dd,paint);break;
                case (3):
                    canvas.drawRect(xx_o[0]-(t.zhijing()/2)*dd,yy_o[0]-(t.zhijing()/2)*dd+1,k*dd+distance,c*dd,paint);break;
                case (4):
                    canvas.drawRect(xx_o[0]-(t.zhijing()/2)*dd,yy_o[0]-(t.zhijing()/2)*dd+1,c*dd+distance,k*dd,paint);break;
            }

        }
    }


        /*canvas.drawLine(xx_o[0]-(t.zhijing()/2)*dd, yy_o[0]-(t.zhijing()/2)*dd, xx_o[zuidax_o]+(t.zhijing()/2)*dd+c_rest, yy_o[0]-(t.zhijing()/2)*dd, paint);
        canvas.drawLine(xx_o[0]-(t.zhijing()/2)*dd, yy_o[0]-(t.zhijing()/2)*dd, xx_o[0]-(t.zhijing()/2)*dd, yy_o[zuiday_o]+(t.zhijing()/2)*dd+k_rest, paint);
        canvas.drawLine(xx_o[zuidax_o]+(t.zhijing()/2)*dd+c_rest, yy_o[0]-(t.zhijing()/2)*dd, xx_o[zuidax_o]+(t.zhijing()/2)*dd+c_rest, yy_o[zuiday_o]+(t.zhijing()/2)*dd+k_rest, paint);
        canvas.drawLine(xx_o[0]-(t.zhijing()/2)*dd, yy_o[zuiday_o]+(t.zhijing()/2)*dd+k_rest, xx_o[zuidax_o]+(t.zhijing()/2)*dd+c_rest, yy_o[zuiday_o]+(t.zhijing()/2)*dd+k_rest, paint);
        */
    }
}






