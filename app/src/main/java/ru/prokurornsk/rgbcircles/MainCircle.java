package ru.prokurornsk.rgbcircles;

class MainCircle extends SimpleCircle{
    private static final int INIT_RADIUS = 50;
    private static final int MAIN_SPEED = 30;

    MainCircle(int x, int y) {
        super(x, y, INIT_RADIUS);
    }

    void moveMainCircleWhenTouchAt(int x1, int y1) {
        int dx = (x1 - x) * MAIN_SPEED / GameManager.getWidth();
        int dy = (y1 - y) * MAIN_SPEED / GameManager.getHeight();
        x += dx;
        y += dy;

    }
}
