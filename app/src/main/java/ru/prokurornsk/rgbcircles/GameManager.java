package ru.prokurornsk.rgbcircles;

import java.util.ArrayList;

class GameManager {
    private static final int MAX_CIRCLES = 10;
    private MainCircle mainCircle;
    private ArrayList<EnemyCircle> enemyCircles;
    private final CanvasView canvasView;
    private static int width;
    private static int height;


    GameManager(CanvasView canvasView, int w, int h) {
        this.canvasView = canvasView;
        width = w;
        height = h;
        initMainCircle();
        initEnemyCircles();
    }

    private void initEnemyCircles() {
        enemyCircles = new ArrayList<>();
        for (int i = 0; i < MAX_CIRCLES; i++) {
            EnemyCircle circle;
            circle = EnemyCircle.getRandomCircle();
            enemyCircles.add(circle);
        }
        calculateAndSetCirclesColor();
    }

    private void calculateAndSetCirclesColor() {
        for (EnemyCircle circle : enemyCircles) {
            circle.setEnemyOrFoodColorDependsOn(mainCircle);
        }
    }

    static int getWidth() {
        return width;
    }

    static int getHeight() {
        return height;
    }

    private void initMainCircle() {
        mainCircle = new MainCircle(width / 2, height / 2);
    }

    void onDraw() {
        canvasView.drawCircle(mainCircle);
        for (EnemyCircle circle: enemyCircles) {
            canvasView.drawCircle(circle);
        }
    }

    void onTouchEvent(int x, int y) {
        mainCircle.moveMainCircleWhenTouchAt(x, y);
    }
}
