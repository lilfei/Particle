package com.example.particle;

/**
 * Created by mysat on 2018/5/13.
 */

public class Particle {

    public float centerX;   // 圆心x
    public float centerY;   // 圆心y

    private double centerVX;
    private double centerVY;

    public int radius;
    public int color;

    private float viewWidth;
    private float viewHeight;

    public Particle(float x, float y, double vx, double vy, int r, int c, float vw, float vh) {
        this.centerX = x;
        this.centerY = y;

        this.centerVX = vx;
        this.centerVY = vy;

        this.radius = r;
        this.color = c;

        this.viewWidth = vw;
        this.viewHeight = vh;
    }

    public void move() {
        centerX += centerVX;
        centerY += centerVY;
    }

    public int state() {
        if (0 < centerX && centerX < viewWidth && 0 < centerY && centerY < viewHeight) {
            return 1;
        } else {
            return 0;
        }
    }
}
