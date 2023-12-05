package com.example.finalprojectparttwo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class StudentController {

    TextField[] textFields;
    private ObservableList<Advisee> adviseesList = FXCollections.observableArrayList();
    private String name, acadID, email, address;
    private long phoneNum;

    @FXML
    private Button addBtn;

    @FXML
    private Button editBtn;

    @FXML
    private ListView<Advisee> listView;

    @FXML
    private TextField txt_acadID;

    @FXML
    private TextField txt_address;

    @FXML
    private TextField txt_email;

    @FXML
    private TextField txt_name;

    @FXML
    private TextField txt_phoneNum;

    private void fillData() {
        name = txt_name.getText();
        acadID = txt_acadID.getText();
        email = txt_email.getText();
        phoneNum = Long.parseLong(txt_phoneNum.getText());
        address = txt_address.getText();
    }

    private void clearTextFields() {
        for (TextField tf : textFields) {
            tf.clear();
        }
    }

    @FXML
    void addBtnPress(ActionEvent event) {
        fillData();

        Advisee addedAdvisee = new Advisee(name, acadID);
        addedAdvisee.setEmail(email);
        //addedAdvisee.setAddress(address);
        addedAdvisee.setPhoneNum(phoneNum);
        adviseesList.add(addedAdvisee);

        clearTextFields();
    }

    @FXML
    void editBtnPress(ActionEvent event) {
        fillData();

        Advisee editedAdvisee = listView.getSelectionModel().getSelectedItem();

        if (!name.isEmpty()) {
            editedAdvisee.setName(name);
        }
        if (!email.isEmpty()) {
            editedAdvisee.setEmail(email);
        }
        editedAdvisee.setPhoneNum(phoneNum);
        listView.getSelectionModel().clearSelection();

        clearTextFields();
    }

    @FXML
    void initialize() {
        textFields = new TextField[]{txt_name, txt_acadID, txt_email, txt_phoneNum, txt_address};

        listView.setItems(adviseesList);
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Advisee>() {
            @Override
            public void changed(ObservableValue<? extends Advisee> observableValue, Advisee oldA, Advisee newA) {
                txt_name.setText(newA.getName());
                txt_acadID.setText(newA.getID());
                txt_email.setText(newA.getEmail().toString());
                txt_phoneNum.setText("" + newA.getPhoneNum());
                txt_address.setText(newA.getAddress().toString());
            }
        });
    }
}