package ru.prokurornsk.rgbcircles;

import android.graphics.Canvas;
import android.graphics.Paint;

class GameManager {
    private MainCircle mainCircle;
    private Paint paint;

    GameManager() {
        initMainCircle();
        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    private void initMainCircle() {
        mainCircle = new MainCircle(200, 500);
    }

    void onDraw(Canvas canvas) {
        canvas.drawCircle(mainCircle.getX(), mainCircle.getY(), mainCircle.getRadius(), paint);
    }
}
