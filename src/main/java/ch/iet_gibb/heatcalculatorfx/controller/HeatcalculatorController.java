package ch.iet_gibb.heatcalculatorfx.controller;

import ch.iet_gibb.heatcalculatorfx.model.SuperTank;
import ch.iet_gibb.heatcalculatorfx.view.HeatcalculatorView;
import javafx.event.ActionEvent;
import java.util.List;

public class HeatcalculatorController implements javafx.event.EventHandler<ActionEvent> {


    protected List<SuperTank> models;
    protected HeatcalculatorView view;
    protected int currentTank =0;

    public HeatcalculatorController(List<SuperTank> models) {
        this.models = models;
    }

    public void setView(HeatcalculatorView view){
        this.view=view;
    }

    public void startView(){
        view.startView(models.get(currentTank));
    }

    public void showNextTank(){
        if(currentTank < models.size()-1) {
            currentTank++;
        }else{
            currentTank = 0;
        }
        view.startView(models.get(currentTank));
    }

    public String getTank(){
        return models.get(currentTank).toString();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        showNextTank();
    }
}