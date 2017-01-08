package ru.prokurornsk.rgbcircles;


interface ICanvasView {
    void drawCircle(SimpleCircle circle);

    void redraw();

    void showMessage(String text);
}
