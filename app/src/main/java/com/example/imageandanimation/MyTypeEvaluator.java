package com.example.imageandanimation;

import android.animation.TypeEvaluator;


public class MyTypeEvaluator implements TypeEvaluator<MyTypeEvaluator.Point> {
    private int width;
    private int height;
    final int R = width / 4;

    MyTypeEvaluator(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        float x = startValue.getX() + fraction * (endValue.getX() - startValue.getX());
        float y = startValue.getY() + fraction * (endValue.getY() - startValue.getY());
        Point point = new Point(x, y);
        return point;
    }

    public static class Point {

        private float x;
        private float y;

        public Point() {
        }

        public Point(float x, float y) {
            this.x = x;
            this.y = y;
        }

        public float getX() {
            return x;
        }

        public float getY() {
            return y;
        }

        public void setX(float x) {
            this.x = x;
        }

        public void setY(float y) {
            this.y = y;
        }
    }

}
