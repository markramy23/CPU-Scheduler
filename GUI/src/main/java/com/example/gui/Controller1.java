package com.example.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller1 implements Initializable {
    @FXML
    private TableColumn<Job, String> ProcessesAdded;

    @FXML
    private TableView<Job> Table_processes;
    @FXML
    private Label algorithmType;
    @FXML
    private Label turnaroundField;
    @FXML
    private Label waitingField;
    @FXML
    private TableView<Job> Table;
    private ObservableList<Job> jobList = FXCollections.observableArrayList();
    @FXML
    private AnchorPane anchor;

    @FXML
    private TextField bursttime;

    @FXML
    private TextField priority;

    @FXML
    private TextField processname;

    @FXML
    private Button addprocess;
    @FXML
    private TableColumn<Job, Integer> burst_table;

    @FXML
    private TableColumn<Job, String> name_table;

    @FXML
    private TableColumn<Job, Integer> priority_table;

    @FXML
    private TableColumn<Job, Integer> waiting_table;
    @FXML
    private TextField NoProcesses; // Remove the static keyword
    /*    id.setCellValueFactory(new PropertyValueFactory<jobs,Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<jobs,String>("name"));
        lname.setCellValueFactory(new PropertyValueFactory<jobs,String>("lname"));
        gmail.setCellValueFactory(new PropertyValueFactory<jobs,String>("gmail"));
    */

    @FXML
    void addProcess(ActionEvent event) {
                String name = processname.getText();
                int arrivalTime = 0; // You need to get this value from the GUI as well
                int burstTime = Integer.parseInt(bursttime.getText());
                int priorityLevel = Integer.parseInt(priority.getText());
                // Create a new Job object with the retrieved values
                Job newJob = new Job(name, arrivalTime, burstTime, priorityLevel);

                jobList.add(newJob);
                /* System.out.print(newJob.getName());
                System.out.print(newJob.getArrivalTime());
                System.out.print(newJob.getPriorityLevel());
                System.out.print(newJob.getWaitingTime());
                System.out.print("      ");*/
                 updateTable();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
         updateTable();
    }
    public void updateTable()
    {
        //algorithmType.setText(HelloController.scheduler);
        ProcessesAdded.setCellValueFactory(new PropertyValueFactory<Job,String>("name"));
        //burst_table.setCellValueFactory(new PropertyValueFactory<Job,Integer>("burstTime"));
        //waiting_table.setCellValueFactory(new PropertyValueFactory<Job,Integer>("waiting"));
        //priority_table.setCellValueFactory(new PropertyValueFactory<Job,Integer>("priorityLevel"));

        Table_processes.setItems(jobList);
    }



}
