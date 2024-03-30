package com.example.nlrs_main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class PerformanceReport_Controller  {
    @FXML
    private AnchorPane chartPane;

    private String lecturerID;
    private String unitName;
    private PerformanceReport performanceReport;

    @FXML
    private PieChart pieChart;

    @FXML
    private ListView<String> strengthsListView;

    @FXML
    private ListView<String> weaknessesListView;

    @FXML
    private Label performanceCommentLabel;


    public void initialize(String lecturerID, String unitName) {
        this.lecturerID = lecturerID;
        this.unitName = unitName;
        performanceReport = new PerformanceReport(lecturerID, unitName);
        initializeUI();
    }

    private void initializeUI() {
        pieChart.setData(performanceReport.getPieChartData());
        strengthsListView.setItems(performanceReport.getStrengths());
        weaknessesListView.setItems(performanceReport.getWeaknesses());
        performanceCommentLabel.setText(performanceReport.getPerformanceComment());
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
