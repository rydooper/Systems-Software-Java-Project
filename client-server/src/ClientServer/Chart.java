/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientServer;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.stage.Stage;
/**
 *
 * @author lwa15
 */
public class Chart extends Application { //Lines 17-41 have been adapted from "Example 3-1 Simple Line Chart from the Oracle JavaFX documentation (https://docs.oracle.com/javafx/2/charts/line-chart.htm)
    @Override public void start(Stage stage) { //starts the line graph building
        stage.setTitle("Change of crops grown during the last six months");
        final NumberAxis xAxis = new NumberAxis(); //Declares a new axis object
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Month Number");
        yAxis.setLabel("Number of crops grown");
        final LineChart<Number,Number> lineChart = new LineChart<>(xAxis,yAxis); //Declares a new Line Chart
        lineChart.setTitle("Change of crops grown during the last six months");
        XYChart.Series series = new XYChart.Series(); //Declares a container to store the XY values
        series.setName("Carrots");
        series.getData().add(new XYChart.Data(1, 15)); //Adds a XY pair to the XYChart object
        series.getData().add(new XYChart.Data(2, 18));
        series.getData().add(new XYChart.Data(3, 25));
        series.getData().add(new XYChart.Data(4, 19));
        series.getData().add(new XYChart.Data(5, 38));
        series.getData().add(new XYChart.Data(6, 41));
        
        Scene scene = new Scene(lineChart,800,600);
        lineChart.getData().add(series); //Adds the data into the graph
        stage.setScene(scene);
        stage.show(); //Show the constructed line graph
    }
    public static void main(String[] args) {
        launch(args); //Launches the line graph setup
        
    }
}