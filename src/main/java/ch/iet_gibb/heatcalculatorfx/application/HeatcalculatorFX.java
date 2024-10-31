package ch.iet_gibb.heatcalculatorfx.application;

import ch.iet_gibb.heatcalculatorfx.controller.HeatcalculatorController;
import ch.iet_gibb.heatcalculatorfx.model.CylinderTank;
import ch.iet_gibb.heatcalculatorfx.model.SquaredTank;
import ch.iet_gibb.heatcalculatorfx.model.SuperTank;
import ch.iet_gibb.heatcalculatorfx.model.UnknownTank;
import ch.iet_gibb.heatcalculatorfx.view.AlternativeHeatView;
import ch.iet_gibb.heatcalculatorfx.view.HeatcalculatorView;
import javafx.application.Application;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class HeatcalculatorFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        List<SuperTank> models = createModels();
        HeatcalculatorController controller = new HeatcalculatorController(models);
        //Hier können wir die View austauschen
        AlternativeHeatView alternativeView = new AlternativeHeatView(stage, controller);
        HeatcalculatorView view = new HeatcalculatorView(stage, controller);
        //Hier einfach statt view die alternativeView setzen
        //controller.setView(alternativeView);
        controller.setView(view);
        controller.startView();
    }

    protected List<SuperTank> createModels(){
        ArrayList<SuperTank> tanks = new ArrayList<>();
        tanks.add(new CylinderTank(100.0, "Tank 1", 100.0, 10.0, 10.0));
        tanks.add(new SquaredTank(45.5, "Tank 2", 200.0, 15.0, 10.0));
        tanks.add(new UnknownTank(100.0, 20.0, "Tank 3", 100.0));
        return tanks;
    }

    public static void main(String[] args) {
        launch(args);
    }
}