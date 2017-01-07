package ru.prokurornsk.rgbcircles;

import java.util.Random;

class EnemyCircle extends SimpleCircle {

    private static final int FROM_RADIUS = 10;
    private static final int TO_RADIUS = 110;

    private EnemyCircle(int x, int y, int radius) {
        super(x, y, radius);
    }

    static EnemyCircle getRandomCircle() {
        Random random = new Random();
        int x = random.nextInt(GameManager.getWidth());
        int y = random.nextInt(GameManager.getHeight());
        int radius = FROM_RADIUS + random.nextInt(TO_RADIUS - FROM_RADIUS);
        return new EnemyCircle(x, y, radius);
    }
}
