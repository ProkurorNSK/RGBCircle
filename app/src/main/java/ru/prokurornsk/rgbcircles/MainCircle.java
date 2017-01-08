package ru.prokurornsk.rgbcircles;

import android.graphics.Color;

class MainCircle extends SimpleCircle{
    private static final int INIT_RADIUS = 50;
    private static final int MAIN_SPEED = 30;
    private static final int OUR_COLOR = Color.BLUE;

    MainCircle(int x, int y) {
        super(x, y, INIT_RADIUS);
        setColor(OUR_COLOR);
    }

    void moveMainCircleWhenTouchAt(int x1, int y1) {
        int dx = (x1 - x) * MAIN_SPEED / GameManager.getWidth();
        int dy = (y1 - y) * MAIN_SPEED / GameManager.getHeight();
        x += dx;
        y += dy;

    }

    void initRadius() {
        radius = INIT_RADIUS;
    }
}
