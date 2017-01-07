package ru.prokurornsk.rgbcircles;

import android.graphics.Color;

import java.util.Random;

class EnemyCircle extends SimpleCircle {

    private static final int FOOD_COLOR = Color.rgb(0, 200, 0);
    private static final int FROM_RADIUS = 10;
    private static final int TO_RADIUS = 110;
    private static final int ENEMY_COLOR = Color.RED;

    private EnemyCircle(int x, int y, int radius) {
        super(x, y, radius);
        setColor(ENEMY_COLOR);
    }

    static EnemyCircle getRandomCircle() {
        Random random = new Random();
        int x = random.nextInt(GameManager.getWidth());
        int y = random.nextInt(GameManager.getHeight());
        int radius = FROM_RADIUS + random.nextInt(TO_RADIUS - FROM_RADIUS);
        return new EnemyCircle(x, y, radius);
    }

    void setEnemyOrFoodColorDependsOn(MainCircle mainCircle) {
        if (isSmallerThen(mainCircle)) {
            setColor(FOOD_COLOR);
        } else {
            setColor(ENEMY_COLOR);
        }
    }

    private boolean isSmallerThen(SimpleCircle circle) {
        return radius < circle.radius;
    }
}
