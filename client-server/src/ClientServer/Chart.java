/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientServer;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.stage.Stage;
/**
 *
 * @author lwa15
 */
public class Chart extends Application { //method of creating a bar chart has been adapted from "Example 7-1 Creating a Bar Chart with Three Series of Data" from the Oracle JavaFX documentation (https://docs.oracle.com/javafx/2/charts/bar-chart.htm)
    @Override public void start(Stage stage) { //starts the line graph building
        stage.setTitle("Bar Chart to show Weather Station data"); //sets the title of the bar chart page
        final CategoryAxis xAxis = new CategoryAxis(); //new class for the X-Axis declared 
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> barChart = new BarChart<String,Number>(xAxis,yAxis); //Declares a new bar chart
        barChart.setTitle("A bar chart to show the Weather Station data"); //sets the bar chart's title
        xAxis.setLabel("Features"); //x-axis label
        yAxis.setLabel("Value"); //y-axis label
        
        XYChart.Series WSDataSeries = new XYChart.Series(); //declares a new container to store the XY values inside for the graph
        WSDataSeries.setName("Weather Station " + StationDataDisplayUI.stationNoInput.getText()); //declares the legend of the graph, which is the Weather Station name       
        String Humidity = StationDataDisplayUI.humidityInput.getText(); //gets the text inside the text boxes
        String Wind = StationDataDisplayUI.windInput.getText().trim(); //.trim() removes the leading and following space characters
        String Precipitation = StationDataDisplayUI.precipitationInput.getText().trim();
        Integer HumidityValue = Integer.parseInt(Humidity); //converts String into Integer for the graph
        Integer WindValue = Integer.parseInt(Wind);
        Integer PrecipitationValue = Integer.parseInt(Precipitation);
        WSDataSeries.getData().add(new XYChart.Data("Humidity", HumidityValue)); //adds the data to the series, with "Humidity" being on the x-axis and the value on the y-axis
        WSDataSeries.getData().add(new XYChart.Data("Wind", WindValue));
        WSDataSeries.getData().add(new XYChart.Data("Percipitation", PrecipitationValue));
        
        Scene scene  = new Scene(barChart,800,600); //sets a new scene for the bar chart
        barChart.getData().addAll(WSDataSeries); //implements the data series into the bar chart
        stage.setScene(scene);
        stage.show(); //shows the bar chart
    }
    public static void main(String[] args) {
        launch(args); //Launches the line graph setup
    }
}