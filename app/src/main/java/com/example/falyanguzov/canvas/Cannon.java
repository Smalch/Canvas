package com.example.falyanguzov.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by falyanguzov on 26.12.2016.
 */
public class Cannon extends View {
    private int alpha;
    private Paint paint = new Paint();
    private int d;
    private Bitmap python;
    private Rect src;
    private float x;
    private float y;

    public Cannon(Context context) {
        super(context);
        paint.setColor(0x000000FF);
        alpha = 1;
        d = 1;
        python = BitmapFactory.decodeResource(getResources(),
                R.drawable.python);
        src = new Rect(0,0, python.getWidth(), python.getHeight());

    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(alpha==0 || alpha==255)
            d *= -1;
        alpha += d;
        int w = getWidth();
        int h = getHeight();
        Rect dst = new Rect(w/4, h/4, w*3/4, h*3/4);
        paint.setColor(0x1000000*alpha+0xff);
        canvas.drawCircle(x, y, h/4.0f, paint);
        canvas.drawBitmap(python, src, dst, paint);
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = event.getX();
        y = event.getY();
        return super.onTouchEvent(event);
    }
}
