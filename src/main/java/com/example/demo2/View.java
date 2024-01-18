package com.example.demo2;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.List;

public class View extends StackPane implements Subscriber {

    Canvas myCanvas; // canvas is what you draw on
    GraphicsContext gc; // graphics context is what you "draw with"

    public View() {
        myCanvas = new Canvas(500, 500);
        gc = myCanvas.getGraphicsContext2D();
        this.getChildren().add(myCanvas);
    }

    public void setupEvents(Controller controller) {
        this.setOnMousePressed(controller::handleMousePressed);
        this.setOnMouseDragged(controller::handleMouseDragged);
        this.setOnMouseReleased(controller::handleMouseReleased);
    }

    public void draw(List<Entity> entities) {
        gc.clearRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
        gc.setFill(Color.INDIGO);
        entities.forEach(entity -> {
            gc.fillOval(entity.getX() - 10, entity.getY() - 10, 20, 20);
        });
    }

    @Override
    public void modelChanged(List<Entity> entities) {
        // whenever the model changed, re-draw the canvas
        draw(entities);
    }
}
