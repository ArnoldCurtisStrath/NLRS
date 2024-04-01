package com.example.nlrs_main;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class PerformanceReport_Controller {
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
    private ListView<String> nuetralListView;

    @FXML
    private Label performanceCommentLabel;

    @FXML
    private Label performanceCommentLabel1;

    @FXML
    private Label performanceCommentLabel2;

    @FXML
    private TextFlow reportAnalysisDescription;


    public void initialize(String lecturerID, String unitName) {
        this.lecturerID = lecturerID;
        this.unitName = unitName;
        initializeUI();
    }
    private void initializeUI() {
        performanceReport = new PerformanceReport(lecturerID, unitName);
        pieChart.setData(performanceReport.getPieChartData());
        strengthsListView.setItems(performanceReport.getStrengths());
        weaknessesListView.setItems(performanceReport.getWeaknesses());
        nuetralListView.setItems(performanceReport.getNeutrals());

        if (performanceReport.getPerformanceComment().equals("Amazing")){
            performanceCommentLabel.setText(performanceReport.getPerformanceComment());
        } else if (performanceReport.getPerformanceComment().equals("Good")) {
            performanceCommentLabel1.setText(performanceReport.getPerformanceComment());
        } else {
            performanceCommentLabel2.setText(performanceReport.getPerformanceComment());
        }
        printDescriptionOnTextFlow();
    }
    public void printDescriptionOnTextFlow(){
        StringBuilder description = new StringBuilder();

        int weaknessesCount = performanceReport.getWeaknesses().size();
        int strengthsCount = performanceReport.getStrengths().size();
        int neutralsCount = performanceReport.getNeutrals().size();

        if (weaknessesCount > strengthsCount && weaknessesCount > neutralsCount) {
            description.append("According to the performance report chart, you need to work extremely hard because you " +
                    "have more weaknesses. \n\n" +
                    "");
            description.append("You have a negative performance report review. ");
            description.append("This means students do not agree with your methods of lecturing them, hence you have ")
                    .append(weaknessesCount).append(" weaknesses\n");

        } else if (strengthsCount > weaknessesCount && strengthsCount > neutralsCount) {
            description.append("Congratulations! According to the performance report chart, you are doing great. ");
            description.append("You have more strengths, and your overall performance is positive. ");
            description.append("Keep up the good work!\n");
        } else {
            description.append("Your performance is average. ");
            description.append("You have equal or nearly equal strengths and weaknesses. ");
            description.append("You need to work extra hard to improve.\n");
        }

        if (strengthsCount > 0) {
            description.append("\nDespite all the stated reviews, a small number of students did find your lectures " +
                    "good. ");
            description.append("You excelled in the following categories:\n\n");

            // Append neutrals
            ObservableList<String> strengthsList = performanceReport.getStrengths();
            for (String strengths : strengthsList) {
                description.append("- ").append(strengths).append("\n");
            }
        }

        description.append("\nTake a look at well summarized lecturing Skills in the sections below:");

        Text descriptionText = new Text(description.toString());
        reportAnalysisDescription.getChildren().add(descriptionText);
    }

}