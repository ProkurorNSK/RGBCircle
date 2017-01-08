package ru.prokurornsk.rgbcircles;

class SimpleCircle {
    int x;
    int y;
    int radius;
    private int color;

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    int getRadius() {
        return radius;
    }

    SimpleCircle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int getColor() {
        return color;
    }

    void setColor(int color) {
        this.color = color;
    }

    SimpleCircle getCircleArea() {
        return new SimpleCircle(x, y, radius * 3);
    }

    boolean isIntersect(SimpleCircle circle) {
        return (radius + circle.radius) >= Math.sqrt(Math.pow(x - circle.x, 2) + Math.pow(y - circle.y, 2));
    }
}
