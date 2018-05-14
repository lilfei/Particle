package com.example.particle;

/**
 * Created by mysat on 2018/5/14.
 */

public class ParticleRound {

    float startX;
    float startY;

    float centerX;
    float centerY;

    double centerV;

    float startR;
    float centerR = 0;
    float endR;

    int angle;

    int radius;
    int color;

    public ParticleRound(float cx, float cy, double cv, float sr, float er, int a, int r, int c) {
        this.startX = cx;
        this.startY = cy;

        this.centerV = cv;

        this.startR = sr;
        this.centerR = sr;
        this.endR = er;

        this.angle = a;

        this.radius = r;
        this.color = c;
    }

    public void move() {
        centerR += centerV;
        centerX = startX + (float) (centerR * Math.sin(angle));
        centerY = startY + (float) (centerR * Math.cos(angle));
    }

    public boolean show() {
        return startR <= centerR && centerR <= endR;
    }
}
