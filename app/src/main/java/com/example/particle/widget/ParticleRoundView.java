package com.example.particle.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import static com.example.particle.utils.Util.randomAngle;
import static com.example.particle.utils.Util.randomColor;
import static com.example.particle.utils.Util.randomRV;
import static com.example.particle.utils.Util.randomRadius;

/**
 * Created by mysat on 2018/5/14.
 */

public class ParticleRoundView extends View {

    int mScreenWidth = 910;
    int mScreenHeight = 826;

    Paint paint = new Paint();

    ParticleRound[] prs = new ParticleRound[120];

    public ParticleRoundView(Context context) {
        this(context, null);
    }

    public ParticleRoundView(Context context, AttributeSet attr) {
        this(context, attr, 0);
    }

    public ParticleRoundView(Context context, AttributeSet attr, int defStyleAttr) {
        super(context, attr, defStyleAttr);
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < prs.length; i++) {
            if (prs[i] == null || !prs[i].show()) {
                prs[i] = new ParticleRound(mScreenWidth / 2, mScreenHeight / 2, randomRV(), 180, 300, randomAngle(), randomRadius(), randomColor());
                continue;
            }
            prs[i].move();
            paint.setColor(prs[i].color);
            canvas.drawCircle(prs[i].centerX, prs[i].centerY, prs[i].radius, paint);

        }
        postInvalidateDelayed(33);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        Drawable bg = getBackground();
        if (widthMode == MeasureSpec.AT_MOST) {
            if (bg != null) {
                mScreenWidth = bg.getIntrinsicWidth();
            }
            if (mScreenWidth <= 0) {
                mScreenWidth = 910;
            }
        } else {
            mScreenWidth = widthSize;
        }
        if (heightMode == MeasureSpec.AT_MOST) {
            if (bg != null) {
                mScreenHeight = bg.getIntrinsicHeight();
            }
            if (mScreenHeight <= 0) {
                mScreenHeight = 826;
            }
        } else {
            mScreenHeight = heightSize;
        }
        setMeasuredDimension(mScreenWidth, mScreenHeight);
    }
}
