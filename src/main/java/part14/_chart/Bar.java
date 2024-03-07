package dataviz.chart;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Bar extends Application {
    @Override
    public void start(Stage stage) {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);

        barChart.setTitle("Populations of the Nordic countries");
        barChart.setLegendVisible(false);

        List<XYChart.Data> populationData = new ArrayList<>();
        populationData.add(new XYChart.Data("Sweden", 10313447));
        populationData.add(new XYChart.Data("Denmark", 5809502));
        populationData.add(new XYChart.Data("Finland", 5537364));
        populationData.add(new XYChart.Data("Norway", 5372191));
        populationData.add(new XYChart.Data("Iceland", 343518));
        XYChart.Series populations = new XYChart.Series();
        populationData.stream()
                .sorted((o1, o2) -> o1.getXValue().toString().compareToIgnoreCase(o2.getXValue().toString()))
                .forEachOrdered(data -> populations.getData().add(data));

        barChart.getData().add(populations);
        Scene view = new Scene(barChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }

    public static void main(String[] args) {
        launch(Bar.class);
    }
}
