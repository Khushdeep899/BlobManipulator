package com.example.demo2;

import javafx.scene.layout.StackPane;

public class MainUI extends StackPane {

    public MainUI() {
        // create MVC components
        Controller controller = new Controller();
        View view = new View();
        Model model = new Model();
        IModel iModel = new IModel();

        // link MVC together
        view.setupEvents(controller);
        controller.setModel(model);
        controller.setIModel(iModel);
        model.addSubscriber(view);


        this.getChildren().add(view);
    }

}
