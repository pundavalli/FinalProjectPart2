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

    TextField[] studentTextFields, courseTextFields;
    private ObservableList<Advisee> adviseesList = FXCollections.observableArrayList();
    private String name, acadID, email, phoneNum;
    private ObservableList<Course> courseList = FXCollections.observableArrayList();
    private ObservableList<Course> studentCourseList;

    @FXML
    private Button addBtn;

    @FXML
    private Button editBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button addCourseBtn;

    @FXML
    private Button deleteCourseBtn;

    @FXML
    private ListView<Advisee> adviseeListView;

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

    @FXML
    private TextField txt_tuition;

    @FXML
    private ListView<Course> courseListView;

    @FXML
    private ListView<Course> studentCourseListView;

    @FXML
    private TextField txt_courseCost;

    @FXML
    private TextField txt_courseCredits;

    @FXML
    private TextField txt_courseName;

    private void fillData() {
        name = txt_name.getText();
        acadID = txt_acadID.getText();
        email = txt_email.getText();
        phoneNum = txt_phoneNum.getText();
    }

    private void fillCourseTextFields(Course selectedCourse) {
        txt_courseName.setText(selectedCourse.getCourseName());
        txt_courseCredits.setText("" + selectedCourse.getNumOfCredits());
        txt_courseCost.setText("$" + selectedCourse.calcCost());
    }

    private void clearStudentInfo() {
        for (TextField tf : studentTextFields) {
            tf.clear();
        }
        studentCourseList.clear();
    }

    private void clearCourseInfo() {
        for (TextField tf : courseTextFields) {
            tf.clear();
        }
    }

    @FXML
    void addBtnPress(ActionEvent event) {
        fillData();

        Advisee addedAdvisee = new Advisee(name, acadID);
        if (!email.isEmpty()) {
            addedAdvisee.setEmail(email);
        }
        if (!phoneNum.isEmpty()) {
            addedAdvisee.setPhoneNum(Long.parseLong(phoneNum));
        }
        addedAdvisee.setAddress(new Address(25, "Yearsley Mill Rd", "Media", "PA", 19063));
        adviseesList.add(addedAdvisee);

        clearStudentInfo();
        adviseeListView.getSelectionModel().clearSelection();
    }

    @FXML
    void editBtnPress(ActionEvent event) {
        fillData();

        Advisee selectedAdvisee = adviseeListView.getSelectionModel().getSelectedItem();

        if (!name.isEmpty()) {
            selectedAdvisee.setName(name);
        }
        if (!acadID.isEmpty()) {
            selectedAdvisee.setID(acadID);
        }
        if (!email.isEmpty()) {
            selectedAdvisee.setEmail(email);
        }
        if (!phoneNum.isEmpty()) {
            selectedAdvisee.setPhoneNum(Long.parseLong(phoneNum));
        }

        clearStudentInfo();
        adviseeListView.getSelectionModel().clearSelection();
    }

    @FXML
    void deleteBtnPress(ActionEvent event) {
        adviseesList.remove(adviseeListView.getSelectionModel().getSelectedItem());
        clearStudentInfo();
        adviseeListView.getSelectionModel().clearSelection();
    }

    @FXML
    void add_CoursePress(ActionEvent event) {
        Course selectedCourse = courseListView.getSelectionModel().getSelectedItem();
        adviseeListView.getSelectionModel().getSelectedItem().getCourses().add(selectedCourse);
        int index = adviseeListView.getSelectionModel().getSelectedIndex();
        adviseeListView.getSelectionModel().clearSelection();
        adviseeListView.getSelectionModel().select(index);
    }

    @FXML
    void deleteCourseBtnPress(ActionEvent event) {
        int selectedCourse = studentCourseListView.getSelectionModel().getSelectedIndex();
        Advisee selectedAdvisee = adviseeListView.getSelectionModel().getSelectedItem();
        selectedAdvisee.getCourses().remove(selectedCourse);
        studentCourseListView.getSelectionModel().clearSelection();
        studentCourseList = FXCollections.observableArrayList(selectedAdvisee.getCourses());
        studentCourseListView.setItems(studentCourseList);
        selectedAdvisee.Payment();
        txt_tuition.setText("" + selectedAdvisee.getTuition());
        clearCourseInfo();
    }

    @FXML
    void initialize() {
        studentTextFields = new TextField[]{txt_name, txt_acadID, txt_email, txt_phoneNum, txt_address, txt_tuition};
        courseTextFields = new TextField[]{txt_courseName, txt_courseCredits, txt_courseCost};

        txt_address.setText("25 Yearsley Mill Rd, Media, PA 19063");

        adviseeListView.setItems(adviseesList);
        adviseeListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Advisee>() {
            @Override
            public void changed(ObservableValue<? extends Advisee> observableValue, Advisee oldA, Advisee newA) {
                txt_name.setText(newA.getName());
                txt_acadID.setText(newA.getID());
                if (newA.getPhoneNum() != 0) {
                    txt_phoneNum.setText("" + newA.getPhoneNum());
                }
                txt_address.setText(newA.getAddress().toString());
                newA.Payment();
                txt_tuition.setText("" + newA.getTuition());
                studentCourseList = FXCollections.observableArrayList(newA.getCourses());
                studentCourseListView.setItems(studentCourseList);
                txt_email.setText(newA.getEmail().toString());
            }
        });

        courseList.addAll(new Course("CMPSC221", 4, 100),
                new Course("ECON102", 4, 100),
                new Course("NUTR251", 3, 100)
        );
        courseListView.setItems(courseList);
        courseListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Course>() {
            @Override
            public void changed(ObservableValue<? extends Course> observableValue, Course oldC, Course newC) {
                fillCourseTextFields(newC);
                studentCourseListView.getSelectionModel().clearSelection();
            }
        });

        studentCourseListView.setItems(studentCourseList);
        studentCourseListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Course>() {
            @Override
            public void changed(ObservableValue<? extends Course> observableValue, Course oldC, Course newC) {
                fillCourseTextFields(newC);
                courseListView.getSelectionModel().clearSelection();
            }
        });
    }
}