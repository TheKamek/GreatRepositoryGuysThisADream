package ch.iet_gibb.heatcalculatorfx.view;

import ch.iet_gibb.heatcalculatorfx.controller.HeatcalculatorController;
import ch.iet_gibb.heatcalculatorfx.model.ControllerViewInterface;
import ch.iet_gibb.heatcalculatorfx.model.InterfaceTank;
import ch.iet_gibb.heatcalculatorfx.Property.Property;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.Region;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class HeatcalculatorView implements ControllerViewInterface {
    protected Stage stage;

    protected HeatcalculatorController controller;


    public HeatcalculatorView(Stage stage, HeatcalculatorController controller) {
        this.stage = stage;
        this.controller = controller;
    }

    @Override
    public void startView(InterfaceTank data) {
        VBox layout = new VBox();
        layout.setPadding(new Insets(15, 15, 15, 15));
        layout.setSpacing(20);
        Text labelText = new Text();
        labelText.setText(data.getTitle());
        labelText.setFont(Font.font ("Tahoma", FontWeight.EXTRA_BOLD, 20));
        labelText.setStyle("-fx-font-family: monospace;-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, aqua 0%, red 50%);");
        layout.getChildren().add(labelText);
        TilePane propertiesPane = new TilePane();
        propertiesPane.setPrefColumns(2);
        propertiesPane.setMaxWidth(Region.USE_PREF_SIZE);
        propertiesPane.setMaxHeight(100);
        for(Property property :data.getProperties()){
            addPropertyToPane(property, propertiesPane);
        }
        layout.getChildren().add(propertiesPane);
        Button btnNext;
        btnNext =new Button("→");
        btnNext.setOnAction(controller);
        layout.getChildren().add(btnNext);
        Scene scene = new Scene(layout, 600, 600);
        stage.setScene(scene);
        stage.show();
    }

    protected void addPropertyToPane(Property property, Pane layout) {
        Font propertiesFont = Font.font("Tahoma", FontWeight.BOLD, 16);

        Text keyText = new Text();
        keyText.setText(property.getKey());
        keyText.setFont(propertiesFont);
        keyText.setWrappingWidth(200);
        keyText.setTextAlignment(TextAlignment.LEFT);
        layout.getChildren().add(keyText);
        Text valueText = new Text();
        valueText.setText(property.getValue());
        valueText.setFont(propertiesFont);
        valueText.setWrappingWidth(200);
        valueText.setTextAlignment(TextAlignment.RIGHT);
        layout.getChildren().add(valueText);

    }
}