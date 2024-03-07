package dataviz.datastructure;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.HashMap;
import java.util.Map;

public class Better {
    public static void main(String[] args) {
        Map<String, Map<Integer, Double>> values = new HashMap<>();

        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);

        values.keySet().forEach(party -> {
            XYChart.Series data = new XYChart.Series();
            data.setName(party);

            values.get(party).entrySet().forEach(pair -> {
                data.getData().add(new XYChart.Data<>(pair.getKey(), pair.getValue()));
            });

            lineChart.getData().add(data);
        });
    }
}
