package com.example.particle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import static com.example.particle.Util.randomColor;
import static com.example.particle.Util.randomRadius;
import static com.example.particle.Util.randomV;

/**
 * Created by mysat on 2018/5/12.
 */

public class ParticlesView extends View {

    Paint paint = new Paint();

    int mScreenWidth = 910;
    int mScreenHeight = 826;

    Particle[] particles = new Particle[120];

    public ParticlesView(Context context) {
        this(context, null);
    }

    public ParticlesView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ParticlesView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < particles.length; i++) {
            if (particles[i] == null || particles[i].state() == 0) {
                particles[i] = new Particle(mScreenWidth / 2,  mScreenHeight / 2, randomV(), randomV(), randomRadius(), randomColor(), mScreenWidth, mScreenHeight);
                continue;
            }
            particles[i].move();
            paint.setColor(particles[i].color);
            canvas.drawCircle(particles[i].centerX, particles[i].centerY, particles[i].radius, paint);

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
