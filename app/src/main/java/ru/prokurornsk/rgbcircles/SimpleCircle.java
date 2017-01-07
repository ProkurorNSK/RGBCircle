package ru.prokurornsk.rgbcircles;

class SimpleCircle {
    int x;
    int y;
    private int radius;

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    int getRadius() {
        return radius;
    }

    SimpleCircle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
}
