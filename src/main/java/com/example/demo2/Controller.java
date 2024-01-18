package com.example.demo2;

import javafx.scene.input.MouseEvent;

public class Controller {

    private Model model;

    private IModel iModel;
    private Entity selectedEntity;

    private enum InteractionState {READY, DRAGGING, PREPARE_CREATE};
    private InteractionState state = InteractionState.READY;
    private double startX, startY, dX, dY;

    public void setModel(Model m)
    {
        model = m;
    }

    public void setIModel(IModel iModel) {
        this.iModel = iModel;
    }

    public void handleMousePressed(MouseEvent event) {
        startX = event.getX();
        startY = event.getY();
        selectedEntity = model.whichHit(startX, startY);

        if (selectedEntity != null) {
            iModel.select(selectedEntity);
            state = InteractionState.DRAGGING;
        } else {
            state = InteractionState.PREPARE_CREATE;
        }
    }


    public void handleMouseDragged(MouseEvent event) {
        switch (state) {
            case DRAGGING:
                if (selectedEntity != null) {
                    double dX = event.getX() - startX;
                    double dY = event.getY() - startY;
                    selectedEntity.move(dX, dY);
                    model.notifySubscribers();
                    startX = event.getX();
                    startY = event.getY();
                }
                break;
            default:
                break;
        }
    }


    public void handleMouseReleased(MouseEvent event) {
        switch (state) {
            case DRAGGING:
                iModel.unselect();
                selectedEntity = null;
                break;
            case PREPARE_CREATE:
                model.addEntity(event.getX(), event.getY());
                break;
            default:
                break;
        }
        state = InteractionState.READY;
    }

}
