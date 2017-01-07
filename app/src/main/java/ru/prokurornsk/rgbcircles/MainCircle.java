package ru.prokurornsk.rgbcircles;

class MainCircle {
    private static final int INIT_RADIUS = 50;
    private int x;
    private int y;
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

    MainCircle(int x, int y) {
        this.x = x;
        this.y = y;
        this.radius = INIT_RADIUS;
    }
}
