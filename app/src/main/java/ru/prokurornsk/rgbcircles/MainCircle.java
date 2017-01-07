package ru.prokurornsk.rgbcircles;

class MainCircle {
    private static final int INIT_RADIUS = 50;
    private static final int MAIN_SPEED = 30;
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

    void moveMainCircleWhenTouchAt(int x1, int y1) {
        int dx = (x1 - x) * MAIN_SPEED / GameManager.getWidth();
        int dy = (y1 - y) * MAIN_SPEED / GameManager.getHeight();
        x += dx;
        y += dy;

    }
}
