package ch.iet_gibb.heatcalculatorfx.view;

import ch.iet_gibb.heatcalculatorfx.Property.Property;
import ch.iet_gibb.heatcalculatorfx.controller.HeatcalculatorController;
import ch.iet_gibb.heatcalculatorfx.model.ControllerViewInterface;
import ch.iet_gibb.heatcalculatorfx.model.InterfaceTank;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AlternativeHeatView implements ControllerViewInterface {
    protected HeatcalculatorController controller;
    protected Stage stage;

    public AlternativeHeatView(Stage stage, HeatcalculatorController controller) {
        this.controller = controller;
        this.stage=stage;
        stage.setTitle("Heatcalculator");
    }

    @Override
    public void startView(InterfaceTank data) {
        VBox layout = new VBox();
        layout.setPadding(new Insets(10));
        layout.setSpacing(10);
        Text labelText = getLabelNode(data.getTitle());
        layout.getChildren().add(labelText);
        VBox propertiesLayout = new VBox();
        for(Property property : data.getProperties()){
            addPropertyToPane(property, propertiesLayout);
        }
        layout.getChildren().add(propertiesLayout);

        /* Button erstellen und dem Layout anfügen, um zwischen den Labels navigieren zu können */
        Button btnNext = new Button("→");
        btnNext.setOnAction(controller);
        layout.getChildren().add(btnNext);

        /* Scene erstellen und die View darstellen */
        Scene scene = new Scene(layout,600,600);
        stage.setScene(scene);
        stage.show();
    }

    protected Text getLabelNode(String title){
        Text labelText = new Text();
        labelText.setText(title);
        labelText.setFont(Font.font ("Arial", FontWeight.EXTRA_BOLD, 30));
        labelText.setStyle("-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, darkblue 0%, black 50%);");
        return labelText;
    }

    protected void addPropertyToPane(Property property, Pane propertiesLayout){
        Text keyText = new Text();
        keyText.setText(property.getKey());
        keyText.setFont(Font.font ("Arial", FontWeight.BOLD, 20));
        propertiesLayout.getChildren().add(keyText);
        Text valueText = new Text();
        valueText.setText(property.getValue());
        valueText.setFont(Font.font ("Arial", FontWeight.NORMAL, 16));
        propertiesLayout.getChildren().add(valueText);
    }
}
