package ru.prokurornsk.rgbcircles;

import java.util.ArrayList;

class GameManager {
    private static final int MAX_CIRCLES = 10;
    public static final int PADDING = 30;
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
        SimpleCircle mainCircleArea = mainCircle.getCircleArea();
        enemyCircles = new ArrayList<>();
        for (int i = 0; i < MAX_CIRCLES; i++) {
            EnemyCircle circle;
            do {
                circle = EnemyCircle.getRandomCircle();
            } while (circle.isIntersect(mainCircleArea));
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
        return width - 2 * PADDING;
    }

    static int getHeight() {
        return height;
    }

    private void initMainCircle() {
//        mainCircle = new MainCircle(width / 2, height / 2);
        mainCircle = new MainCircle(width / 2 - PADDING, height / 2 - PADDING);
    }

    void onDraw() {
        canvasView.drawCircle(mainCircle);
        for (EnemyCircle circle : enemyCircles) {
            canvasView.drawCircle(circle);
        }
    }

    void onTouchEvent(int x, int y) {
        mainCircle.moveMainCircleWhenTouchAt(x, y);
        checkCollision();
        moveCircles();
    }

    private void checkCollision() {
        EnemyCircle circleForDel = null;
        for (EnemyCircle circle : enemyCircles) {
            if (mainCircle.isIntersect(circle)) {
                if (circle.isSmallerThen(mainCircle)) {
                    mainCircle.growRadius(circle);
                    circleForDel = circle;
                    calculateAndSetCirclesColor();
                    break;
                } else {
                    gameEnd("Проиграл!");
                    return;
                }
            }
        }
        if (circleForDel != null) {
            enemyCircles.remove(circleForDel);
        }
        if (enemyCircles.isEmpty()) {
            gameEnd("Выйграл!!!");
        }
    }

    private void gameEnd(String text) {
        canvasView.showMessage(text);
        mainCircle.initRadius();
        initEnemyCircles();
        canvasView.redraw();
    }

    private void moveCircles() {
        for (EnemyCircle circle : enemyCircles) {
            circle.moveOneStep();
        }
    }
}
