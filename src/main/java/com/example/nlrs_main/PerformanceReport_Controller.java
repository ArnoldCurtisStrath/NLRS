package com.example.nlrs_main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class PerformanceReport_Controller implements Initializable {
    @FXML
    private AnchorPane chartPane;

    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {
        loadPerformanceReport();
    }

    public void loadPerformanceReport(){
        chartPane.getChildren().clear();
        ObservableList<PieChart.Data> reportContentList = FXCollections.observableArrayList();
        reportContentList.add(new PieChart.Data("Time-Keeping", 9.5));
        reportContentList.add(new PieChart.Data("Interactions", 8));
        reportContentList.add(new PieChart.Data("Loving", 5));
        reportContentList.add(new PieChart.Data("heheh", 2));
        reportContentList.add(new PieChart.Data("yeah", -5.5));

        PieChart performanceReportChart = new PieChart(reportContentList);
        performanceReportChart.setTitle("Average Performance Report Chart");
        chartPane.getChildren().add(performanceReportChart);
    }


}
