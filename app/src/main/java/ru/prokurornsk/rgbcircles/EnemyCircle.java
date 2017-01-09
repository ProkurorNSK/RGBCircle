package ru.prokurornsk.rgbcircles;

import android.graphics.Color;

import java.util.Random;

class EnemyCircle extends SimpleCircle {

    private static final int FOOD_COLOR = Color.GREEN;
    private static final int FROM_RADIUS = 10;
    private static final int TO_RADIUS = 110;
    private static final int ENEMY_COLOR = Color.RED;
    private static final int RANDOM_SPEED = 10;
    private int dx;
    private int dy;

    private EnemyCircle(int x, int y, int radius, int dx, int dy) {
        super(x, y, radius);
        this.dx = dx;
        this.dy = dy;
    }

    static EnemyCircle getRandomCircle() {
        Random random = new Random();
        int radius = FROM_RADIUS + random.nextInt(TO_RADIUS - FROM_RADIUS);
        int x = radius + random.nextInt(GameManager.getWidth() - radius * 2);
        int y = radius + random.nextInt(GameManager.getHeight() - radius * 2);
        int dx = 1 + random.nextInt(RANDOM_SPEED);
        int dy = 1 + random.nextInt(RANDOM_SPEED);
        return new EnemyCircle(x, y, radius, dx, dy);
    }

    void setEnemyOrFoodColorDependsOn(MainCircle mainCircle) {
        if (isSmallerThen(mainCircle)) {
            setColor(FOOD_COLOR);
        } else {
            setColor(ENEMY_COLOR);
        }
    }

    boolean isSmallerThen(SimpleCircle circle) {
        return radius < circle.radius;
    }

    void moveOneStep() {
        x += dx;
        y += dy;
        checkBounds();
    }

    private void checkBounds() {
        if (x + radius > GameManager.getWidth() || x < radius) {
            dx = -dx;
        }
        if (y + radius > GameManager.getHeight() || y < radius) {
            dy = -dy;
        }
    }
}
